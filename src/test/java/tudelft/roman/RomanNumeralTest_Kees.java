package tudelft.roman;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RomanNumeralTest_Kees {


    @Test
    public void singleNumber() {
        RomanNumeral roman = new RomanNumeral();
        try {
            int result = roman.convert_kees("I");
            Assertions.assertEquals(1, result);
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void numberWithManyDigits() {
        RomanNumeral roman = new RomanNumeral();
        try {
            int result = roman.convert("VIII");
            Assertions.assertEquals(8, result);
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
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void illegalNumber() {
        RomanNumeral roman = new RomanNumeral();
        try {
            int result = roman.convert_kees("iV");
            Assertions.assertEquals(4, result);
        } catch (Exception e) {

        }
        try {
            int result = roman.convert_kees("VIV");
            Assertions.fail("Violation accepted");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            int result = roman.convert_kees("XIX");
            Assertions.fail("Violation accepted");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            int result = roman.convert_kees("IIV");
            Assertions.fail("Violation accepted");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            int result = roman.convert_kees("IVV");
            Assertions.fail("Violation accepted");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            int result = roman.convert_kees("IIVI");
            Assertions.fail("Violation accepted");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
