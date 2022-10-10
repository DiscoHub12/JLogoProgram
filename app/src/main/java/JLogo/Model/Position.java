//
// @author Alessio Giacché
//
package JLogo.Model;

/**
 * This class rapresents a Coordinate, that
 * is, ordered pairs of real numbers that identify
 * a point within a given Cartesian plane /plane,
 * composed of a point x and a point y of the plane.
 */
public class Position {

    /**
     * This value rapresent the
     * x point of a Coordinate.
     */
    private double x;

    /**
     * This value rapresent the
     * y point of a Coordinate.
     */
    private double y;

    /**
     * Constructor method that permit
     * to create a Coordinate by the x and y point.
     *
     * @param x the x point of a Coordinate.
     * @param y the y point of a Coordinate.
     */
    public Position(double x, double y) {
        this.setX(x);
        this.setY(y);
    }

    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        if (x < 0 || x >= Integer.MAX_VALUE)
            throw new IllegalArgumentException("Illegal X point.");
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        if (y < 0 || y >= Integer.MAX_VALUE)
            throw new IllegalArgumentException("Illegal Y point.");
        this.y = y;
    }

    /**
     * Equals method, allow to compare
     * two Objects, returning true if their
     * values are equal, in this case if the
     * Coordinates (point) is equal to a date.
     *
     * @param obj the Object to compare.
     * @return true if the Objects are equals,
     * false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (this == obj)
            return true;
        if (obj instanceof Position tmp) {
            return this.getX() == tmp.getX() && this.getY() == tmp.getY();
        }
        return false;
    }

    public String toString() {
        return "<" + this.getX() + "> <" + this.getY() + ">";
    }
}
