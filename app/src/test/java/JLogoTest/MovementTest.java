//
// @author Alessio Giacché
//
package JLogoTest;
import JLogo.Model.Area;
import JLogo.Model.Movement;
import JLogo.Model.Position;
import JLogo.Model.Segment;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MovementTest {

    private final Area a = new Area(10,10);
    private final Movement mov = new Movement(a);

    /**
     * Test the correct functioning of the calculating
     * of the right Position for the forward
     * displacement.
     */
    @Test
    public void testCalculateForwardCoordinate(){
        assertEquals(5, a.getCursor().getPosition().getX());
        assertEquals(5, a.getCursor().getPosition().getY());
        Position f1 = mov.calcForwardPosition(2);
        assertEquals(7, f1.getX());
        assertEquals(5, f1.getY());
        a.getCursor().setPosition(new Position(7, 5));
        Position f2 = mov.calcForwardPosition(2);
        assertEquals(9, f2.getX());
        assertEquals(5, f2.getY());
        a.getCursor().setPosition(new Position(9, 5));
        mov.left(90);
        assertEquals(90, a.getCursor().getDirection());
        Position f3 = mov.calcForwardPosition(2);
        assertEquals(9, f3.getX());
        assertEquals(7, f3.getY());
        a.getCursor().setPosition(new Position(9, 7));
        Position f4 = mov.calcForwardPosition(2);
        assertEquals(9, f4.getX());
        assertEquals(9, f4.getY());
        a.getCursor().setPosition(new Position(9, 9));
        mov.left(90);
        assertEquals(180, a.getCursor().getDirection());
        Position f5 = mov.calcForwardPosition(2);
        assertEquals(7, f5.getX());
        assertEquals(9, f5.getY());
        a.getCursor().setPosition(new Position(7, 9));
        mov.left(90);
        assertEquals(270, a.getCursor().getDirection());
        Position f6 = mov.calcForwardPosition(2);
        assertEquals(7, f6.getX());
        assertEquals(7, f6.getY());
        a.getCursor().setPosition(new Position(7, 7));
        mov.right(90);
        assertEquals(180, a.getCursor().getDirection());
        Position f7 = mov.calcForwardPosition(2);
        assertEquals(5, f7.getX());
        assertEquals(7, f7.getY());
        a.getCursor().setPosition(new Position(5, 7));
        mov.right(45);
        assertEquals(135, a.getCursor().getDirection());
        Position f8 = mov.calcForwardPosition(2);
        assertEquals(3.59, f8.getX()); //3.585786437626905
        assertEquals(8.41, f8.getY()); //8.414213562373096

    }

    /**
     * Test the correct functioning of the method
     * for moving the Cursor via de forward method.
     */
    @Test
    public void testForward(){
        assertEquals(5, a.getCursor().getPosition().getX());
        assertEquals(5, a.getCursor().getPosition().getY());
        mov.penDown();
        mov.forward(2);
        assertEquals(7, a.getCursor().getPosition().getX());
        assertEquals(5, a.getCursor().getPosition().getY());
        assertEquals(1, a.segmentList().size());
        assertFalse(a.isPresentPolygon());
        mov.forward(2);
        assertEquals(9, a.getCursor().getPosition().getX());
        assertEquals(5, a.getCursor().getPosition().getY());
        assertEquals(2, a.segmentList().size());
        assertFalse(a.isPresentPolygon());
        mov.penDown();
        mov.left(90);
        assertEquals(90, a.getCursor().getDirection());
        mov.forward(2);
        assertEquals(9, a.getCursor().getPosition().getX());
        assertEquals(7, a.getCursor().getPosition().getY());
        assertEquals(3, a.segmentList().size());
        assertFalse(a.isPresentPolygon());
        mov.forward(2);
        assertEquals(9, a.getCursor().getPosition().getX());
        assertEquals(9, a.getCursor().getPosition().getY());
        assertEquals(4, a.segmentList().size());
        assertFalse(a.isPresentPolygon());
        mov.left(90);
        assertEquals(180, a.getCursor().getDirection());
        mov.forward(2);
        assertEquals(7, a.getCursor().getPosition().getX());
        assertEquals(9, a.getCursor().getPosition().getY());
        assertEquals(5, a.segmentList().size());
        assertFalse(a.isPresentPolygon());
        mov.forward(2);
        assertEquals(5, a.getCursor().getPosition().getX());
        assertEquals(9, a.getCursor().getPosition().getY());
        assertEquals(6, a.segmentList().size());
        assertFalse(a.isPresentPolygon());
        mov.left(90);
        assertEquals(270, a.getCursor().getDirection());
        mov.forward(2);
        assertEquals(5, a.getCursor().getPosition().getX());
        assertEquals(7, a.getCursor().getPosition().getY());
        assertEquals(7, a.segmentList().size());
        assertFalse(a.isPresentPolygon());
        mov.forward(2);
        assertEquals(5, a.getCursor().getPosition().getX());
        assertEquals(5, a.getCursor().getPosition().getY());
        assertEquals(8, a.segmentList().size());
        assertTrue(a.isPresentPolygon());
        mov.home();
        assertEquals(5, a.getCursor().getPosition().getX());
        assertEquals(5, a.getCursor().getPosition().getY());
        a.getCursor().setDirection(0);
        mov.penDown();
        assertThrows(IllegalArgumentException.class, () -> mov.forward(2));
        mov.penUp();
        mov.clearScreen();
        assertFalse(a.isPresentPolygon());
        assertEquals(0, a.segmentList().size());

    }

    /**
     * Test the correct functioning of the calculation
     * of the right position for the Backward displacement.
     */
    @Test
    public void testCalculateBackwardCoordinate(){
        assertEquals(5, a.getCursor().getPosition().getX());
        assertEquals(5, a.getCursor().getPosition().getY());
        Position f1 = mov.calcBackwardPosition(2);
        assertEquals(3, f1.getX());
        assertEquals(5, f1.getY());
        a.getCursor().setPosition(f1);
        Position f2 = mov.calcBackwardPosition(2);
        assertEquals(1, f2.getX());
        assertEquals(5, f2.getY());
        a.getCursor().setPosition(f2);
        mov.left(90);
        assertEquals(90, a.getCursor().getDirection());
        Position f3 = mov.calcBackwardPosition(2);
        assertEquals(1, f3.getX());
        assertEquals(3, f3.getY());
        a.getCursor().setPosition(f3);
        Position f4 = mov.calcBackwardPosition(2);
        assertEquals(1, f4.getX());
        assertEquals(1, f4.getY());
        a.getCursor().setPosition(f4);
        mov.left(90);
        assertEquals(180, a.getCursor().getDirection());
        Position f5 = mov.calcBackwardPosition(2);
        assertEquals(3, f5.getX());
        assertEquals(1, f5.getY());
        a.getCursor().setPosition(f5);
        Position f6 = mov.calcBackwardPosition(2);
        assertEquals(5, f6.getX());
        assertEquals(1, f6.getY());
        a.getCursor().setPosition(f6);
        mov.left(90);
        assertEquals(270, a.getCursor().getDirection());
        Position f7 = mov.calcBackwardPosition(2);
        assertEquals(5, f7.getX());
        assertEquals(3, f7.getY());
        a.getCursor().setPosition(f7);
        Position f8 = mov.calcBackwardPosition(2);
        assertEquals(5, f8.getX());
        assertEquals(5, f8.getY());
    }

    /**
     * Test the correct functioning of the method
     * for moving the Cursor via de backward method.
     */
    @Test
    public void testBackward(){
        assertEquals(5, a.getCursor().getPosition().getX());
        assertEquals(5, a.getCursor().getPosition().getY());
        mov.penDown();
        mov.backward(2);
        assertEquals(3, a.getCursor().getPosition().getX());
        assertEquals(5, a.getCursor().getPosition().getY());
        mov.backward(2);
        assertEquals(1, a.getCursor().getPosition().getX());
        assertEquals(5, a.getCursor().getPosition().getY());
        mov.left(90);
        assertEquals(90, a.getCursor().getDirection());
        mov.backward(2);
        assertEquals(1, a.getCursor().getPosition().getX());
        assertEquals(3, a.getCursor().getPosition().getY());
        mov.backward(2);
        assertEquals(1, a.getCursor().getPosition().getX());
        assertEquals(1, a.getCursor().getPosition().getY());
        mov.left(90);
        assertEquals(180, a.getCursor().getDirection());
        mov.backward(2);
        assertEquals(3, a.getCursor().getPosition().getX());
        assertEquals(1, a.getCursor().getPosition().getY());
        mov.backward(2);
        assertEquals(5, a.getCursor().getPosition().getX());
        assertEquals(1, a.getCursor().getPosition().getY());
        mov.left(90);
        assertEquals(270, a.getCursor().getDirection());
        mov.backward(2);
        assertEquals(5, a.getCursor().getPosition().getX());
        assertEquals(3, a.getCursor().getPosition().getY());
        mov.backward(2);
        assertEquals(5, a.getCursor().getPosition().getX());
        assertEquals(5, a.getCursor().getPosition().getY());
        mov.penUp();
        a.getCursor().setPosition(new Position(5,5));
        a.getCursor().setDirection(0);
        mov.penDown();
        assertThrows(IllegalArgumentException.class, () -> mov.backward(2));
    }

    /**
     * Test the correct direction of the
     * Cursor after changing counterclockwise.
     */
    @Test
    public void testLeftDirection(){
        assertEquals(0, a.getCursor().getDirection());
        mov.left(10);
        assertEquals(10, a.getCursor().getDirection());
        mov.left(135);
        assertEquals(145, a.getCursor().getDirection());
        mov.left(100);
        assertEquals(245, a.getCursor().getDirection());
        assertThrows(IllegalArgumentException.class, () -> mov.left(300));
        a.getCursor().setDirection(0);
    }

    /**
     * Test the correct direction of the
     * Cursor after changing clockwise.
     */
    @Test
    public void testRightDirection(){
        assertThrows(IllegalArgumentException.class, () -> mov.right(2));
        mov.left(300);
        mov.right(50);
        assertEquals(250, a.getCursor().getDirection());
        mov.right(50);
        assertEquals(200, a.getCursor().getDirection());
        mov.right(50);
        assertEquals(150, a.getCursor().getDirection());
        mov.right(50);
        assertEquals(100, a.getCursor().getDirection());

    }

    /**
     * Test for proper operation to clean
     * the Area of any Polygons or Segments.
     */
    @Test
    public void testClearScreen(){
        Segment s = new Segment(new Position(5,5), new Position(6,5), a.getCursor().getPenSize(), a.getCursor().getColorLine());
        Segment s1 = new Segment(new Position(6,5), new Position(7,5), a.getCursor().getPenSize(), a.getCursor().getColorLine());
        Segment s2 = new Segment(new Position(7,5), new Position(8,5), a.getCursor().getPenSize(), a.getCursor().getColorLine());
        Segment s3 = new Segment(new Position(8,5), new Position(9,5), a.getCursor().getPenSize(), a.getCursor().getColorLine());
        a.segmentList().add(s);
        a.segmentList().add(s1);
        a.segmentList().add(s2);
        a.segmentList().add(s3);
        assertEquals(4, a.segmentList().size());
        mov.clearScreen();
        assertEquals(0, a.segmentList().size());
    }

    /**
     * Test the correct functioning of the
     * Home method. (Cursor positioned in the
     * Center of the Area of Logo)
     */
    @Test
    public void testHome(){
        assertEquals(5, a.getCursor().getPosition().getX());
        assertEquals(5, a.getCursor().getPosition().getY());
        mov.forward(2);
        assertEquals(7, a.getCursor().getPosition().getX());
        assertEquals(5, a.getCursor().getPosition().getY());
        mov.home();
        assertEquals(5, a.getCursor().getPosition().getX());
        assertEquals(5, a.getCursor().getPosition().getY());
    }

    /**
     * Test the correct functioning for
     * detach the Pen from the Paper.
     */
    @Test
    public void testPenUp(){
        assertFalse(a.getCursor().isPlot());
        mov.penUp();
        assertFalse(a.getCursor().isPlot());
    }

    /**
     * Test the correct functioning for
     * the attachment of the Pen on the Paper.
     */
    @Test
    public void testPenDown(){
        assertFalse(a.getCursor().isPlot());
        mov.penDown();
        assertTrue(a.getCursor().isPlot());
    }

    /**
     * Test the correct color (RGBColor)
     * for the pen.
     */
    @Test
    public void testSetPenColor(){
        assertEquals(0, a.getCursor().getColorLine().getFirstByteColor());
        assertEquals(0, a.getCursor().getColorLine().getSecondByteColor());
        assertEquals(0, a.getCursor().getColorLine().getThirdByteColor());
        mov.setPenColor(2,3,4);
        assertEquals(2, a.getCursor().getColorLine().getFirstByteColor());
        assertEquals(3, a.getCursor().getColorLine().getSecondByteColor());
        assertEquals(4, a.getCursor().getColorLine().getThirdByteColor());
        mov.setPenColor(10,100,130);
        assertEquals(10, a.getCursor().getColorLine().getFirstByteColor());
        assertEquals(100, a.getCursor().getColorLine().getSecondByteColor());
        assertEquals(130, a.getCursor().getColorLine().getThirdByteColor());
        assertThrows(IllegalArgumentException.class, () -> mov.setPenColor(256, -1, 256));

    }

    /**
     * Test the correct color (RGBColor)
     * for the fill color.
     */
    @Test
    public void testSetFillColor(){
        assertEquals(255, a.getCursor().getColorFill().getFirstByteColor());
        assertEquals(255, a.getCursor().getColorFill().getSecondByteColor());
        assertEquals(255, a.getCursor().getColorFill().getThirdByteColor());
        mov.setFillColor(10,11,12);
        assertEquals(10, a.getCursor().getColorFill().getFirstByteColor());
        assertEquals(11, a.getCursor().getColorFill().getSecondByteColor());
        assertEquals(12, a.getCursor().getColorFill().getThirdByteColor());
        mov.setFillColor(155, 155, 156);
        assertEquals(155, a.getCursor().getColorFill().getFirstByteColor());
        assertEquals(155, a.getCursor().getColorFill().getSecondByteColor());
        assertEquals(156, a.getCursor().getColorFill().getThirdByteColor());
        assertThrows(IllegalArgumentException.class, () -> mov.setFillColor(256, -1, 256));
    }

    /**
     * Test the correct color (RGBColor)
     * for the Screen.
     */
    @Test
    public void testSetScreenColor(){
        assertEquals(255, a.getColorPlane().getFirstByteColor());
        assertEquals(255, a.getColorPlane().getSecondByteColor());
        assertEquals(255, a.getColorPlane().getThirdByteColor());
        mov.setScreenColor(10,11,12);
        assertEquals(10, a.getColorPlane().getFirstByteColor());
        assertEquals(11, a.getColorPlane().getSecondByteColor());
        assertEquals(12, a.getColorPlane().getThirdByteColor());
        mov.setScreenColor(145,145,146);
        assertEquals(145, a.getColorPlane().getFirstByteColor());
        assertEquals(145, a.getColorPlane().getSecondByteColor());
        assertEquals(146, a.getColorPlane().getThirdByteColor());
        assertThrows(IllegalArgumentException.class, () -> mov.setScreenColor(256, -1, 256));
    }

    /**
     * Test the correct pen Size.
     */
    @Test
    public void testPenSize(){
        assertEquals(1, a.getCursor().getPenSize());
        mov.setPenSize(2);
        assertEquals(2, a.getCursor().getPenSize());
        mov.setPenSize(3);
        assertEquals(3, a.getCursor().getPenSize());
        assertThrows(IllegalArgumentException.class, () -> mov.setPenSize(-1));
    }

}
