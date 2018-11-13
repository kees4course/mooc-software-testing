package tudelft.ghappy;

public class GHappy {

    public boolean gHappy(String str) {
        assert str!=null;
        boolean result = true;
        int i;

        for (i=0; i < str.length(); i++) {
            if (str.charAt(i) == 'g') {
                /* Before or after also an g? */
                if (false == ((i > 0) && (str.charAt(i-1)=='g'))) {
                    if (false == ((i+1 < str.length()) && (str.charAt(i+1)=='g'))) {
                        result = false;
                        /* One unhappy, no need to check the others */
                        break;
                    }
                }
            }
        }

        return result;
    }
}
