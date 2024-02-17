import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.PriorityQueue;

import part1.ColorImage;
import part1.ColorHistogram;

public class SimilaritySearch {
    public static void main(String[] args) throws FileNotFoundException, IOException {

        if (args.length > 2 || args.length < 1) {
            System.err.println("java SimilaritySearch <image> <dataset>");
        }

        String image = args[0];

        PriorityQueue<Fucked> sorted = new PriorityQueue<>();

        ColorImage pixelImage = new ColorImage(image);
        pixelImage.reduceColor(3);      // reduce to 3 bit
        
        File dataFolder = new File(args[1]);
        File[] fileList = dataFolder.listFiles();
        ColorHistogram queryHistogram = new ColorHistogram(3);
        queryHistogram.setImage(pixelImage); // this is second histogram

        for (File i: fileList) {
            if (i.getName().charAt(i.getName().length()-1) == 't') { // if it's a jpg.txt file

                if (!i.exists()) {
                    System.out.println(i.getAbsolutePath());
                    continue; 
                }

                ColorHistogram fileHist = new ColorHistogram(i.getAbsolutePath()); // this is one histogram
            



                // compare histograms            
                // add returning value in dictionary, find highest # return top 5
                Fucked fuck = new Fucked(i.getName(), fileHist.compare(queryHistogram));
                sorted.add(fuck);

                /*if (sorted.size() < 5) {
                    sorted.add(fuck);
                } else if ((sorted.peek()).compareTo(fuck)  == -1 ) {
                    sorted.poll();
                    sorted.add(fuck);
                } */
            }          
        }

        // print out the top 5

        for ( int i = sorted.size(); i > 0; i --) {
            Fucked val = sorted.poll();
            System.out.println(val.getValue());
            System.out.printf("%d. %s%n%n", i, val.toString());
        }

        
        /*
         * you can assume that the histograms of the image dataset have been pre-computed 
         * however, you must compute the histogram of the query image
         * you can assume that the search is done on 3-bit color reduced images but make
         * your program as generic as possible (no hard-coding of the depth value except in the main method).
         * The program must print the name of the 5 most similar images to the query image
         */

        
    }
}

