//
// @author Alessio Giacché
//
package JLogo.Model;

import java.util.Objects;

/**
 * This class give a default implementation of "Line"
 * interface. Rapresents the Segment Object, which is
 * created by moving the Cursor within in the Plane (Area).
 * The Segment is composed of variables such as the Initial
 * Position (start, the starting point A of a Segment in a
 * Plane), the Final Position (end, the final point B of a Segment
 * in a plane), and through other variables such as the color and size.
 */
public class Segment implements Line {

    /**
     * The initial Position (Coordinate)
     * of the Segment.
     */
    private final Position start;

    /**
     * The final Positionc (Coordinate)
     * of the Segment.
     */
    private final Position end;

    /**
     * The size of the pen that draw
     * this Segment.
     */
    private final int penSize;

    /**
     * The color of the Segment.
     */
    private final RGBColor coloLine;

    /**
     * Constructor of the Segment.
     *
     * @param start     the initial position of the Segment.
     * @param end       the final position of the Segment.
     * @param penSize   the size of the pen for this Segment.
     * @param colorLine the color of the Segment.
     */
    public Segment(Position start, Position end, int penSize, RGBColor colorLine) {
        this.start = Objects.requireNonNull(start, "Start position of the Segment is null.");
        this.end = Objects.requireNonNull(end, "End position of the Segment is null.");
        this.penSize = penSize;
        this.coloLine = colorLine;
    }

    @Override
    public Position getInitialCoordinate() {
        return this.start;
    }

    @Override
    public Position getFinalCoordinate() {
        return this.end;
    }

    @Override
    public int getPenSize() {
        return this.penSize;
    }

    @Override
    public RGBColor getColorSegment() {
        return this.coloLine;
    }

    @Override
    public double calculateLength() {
        double x1 = this.start.getX();
        double x2 = this.end.getX();
        double y1 = this.start.getY();
        double y2 = this.end.getY();
        double diff1 = Math.pow(x2 - x1, 2);
        double diff2 = Math.pow(y2 - y1, 2);
        return Math.sqrt(diff1 + diff2);
    }

    /**
     * Equals method, allow to compare
     * two Objects, returning true if their
     * values are equal, in this case if the
     * Segment is equal to a date. In this case, two
     * Segment are equals if the variables Position start , end,
     * penSize and color are equals.
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
        if (obj instanceof Segment tmp) {
            return this.getInitialCoordinate().equals(tmp.getInitialCoordinate()) &&
                    this.getFinalCoordinate().equals(tmp.getFinalCoordinate()) &&
                    this.getPenSize() == tmp.getPenSize() && this.coloLine == tmp.getColorSegment();
        }
        return false;
    }

    public String toString() {
        return "<" + this.getInitialCoordinate().getX() + "><" +
                this.getInitialCoordinate().getY() + "><" + this.getFinalCoordinate().getX() +
                "><" + this.getFinalCoordinate().getY() + ">" + this.coloLine.toString() +
                " <" + this.getPenSize() + ">";
    }
}
