package com.example.fragment2;

import android.app.FragmentManager;
import android.app.FragmentTransaction;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fragment2.Fragment1;
import com.example.fragment2.Fragment2;
import com.example.fragment2.Fragment3;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private FragmentManager mManager;
    private FragmentTransaction mTransaction;
    private RadioButton btn1;
    private RadioButton btn2;
    private RadioButton btn3;
    private RadioButton btn4;
    private RadioButton btn5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mManager = getFragmentManager();//获取管理器
        mTransaction = mManager.beginTransaction();//初始化事务
        //增加Fragment到布局中
        mTransaction.add(R.id.id_content_layout,new Fragment1());
        mTransaction.commit();//提交事务
        initView();//初始化视图函数
        changeImageSize();//修改图片大小
    }
    private void initView() {
        btn1 = findViewById(R.id.rb1);//绑定组件与对象
        btn2 = findViewById(R.id.rb2);
        btn3 = findViewById(R.id.rb3);
        btn4 = findViewById(R.id.rb4);
        btn5= findViewById(R.id.rb5);
        btn1.setOnClickListener(this);//设置监听事件
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        mTransaction = mManager.beginTransaction();//获取事务
        switch (v.getId())
        {
            case R.id.rb1://单击第一个按钮实现插入第一个Fragment
                Drawable drawable_news = getResources().getDrawable(R.drawable.shouye_active);
                //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
                drawable_news.setBounds(0, 0, 50, 50);
                //设置图片在文字的哪个方向
                btn1.setCompoundDrawables(null, drawable_news, null, null);

                //定义底部标签图片大小和位置
                Drawable drawable_live = getResources().getDrawable(R.drawable.search);
                //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
                drawable_live.setBounds(0, 0, 50, 50);
                //设置图片在文字的哪个方向
                btn2.setCompoundDrawables(null, drawable_live, null, null);

                //定义底部标签图片大小和位置
                Drawable drawable_tuijian = getResources().getDrawable(R.drawable.classfy);
                //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
                drawable_tuijian.setBounds(0, 0, 50, 50);
                //设置图片在文字的哪个方向
                btn3.setCompoundDrawables(null, drawable_tuijian, null, null);

                //定义底部标签图片大小和位置
                Drawable drawable_me = getResources().getDrawable(R.drawable.gouwuche);
                //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
                drawable_me.setBounds(0, 0, 50, 50);
                //设置图片在文字的哪个方向
                btn4.setCompoundDrawables(null, drawable_me, null, null);

                //定义底部标签图片大小和位置
                Drawable drawable_seach = getResources().getDrawable(R.drawable.my);
                //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
                drawable_seach.setBounds(0, 0, 50, 50);
                //设置图片在文字的哪个方向
                btn5.setCompoundDrawables(null, drawable_seach, null, null);
                mTransaction.replace(R.id.id_content_layout,new Fragment1());
                break;
            case R.id.rb2:
                drawable_news = getResources().getDrawable(R.drawable.shouye);
                //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
                drawable_news.setBounds(0, 0, 50, 50);
                //设置图片在文字的哪个方向
                btn1.setCompoundDrawables(null, drawable_news, null, null);

                //定义底部标签图片大小和位置
                drawable_live = getResources().getDrawable(R.drawable.search_active);
                //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
                drawable_live.setBounds(0, 0, 50, 50);
                //设置图片在文字的哪个方向
                btn2.setCompoundDrawables(null, drawable_live, null, null);

                //定义底部标签图片大小和位置
                drawable_tuijian = getResources().getDrawable(R.drawable.classfy);
                //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
                drawable_tuijian.setBounds(0, 0, 50, 50);
                //设置图片在文字的哪个方向
                btn3.setCompoundDrawables(null, drawable_tuijian, null, null);

                //定义底部标签图片大小和位置
                drawable_me = getResources().getDrawable(R.drawable.gouwuche);
                //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
                drawable_me.setBounds(0, 0, 50, 50);
                //设置图片在文字的哪个方向
                btn4.setCompoundDrawables(null, drawable_me, null, null);

                //定义底部标签图片大小和位置
                drawable_seach = getResources().getDrawable(R.drawable.my);
                //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
                drawable_seach.setBounds(0, 0, 50, 50);
                //设置图片在文字的哪个方向
                btn5.setCompoundDrawables(null, drawable_seach, null, null);
                mTransaction.replace(R.id.id_content_layout,new Fragment2());
                break;
            case R.id.rb3:
                drawable_news = getResources().getDrawable(R.drawable.shouye);
                //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
                drawable_news.setBounds(0, 0, 50, 50);
                //设置图片在文字的哪个方向
                btn1.setCompoundDrawables(null, drawable_news, null, null);

                //定义底部标签图片大小和位置
                drawable_live = getResources().getDrawable(R.drawable.search);
                //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
                drawable_live.setBounds(0, 0, 50, 50);
                //设置图片在文字的哪个方向
                btn2.setCompoundDrawables(null, drawable_live, null, null);

                //定义底部标签图片大小和位置
                drawable_tuijian = getResources().getDrawable(R.drawable.classfy_active);
                //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
                drawable_tuijian.setBounds(0, 0, 50, 50);
                //设置图片在文字的哪个方向
                btn3.setCompoundDrawables(null, drawable_tuijian, null, null);

                //定义底部标签图片大小和位置
                drawable_me = getResources().getDrawable(R.drawable.gouwuche);
                //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
                drawable_me.setBounds(0, 0, 50, 50);
                //设置图片在文字的哪个方向
                btn4.setCompoundDrawables(null, drawable_me, null, null);

                //定义底部标签图片大小和位置
                drawable_seach = getResources().getDrawable(R.drawable.my);
                //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
                drawable_seach.setBounds(0, 0, 50, 50);
                //设置图片在文字的哪个方向
                btn5.setCompoundDrawables(null, drawable_seach, null, null);
                mTransaction.replace(R.id.id_content_layout,new Fragment22());
                break;
            case R.id.rb4:
                drawable_news = getResources().getDrawable(R.drawable.shouye);
                //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
                drawable_news.setBounds(0, 0, 50, 50);
                //设置图片在文字的哪个方向
                btn1.setCompoundDrawables(null, drawable_news, null, null);

                //定义底部标签图片大小和位置
                drawable_live = getResources().getDrawable(R.drawable.search);
                //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
                drawable_live.setBounds(0, 0, 50, 50);
                //设置图片在文字的哪个方向
                btn2.setCompoundDrawables(null, drawable_live, null, null);

                //定义底部标签图片大小和位置
                drawable_tuijian = getResources().getDrawable(R.drawable.classfy);
                //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
                drawable_tuijian.setBounds(0, 0, 50, 50);
                //设置图片在文字的哪个方向
                btn3.setCompoundDrawables(null, drawable_tuijian, null, null);

                //定义底部标签图片大小和位置
                drawable_me = getResources().getDrawable(R.drawable.gouwuche_active);
                //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
                drawable_me.setBounds(0, 0, 50, 50);
                //设置图片在文字的哪个方向
                btn4.setCompoundDrawables(null, drawable_me, null, null);

                //定义底部标签图片大小和位置
                drawable_seach = getResources().getDrawable(R.drawable.my);
                //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
                drawable_seach.setBounds(0, 0, 50, 50);
                //设置图片在文字的哪个方向
                btn5.setCompoundDrawables(null, drawable_seach, null, null);
                mTransaction.replace(R.id.id_content_layout,new Fragment4());
                break;
            case R.id.rb5:
                drawable_news = getResources().getDrawable(R.drawable.shouye);
                //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
                drawable_news.setBounds(0, 0, 50, 50);
                //设置图片在文字的哪个方向
                btn1.setCompoundDrawables(null, drawable_news, null, null);

                //定义底部标签图片大小和位置
                drawable_live = getResources().getDrawable(R.drawable.search);
                //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
                drawable_live.setBounds(0, 0, 50, 50);
                //设置图片在文字的哪个方向
                btn2.setCompoundDrawables(null, drawable_live, null, null);

                //定义底部标签图片大小和位置
                drawable_tuijian = getResources().getDrawable(R.drawable.classfy);
                //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
                drawable_tuijian.setBounds(0, 0, 50, 50);
                //设置图片在文字的哪个方向
                btn3.setCompoundDrawables(null, drawable_tuijian, null, null);

                //定义底部标签图片大小和位置
                drawable_me = getResources().getDrawable(R.drawable.gouwuche);
                //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
                drawable_me.setBounds(0, 0, 50, 50);
                //设置图片在文字的哪个方向
                btn4.setCompoundDrawables(null, drawable_me, null, null);

                //定义底部标签图片大小和位置
                drawable_seach = getResources().getDrawable(R.drawable.my_active);
                //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
                drawable_seach.setBounds(0, 0, 50, 50);
                //设置图片在文字的哪个方向
                btn5.setCompoundDrawables(null, drawable_seach, null, null);
                mTransaction.replace(R.id.id_content_layout,new Fragment5());
                break;
        }
        mTransaction.commit();//提交事务
    }
    private void changeImageSize() {
        //定义底部标签图片大小和位置
        Drawable drawable_news = getResources().getDrawable(R.drawable.shouye_active);
        //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
        drawable_news.setBounds(0, 0, 50, 50);
        //设置图片在文字的哪个方向
        btn1.setCompoundDrawables(null, drawable_news, null, null);

        //定义底部标签图片大小和位置
        Drawable drawable_live = getResources().getDrawable(R.drawable.search);
        //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
        drawable_live.setBounds(0, 0, 50, 50);
        //设置图片在文字的哪个方向
        btn2.setCompoundDrawables(null, drawable_live, null, null);

        //定义底部标签图片大小和位置
        Drawable drawable_tuijian = getResources().getDrawable(R.drawable.classfy);
        //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
        drawable_tuijian.setBounds(0, 0, 50, 50);
        //设置图片在文字的哪个方向
        btn3.setCompoundDrawables(null, drawable_tuijian, null, null);

        //定义底部标签图片大小和位置
        Drawable drawable_me = getResources().getDrawable(R.drawable.gouwuche);
        //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
        drawable_me.setBounds(0, 0, 50, 50);
        //设置图片在文字的哪个方向
        btn4.setCompoundDrawables(null, drawable_me, null, null);

        //定义底部标签图片大小和位置
        Drawable drawable_seach = getResources().getDrawable(R.drawable.my);
        //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
        drawable_seach.setBounds(0, 0, 50, 50);
        //设置图片在文字的哪个方向
        btn5.setCompoundDrawables(null, drawable_seach, null, null);
    }

}

