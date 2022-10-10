package design2;

// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at http://www.site.uottawa.ca/school/research/lloseng/

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
public class PointCP2 {
    // Instance variables ************************************************

    /**
     * Contains C(artesian) or P(olar) to identify the type of
     * coordinates that are being dealt with.
     */
    private char typeCoord;

    /**
     * Contains the current value of RHO.
     */
    private double rho;

    /**
     * Contains the current value of THETA.
     */
    private double theta;

    // Constructors ******************************************************

    /**
     * Constructs a coordinate object, with a type identifier.
     * Stores in Polar and converts from Cartesian if necessary.
     */
    public PointCP2(char type, double rho, double theta) {
        if (type != 'C' && type != 'P')
            throw new IllegalArgumentException();
        this.typeCoord = type;
        if (this.typeCoord == 'C') {
            this.rho = (Math.sqrt(Math.pow(rho, 2) + Math.pow(theta, 2)));
            this.theta = Math.toDegrees(Math.atan2(theta, rho));
        } else {
            this.rho = rho;
            this.theta = theta;
        }

    }

    // Instance methods **************************************************

    public double getX() {
        return (Math.cos(Math.toRadians(theta)) * rho);
    }

    public double getY() {
        return (Math.sin(Math.toRadians(theta)) * rho);
    }

    public double getRho() {
        return rho;
    }

    public double getTheta() {
        return theta;
    }

    /**
     * Converts Cartesian coordinates to Polar coordinates.
     * Does nothing since this implementation has only one storage format
     */
    public static void convertStorageToPolar() {
        return;
    }

    /**
     * Converts Polar coordinates to Cartesian coordinates.
     * Does nothing since this implementation has only one storage format
     */
    public static void convertStorageToCartesian() {
        return;
    }

    /**
     * Calculates the distance in between two points using the Pythagorean
     * theorem (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
     *
     * @param pointA The first point.
     * @param pointB The second point.
     * @return The distance between the two points.
     */
    public double getDistance(PointCP2 pointB) {
        // Obtain differences in X and Y, sign is not important as these values
        // will be squared later.
        double deltaX = getX() - pointB.getX();
        double deltaY = getY() - pointB.getY();

        return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
    }

    /**
     * Rotates the specified point by the specified number of degrees.
     * Not required until E2.30
     *
     * @param point    The point to rotate
     * @param rotation The number of degrees to rotate the point.
     * @return The rotated image of the original point.
     */
    public PointCP2 rotatePoint(double rotation) {
        double radRotation = Math.toRadians(rotation);
        double X = getX();
        double Y = getY();

        return new PointCP2(typeCoord,
                (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
                (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
    }

    /**
     * Returns information about the coordinates.
     *
     * @return A String containing information about the coordinates.
     */
    public String toString() {
        return "Stored as Polar  (" + getTheta() + "," + getRho() + ")\n" +
                "Computed Cartesian as (" + getX() + ", " + getY() + ")";
    }
}