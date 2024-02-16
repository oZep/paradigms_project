package part1;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;  
import java.io.FileNotFoundException; 
/*
 * reading the image from the ppm format
 * storing the pixel values in a list matrix
 */

public class ColorImage {
    private int width;
    private int height;
    private int depth;
    private int[][][] spreadMatrix;



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
     * https://stackoverflow.com/questions/41783414/get-bits-per-pixel-of-a-bufferedimage 
     */

    /**
     * @param filename
     * @throws IOException 
     */
    public ColorImage(String filename) throws IOException {  
        try {
            File file = new File(filename);
            BufferedImage myImage = ImageIO.read(file);
            this.width = myImage.getWidth();
            this.height = myImage.getHeight();
            spreadMatrix = new int[width][height][3];

            for (int i = 0; i < this.width; i++) { 
                for (int j = 0; j < this.height; j++) {
                    int pix = myImage.getRGB(i, j);
                    //System.out.print(Integer.toString(pix & 0xff) + "\n");
                    // Source: https://stackoverflow.com/questions/25761438/understanding-bufferedimage-getrgb-output-values
                    spreadMatrix[i][j][0] = (pix & 0xff0000) >> 16;
                    spreadMatrix[i][j][1] = (pix & 0xff00) >> 8;
                    spreadMatrix[i][j][2] = pix & 0xff; 
                }


                // find depth
                // Source: https://stackoverflow.com/questions/25761438/understanding-bufferedimage-getrgb-output-values
                this.depth = myImage.getColorModel().getPixelSize();


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
        if (i < 0 || i >= this.getWidth() || j < 0 || j >= this.getHeight()) {
            throw new IllegalArgumentException("Coord Not in Frame");
        }
        return spreadMatrix[i][j];
    }

    /*
     * A reduceColor method that reduces the color space to a d-bit representation
     * public void reduceColor(int d)
     */

    public void reduceColor(int d) {
        for (int i = 0; i < this.width; i++) { 
            for (int j = 0; j < this.height; j++) {
                spreadMatrix[i][j][0] = spreadMatrix[i][j][0]>>(8-d);
                spreadMatrix[i][j][1] = spreadMatrix[i][j][1]>>(8-d);
                spreadMatrix[i][j][2] = spreadMatrix[i][j][2]>>(8-d);
            }
        }
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
