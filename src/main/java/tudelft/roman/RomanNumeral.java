package tudelft.roman;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeral {

    private static Map<Character, Integer> map;

    static {
        map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int convert(String s) {

        int convertedNumber = 0;
        for(int i = 0; i < s.length(); i++) {
            int currentNumber = map.get(s.charAt(i));
            int next = i+1 < s.length() ? map.get(s.charAt(i+1)) : 0;

            if(currentNumber >= next)
                convertedNumber += currentNumber;
            else
                convertedNumber -= currentNumber;
        }

        return convertedNumber;

    }

    /*
        Roman number requirements:
        1. Symbol-> value as shown in datatype map
        2. Symbols can be capitalized, but is not mandatory
        3a Starts with big value on left to small on right which should be added,
        3b  only exception is when preceded with 1 smaller value (I for V or 10 times in other cases)
          then this smaller value should be substracted
        4a Maximum 3 symbols on a row,
        4b except V, L and D which are used only 1 time in the whole number

         Analyse:
         - Results in 0 < number < 40000, so result type int is sufficient value
           value -1 could be used to signal error
           value 0 could be used for input of empty-string
         - When next symbol has higher value than previous, apply 3b
         - To check 3b, lowestnumber found will be: 5 if I, 10 x value if other symbol
         - When addition occurs, the added number cannot be lower than the highestnumber found so far
     */
    public int convert_kees(String s) throws Exception {
        int result = 0;
        String roman_number = s.toUpperCase(); /* Rule 2 */
        int times_same = 0;
        Character current_symbol = null;
        boolean used_substraction = false;
        boolean used_V = false;
        boolean used_L = false;
        boolean used_D = false;
        int current_number = 0;
        int previous_number = 0;
        int highest_addition = 2*1000; /* Start with highest symbol-value */


        for(int i = 0; i < s.length(); i++) {
            current_symbol = roman_number.charAt(i);

            /* Check rules 1 and 4b */
            switch (current_symbol) {
                case 'I':
                    current_number = 1;
                    break;
                case 'V':
                    if (used_V) {
                        throw new Exception("Symbol 'V' used more than once");
                    }
                    used_V = true;
                    current_number = 5;
                    break;
                case 'X':
                    current_number = 10;
                    break;
                case 'L':
                    if (used_L) {
                        throw new Exception("Symbol 'L' used more than once");
                    }
                    used_L = true;
                    current_number = 50;
                    break;
                case 'C':
                    current_number = 100;
                    break;
                case 'D':
                    if (used_D) {
                        throw new Exception("Symbol 'D' used more than once");
                    }
                    used_D = true;
                    current_number = 500;
                    break;
                case 'M':
                    current_number = 1000;
                    break;
                default:
                    throw new Exception("Symbol '" + current_symbol + "'not a known roman-symbol");
            }


            /* Check rule 3a */
            if (current_number<highest_addition) {

                if (current_number==previous_number) {
                    times_same++;

                    /* Rule 4a? */
                    if (times_same>=3) {
                        throw new Exception("Found symbol'" + current_symbol + "' more than 3 times in a row");
                    } else {
                        result += current_number;
                    }
                } else {

                    times_same = 0;
                }

                /* Set highest allowable addition */
                if (current_number==1) {
                    highest_addition = 5;
                } else {
                    highest_addition = 10 * current_number;
                }

                result += current_number;
            } else {

                /* Symbol is the same? */
                if (current_number==previous_number) {
                    times_same++;

                    /* Rule 4a? */
                    if (times_same>=3) {
                        throw new Exception("Found symbol'" + current_symbol + "' more than 3 times in a row");
                    } else {
                        result += current_number;
                    }
                } else {

                    /* Rule 3b? */
                    if (current_number<=highest_addition) {
                        if (times_same==0) {
                            highest_addition = previous_number - 1;
                            result = (-previous_number + current_number);
                        } else {
                            throw new Exception("Substraction can only applied once");
                        }
                    } else {
                        throw new Exception("Right side not lower than left side");
                    }
                }
            }


            previous_number = current_number;
        }

        return result;
    }
}
