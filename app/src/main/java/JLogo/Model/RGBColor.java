//
// @author Alessio Giacché
//
package JLogo.Model;

/**
 * This class rapresents an RGB Color
 * composed of 3 Integer number from 0 to 255.
 * Useful for Setting colors for the Plane, the Segment
 * or the Cursor Pen.
 */

public class RGBColor {

    /**
     * This value rapresent the
     * first byte of an RGB Color.
     */
    private int firstByteColor;

    /**
     * This value rapresent the
     * second byte of an RGB Color.
     */
    private int secondByteColor;

    /**
     * This value rapresent the
     * third byte of an RGB Color.
     */
    private int thirdByteColor;

    /**
     * Constructor method, that permits
     * to create a new RGB Color.
     *
     * @param b1 the first number in byte.
     * @param b2 the second number in byte.
     * @param b3 the third number in byte.
     */
    public RGBColor(int b1, int b2, int b3) {
        this.setFirstByteColor(b1);
        this.setSecondByteColor(b2);
        this.setThirdByteColor(b3);
    }

    public int getFirstByteColor() {
        return firstByteColor;
    }

    public void setFirstByteColor(int firstByteColor) {
        if (firstByteColor < 0 || firstByteColor > 255)
            throw new IllegalArgumentException("Illegal first byte value for the RGB Color.");
        this.firstByteColor = firstByteColor;
    }

    public int getSecondByteColor() {
        return secondByteColor;
    }

    public void setSecondByteColor(int secondByteColor) {
        if (secondByteColor < 0 || secondByteColor > 255)
            throw new IllegalArgumentException("Illegal second byte value for the RGB Color.");
        this.secondByteColor = secondByteColor;
    }

    public int getThirdByteColor() {
        return thirdByteColor;
    }

    public void setThirdByteColor(int thirdByteColor) {
        if (thirdByteColor < 0 || thirdByteColor > 255)
            throw new IllegalArgumentException("Illegal third byte value for the RGB Color.");
        this.thirdByteColor = thirdByteColor;
    }

    /**
     * Equals method, allow to compare
     * two Objects, returning true if their
     * values are equal, in this case if the
     * RGBColor (value of the byte) is equal to a date.
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
        if (obj instanceof RGBColor tmp) {
            return this.getFirstByteColor() == tmp.getFirstByteColor() && this.getSecondByteColor() == tmp.getSecondByteColor()
                    && this.getThirdByteColor() == tmp.getThirdByteColor();
        }
        return false;
    }

    public String toString() {
        return " <" + this.getFirstByteColor() + "><" + this.getSecondByteColor() +
                "><" + this.getThirdByteColor() + "> ";
    }

}
