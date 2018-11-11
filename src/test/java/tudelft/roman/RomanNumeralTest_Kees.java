package tudelft.roman;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RomanNumeralTest_Kees {


    @Test
    public void singleNumber() {
        RomanNumeral_Kees roman = new RomanNumeral_Kees();

    }

    @Test
    public void numberWithManyDigits() {
        RomanNumeral roman = new RomanNumeral();
        try {
            int result = roman.convert("VIII");
            Assertions.assertEquals(8, result);
            result = roman.convert("MDCLXVI");
            Assertions.assertEquals(1666, result);
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void numberWithSubtractiveNotation() {
        RomanNumeral roman = new RomanNumeral();
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
        RomanNumeral roman = new RomanNumeral();
        try {
            int result = roman.convert("XLIV");
            Assertions.assertEquals(44, result);
            result = roman.convert("XCII");
            Assertions.assertEquals(92, result);
            result = roman.convert("MDCDXCIX");
            Assertions.assertEquals(1999, result);
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void illegalNumber() {
        RomanNumeral roman = new RomanNumeral();
        try {
            int result = roman.convert("iV");
            Assertions.assertEquals(4, result);
        } catch (Exception e) {

        }
        try {
            int result = roman.convert("VIV");
            Assertions.fail("Violation accepted");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            int result = roman.convert("XIX");
            Assertions.fail("Violation accepted");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            int result = roman.convert("IIV");
            Assertions.fail("Violation accepted");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            int result = roman.convert("IVV");
            Assertions.fail("Violation accepted");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            int result = roman.convert("IIVI");
            Assertions.fail("Violation accepted");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
