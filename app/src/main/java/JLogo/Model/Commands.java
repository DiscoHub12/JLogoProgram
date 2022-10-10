//
// @author Alessio Giacché
//
package JLogo.Model;

/**
 * Interface implemented by the Movement class.
 * It provides a whole series of methods concerning
 * the movement of the cursor within the Area, consisting
 * of a list of instructions such as moving forward by a
 * given distance, set the angle direction of the cursor, which
 * can allow the creations of Segmens or Polygon and other.
 */
public interface Commands {


    /**
     * Move the Cursor forward by
     * a give distance.
     *
     * @param dist the distance to move.
     */
    void forward(double dist);

    /**
     * Move the Cursor backward by
     * a give distance.
     *
     * @param dist the distance to move.
     */
    void backward(double dist);

    /**
     * Counterclockwise rotation
     * of the cursor given an angle.
     *
     * @param angle the new angle for the Cursor.
     */
    void left(int angle);

    /**
     * Clockwise rotation
     * of the Cursor given an angle.
     *
     * @param angle the new angle for the Cursor.
     */
    void right(int angle);

    /**
     * Method that allow to clean
     * the Area from any Segments or Polygons.
     */
    void clearScreen();

    /**
     * Method that allow to move
     * the cursor to the "Home" position.
     */
    void home();

    /**
     * Method that allow to detach
     * the pen on the Plane.
     */
    void penUp();

    /**
     * Method that allow to stick
     * the pen on the Plane.
     */
    void penDown();

    /**
     * Method that allow to change the
     * color of the pen.
     *
     * @param b the first Byte for the RGBColor.
     * @param c the second Byte for the RGBColor.
     * @param d the third Byte for the RGBColor
     */
    void setPenColor(int b, int c, int d);

    /**
     * Method that allow to change
     * the color of closed Area if it is formed.
     *
     * @param b the first Byte for the RGBColor.
     * @param c the second Byte for the RGBColor.
     * @param d the third Byte for the RGBColor
     */
    void setFillColor(int b, int c, int d);

    /**
     * Method that allow to
     * change the color of the Area.
     *
     * @param b the first Byte for the RGBColor.
     * @param c the second Byte for the RGBColor.
     * @param d the third Byte for the RGBColor
     */
    void setScreenColor(int b, int c, int d);

    /**
     * Method that allow to set a pen
     * Size.
     *
     * @param size the new size for the pen.
     */
    void setPenSize(int size);
}
