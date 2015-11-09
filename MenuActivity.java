package com.example.isaacsmith.tba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**************************************************************************************
 * Main Activiy that allows you to move through the different menus with button clicks
 *
 * @Author: Isaac Smith, Chad Mayo, Nam Nguyen
 **************************************************************************************/
public class MenuActivity extends AppCompatActivity {

    /***************************
     * Sets the view on creation
     * @param savedInstanceState
     **************************/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Sets listeners to all buttons on the main menu
        Button optionsbtn = (Button) findViewById(R.id.optionsbutton);
        optionsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //When clicked it moves you to the option menu
                Intent intent = new Intent(v.getContext(), Options.class);
                startActivityForResult(intent, 0);
            }
        });
        Button highscoresbtn = (Button) findViewById(R.id.leaderboardbutton);
        highscoresbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //When clicked it moves you to the high scores menu
                Intent intent = new Intent(v.getContext(), HighScores.class);
                startActivityForResult(intent, 0);
            }
        });

        Button gamestartbtn = (Button) findViewById(R.id.startbutton);
        gamestartbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //When clicked this will start the game
                Intent intent = new Intent(v.getContext(), ChooseGame.class);
                startActivityForResult(intent, 0);
            }
        });
    }

    /*************************
     * Adds item to action bar
     * @param menu
     * @return
     ************************/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu, menu);
        return true;
    }

    /***********************
     * Handles item clicks
     * @param item
     * @return
     **********************/
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
