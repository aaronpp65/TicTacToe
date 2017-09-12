package com.creativeclan.tictactoe;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int player=0,stat[]={2,2,2,2,2,2,2,2,2};int active=1;
    int win[][]={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
String d;int o=0,x=0;//
    public void drop(View view){
        ImageView counter =(ImageView)view;


        int playerupdate= Integer.parseInt(counter.getTag().toString());


         if(stat[playerupdate]==2&&active==1){
             counter.setTranslationY(-1000f);
             if (player == 0) {
                 counter.setImageResource(R.drawable.play);
                 player = 1;
                 stat[playerupdate] = 0;

             } else {
                 counter.setImageResource(R.drawable.playx);
                 player = 0;
                 stat[playerupdate] = 1;
             }
             counter.animate().translationYBy(1000f).setDuration(300);

             for (int[] winning : win) {
                 if (stat[winning[0]] == stat[winning[1]] && stat[winning[1]] == stat[winning[2]] && stat[winning[1]] != 2)
                 {
                    String winner="X ";active=0;
                      //

                     if(stat[winning[0]]==0)
                     {
                         winner="O ";
                         o++;//
                     }
                     else
                         x++;

                     TextView textview3 =(TextView)findViewById(R.id.textView3);
                     textview3.setText(winner+"has won!!");
                     TextView score =(TextView)findViewById(R.id.score);//
                     score.setText("O:"+o+"     X:"+x);//
                     LinearLayout layout=(LinearLayout)findViewById(R.id.popup);
                     layout.setVisibility(view.VISIBLE);

                 }
                 else {
                     boolean count=true;
                     for(int state:stat)
                         if (state==2)
                             count=false;

                     if(count)
                     {
                         TextView textview3 =(TextView)findViewById(R.id.textView3);
                         textview3.setText("Draw!!");
                         LinearLayout layout=(LinearLayout)findViewById(R.id.popup);
                         layout.setVisibility(view.VISIBLE);
                     }

                 }


             }
         }


    }
    public  void playagain(View view)
    {active=1;
        LinearLayout layout=(LinearLayout)findViewById(R.id.popup);
        layout.setVisibility(view.INVISIBLE);
        player=0;
        for(int i=0;i<9;i++)
        {
            stat[i]=2;
        }
        GridLayout grid =(GridLayout)findViewById(R.id.grid);
        for(int i=0;i<9;i++){
           ((ImageView)grid.getChildAt(i)).setImageResource(0);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
