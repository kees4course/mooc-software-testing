package tudelft.roman;



public class RomanNumeral_Kees_SM extends RomanNumeral_Kees {

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
         - Results in 0 < number < 4000, so result type int is sufficient value
           value -1 could be used to signal error
           value 0 could be used for input of empty-string
         - When next symbol has higher value than previous, apply 3b
         - To check 3b, lowestnumber found will be: 5 if I, 10 x value if other symbol
         - When addition occurs, the added number cannot be lower than the highestnumber found so far
     */

    protected enum StateRoman {
        INITIAL, ADDORSUB, CHECKMAX3
    }


    protected boolean Check3a(int current_number, int lowest_addition) {
        boolean result = false;

        if (current_number<=lowest_addition) {
            result = true;
        }

        return result;
    }

    protected boolean Check3b(int current_number, int previous_number) {
        boolean result = false;

        if (current_number>previous_number) {

            if ((current_number == 5) && (previous_number == 1)) {
                result = true;
            } else if (current_number <= (10 * previous_number)) {
                result = true;
            }
        }

        return result;
    }

    protected boolean Check4a() {
        boolean result = false;

        return result;
    }

    protected boolean Check4b() {
        boolean result = false;

        return result;
    }

    public int convert(String s) throws Exception {
        int result = 0;
        StateRoman state = StateRoman.INITIAL;
        String roman_number = s.toUpperCase(); /* Rule 2 */
        int times_same = 0;
        Character current_symbol = null;
        boolean used_V = false;
        boolean used_L = false;
        boolean used_D = false;
        int current_number = 0;
        int previous_number = 0;
        int lowest_addition = 1000;  /* Start with highest symbol-value */

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

            switch (state) {
                case INITIAL:
                    lowest_addition = current_number;
                    result = current_number;
                    state = StateRoman.ADDORSUB;
                    break;
                case ADDORSUB:
                    if (Check3a(current_number,lowest_addition)) {

                        lowest_addition = current_number;
                        result += current_number;
                        if (current_number==previous_number) {
                            times_same = 1;
                            state = StateRoman.CHECKMAX3;
                        } else {
                            state = StateRoman.ADDORSUB;
                        }
                    } else {
                        if (Check3b(current_number,previous_number)) {
                            result += (-2*previous_number + current_number);
                            lowest_addition = current_number - 1;
                            state = StateRoman.ADDORSUB;
                        } else {
                            throw new Exception("Right side not lower than left side");
                        }
                    }
                    break;
                case CHECKMAX3:
                    if (Check3a(current_number,lowest_addition)) {
                        if (current_number==previous_number) {
                            times_same++;

                            /* Rule 4a? */
                            if (times_same>=3) {
                                throw new Exception("Found symbol'" + current_symbol + "' more than 3 times in a row");
                            }
                            state = StateRoman.CHECKMAX3;
                        } else  {
                            times_same = 0;
                            state = StateRoman.ADDORSUB;
                        }
                        lowest_addition = current_number;
                        result += current_number;
                    } else {
                        throw new Exception("Right side not lower than left side");
                    }
                    break;
                default:
                    throw new Exception("Illiegal/unimplemented state");
            }

            previous_number = current_number;
        }

        return result;
    }
}
