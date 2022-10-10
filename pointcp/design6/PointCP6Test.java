package design6;
// This file contains material supporting section 2.9 of the textbook:

// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

import java.io.*;

import java.util.Random;

/**
 * This class prompts the user for a set of coordinates, and then
 * converts them from polar to cartesian or vice-versa.
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @author Paul Holden
 * @version July 2000
 */
public class PointCP6Test {
    private static Random r = new Random();

    private static int TEST_CASES = 1000;

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

        System.out.println("Cartesian-Polar Coordinates Conversion Test Program");

        long startTime = System.nanoTime();

        System.out.println("Generating Test Cases...");

        String[][] testCases = generateTestCases();

        System.out.println("Done Generating Test Cases");

        long testCaseTime = System.nanoTime();

        // START TIMER

        for (int i = 0; i < TEST_CASES; i++) {

            PointP6 point = null;
            // Check if the user input coordinates from the command line
            // If he did, create the PointCP object from these arguments.
            // If he did not, prompt the user for them.
            try {
                point = new PointP6(
                        Double.valueOf(testCases[i][0]).doubleValue(),
                        Double.valueOf(testCases[i][1]).doubleValue());
            } catch (Exception e) {
                // If we arrive here, it is because either there were no
                // command line arguments, or they were invalid
                if (args.length != 0)
                    System.out.println("Invalid arguments on command line");

            }

            System.out.println("\nYou entered:\n" + point);
            PointC6 pointC = point.convertStorageToCartesian();
            System.out.println("After asking to store as Cartesian:\n" + pointC);
            System.out.println("Finished " + (i + 1) + " out of " + TEST_CASES + " test cases.");
        }

        System.out.println("Polar Test Finished!\n");

        long polarTestTime = System.nanoTime();

        for (int i = 0; i < TEST_CASES; i++) {

            PointC6 point = null;
            // Check if the user input coordinates from the command line
            // If he did, create the PointCP object from these arguments.
            // If he did not, prompt the user for them.
            try {
                point = new PointC6(
                        Double.valueOf(testCases[i][0]).doubleValue(),
                        Double.valueOf(testCases[i][1]).doubleValue());
            } catch (Exception e) {
                // If we arrive here, it is because either there were no
                // command line arguments, or they were invalid
                if (args.length != 0)
                    System.out.println("Invalid arguments on command line");

            }

            System.out.println("\nYou entered:\n" + point);
            PointP6 pointP = point.convertStorageToPolar();
            System.out.println("After asking to store as Polar:\n" + pointP);
            System.out.println("Finished " + (i + 1) + " out of " + TEST_CASES + " test cases.");
        }

        long endTime = System.nanoTime();

        System.out.println("Results:\n");

        System.out.println("Average time to generate test cases: " + ((testCaseTime - startTime) / TEST_CASES));
        System.out.println("Average time to store and convert Polar test cases to Cartesian: "
                + ((polarTestTime - testCaseTime) / TEST_CASES));
        System.out.println("Average time to store and convert Cartesian Test cases to Polar: "
                + ((endTime - polarTestTime) / TEST_CASES));

        System.out.println("Time to generate test cases: " + ((testCaseTime - startTime)));
        System.out.println(
                "Average time to store and convert Polar test cases to Cartesian: " + (polarTestTime - testCaseTime));
        System.out.println(
                "Average time to store and convert Cartesian test cases to Polar: " + (endTime - polarTestTime));
        System.out.println("Total Time: " + ((endTime - startTime)));

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

    private static String[][] generateTestCases() {

        String[][] t = new String[TEST_CASES][2];

        for (int i = 0; i < TEST_CASES; i++) {

            System.out.println("Generating test case " + i);
            t[i][0] = Double.toString(r.nextDouble() * 10);
            t[i][1] = Double.toString(r.nextDouble() * 10);
        }
        return t;
    }
}