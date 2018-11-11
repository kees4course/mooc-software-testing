package tudelft.roman;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RomanNumeralTestWithBeforeEach {

    private RomanNumeral roman = new RomanNumeral();

    @BeforeEach
    public void initialize() {
        this.roman = new RomanNumeral();
    }

    @Test
    public void singleNumber() {
        int result = roman.convert("I");
        Assertions.assertEquals(1, result);
    }

    @Test
    public void numberWithManyDigits() {
        int result = roman.convert("VIII");
        Assertions.assertEquals(8, result);
    }

    @Test
    public void numberWithSubtractiveNotation() {
        try {
            int result = roman.convert("IV");
            Assertions.assertEquals(4, result);
            result = roman.convert("VL");
            Assertions.assertEquals(45, result);
            result = roman.convert("XC");
            Assertions.assertEquals(90, result);
            result = roman.convert("LD");
            Assertions.assertEquals(450, result);
            result = roman.convert("CM");
            Assertions.assertEquals(900, result);
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void numberWithAndWithoutSubtractiveNotation() {
        int result = roman.convert("XLIV");
        Assertions.assertEquals(44, result);
    }

    @Test
    public void illegalNumber() {

        {
            int result = roman.convert("VIV");
            Assertions.assertNotEquals(9, result);
        }
        {
            int result = roman.convert("VIV");
            Assertions.assertNotEquals(11, result);
        }

        {
            int result = roman.convert("IIV");
            Assertions.assertNotEquals(3, result);
        }

        {
            int result = roman.convert("IVV");
            Assertions.assertNotEquals(9, result);
        }

        {
            int result = roman.convert("IIVI");
            Assertions.assertNotEquals(10, result);
        }
    }
}

