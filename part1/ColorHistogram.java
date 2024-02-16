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
    private int array_size;
    

    /*
     * A constructor that construct a ColorHistogram instance for a d-bit image
     */
    public ColorHistogram(int d) {

        //// this just reduces the images in the file to that value ( wrote a function for this but it's simple ) tbh this is just
        /// something like 

        this.d = d; // which you use elsewhere

        this.array_size = (int)Math.pow(2, d*3);
    }

    /*
     * A constructor that construct a ColorHistogram from a text file
     */

    public ColorHistogram(String filename) throws FileNotFoundException, IOException{

        // this takes a file and computes all of the histogram values for each image
        // if you go to 25.jpg.txt the value [255,255,255] (white) is the first int
        // the second int is [255,255,254] etc

        File file = new File("./" + filename);
        Scanner scanner = new Scanner(file);
            
        scanner.nextInt();

        for (int i = 0; i < d; i++){
            histogramData[i] = scanner.nextInt();
        }

        
        scanner.close();
        

        // save resolution for normalization
        // source: https://stackoverflow.com/questions/672916/how-to-get-image-height-and-width-using-java
        BufferedImage image = ImageIO.read(file);
        imageResolution = image.getWidth() * image.getHeight();
    }

    /*
     * A setImage method that associate an image with a histogram instance
     */

    public void setImage(ColorImage image) {
        this.associatedImage = image;
        if (this.histogramData == null) {
            this.constructHistogram();
        }

        // this is the image you want to compare all histograms with

    }

    public void constructHistogram() {
        this.histogramData = new int[array_size];
        for (int i= 0; i < associatedImage.getWidth(); i++){
            for (int j = 0; j < associatedImage.getHeight(); j++){
                int index = this.decimalConvertl(associatedImage.getPixel(i,j));
                histogramData[index] += 1;
            }
        }
    }

    private int decimalConvertl(int[] arr) {
        return (arr[0] << 2 * d) + (arr[1] << d) + arr[2];
    }

    /*
     * A getHistogram method that returns the normalized histogram of the image
     */
    public double[] getHistogram() {

        // you gotta normalize the histogram in the getHistogram method
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

    public void save(String filename) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

        for(int i = 0; i < d; i++){
            writer.write(histogramData[i]);
        }

        writer.close();
    }

    public double compare(ColorHistogram hist) {

        // compare these two
        double sum = 0;

        for (int i = 0; i < this.getHistogram().length; i++) {
            sum += Math.min(this.getHistogram()[i], this.histogramData[i]);
        }

        return sum;
    }


}