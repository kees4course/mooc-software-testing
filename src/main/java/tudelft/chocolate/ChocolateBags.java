package tudelft.chocolate;

public class ChocolateBags {

    /**
     * Calculates the least number of small bars to use to create a package of total kilo's
     *
     * @param small The number of small bars (1 kg)
     * @param big The number of big bars (5 kg)
     * @param total The total wieght of the package (kg)
     * @return The number of small bars, or -1 if it cannot be done using the current input
     */

    public int calculate(int small, int big, int total) {
        int maxBigBoxes = total / 5;
        int bigBoxesWeCanUse = maxBigBoxes < big ? maxBigBoxes : big;
        total -= (bigBoxesWeCanUse * 5);

        if(small < total)
            return -1;
        return total;

    }

}
