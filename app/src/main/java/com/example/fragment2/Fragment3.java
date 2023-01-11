package com.example.fragment2;

import android.app.Fragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;


public class Fragment3 extends Fragment{
    private SimpleAdapter simpleAdapter;
    private ArrayList<HashMap<String,Object>> maparry=new ArrayList<HashMap<String,Object>>();
    private View root;
    private ListView mListView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (root == null) {
            root = inflater.inflate(R.layout.layout_content3, container, false);
        }
        initData();
        mListView = root.findViewById(R.id.listView_classfy);

        simpleAdapter=new SimpleAdapter(getActivity(),maparry,R.layout.classfy_item,new String[]{"photo","title","content"},new int[]{R.id.photo,R.id.title,R.id.content});
        mListView.setAdapter(simpleAdapter);

        return root;
    }
    public void initData(){
        HashMap<String,Object> map1=new HashMap<String,Object>();
        map1.put("photo",R.drawable.s_jiadian);
        map1.put("title","家电");
        map1.put("content","家电/生活电器/厨房电器");
        maparry.add(map1);
        HashMap<String,Object> map2=new HashMap<String,Object>();
        map2.put("photo",R.drawable.s_wenju);
        map2.put("title","文具");
        map2.put("content","笔/草稿纸");
        maparry.add(map2);
        HashMap<String,Object> map3=new HashMap<String,Object>();
        map3.put("photo",R.drawable.s_tushu);
        map3.put("title","图书");
        map3.put("content","图书电子书/图书/小说");
        maparry.add(map3);
        HashMap<String,Object> map4=new HashMap<String,Object>();
        map4.put("photo",R.drawable.s_shuma);
        map4.put("title","数码");
        map4.put("content","摄影摄像/数码配件");
        maparry.add(map4);
        HashMap<String,Object> map5=new HashMap<String,Object>();
        map5.put("photo",R.drawable.s_jiaju);
        map5.put("title","家具");
        map5.put("content","家具/灯具/生活用品");
        maparry.add(map5);
        HashMap<String,Object> map6=new HashMap<String,Object>();
        map6.put("photo",R.drawable.s_shouji);
        map6.put("title","手机");
        map6.put("content","运营商/手机配件");
        maparry.add(map6);
        HashMap<String,Object> map7=new HashMap<String,Object>();
        map7.put("photo",R.drawable.s_shiping);
        map7.put("title","食品");
        map7.put("content","蔬菜/水果/零食");
        maparry.add(map7);
    }
}
