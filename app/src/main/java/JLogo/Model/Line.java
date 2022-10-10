//
// @author Alessio Giacché
//
package JLogo.Model;

/**
 * Interface created and implemented by the Segment
 * class. Provides methods that allow you to modify and return
 * initial and final coordinates of a given segment.
 * As well as a method for calculating the lenght.
 */

public interface Line {

    /**
     * This method return the initial Coordinate
     * of the Segment.
     *
     * @return the initial coordinate.
     */
    Position getInitialCoordinate();

    /**
     * This method return the final coordinate
     * of the Segment.
     *
     * @return final Coordinate.
     */
    Position getFinalCoordinate();

    /**
     * Return the size of the pen
     * used to draw this segment.
     */
    int getPenSize();

    /**
     * Returns the color of this
     * segment.
     */
    RGBColor getColorSegment();

    /**
     * This method allows you to calculate
     * the length of the segment given the
     * two coordinates.
     *
     * @return the length for Segment.
     */
    double calculateLength();
}
