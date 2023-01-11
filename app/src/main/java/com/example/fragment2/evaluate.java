package com.example.fragment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public  class evaluate extends AppCompatActivity{
    private ImageView e1;
    protected void  onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.evaluate);
        e1=findViewById(R.id.e1);
        e1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(evaluate.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
