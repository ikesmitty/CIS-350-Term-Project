package com.example.isaacsmith.tba;


import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

/*******************************************************************************
 * This class handles all elements of the game and lets the user play until the
 * timer hits zero.
 * @Authors: Isaac Smith, Chad Mayo, Nam Nguyen
 ******************************************************************************/
public class GameStart extends AppCompatActivity {

    //Variables for players score
    private int score;

    //Creates our timer
    private CountDownTimer countDownTimer;

    //Shows when timer is running
    private boolean timerHasStarted = false;

    //Text view for our timer
    public TextView start;

    //long integers for our timer time and interval on ticks
    private final long startTime = 30 * 1000;
    private final long interval = 1 * 1000;

    public int lastShown = 0;

    /**********************************************************
     * Displays the game screen and starts our countdown timer
     * @param savedInstanceState
     *********************************************************/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_start);
        //creates and starts our countdowntimer
        final MyCountDownTimer countDownTimer = new MyCountDownTimer(startTime, interval);

        //Sets a text field to display the time of the timer
        start = (TextView) this.findViewById(R.id.timeleft);
        start.setText(start.getText() + String.valueOf(startTime / 1000));


    }

    /********************************
     * Adds items to the action bar
     * @param menu
     * @return
     *******************************/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game_start, menu);
        return true;
    }

    /**************************************
     * Handles all action bar item clicks
     * @param item
     * @return
     *************************************/
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

    /**********************************************************
     * This class runs the countdown timer once it is created
     *********************************************************/
    public class MyCountDownTimer extends CountDownTimer {

        /****************************************************************
         * Class the is called on creation of the timer
         * @param startTime Time the timer will start at
         * @param interval How many seconds or minutes it counts down by
         ***************************************************************/
        public  MyCountDownTimer(long startTime, long interval){
            super(startTime, interval);

            //starts the timer
            start();
            timerHasStarted = true;

            //Initializes all the buttons in the view
            Button button1 = (Button) findViewById(R.id.button1);
            Button button2 = (Button) findViewById(R.id.button2);
            Button button3 = (Button) findViewById(R.id.button3);
            Button button4 = (Button) findViewById(R.id.button4);
            Button button5 = (Button) findViewById(R.id.button5);
            Button button6 = (Button) findViewById(R.id.button6);

            //To Do: Make a new button be displayed on click instead of on tick
            //Can be done inside of the onclick listeners

            //Sets on click listeners to all the buttons so when clicked
            //they will update our score
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    score = score + 1;
                    TextView scoredisp = (TextView) findViewById(R.id.addDispScore);
                    scoredisp.setText("Score: " + score);
                }
            });

            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    score = score + 1;
                    TextView scoredisp = (TextView) findViewById(R.id.addDispScore);
                    scoredisp.setText("Score: " + score);
                }
            });
            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    score = score + 1;
                    TextView scoredisp = (TextView) findViewById(R.id.addDispScore);
                    scoredisp.setText("Score: " + score);
                }
            });
            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    score = score + 1;
                    TextView scoredisp = (TextView) findViewById(R.id.addDispScore);
                    scoredisp.setText("Score: " + score);
                }
            });
            button5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    score = score + 1;
                    TextView scoredisp = (TextView) findViewById(R.id.addDispScore);
                    scoredisp.setText("Score: " + score);
                }
            });
            button6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    score = score + 1;
                    TextView scoredisp = (TextView) findViewById(R.id.addDispScore);
                    scoredisp.setText("Score: " + score);
                }
            });
        }

        /***********************************************
         * Getter method to check if timer has started
         * @return boolean if timer has started
         **********************************************/
        public boolean getTimerStart(){
            return timerHasStarted;
        }

        /***********************************************
         * Makes all buttons invisible and unclickable
         **********************************************/
        public void buttonsOff(){

            //Gets the button id and sets a button to it
            Button button1 = (Button) findViewById(R.id.button1);
            Button button2 = (Button) findViewById(R.id.button2);
            Button button3 = (Button) findViewById(R.id.button3);
            Button button4 = (Button) findViewById(R.id.button4);
            Button button5 = (Button) findViewById(R.id.button5);
            Button button6 = (Button) findViewById(R.id.button6);

            //Makes all buttons invisible and un-clickable
            button1.setVisibility(View.INVISIBLE);
            button2.setVisibility(View.INVISIBLE);
            button3.setVisibility(View.INVISIBLE);
            button4.setVisibility(View.INVISIBLE);
            button5.setVisibility(View.INVISIBLE);
            button6.setVisibility(View.INVISIBLE);
        }

        /**************************************************************************
         * Returns a random int which will be used to randomly display the buttons
         * @return random integer 1-6
         *************************************************************************/
        public int randButtonShow(){
            Random rand = new Random();
            int i = rand.nextInt(6) + 1;
            return i;
        }

        /************************************************
         * On finish of the timer this method is called
         ***********************************************/
        @Override
        public void onFinish(){
            //Sets display text that the time is up
            start.setText("Time's up!");

            //Sets timer start variable to false and makes all buttons on the screen
            //un-clickable
            timerHasStarted = false;
            buttonsOff();
        }

        /*******************************************************
         * Method called every seconds as the timer counts down
         * @param millisUntilFinished
         ******************************************************/
        @Override
        public void onTick(long millisUntilFinished){
            //Sets our text to the amount of time remaining
            start.setText("" + millisUntilFinished / 1000);
            Button button1 = (Button) findViewById(R.id.button1);
            Button button2 = (Button) findViewById(R.id.button2);
            Button button3 = (Button) findViewById(R.id.button3);
            Button button4 = (Button) findViewById(R.id.button4);
            Button button5 = (Button) findViewById(R.id.button5);
            Button button6 = (Button) findViewById(R.id.button6);
            int x = randButtonShow();

            //Makes all buttons invisible and un-clickable
            buttonsOff();

            int newbutton = 0;

            //Randomly displays a button for the user to click
            while(newbutton != 1) {
                if (x == 1) {
                    //Checks if button was shown before
                    if (lastShown != x) {
                        button1.setVisibility(View.VISIBLE);
                        button1.setEnabled(true);
                        //Sets last button shown and exits our loop
                        lastShown = x;
                        newbutton = 1;
                    } else {
                        x = randButtonShow();
                    }
                } else if (x == 2) {
                    //Checks if button was shown before
                    if (lastShown != x) {
                        button2.setVisibility(View.VISIBLE);
                        button2.setEnabled(true);
                        //Sets last button shown and exits our loop
                        lastShown = x;
                        newbutton = 1;
                    } else {
                        x = randButtonShow();
                    }
                } else if (x == 3) {
                    //Checks if button was shown before
                    if (lastShown != x) {
                        button3.setVisibility(View.VISIBLE);
                        button3.setEnabled(true);
                        //Sets last button shown and exits our loop
                        lastShown = x;
                        newbutton = 1;
                    } else {
                        x = randButtonShow();
                    }
                } else if (x == 4) {
                    //Checks if button was shown before
                    if (lastShown != x) {
                        button4.setVisibility(View.VISIBLE);
                        button4.setEnabled(true);
                        //Sets last button shown and exits our loop
                        lastShown = x;
                        newbutton = 1;
                    } else {
                        x = randButtonShow();
                    }
                } else if (x == 5) {
                    //Checks if button was shown before
                    if (lastShown != x) {
                        button5.setVisibility(View.VISIBLE);
                        button5.setEnabled(true);
                        //Sets last button shown and exits our loop
                        lastShown = x;
                        newbutton = 1;
                    } else {
                        x = randButtonShow();
                    }
                } else if (x == 6) {
                    //Checks if button was shown before
                    if (lastShown != x) {
                        button6.setVisibility(View.VISIBLE);
                        button6.setEnabled(true);
                        //Sets last button shown and exits our loop
                        lastShown = x;
                        newbutton = 1;
                    } else {
                        x = randButtonShow();
                    }
                }
            }
        }
    }
}

