package tudelft.numfinder;

public class NumFinderMain {

    public static void main (String[] args) {
        NumFinder nf = new NumFinder();

        if (nf!=null) {
            //nf.find(new int[]{4, 3, 2, 1});
            nf.find(null);

            System.out.println(nf.getLargest());
            System.out.println(nf.getSmallest());
        } else {
            System.err.println("Unable to create NumFinder");
        }
    }
}
