package com.example.fragment2;

import android.app.AlarmManager;
import android.app.Fragment;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.os.Handler;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Fragment1 extends Fragment{
    //    六个按钮
    private Button a1,a2,a3,a4,a5,a6,a7,a8;
    private CountDownTimerView countDownTimerView;
    private Button btn;
    private AlarmManager alarmManager;  //闹钟管理器
    private View root;
    private ViewPager mViewPaper;
    private List<ImageView> images;
    //下方指示点
    private List<View> dots;
    private int currentItem;
    //记录上一次点的位置
    private int oldPosition = 0;
    //存放图片的id
    private int[] imageIds = new int[]{R.drawable.paper1, R.drawable.paper5, R.drawable.s_jiadian,R.drawable.paper4,R.drawable.paper3,R.drawable.camara};
    //存放图片的标题，可以设为空
    private String[] titles = new String[]{"", "", ""};
    private TextView title;
    //定时调度机制
    private ScheduledExecutorService scheduledExecutorService;
    private ViewPagerAdapter adapter;
    private ArrayList<HashMap<String, Object>> maparry = new ArrayList<HashMap<String, Object>>();
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        if(root==null){
            root=inflater.inflate(R.layout.layout_content1,container,false);
        }
        setView();
//        计算器按钮
        a1=root.findViewById(R.id.a1);
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),caculate.class);
                startActivity(intent);
            }
        });
//        倒计时
        countDownTimerView =root.findViewById(R.id.my_timer);
        countDownTimerView.init(1000*60*60*2,50);
        countDownTimerView.start();
//        闹钟
        //获取闹钟管理器
        alarmManager = (AlarmManager)getActivity().getSystemService(Context.ALARM_SERVICE);
        btn = root.findViewById(R.id.a2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setClock(view);
            }
        });
//        剪刀石头布
        a3=root.findViewById(R.id.a3);
        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),game.class);
                startActivity(intent);
            }
        });
//        下载图片
        a4=root.findViewById(R.id.a4);
        a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),downloadimg.class);
                startActivity(intent);
            }
        });
//        日历
        a5=root.findViewById(R.id.a5);
        a5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),rili.class);
                startActivity(intent);
            }
        });
//        画廊
        a6=root.findViewById(R.id.a6);
        a6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),hualang.class);
                startActivity(intent);

            }
        });
//       重启
        a7=root.findViewById(R.id.a7);
        a7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = getActivity().getPackageManager().getLaunchIntentForPackage(getActivity().getPackageName());
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });
        return root;
    }
    //    闹钟
    public void setClock(View view){
        //获取当前系统时间
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        //弹出闹钟框
        TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Calendar c = Calendar.getInstance();    //获取日期对象
                c.set(Calendar.HOUR_OF_DAY, hourOfDay); //设置闹钟小时数
                c.set(Calendar.MINUTE, minute); //设置闹钟分钟数
                Intent intent = new Intent(getActivity(), AlarmReceiver.class);
                //创建pendingIntent
                PendingIntent pendingIntent = PendingIntent.getBroadcast(getActivity(),0X102, intent,0);
                //设置闹钟
                alarmManager.set(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pendingIntent);
                Toast.makeText(getActivity(), "闹钟设置成功", Toast.LENGTH_SHORT).show();
            }
        },hour,minute,true);
        timePickerDialog.show();
    }
    //UI界面的更新
    private void setView() {
        mViewPaper = root.findViewById(R.id.viewpager);
        //显示的图片
        images = new ArrayList<ImageView>();
        for (int i = 0; i < imageIds.length; i++) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setBackgroundResource(imageIds[i]);
            images.add(imageView);
        }
        //显示的小点
        dots = new ArrayList<View>();
        dots.add(root.findViewById(R.id.dot_0));
        dots.add(root.findViewById(R.id.dot_1));
        dots.add(root.findViewById(R.id.dot_2));
        dots.add(root.findViewById(R.id.dot_3));
        dots.add(root.findViewById(R.id.dot_4));
        dots.add(root.findViewById(R.id.dot_5));

        title = root.findViewById(R.id.title);
//        title.setText(titles[0]);

        adapter = new ViewPagerAdapter();
        mViewPaper.setAdapter(adapter);

        mViewPaper.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
//                title.setText(titles[position]);
                dots.get(position).setBackgroundResource(R.drawable.dotyes);
                dots.get(oldPosition).setBackgroundResource(R.drawable.dotno);
                oldPosition = position;
                currentItem = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
        });
    }

    /*定义的适配器*/
    public class ViewPagerAdapter extends PagerAdapter {
        //返回当前有效视图的个数。
        @Override
        public int getCount() {
            return images.size();
        }

        //判断instantiateItem函数所返回来的Key与一个页面视图是否是代表的同一个视图
        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void destroyItem(ViewGroup view, int position, Object object) {
            view.removeView(images.get(position));
        }

        //创建指定位置的页面视图，也就是将一张图片放到容器中的指定位置
        @Override
        public Object instantiateItem(ViewGroup view, int position) {
            view.addView(images.get(position));
            return images.get(position);
        }

    }

    /**
     * 利用线程池定时执行动画轮播
     */
    @Override
    public void onStart() {
        super.onStart();
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        //每隔2s时间，固定执行轮播任务。
        scheduledExecutorService.scheduleWithFixedDelay(new ViewPageTask(), 2, 2, TimeUnit.SECONDS);
    }

    /**
     * 图片轮播任务,发送轮播消息
     */
    private class ViewPageTask implements Runnable {
        @Override
        public void run() {
            currentItem = (currentItem + 1) % imageIds.length;
            mHandler.sendEmptyMessage(0);   //发送轮播消息
        }
    }

    /**
     * 接收子线程传递过来的数据
     */
    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            //这里不是具体的数据，而是一个轮播信号，目的是切换下一张图片
            mViewPaper.setCurrentItem(currentItem);
        }
    };

    //当切换到其他界面时，关闭后台轮播
    @Override
    public void onStop() {
        super.onStop();
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
            scheduledExecutorService = null;
        }
    }

}
