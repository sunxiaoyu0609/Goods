package com.example.fragment2;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.fragment2.R;

import java.util.ArrayList;


public class Fragment4 extends Fragment{
    private View root;
    private LinearLayout linearLayout,linearLayout2,linearLayout3;
    private View view;
    private Button btn1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (root == null) {
            root = inflater.inflate(R.layout.order, container, false);
        }
        btn1=root.findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),evaluate.class);
                startActivity(intent);
            }
        });
//        linearLayout=root.findViewById(R.id.a2);
//        linearLayout2=root.findViewById(R.id.a3);
//        linearLayout3=root.findViewById(R.id.a5);
//        linearLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(),goods_detail.class);
//                startActivity(intent);
//            }
//        });
//        linearLayout2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(),goods_detail.class);
//                startActivity(intent);
//            }
//        });
//        linearLayout3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(),goods_detail.class);
//                startActivity(intent);
//            }
//        });
        return root;
    }
}
