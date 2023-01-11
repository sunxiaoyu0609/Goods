package com.example.fragment2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;


public class hualang extends Activity {
    private Gallery gallery;
    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.hualang);
        iv = findViewById(R.id.imageView);
        iv.setImageResource(ImageAdapter2.images[0]);
        gallery =findViewById(R.id.gallery);
        gallery.setAdapter(new ImageAdapter2(this));
        gallery.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view, int position, long id) {
                iv.setImageResource(ImageAdapter2.images[position]);
                Toast.makeText(hualang.this, "商品"+(position+1), 2).show();
            }
        });
    }
}