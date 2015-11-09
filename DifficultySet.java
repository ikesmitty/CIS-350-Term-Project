package com.example.isaacsmith.tba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class DifficultySet extends AppCompatActivity {

    int startTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty_set);

        Button easy = (Button) findViewById(R.id.easy);
        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTime = 3 * 1000;
                //When clicked it moves you to the option menu
                Intent intent = new Intent(v.getContext(), GameStart.class);
                intent.putExtra("time", 3000);
                startActivityForResult(intent, 0);
            }
        });

        Button medium = (Button) findViewById(R.id.medium);
        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTime = 2 * 1000;
                //When clicked it moves you to the option menu
                Intent intent2 = new Intent(v.getContext(), GameStart.class);
                intent2.putExtra("time", 2000);
                startActivityForResult(intent2, 0);
            }
        });

        Button hard = (Button) findViewById(R.id.hard);
        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTime = 1 * 1000;
                //When clicked it moves you to the option menu
                Intent intent3 = new Intent(v.getContext(), GameStart.class);
                intent3.putExtra("time", 1000);
                startActivityForResult(intent3, 0);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_difficulty_set, menu);
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
}
