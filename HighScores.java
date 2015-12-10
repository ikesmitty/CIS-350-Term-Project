package com.example.isaacsmith.tba;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;


import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

public class HighScores extends AppCompatActivity {

    List<String> storedScore;

    public static HighScores hs = new HighScores();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_scores);
        try {
            storedScore = readHighScores();
        } catch (ParseException e) {
            e.printStackTrace();
        }


        TextView scoreOne = (TextView) findViewById(R.id.editText1);
        TextView scoreTwo = (TextView) findViewById(R.id.editText2);
        TextView scoreThree = (TextView) findViewById(R.id.editText3);
        TextView scoreFour = (TextView) findViewById(R.id.editText4);
        TextView scoreFive = (TextView) findViewById(R.id.editText5);

        scoreOne.setText  ("1) " + storedScore.get(0));
        scoreTwo.setText  ("2) " + storedScore.get(1));
        scoreThree.setText("3) " + storedScore.get(2));
        scoreFour.setText ("4) " + storedScore.get(3));
        scoreFive.setText ("5) " + storedScore.get(4));

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_high_scores, menu);
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

    //Saves the highscore into the database
    public static void saveHighScore (String score) throws FileNotFoundException {

        ParseObject savedScores = new ParseObject("savedScores");
        savedScores.put("Score", score);
        savedScores.saveInBackground();

    }


    //Reads the highscore from the designated file and returns a string of the value
    public static List<String> readHighScores() throws ParseException {

        List<String> scoreList = new ArrayList<>();
        ParseQuery<ParseObject> getScores = ParseQuery.getQuery("savedScores");

        List<ParseObject> parseList = (getScores.addDescendingOrder("Score")).find();

        for (int i = 0; i < parseList.size(); i++){
            String sc = parseList.get(i).getString("Score");
            scoreList.add(sc);
        }

        return scoreList;
    }
}
