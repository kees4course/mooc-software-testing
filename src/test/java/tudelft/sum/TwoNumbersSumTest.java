package tudelft.sum;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.CsvSource;
import tudelft.caesarshift.CaesarShiftCipher;
import tudelft.countletters.CountLetters;

import java.util.ArrayList;

public class TwoNumbersSumTest {

    private TwoNumbersSum twonumberssum = new TwoNumbersSum();


    /**
     *
     * @param source
     * @return
     * @throws Exception
     */
    static ArrayList<Integer> String2ArrayList(@NotNull String source) throws Exception {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (source.matches("((\\+|-){0,1}[0-9])(,[0-9])*")) {
            for (String digit: ((String) source).split(",")) {
                result.add(Integer.valueOf(digit));
            }
        } else {
            throw new Exception("Illegal format");
        }

        return result;
    }

    /**
     *
     * @param digits
     * @return
     */
    static Integer ArrayList2Integer(@NotNull ArrayList<Integer> digits) {
        Integer result = 0;
        boolean negate = false;

        for (Integer digit: digits) {
            if (digit<0) {
                negate = true;
                digit *= -1;
            }
            result *= 10;
            result += digit;
        }

        if (negate) {
            result *= -1;
        }

        return result;
    }

    /* Converts an array definition as CSV-string to an ArrayList<Integer>
     * It only accepts a single character as array-value (only '1', '2' etc)
    */
    public class CConverter extends SimpleArgumentConverter {

        @Override
        protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
            if (source instanceof String) {
                try {
                    return (ArrayList<Integer>)TwoNumbersSumTest.String2ArrayList((String) source);
                } catch (Exception e) {
                    throw new IllegalArgumentException(e.getMessage());
                }
            } else {
                throw new IllegalArgumentException("Conversion from " + source.getClass() + " to "
                        + targetType + " not supported.");
            }
        }
    }


    @BeforeEach
    public void initialize() {
        this.twonumberssum = new TwoNumbersSum();
    }

    @ParameterizedTest
    @CsvSource({
            "'1',1",
            "'1,2,3',123",
            "'1,0',10",
            "'1,0,0',100",
            "'1,0,0,1',1001",
            "'-1,0,0,1',-1001",
            "'0',0",
            "'0,1',1",
            "'0,0,0',0",
    })
    void DigitCharacterArrayConverterTestValid(String sDigits,Integer result) {
        try {
            ArrayList<Integer> digits = String2ArrayList(sDigits);
            Integer actual = ArrayList2Integer(digits);

            Assertions.assertEquals(result,actual);
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }


    @ParameterizedTest
    @CsvSource({
            "'a'",
            "11"
    })
    void DigitCharacterArrayConverterTestInvalid(String sDigits) {
        try {
            ArrayList<Integer> digits = String2ArrayList(sDigits);
            Assertions.fail("Illegal array");
        } catch (Exception e) {

        }
    }

    @ParameterizedTest
    @CsvSource({
            "'0','1',1",
            "'1','1',2",
            "'1,1','1',12",
            "'3,4,2','4,6,5',807",
    })
    void TwoNumbersSumTestSimple(String sFirst, String sSecond, Integer result) {
        try {
            ArrayList<Integer> first = String2ArrayList(sFirst);
            ArrayList<Integer> second = String2ArrayList(sSecond);
            ArrayList<Integer> actual = twonumberssum.addTwoNumbers(first, second);

            Assertions.assertEquals(result,ArrayList2Integer(actual));
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    @ParameterizedTest
    @CsvSource({
            "'0','1',1",
            "'1','0',1",
            "'0,1','9',10",
            "'9','0,1',10"
    })
    void TwoNumbersSumTestZeroes(String sFirst, String sSecond, Integer result) {
        try {
            ArrayList<Integer> first = String2ArrayList(sFirst);
            ArrayList<Integer> second = String2ArrayList(sSecond);
            ArrayList<Integer> actual = twonumberssum.addTwoNumbers(first, second);

            //Assertions.fail("Preceding zeros not allowed");
            Assertions.assertEquals(ArrayList2Integer(actual),result);

        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    @ParameterizedTest
    @CsvSource({
            "'1','9',10",
            "'1,1','9',20",
            "'9,9','9',108"
    })
    void TwoNumbersSumTestWithCarry(String sFirst, String sSecond, Integer result) {
        try {
            ArrayList<Integer> first = String2ArrayList(sFirst);
            ArrayList<Integer> second = String2ArrayList(sSecond);
            ArrayList<Integer> actual = twonumberssum.addTwoNumbers(first, second);

            Assertions.assertEquals(ArrayList2Integer(actual),result);

        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

}
