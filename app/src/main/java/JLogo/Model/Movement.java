//
// @author Alessio Giacché
//
package JLogo.Model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * This class gives a default implementation ot the "Commands" interface.
 * It implements methods provided by the interface regarding moving the
 * cursor and so on, as in the Logo program. Moving the Cursor when pen is
 * attached to the Area allow to generate Segments and if the Segments
 * close it forms a closed area /Polygon. The movements are made
 * via a certain Cursor in a certain Area.
 */
public class Movement implements Commands {

    /**
     * The cursor to apply the Movement into the
     * Area.
     */
    private final Cursor cursor;

    /**
     * The Area where the cursor resides, essential
     * to carry out a whole series of checks on the
     * generation of Segments, Polygon, check if the
     * movement of the cursor is outside the Area or other.
     */
    private final Area area;

    private final FoldPoly fold;


    public Movement(Area area) {
        Objects.requireNonNull(area);
        this.cursor = area.getCursor();
        this.area = area;
        fold = new FoldPoly();
    }


    @Override
    public void forward(double dist) {
        Position tmp = calcForwardPosition(dist);
        if (!this.area.coordinateInside(tmp))
            tmp = this.area.applyMaxCoordinate(tmp);
        if (!this.cursor.isPlot()) {
            this.cursor.setPosition(tmp);
        } else {
            Segment s = new Segment(this.cursor.getPosition(), tmp, this.cursor.getPenSize(), this.cursor.getColorLine());
            this.cursor.setPosition(tmp);
            this.area.addSegment(s);
            fold.createPoly(s, this.area);
        }
    }


    @Override
    public void backward(double dist) {
        Position tmp = calcBackwardPosition(dist);
        if (!this.area.coordinateInside(tmp))
            tmp = this.area.applyMaxCoordinate(tmp);
        if (!this.cursor.isPlot()) {
            this.cursor.setPosition(tmp);
        } else {
            Segment s = new Segment(this.cursor.getPosition(), tmp, this.cursor.getPenSize(), this.cursor.getColorLine());
            this.cursor.setPosition(tmp);
            this.area.addSegment(s);
            fold.createPoly(s, this.area);
        }

    }

    @Override
    public void left(int angle) {
        if (angle < 0 || angle > 360)
            throw new IllegalArgumentException("Illegal angle value.");
        int dir = this.cursor.getDirection();
        if (dir + angle > 360 || dir + angle < 0)
            throw new IllegalArgumentException("Illegal angle value.");
        this.cursor.setDirection(dir + angle);
    }

    @Override
    public void right(int angle) {
        if (angle < 0 || angle > 360)
            throw new IllegalArgumentException("Illegal angle value.");
        int dir = this.cursor.getDirection();
        if (dir - angle > 360 || dir - angle < 0)
            throw new IllegalArgumentException("Illegal angle value.");
        this.cursor.setDirection(dir - angle);
    }

    @Override
    public void clearScreen() {
        this.area.clear();
    }

    @Override
    public void home() {
        this.cursor.setPosition(this.area.homeCoordinate());
        this.cursor.setDirection(0);
    }

    @Override
    public void penUp() {
        this.cursor.setPlot(false);
    }

    @Override
    public void penDown() {
        this.cursor.setPlot(true);
    }

    @Override
    public void setPenColor(int b, int c, int d) {
        this.cursor.setColorLine(new RGBColor(b, c, d));
    }

    @Override
    public void setFillColor(int b, int c, int d) {
        this.cursor.setColorFill(new RGBColor(b, c, d));
    }

    @Override
    public void setScreenColor(int b, int c, int d) {
        this.area.setColorPlane(new RGBColor(b, c, d));
    }

    @Override
    public void setPenSize(int size) {
        this.cursor.setPenSize(size);
    }

    private double getCos(double dist) {
        double direction = this.cursor.getDirection();
        double cosA = dist * (Math.cos(Math.toRadians(direction)));
        BigDecimal bCosA = new BigDecimal(cosA).setScale(2, RoundingMode.HALF_UP);
        return bCosA.doubleValue();
    }

    private double getSin(double dist) {
        double direction = this.cursor.getDirection();
        double sinA = dist * (Math.sin(Math.toRadians(direction)));
        BigDecimal bSinA = new BigDecimal(sinA).setScale(2, RoundingMode.HALF_UP);
        return bSinA.doubleValue();
    }

    public Position calcForwardPosition(double dist) {
        if (dist <= 0)
            throw new IllegalArgumentException("Invalid distance.");
        Position tmp;
        double cosA = getCos(dist);
        double sinA = getSin(dist);
        tmp = new Position(this.cursor.getPosition().getX() + cosA, this.cursor.getPosition().getY() + sinA);
        return tmp;
    }

    public Position calcBackwardPosition(double dist) {
        if (dist <= 0)
            throw new IllegalArgumentException("Invalid distance.");
        Position tmp;
        double cosA = getCos(dist);
        double sinA = getSin(dist);
        tmp = new Position(this.cursor.getPosition().getX() - cosA, this.cursor.getPosition().getY() - sinA);
        return tmp;
    }
}
