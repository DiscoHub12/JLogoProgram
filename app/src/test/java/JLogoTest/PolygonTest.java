//
// @author Alessio Giacché
//
package JLogoTest;

import JLogo.Model.Area;
import JLogo.Model.Movement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PolygonTest {

    private final Area a = new Area(10,10);
    private final Movement mov = new Movement(a);

    /**
     * Test the correct creation of the Polygon or
     * closed Area.
     */
    @Test
    public void testCreated(){
        assertEquals(5, a.getCursor().getPosition().getX());
        assertEquals(5, a.getCursor().getPosition().getY());
        mov.penDown();
        mov.forward(2);
        assertEquals(7, a.getCursor().getPosition().getX());
        assertEquals(5, a.getCursor().getPosition().getY());
        mov.left(90);
        mov.forward(2);
        assertEquals(7, a.getCursor().getPosition().getX());
        assertEquals(7, a.getCursor().getPosition().getY());
        mov.left(90);
        mov.forward(2);
        assertEquals(5, a.getCursor().getPosition().getX());
        assertEquals(7, a.getCursor().getPosition().getY());
        mov.left(90);
        mov.forward(2);
        assertEquals(5, a.getCursor().getPosition().getX());
        assertEquals(5, a.getCursor().getPosition().getY());
        mov.penUp();
        assertTrue(a.isPresentPolygon());
        assertEquals(4, a.getPolygon().getPolySegment().size());
        mov.home();
        mov.penDown();
        mov.left(180);
        mov.forward(2);
        mov.penUp();
        assertEquals(5, a.segmentList().size());
    }

    /**
     * Test the correct color (RGBColor)
     * inside Polygon or closed area.
     */
    @Test
    public void testColor(){
        mov.setFillColor(3,6,8);
        mov.penDown();
        mov.forward(2);
        mov.left(90);
        mov.forward(2);
        mov.left(90);
        mov.forward(2);
        mov.left(90);
        mov.forward(2);
        mov.penUp();
        assertTrue(a.isPresentPolygon());
        assertEquals(3, a.getPolygon().getColorFill().getFirstByteColor());
        assertEquals(6, a.getPolygon().getColorFill().getSecondByteColor());
        assertEquals(8, a.getPolygon().getColorFill().getThirdByteColor());
    }
}
