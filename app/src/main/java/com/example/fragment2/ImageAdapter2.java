package com.example.fragment2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
public class ImageAdapter2 extends BaseAdapter {
    //上下文对象，提供给外界实例化ImageAdapter
    private Context mContext;
    //待加载到Gallery之中的图片id数组
    public static int images[] = {
            R.drawable.paper1,
            R.drawable.paper2,
            R.drawable.paper3,
            R.drawable.paper4
    };
    //ImageAdapter构造方法
    public ImageAdapter2(Context mContext) {
        this.mContext = mContext;
    }
    //获得图片的个数
    @Override
    public int getCount() {
        return images.length;
    }
    //获取对应索引上的图片
    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return images[position];
    }
    //获取对应图片的索引id
    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }
    //获取适配器中指定位置的视图对象
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView iv = new ImageView(mContext);
        iv.setImageResource(images[position % images.length]);
        iv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        iv.setLayoutParams(new Gallery.LayoutParams(77, 77));
        return iv;
    }
}