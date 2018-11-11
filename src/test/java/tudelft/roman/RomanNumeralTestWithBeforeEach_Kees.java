package tudelft.roman;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RomanNumeralTestWithBeforeEach_Kees {

    private RomanNumeral_Kees roman;

    @BeforeEach
    public void initialize() {

        //this.roman = new RomanNumeral_Kees();
        this.roman = new RomanNumeral_Kees_SM();
    }

    @Test
    public void singleNumber() {
        try {
            int result = roman.convert("I");
            Assertions.assertEquals(1, result);
            result = roman.convert("V");
            Assertions.assertEquals(5, result);
            result = roman.convert("X");
            Assertions.assertEquals(10, result);
            result = roman.convert("L");
            Assertions.assertEquals(50, result);
            result = roman.convert("C");
            Assertions.assertEquals(100, result);
            result = roman.convert("D");
            Assertions.assertEquals(500, result);
            result = roman.convert("M");
            Assertions.assertEquals(1000, result);
            result = roman.convert("i");
            Assertions.assertEquals(1, result);
            result = roman.convert("v");
            Assertions.assertEquals(5, result);
            result = roman.convert("x");
            Assertions.assertEquals(10, result);
            result = roman.convert("l");
            Assertions.assertEquals(50, result);
            result = roman.convert("c");
            Assertions.assertEquals(100, result);
            result = roman.convert("d");
            Assertions.assertEquals(500, result);
            result = roman.convert("m");
            Assertions.assertEquals(1000, result);
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void numberWithManyDigits() {
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
        try {
            int result = roman.convert("XLIV");
            Assertions.assertEquals(44, result);
            result = roman.convert("XIX");
            Assertions.assertEquals(19, result);
            result = roman.convert("XCII");
            Assertions.assertEquals(92, result);
            result = roman.convert("MCMXCIX");
            Assertions.assertEquals(1999, result);
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void illegalNumber() {
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
            int result = roman.convert("XIXX");
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
