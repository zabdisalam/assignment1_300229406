package design3;

// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at http://www.site.uottawa.ca/school/research/lloseng/

import java.io.*;
import java.util.Scanner;

/**
 * This class prompts the user for a set of coordinates, and then
 * converts them from polar to cartesian or vice-versa.
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @author Paul Holden
 * @version July 2000
 */
public class PointCP3Test {
    // Class methods *****************************************************

    /**
     * This method is responsible for the creation of the PointCP
     * object. This can be done in two ways; the first, by using the
     * command line and running the program using <code> java 
     * PointCPTest &lt;coordtype (c/p)&gt; &lt;X/RHO&gt; &lt;Y/THETA&gt;
     * </code> and the second by getting the program to prompt the user.
     * If the user does not enter a valid sequence at the command line,
     * the program will prompte him or her.
     *
     * @param args[0] The coordinate type. P for polar and C for
     *                cartesian.
     * @param args[1] The value of X or RHO.
     * @param args[2] The value of Y or THETA.
     */
    public static void main(String[] args) {
        PointCP3 point;

        System.out.println("Cartesian-Polar Coordinates Conversion Program");

        // Check if the user input coordinates from the command line
        // If he did, create the PointCP object from these arguments.
        // If he did not, prompt the user for them.

        try {
            point = getInput();
        } catch (IOException ex) {
            System.out.println("Error getting input. Ending program.");
            return;
        }
        Scanner reader = new Scanner(System.in);
        String a = "";

        System.out.println(point);
        System.out.println("\nDo you want to convert to polar (YES/NO):\n");
        a = reader.next();
        String b = a.toUpperCase();
        if (b.equals("YES")) {
            PointCP3 p = point;
            p.convertStorageToPolar();
            System.out.println("\nAfter asking to convert to Polar:\n" + p.outputPolar());
        } else {
            System.out.println("The program has ended");
            return;
        }
    }

    /**
     * This method obtains input from the user and verifies that
     * it is valid. When the input is valid, it returns a PointCP
     * object.
     *
     * @return A PointCP constructed using information obtained
     *         from the user.
     * @throws IOException If there is an error getting input from
     *                     the user.
     */
    private static PointCP3 getInput() throws IOException {

        Scanner first = new Scanner(System.in);
        System.out.print("Enter the X Coordinate using a decimal point(.):");
        double x = first.nextDouble();

        Scanner second = new Scanner(System.in);
        System.out.print("Enter the Y Coordinate using a decimal point(.):");
        double y = second.nextDouble();

        return new PointCP3(x, y);
    }

}