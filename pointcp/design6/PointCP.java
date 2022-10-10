package design6;
// This file contains material supporting section 2.9 of the textbook:

// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

/**
 * This class contains instances of coordinates in either polar or
 * cartesian format. It also provides the utilities to convert
 * them into the other type. It is not an optimal design, it is used
 * only to illustrate some design issues.
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @version July 2000
 */
public abstract class PointCP {
    // Instance variables ************************************************

    /**
     * Contains C(artesian) or P(olar) to identify the type of
     * coordinates that are being dealt with.
     */
    private char typeCoord;

    /**
     * Contains the current value of X or RHO depending on the type
     * of coordinates.
     */
    private double xOrRho;

    /**
     * Contains the current value of Y or THETA value depending on the
     * type of coordinates.
     */
    private double yOrTheta;

    // Constructors ******************************************************

    /**
     * Constructs a coordinate object, with a type identifier.
     */
    public PointCP(char type, double xOrRho, double yOrTheta) {
        if (type != 'C' && type != 'P')
            throw new IllegalArgumentException();
        this.xOrRho = xOrRho;
        this.yOrTheta = yOrTheta;
        typeCoord = type;
    }

    // Instance methods **************************************************

    public abstract double getX();

    public abstract double getY();

    public abstract double getRho();

    public abstract double getTheta();

    /**
     * Calculates the distance in between two points using the Pythagorean
     * theorem (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
     *
     * @param pointA The first point.
     * @param pointB The second point.
     * @return The distance between the two points.
     */
    public double getDistance(PointCP pointB) {
        // Obtain differences in X and Y, sign is not important as these values
        // will be squared later.
        double deltaX = getX() - pointB.getX();
        double deltaY = getY() - pointB.getY();

        return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
    }

    /**
     * Returns information about the coordinates.
     *
     * @return A String containing information about the coordinates.
     */
    public String toString() {
        return "Stored as " + (typeCoord == 'C'
                ? "Cartesian  (" + getX() + "," + getY() + ")"
                : "Polar [" + getRho() + "," + getTheta() + "]") + "\n";
    }
}