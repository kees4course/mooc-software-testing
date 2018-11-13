package tudelft.caesarshift;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tudelft.ghappy.GHappy;

public class CaesarShiftCipherTest {

    private CaesarShiftCipher caesarshift = new CaesarShiftCipher();


    @BeforeEach
    public void initialize() {
        this.caesarshift = new CaesarShiftCipher();
    }


    @ParameterizedTest(name = "string={0}, shift={1}, result={2}")
    @CsvSource({
            "abc,3,def","xyz,3,abc"
    })
    public void Examples(String message,int shift,String result) {
        String outcome = caesarshift.CaesarShiftCipher(message,shift);
        Assertions.assertEquals(result,outcome);
    }

    @ParameterizedTest(name = "string={0}, shift={1}, result={2}")
    @CsvSource({
            "ab cdefghijklmnopqrstuvwxyz ,0,abcdefghijklmnopqrstuvwxyz"
    })
    public void RecognizesValid(String message,int shift,String result) {
        String outcome = caesarshift.CaesarShiftCipher(message,shift);
        Assertions.assertEquals(result,outcome);
    }

    @ParameterizedTest(name = "string={0}, shift={1}, result={2}")
    @CsvSource({
            "ABC,3,invalid","123,3,invalid"
    })
    public void RecognizesInvalid(String message,int shift,String result) {
        String outcome = caesarshift.CaesarShiftCipher(message,shift);
        Assertions.assertEquals(result,outcome);
    }

    @ParameterizedTest(name = "string={0}, shift={1}, result={2}")
    @CsvSource({
            "z,0,z","z,1,a",
            "a,0,a","a,-1,z",
    })
    public void CornerInput(String message,int shift,String result) {
        String outcome = caesarshift.CaesarShiftCipher(message,shift);
        Assertions.assertEquals(result,outcome);
    }
    

}
