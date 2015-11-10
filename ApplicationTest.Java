Package 

import junit.framework.TestCase;

import java.io.IOException;


public class ApplicationTest extends TestCase {


    public void testReadHighScore() {
        HighScores hs = new HighScores();
        String score = "";

        try {
            score = hs.readHighScore(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(score, 5);

        try {
            score = hs.readHighScore(2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(score, 4);

        try {
            score = hs.readHighScore(3);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(score, 3);

        try {
            score = hs.readHighScore(5);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(score, 1);
    }

}
