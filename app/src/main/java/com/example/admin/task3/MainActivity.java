package com.example.admin.task3;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.shashank.sony.fancytoastlib.FancyToast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class  MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4;
    String s;
    String s1, s2, s3, s4;
    String answer;
    TextView txt1;
    RelativeLayout relativeLayout;
    private Data data = new Data();
    int questionlength = data.words.length;
    Random random = new Random();
    private Button[] buttons;
    String sth = "";
    int[] image={R.drawable.right,R.drawable.wrong};
    String[] arr={"Correct","Wrong"};
    private static int splashtimeout=2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        txt1 = (TextView) findViewById(R.id.txt1);
        relativeLayout=(RelativeLayout) findViewById(R.id.r);
        buttons = new Button[4];
        buttons[0] = (Button) findViewById(R.id.btn1);
        buttons[1] = (Button) findViewById(R.id.btn2);
        buttons[2] = (Button) findViewById(R.id.btn3);
        buttons[3] = (Button) findViewById(R.id.btn4);

        NextQusetion(0);


        for (int i = 0; i <= 3; i++) {
            //final int final1 = i;

            buttons[i].setOnClickListener(new ButtonClickListener(i));/* {
                @Override
                public void onClick(View view) {
                    s=buttons[final1].getText().toString();
                    buttons[final1].setEnabled(false);
                    txt1.setText(s);
                }
            });*/

        }


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void NextQusetion(int i) {
        buttons[0].setText(data.getWords1(i));
        buttons[1].setText(data.getWords2(i));
        buttons[2].setText(data.getWords3(i));
        buttons[3].setText(data.getWords4(i));
//      answer=data.getCorrectAnswer(i);
        //txt1.setText(s);

    }

    private class ButtonClickListener implements View.OnClickListener {
        int pos;

        public ButtonClickListener(int i) {
            pos = i;
        }

        @Override
        public void onClick(View view) {

            sth = sth+(buttons[pos].getText().toString());
            txt1.setText(sth.toString());
            buttons[pos].setEnabled(false);
            buttons[pos].setBackgroundColor(Color.CYAN);
            if (sth.length() == 4) {
                if (Arrays.asList(Data.correctAnswer).contains(sth)) {
                    //FancyToast.makeText(MainActivity.this,arr[0],FancyToast.LENGTH_LONG,FancyToast.INFO,image[0]).show();
                    //relativeLayout.setBackgroundColor(Color.GREEN);
                    sth =("");
                    NextQusetion(random.nextInt(questionlength));
                    //Intent i=new Intent(MainActivity.this,Main2Activity.class);
                    //startActivity(i);
                    buttons[0].setEnabled(true);
                    buttons[0].setBackgroundColor(Color.WHITE);
                    buttons[1].setEnabled(true);
                    buttons[1].setBackgroundColor(Color.WHITE);
                    buttons[2].setEnabled(true);
                    buttons[2].setBackgroundColor(Color.WHITE);
                    buttons[3].setEnabled(true);
                    buttons[3].setBackgroundColor(Color.WHITE);
                    final Dialog dialog=new Dialog(MainActivity.this);
                    dialog.setContentView(R.layout.activity_main4);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
//                            finish();
                            dialog.dismiss();
                        }
                    },splashtimeout);
                    dialog.show();


                    //txt1.setText(null);
                    //relativeLayout.setBackgroundColor(Color.WHITE);
                } else {
                    //FancyToast.makeText(MainActivity.this,arr[1],FancyToast.LENGTH_LONG,FancyToast.INFO,image[1]).show();
                    //relativeLayout.setBackgroundColor(Color.RED);
                    sth = ("");
                    NextQusetion(random.nextInt(questionlength));
                    //Intent i=new Intent(MainActivity.this,Main3Activity.class);
                    //startActivity(i);
                    buttons[0].setEnabled(true);
                    buttons[0].setBackgroundColor(Color.WHITE);
                    buttons[1].setEnabled(true);
                    buttons[1].setBackgroundColor(Color.WHITE);
                    buttons[2].setEnabled(true);
                    buttons[2].setBackgroundColor(Color.WHITE);
                    buttons[3].setEnabled(true);
                    buttons[3].setBackgroundColor(Color.WHITE);
                    final Dialog dialog=new Dialog(MainActivity.this);
                    dialog.setContentView(R.layout.activity_main5);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
//                            finish();
                            dialog.dismiss();
                        }
                    },splashtimeout);
                    dialog.show();
                    //txt1.setText(null);
                    //relativeLayout.setBackgroundColor(Color.WHITE);
                    //relativeLayout.setBackgroundColor(Color.WHITE);
                }
            }
        }
    }
}
