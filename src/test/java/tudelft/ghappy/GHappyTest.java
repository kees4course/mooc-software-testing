package tudelft.ghappy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tudelft.mirror.Mirror;

public class GHappyTest {

    private GHappy ghappy = new GHappy();


    @BeforeEach
    public void initialize() {
        this.ghappy = new GHappy();
    }


    @ParameterizedTest(name = "string={0}, result={1}")
    @CsvSource({
            "xxggxx,true","xxgxx,false", "xxggyygxx,false"
    })
    public void Examples(String string,boolean result) {
        boolean outcome = ghappy.gHappy(string);
        Assertions.assertEquals(result,outcome);
    }


    @ParameterizedTest(name = "string={0}, result={1}")
    @CsvSource({
            ",false","'',false",
            "g,false"
    })
    public void LessThenLeast(String string,boolean result) {
        boolean outcome = ghappy.gHappy(string);
        Assertions.assertEquals(result,outcome);
    }


    @ParameterizedTest(name = "string={0}, result={1}")
    @CsvSource({
            "gg,true","xgg,true","xggx,true"
    })
    public void OnegHappy(String string,boolean result) {
        boolean outcome = ghappy.gHappy(string);
        Assertions.assertEquals(result,outcome);
    }


    @ParameterizedTest(name = "string={0}, result={1}")
    @CsvSource({
            "ggxg,false","xggxg,false","xggxgx,false"
    })
    public void NotAllHappy(String string,boolean result) {
        boolean outcome = ghappy.gHappy(string);
        Assertions.assertEquals(result,outcome);
    }


    @ParameterizedTest(name = "string={0}, result={1}")
    @CsvSource({
            "ggxg,false","xggxg,false","xggxgx,false"
    })
    public void MultipleHappy(String string,boolean result) {
        boolean outcome = ghappy.gHappy(string);
        Assertions.assertEquals(result,outcome);
    }

    @ParameterizedTest(name = "string={0}, result={1}")
    @CsvSource({
            "gggx,true","xgggx,true","xgggx,true"
    })
    public void VeryHappy(String string,boolean result) {
        boolean outcome = ghappy.gHappy(string);
        Assertions.assertEquals(result,outcome);
    }




}
