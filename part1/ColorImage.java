package part1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.List;


/*
 * reading the image from the ppm format
 * storing the pixel values in a Hashmap
 */

public class ColorImage {
    private String filename;
    private int width;
    private int height;
    private int depth;
    private Map<Integer, int[]> spreadMap = new HashMap<>(); // {[i, j]: [255, 255, 255]}



    /*
     * A constructor that creates an image from a file
     * public ColorImage(String filename)
     * you can read the image from the jpg or the ppm format (just choose one format)
     * you can use the JMF Java API to read jpg images
     * the ppm format is just a text file with the RGB values listed
     * the pixel values of the images are stored in an array representation of your choice
     * (to be described in the submitted document)
     */

    public ColorImage(String filename) {
        this.filename = filename;
    }





    /*
     * method that returns the 3-channel value of pixel at column i row j in the
     * form of a 3-element array
     * @param row
     * @param column 
     */
    
    public int[] getPixel(int i, int j) {
        if (i < 0 || i >= this.getWidth() || j < 0 || j < this.getHeight()) {
            throw new IllegalArgumentException("Coord Not in Frame");
        }
        List<Integer> pixelKey = Arrays.asList(i, j);
        return spreadMap.get(pixelKey);
    }

    /*
     * A reduceColor method that reduces the color space to a d-bit representation
     * public void reduceColor(int d)
     */

    public void reduceColor(int d) {
        
    }


    /*
     * The following image attributes (and the corresponding getter methods)
     * int width
     * int height
     * int depth (the number of bit per pixel)
     */

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getDepth() {
        return this.depth;
    }
}
