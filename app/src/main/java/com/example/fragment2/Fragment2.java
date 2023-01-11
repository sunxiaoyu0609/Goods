package com.example.fragment2;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleAdapter;

import androidx.fragment.app.FragmentActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class Fragment2 extends Fragment {
    private String[] mStrs = {"iphone14", "德芙巧克力", "水杯"};
    private SearchView mSearchView;
    private ListView mListView;
    private View root;
    protected FragmentActivity mActivity; //可以用的引用
    private LinearLayout l1,l2,l3;
    private SimpleAdapter simpleAdapter;
    private ArrayList<HashMap<String,Object>> maparry=new ArrayList<HashMap<String,Object>>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (root == null) {
            root = inflater.inflate(R.layout.layout_content2, container, false);
        }
        l1=root.findViewById(R.id.l1);
        l2=root.findViewById(R.id.l2);
        l3=root.findViewById(R.id.l3);
        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),goods_detail.class);
                startActivity(intent);
            }
        });
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),goods_detail.class);
                startActivity(intent);
            }
        });
        l3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),goods_detail.class);
                startActivity(intent);
            }
        });
//        initData();
//        mSearchView = (SearchView) root.findViewById(R.id.searchView);
//        mListView = root.findViewById(R.id.listView);
//
//        simpleAdapter=new SimpleAdapter(getActivity(),maparry,R.layout.classfy_item,new String[]{"photo","title","content"},new int[]{R.id.photo,R.id.title,R.id.content});
//        mListView.setAdapter(simpleAdapter);
//        mListView.setTextFilterEnabled(true);
//
//        // 设置搜索文本监听
//        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            // 当点击搜索按钮时触发该方法
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            // 当搜索内容改变时触发该方法
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                if (!TextUtils.isEmpty(newText)) {
//                    mListView.setFilterText(newText);
//                } else {
//                    mListView.clearTextFilter();
//                }
//                return false;
//            }
//        });
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
    }
}
