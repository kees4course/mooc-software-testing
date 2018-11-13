package tudelft.mirror;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tudelft.roman.RomanNumeral;

public class MirrorTest {

    private Mirror mirror = new Mirror();

    @BeforeEach
    public void initialize() {
        this.mirror = new Mirror();
    }

    @ParameterizedTest(name = "string={0}, result={1}")
    @CsvSource({
            "abXYZba,ab","abca,a", "aba,aba"
    })
    public void Examples(String string,String result) {
        String outcome = mirror.mirrorEnds(string);
        Assertions.assertEquals(result,outcome);
    }


    @ParameterizedTest(name = "string={0}, result={1}")
    @CsvSource({
            ",''","'',''",
            "1,''"
            })
    public void LessThenLeast(String string,String result) {
        String outcome = mirror.mirrorEnds(string);
        Assertions.assertEquals(result,outcome);
    }


    @ParameterizedTest(name = "string={0}, result={1}")
    @CsvSource({
            "1,1","00,0","AA,A","aa,a","!!,!"
    })
    public void LeastOn(String string,String result) {
        String outcome = mirror.mirrorEnds(string);
        Assertions.assertEquals(result,outcome);
    }


    @ParameterizedTest(name = "string={0}, result={1}")
    @CsvSource({
            "010,010","ABA,ABA","aba,aba","!@!,!@!"
    })
    public void SharedMirror(String string,String result) {
        String outcome = mirror.mirrorEnds(string);
        Assertions.assertEquals(result,outcome);
    }

}
