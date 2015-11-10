package com.example.isaacsmith.tba;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.io.*;

public class HighScores extends AppCompatActivity {
    public static HighScores hs = new HighScores();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_scores);

        TextView scoreOne = (TextView) findViewById(R.id.editText1);
        TextView scoreTwo = (TextView) findViewById(R.id.editText2);
        TextView scoreThree = (TextView) findViewById(R.id.editText3);
        TextView scoreFour = (TextView) findViewById(R.id.editText4);
        TextView scoreFive = (TextView) findViewById(R.id.editText5);
        try {
            scoreOne.setText("1) " + readHighScore(0));
            scoreTwo.setText("2) " + readHighScore(1));
            scoreThree.setText("3) " + readHighScore(2));
            scoreFour.setText("4) " + readHighScore(3));
            scoreFive.setText("5) " + readHighScore(4));
        } catch (IOException e) {
            e.printStackTrace();
        }



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


    //Saves the highscore into the designated file
    public void saveHighScore (String score) throws FileNotFoundException {
        try {
            FileOutputStream fos = openFileOutput("/blockattacksaves.txt", Context.MODE_WORLD_READABLE);
            fos.write(score.getBytes());
            fos.close();
            Toast.makeText(getApplicationContext(), "Saved Score", Toast.LENGTH_SHORT).show();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }


    //Reads the highscore from the designated file and returns a string of the value
    public String readHighScore(int place) throws IOException {
        String currentScores;
        String[] readScores = new String[5];
        File file = new File("blockattacksaves.txt");



        try{
            FileInputStream fis = openFileInput(file.getAbsolutePath());
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuffer sb = new StringBuffer();

            while ((currentScores = br.readLine())!= null) {
                sb.append(currentScores + "\n");
            }
            currentScores = sb.toString();

            readScores = currentScores.split(" ");


        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        return readScores[place];
    }

    //Takes the score as an input and checks if it is a high score
    //The method will call saveHighScore() when the sorting is complete
    public void checkHighScores(int newScore) throws IOException {

        StringBuilder finalScores = new StringBuilder();
        for (int i = 0; i < 5; i++){
            if (i != 0){
                finalScores.append(" ");
            }
            if (newScore > Integer.valueOf(readHighScore(i))){
                finalScores.append(Integer.toString(newScore));
                newScore = Integer.valueOf(readHighScore(i));

            }else{
                finalScores.append(Integer.valueOf(readHighScore(i)));
            }
        }

        saveHighScore(finalScores.toString());

    }


}
