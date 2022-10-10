//
// @author Alessio Giacché
//
package JLogo.Model;

/**
 * Interface implemented in the Cursor class.
 * Offers a series of methods that allow changes and
 * modifications if not return the values
 * of variables contained within it, such
 * as position, direction and other.
 */

public interface I_Cursor {

    /**
     * This method return the Position
     * (the Coordinate) of the Cursor.
     *
     * @return the position (x,y) of the Cursor.
     */
    Position getPosition();

    /**
     * This method permit to set another
     * position for the Cursor.
     *
     * @param position the new position for
     *                 this Cursor.
     */
    void setPosition(Position position);

    /**
     * This method return the actually direction
     * of the Cursor.
     *
     * @return the Integer Value direction of the Cursor.
     */
    int getDirection();

    /**
     * This method permit to set another
     * direction for this Cursor.
     *
     * @param dir the new direction value.
     */
    void setDirection(int dir);

    /**
     * This method return the color of the Cursor pen.
     *
     * @return the RGB Color.
     */
    RGBColor getColorLine();

    /**
     * This method permit to set
     * another color of the Line.
     *
     * @param color the color for the pen.
     */
    void setColorLine(RGBColor color);

    /**
     * This method return the color of
     * a closed area that will form the
     * cursor through its displacements.
     *
     * @return the fill color.
     */
    RGBColor getColorFill();

    /**
     * This method permit to set the
     * fill Color.
     *
     * @param color the new fill color.
     */
    void setColorFill(RGBColor color);

    /**
     * This method return the Integer Value
     * of the pen Size.
     *
     * @return the pen size.
     */
    int getPenSize();

    /**
     * This method permit to set another
     * size of the pen.
     *
     * @param size the size of the pen.
     */
    void setPenSize(int size);

    /**
     * This method returns true if the
     * plot is positive, so if the pen
     * is attached to the Area (plane),
     * false otherwise.
     */
    boolean isPlot();

    /**
     * This method permit to set the
     * boolean variable for the plot.
     *
     * @param t the plot true or false.
     */
    void setPlot(boolean t);
}
