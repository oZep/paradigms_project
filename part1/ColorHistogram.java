package part1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class ColorHistogram {
    private int d;
    private int[] histogramData;
    private ColorImage associatedImage;
    private int imageResolution;
    

    /*
     * A constructor that construct a ColorHistogram instance for a d-bit image
     */
    public ColorHistogram(int d) {

        //// this just reduces the images in the file to that value ( wrote a function for this but it's simple ) tbh this is just
        /// something like 

        this.d = d; // which you use elsewhere
        this.histogramData[] = new int[d];

        
    }

    /*
     * A constructor that construct a ColorHistogram from a text file
     */

    public ColorHistogram(String filename) throws FileNotFoundException{

        // this takes a file and computes all of the histogram values for each image
        // if you go to 25.jpg.txt the value [255,255,255] (white) is the first int
        // the second int is [255,255,254] etc

        File file = new File("./" + filename);
        Scanner scanner = new Scanner(file);
            
        scanner.nextInt();

        for (int i = 0; i < d; i++){
            histogramData[i] = scanner.nextInt();
        }

        // save resolution for normalization
        // source: https://stackoverflow.com/questions/672916/how-to-get-image-height-and-width-using-java
        BufferedImage image = ImageIO.read(file);
        imageResolution = image.getWidth() * image.getHeight();
    }

    /*
     * A setImage method that associate an image with a histogram instance
     */

    public void setImage(ColorImage image) {

        associatedImage = image;
        // this is the image you want to compare all histograms with

    }

    /*
     * A getHistogram method that returns the normalized histogram of the image
     */
    public double[] getHistogram() {

        //  you gotta normalize the histogram in the getHistogram method
        //(divide every value by the number of pixels in the image)
        double[] doubleData = new double[d];
        for(int i = 0; i < d; i++){
            doubleData[i] = histogramData[i];
            doubleData[i] /= imageResolution;
        }

        return doubleData;
    }

    /*
     * A save that saves the histogram into a text file (ColorHistogram)
     */

    public void SaveState(String filename) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

        for(int i = 0; i < d; i++){
            writer.write()
        }
    }
}