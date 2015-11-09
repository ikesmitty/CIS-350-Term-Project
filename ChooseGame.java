package com.example.isaacsmith.tba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ChooseGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_game);

        Button blockATT = (Button) findViewById(R.id.blockAttack);
        blockATT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //When clicked it moves you to the option menu
                Intent intent = new Intent(v.getContext(), DifficultySet.class);
                intent.putExtra("time", 3000);
                startActivityForResult(intent, 0);
            }
        });

        Button timeATT = (Button) findViewById(R.id.timeAttack);
        timeATT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //When clicked it moves you to the option menu
                Intent intent = new Intent(v.getContext(), TimeAttack.class);
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_choose_game, menu);
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
