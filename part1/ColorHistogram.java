package part1;

public class ColorHistogram {
    

    /*
     * A constructor that construct a ColorHistogram instance for a d-bit image
     */
    public ColorHistogram(int d) {


        //// this just reduces the images in the file to that value
        
    }

    /*
     * A constructor that construct a ColorHistogram from a text file
     */

    public ColorHistogram(String filename) {

        // this takes a file and computes all of the histogram values for each image
        // if you go to 25.jpg.txt the value [255,255,255] (white) is the first int
        // the second int is [255,255,254] etc

    }

    /*
     * A setImage method that associate an image with a histogram instance
     */

    public void setImage(ColorImage image) {

        // this is the image you want to compare all histograms with

    }

    /*
     * A getHistogram method that returns the normalized histogram of the image
     */
    public double[] getHistogram() {

        //  you gotta normalize the histogram in the getHistogram method
        //(divide every value by the number of pixels in the image)



        double[] temp = {2.0,2.0};
        return temp;
    }

    /*
     * A save that saves the histogram into a text file (ColorHistogram)
     */

    public void SaveState(String filename) {

    }
}
