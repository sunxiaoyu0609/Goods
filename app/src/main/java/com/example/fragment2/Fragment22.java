package com.example.fragment2;

import android.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

public class Fragment22 extends Fragment {
    private View root;
    //全局变量
    private boolean isScroll = true;
    ListView left_listview;//左侧列表
    PinnedHeaderListView pinnedListView;//右侧列表
    private LeftListAdapter adapter;
    private String[] leftStr = new String[]{"家电", "文具", "图书", "数码", "酒水", "家具", "手机"};
    private boolean[] flagArray = {true, false, false, false, false, false, false, false, false};
    private String[][] rightStr = new String[][]{{"家电", "生活电器", "厨房电器"},
            {"笔", "草稿纸"},
            {"图书", "电子书", "小说"}, {"摄影摄像", "数码配件"},{"茅台酒", "二锅头", "老白干"},{"家具", "灯具", "生活用品"},
            {"运营商", "手机配件"},
            {"蔬菜", "水果", "零食", "玉米粥", "紫米粥"}, {"麻将", "游戏充值"},
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (root == null) {
            root = inflater.inflate(R.layout.fragment22, container, false);
        }
        instantiation();
        return root;
    }
    private void instantiation() {
        left_listview = root.findViewById(R.id.left_listview);
        pinnedListView =  root.findViewById(R.id.pinnedListView);
        final MainSectionedAdapter sectionedAdapter = new MainSectionedAdapter(getActivity(), leftStr, rightStr);
        pinnedListView.setAdapter(sectionedAdapter);
        adapter = new LeftListAdapter(getActivity(), leftStr, flagArray);
        left_listview.setAdapter(adapter);
        left_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int position, long arg3) {
                isScroll = false;

                for (int i = 0; i < leftStr.length; i++) {
                    if (i == position) {
                        flagArray[i] = true;
                    } else {
                        flagArray[i] = false;
                    }
                }
                adapter.notifyDataSetChanged();
                int rightSection = 0;
                for (int i = 0; i < position; i++) {
                    rightSection += sectionedAdapter.getCountForSection(i) + 1;
                }
                pinnedListView.setSelection(rightSection);

            }

        });
        pinnedListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView arg0, int scrollState) {
                switch (scrollState) {
                    // 当不滚动时
                    case AbsListView.OnScrollListener.SCROLL_STATE_IDLE:
                        // 判断滚动到底部
                        if (pinnedListView.getLastVisiblePosition() == (pinnedListView.getCount() - 1)) {
                            left_listview.setSelection(ListView.FOCUS_DOWN);
                        }

                        // 判断滚动到顶部
                        if (pinnedListView.getFirstVisiblePosition() == 0) {
                            left_listview.setSelection(0);
                        }

                        break;
                }
            }

            int y = 0;
            int x = 0;
            int z = 0;

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (isScroll) {
                    for (int i = 0; i < rightStr.length; i++) {
                        if (i == sectionedAdapter.getSectionForPosition(pinnedListView.getFirstVisiblePosition())) {
                            flagArray[i] = true;
                            x = i;
                        } else {
                            flagArray[i] = false;
                        }
                    }
                    if (x != y) {
                        adapter.notifyDataSetChanged();
                        y = x;
                        if (y == left_listview.getLastVisiblePosition()) {
//                            z = z + 3;
                            left_listview.setSelection(z);
                        }
                        if (x == left_listview.getFirstVisiblePosition()) {
//                            z = z - 1;
                            left_listview.setSelection(z);
                        }
                        if (firstVisibleItem + visibleItemCount == totalItemCount - 1) {
                            left_listview.setSelection(ListView.FOCUS_DOWN);
                        }
                    }
                } else {
                    isScroll = true;
                }
            }
        });
    }
}
