package tudelft.countletters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountLettersTest {

  /*  @Test
    public void multipleMatchingWords() {
        int words = new CountLetters().count("cats|dogs");
        Assertions.assertEquals(2, words);
    }

    @Test
    public void lastWordDoesNotMatch() {
        int words = new CountLetters().count("cats|dog");
        Assertions.assertEquals(1, words);
    }

    @Test
    public void lastWordWithR() {
        int words = new CountLetters().count("catr|dogr");
        Assertions.assertEquals(2, words);
    }

    @Test
    public void nothingDoesNotMatch() {
        int words = new CountLetters().count("cat|dog");
        Assertions.assertEquals(0, words);
    }*/

    @Test
    public void condCovNoWords() {
        int words = new CountLetters().count("*");
        Assertions.assertEquals(0, words);
    }

   /* @Test
    public void condCovCases() {
        int words = new CountLetters().count("s");
        Assertions.assertEquals(1, words);
    }

    @Test
    public void condCovCaser() {
        int words = new CountLetters().count("r");
        Assertions.assertEquals(1, words);
    }*/

    @Test
    public void condCovCases1() {
        int words = new CountLetters().count("s*");
        Assertions.assertEquals(1, words);
    }

    @Test
    public void condCovCaser1() {
        int words = new CountLetters().count("r*");
        Assertions.assertEquals(1, words);
    }

}