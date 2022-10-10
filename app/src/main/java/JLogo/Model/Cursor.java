//
// @author Alessio Giacché
//
package JLogo.Model;

import java.util.Objects;

/**
 * This class rapresents a Cursor (default implementation
 * of the I_Cursor interface) for the Area of program Logo.
 * It able to move and draw segments by the Movements. It has
 * within it several variables such as position, direction
 * the size of the pen and more.
 */
public final class Cursor implements I_Cursor {

    /**
     * The Position (Coordinate) of this Cursor.
     */
    private Position position;

    /**
     * The direction of this Cursor.
     */
    private int direction;

    /**
     * The color for Line (pen) of this Cursor.
     */
    private RGBColor colorLine;

    /**
     * The color inside the polygon area.
     */
    private RGBColor colorFill;

    /**
     * The size of the pen.
     */
    private int penSize;

    /**
     * This boolean parameter indicates
     * wether during a move the Cursor generates
     * a path or not.
     */
    private boolean plot;

    /**
     * Constructor of Cursor instance.
     *
     * @param position the Cursor standard position.
     */
    public Cursor(Position position) {
        this.position = Objects.requireNonNull(position, "The position is null.");
        this.direction = 0;
        this.colorLine = new RGBColor(0, 0, 0);
        this.colorFill = new RGBColor(255, 255, 255);
        this.penSize = 1;
        this.plot = false;
    }


    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = Objects.requireNonNull(position, "Position is null.");
    }

    @Override
    public int getDirection() {
        return this.direction;
    }

    @Override
    public void setDirection(int dir) {
        if (dir < 0 || dir > 360)
            throw new IllegalArgumentException("Illegal direction value.");
        this.direction = dir;

    }

    @Override
    public RGBColor getColorLine() {
        return this.colorLine;
    }

    @Override
    public void setColorLine(RGBColor color) {
        Objects.requireNonNull(color);
        this.colorLine = color;
    }

    @Override
    public RGBColor getColorFill() {
        return this.colorFill;
    }

    @Override
    public void setColorFill(RGBColor color) {
        Objects.requireNonNull(color);
        this.colorFill = color;
    }

    @Override
    public int getPenSize() {
        return this.penSize;
    }

    @Override
    public void setPenSize(int size) {
        if (size < 1)
            throw new IllegalArgumentException("Illegal pen size.");
        this.penSize = size;
    }

    @Override
    public boolean isPlot() {
        return this.plot;
    }

    @Override
    public void setPlot(boolean t) {
        this.plot = t;
    }
}
