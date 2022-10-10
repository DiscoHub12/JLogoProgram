//
// @author Alessio Giacché
//
package JLogoTest;

import JLogo.Model.Cursor;
import JLogo.Model.Position;
import JLogo.Model.RGBColor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CursorTest {

    Position tmp = new Position(5,5);

    /**
     * Test the illegal value.
     */
    @Test
    public void testIllegalValue(){
        double ill = Integer.MAX_VALUE;
        assertThrows(IllegalArgumentException.class, () -> new Cursor(new Position(ill, 10.0)));
        assertThrows(IllegalArgumentException.class, () -> new Cursor(new Position(10.0, ill)));
    }

    @Test
    public void testCreated(){
        Cursor cursor = new Cursor(tmp);
        RGBColor colorLine = new RGBColor(0,0,0);
        RGBColor colorArea = new RGBColor(255,255,255);
        assertEquals(tmp, cursor.getPosition());
        assertEquals(0, cursor.getDirection());
        assertEquals(1, cursor.getPenSize());
        assertEquals(colorLine, cursor.getColorLine());
        assertEquals(colorArea, cursor.getColorFill());
        assertFalse(cursor.isPlot());
    }

    /**
     * Test the correct position of this cursor.
     */
    @Test
    public void testPosition(){
        Position coord = new Position(19,19);
        Cursor c = new Cursor(coord);
        assertEquals(c.getPosition(), coord);
    }

    /**
     * Test the correct values after call
     * the set method to modify the coordinate
     * of this cursor.
     */
    @Test
    public void testSetPosition(){
        Cursor c = new Cursor(tmp);
        Position coord = new Position(19,19);
        c.setPosition(coord);
        assertEquals(c.getPosition(), coord);
    }

    /**
     * Test the get method for the
     * direction of this cursor.
     */
    @Test
    public void testDirection(){
        int x = 15;
        Cursor c = new Cursor(tmp);
        c.setDirection(x);
        assertEquals(15, c.getDirection());
    }

    /**
     * Test the correct values after call
     * the set method to modify the direction
     * of this cursor.
     */
    @Test
    public void testSetDirection(){
        Cursor c = new Cursor(tmp);
        c.setDirection(15);
        assertEquals(15, c.getDirection());
        c.setDirection(20);
        assertEquals(20, c.getDirection());
        assertThrows(IllegalArgumentException.class , () -> c.setDirection(361));
    }

    /**
     * Test the correct values of the colors after call
     * the set method to modify the color line
     * of this cursor.
     */
    @Test
    public void testColorLine(){
        Cursor c = new Cursor(tmp);
        c.setColorLine(new RGBColor(200,200,200));
        assertEquals(200, c.getColorLine().getFirstByteColor());
        assertEquals(200, c.getColorLine().getSecondByteColor());
        assertEquals(200, c.getColorLine().getThirdByteColor());
        c.setColorLine(new RGBColor(23,25,254));
        assertEquals(23, c.getColorLine().getFirstByteColor());
        assertEquals(25, c.getColorLine().getSecondByteColor());
        assertEquals(254, c.getColorLine().getThirdByteColor());

    }

    
    /**
     * Test the correct values of the colors after call
     * the set method to modify the color Area
     * of this cursor.
     */
    @Test
    public void testColorArea(){
        Cursor c = new Cursor(tmp);
        c.setColorFill(new RGBColor(200,200,200));
        assertEquals(200, c.getColorFill().getFirstByteColor());
        assertEquals(200, c.getColorFill().getSecondByteColor());
        assertEquals(200, c.getColorFill().getThirdByteColor());
        c.setColorFill(new RGBColor(23,25,254));
        assertEquals(23, c.getColorFill().getFirstByteColor());
        assertEquals(25, c.getColorFill().getSecondByteColor());
        assertEquals(254, c.getColorFill().getThirdByteColor());


    }

    /**
     * Test the correct pen size.
     */
    @Test
    public void testPenSize(){
        Cursor c = new Cursor(tmp);
        int x = 10;
        c.setPenSize(x);
        assertEquals(10, c.getPenSize());
        c.setPenSize(25);
        assertEquals(25, c.getPenSize());
        assertThrows(IllegalArgumentException.class, () -> c.setPenSize(0));
    }
}
