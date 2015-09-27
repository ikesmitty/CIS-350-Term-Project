package com.example.isaacsmith.tba;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;

public class GameStart extends AppCompatActivity {

    private int score;
    private CountDownTimer countDownTimer;
    private boolean timerHasStarted = false;
    public TextView start;
    private final long startTime = 30 * 1000;
    private final long interval = 1 * 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_start);
        Button clickitbtn = (Button) findViewById(R.id.ClickIt);
        final MyCountDownTimer countDownTimer = new MyCountDownTimer(startTime, interval);
        start = (TextView) this.findViewById(R.id.timeleft);
        start.setText(start.getText() + String.valueOf(startTime / 1000));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game_start, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class MyCountDownTimer extends CountDownTimer {
        public  MyCountDownTimer(long startTime, long interval){
            super(startTime, interval);
            start();
            timerHasStarted = true;
            Button clickitbtn = (Button) findViewById(R.id.ClickIt);
            clickitbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean checks = getTimerStart();
                    if(checks = true) {
                        score = score + 1;
                        TextView scoredisp = (TextView) findViewById(R.id.addDispScore);
                        scoredisp.setText("Score: " + score);
                    }else{
                        score = score;
                    }
                }
            });
        }

        public boolean getTimerStart(){
            return timerHasStarted;
        }
        @Override
        public void onFinish(){
            start.setText("Time's up!");
            timerHasStarted = false;
        }

        @Override
        public void onTick(long millisUntilFinished){
            start.setText("" + millisUntilFinished / 1000);
        }
    }
}
