package part1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ColorHistogram {
    private int d;
    private int[] histogramData;
    private ColorImage associatedImage;
    private double imageResolution;
    private int array_size;
    

    /*
     * A constructor that construct a ColorHistogram instance for a d-bit image
     */
    public ColorHistogram(int d) {
        this.d = d; 
        this.array_size = (int)Math.pow(2, d*3);
    }

    /*
     * A constructor that construct a ColorHistogram from a text file
     */

    public ColorHistogram(String filename) throws FileNotFoundException, IOException{

        // this takes a file and computes all of the histogram values for each image
        // if you go to 25.jpg.txt the value [255,255,255] (white) is the first int
        // the second int is [255,255,254] etc

        File file = new File(filename); 
        Scanner scanner = new Scanner(file);

        this.array_size = scanner.nextInt();
        this.histogramData = new int[this.array_size];

        for (int i = 0; i < this.array_size; i++){
            this.histogramData[i] = scanner.nextInt();
        }
        scanner.close();
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
                this.histogramData[index] += 1;
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
        // calculate resolution
        for (int i = 0; i < this.array_size; i++){
            this.imageResolution += this.histogramData[i];
        }
        
        // you gotta normalize the histogram in the getHistogram method
        //(divide every value by the number of pixels in the image)
        double[] doubleData = new double[this.array_size];
        for(int i = 0; i < this.array_size; i++){
            doubleData[i] = histogramData[i] / imageResolution;
        }
        return doubleData;
    }

    /*
     * A save that saves the histogram into a text file (ColorHistogram)
     */

    public void save(String filename) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

        for(int i = 0; i < this.array_size; i++){
            writer.write(histogramData[i]);
        }

        writer.close();
    }

    public double compare(ColorHistogram hist) {
        // compare these two
        double sum = 0.0;
        double[] temp = this.getHistogram();
        double[] temp2 = hist.getHistogram();


        for (int i = 0; i < this.array_size; i++) {
            sum += Math.min(temp[i], temp2[i]);
        }

        return sum;
    }


}
