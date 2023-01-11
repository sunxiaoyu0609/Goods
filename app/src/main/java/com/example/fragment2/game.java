package com.example.fragment2;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class game extends Activity {
    String computer;
    int player;
    String player2;
    int computer2;
    private EditText edgame;
    private Button gamebutton;
    private TextView gametext;
    ImageView game_iamge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        edgame=findViewById(R.id.edgame);
        gamebutton=findViewById(R.id.gamebutton);
        gametext=findViewById(R.id.gametext);
        game_iamge=findViewById(R.id.game_iamge);
        computer2=new Random().nextInt(3);
        if(computer2==0){
            computer="石头";
        }else if(computer2==1){
            computer="剪刀";
        }else if(computer2==2){
            computer="布";
        }
        gamebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player2=edgame.getText().toString();
                if((player2.equals("石头")&&computer.equals("剪刀"))||(player2.equals("剪刀")&&computer.equals("布"))||(player2.equals("布")&&computer.equals("石头"))){
                    game_iamge.setImageResource(R.drawable.game_win);
                    gametext.setText("你赢了，电脑出的"+computer+",你出的"+player2);

                }else if((player2.equals("石头")&&computer.equals("布"))||(player2.equals("剪刀")&&computer.equals("石头"))||(player2.equals("布")&&computer.equals("剪刀"))){
                    game_iamge.setImageResource(R.drawable.game_lose);
                    gametext.setText("你输了，电脑出的"+computer+",你出的"+player2);
                }else if((player2.equals("石头")&&computer.equals("石头"))||(player2.equals("剪刀")&&computer.equals("剪刀"))||(player2.equals("布")&&computer.equals("布"))){
                    game_iamge.setImageResource(R.drawable.game_pingshou);
                    gametext.setText("平手，电脑出的"+computer+",你出的"+player2);
                }else{
                    gametext.setText("认真输入噢");
                }
            }
        });
    }
}