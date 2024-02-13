package part1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.io.File;  
import java.io.FileNotFoundException; 
import java.util.Scanner;

/*
 * reading the image from the ppm format
 * storing the pixel values in a Hashmap
 */

public class ColorImage {
    private String filename;
    private int width;
    private int height;
    private int depth;
    private int[][][] spreadMap;



    /*
     * A constructor that creates an image from a file
     * public ColorImage(String filename)
     * you can read the image from the jpg or the ppm format (just choose one format)
     * you can use the JMF Java API to read jpg images
     * the ppm format is just a text file with the RGB values listed
     * the pixel values of the images are stored in an array representation of your choice
     * (to be described in the submitted document)
     */

    /*
     * Sources: https://www.w3schools.com/java/java_files_read.asp
     */

    public ColorImage(String filename) {  
        try {
            File myImage = new File("./queryImages/" + filename);
            Scanner myReader = new Scanner(myImage);
            int count = 1;
            while (myReader.hasNextLine() && count > 0) {  // get rid of garbage data
                myReader.nextLine();
                count--;
            }

            int width = myReader.nextInt();
            int height = myReader.nextInt();
            spreadMap = new int[width][height][3];

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    spreadMap[i][j][0] = myReader.nextInt();
                    spreadMap[i][j][1] = myReader.nextInt();
                    spreadMap[i][j][2] = myReader.nextInt();
                }
            }

          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
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

        return spreadMap[i][j];
    }

    /*
     * A reduceColor method that reduces the color space to a d-bit representation
     * public void reduceColor(int d)
     */

    public void reduceColor(int d) {
        for (Integer)
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
