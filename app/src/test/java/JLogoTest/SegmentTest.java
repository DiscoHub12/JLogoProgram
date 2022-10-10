//
// @author Alessio Giacché
//
package JLogoTest;

import JLogo.Model.Position;
import JLogo.Model.RGBColor;
import JLogo.Model.Segment;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SegmentTest {

    RGBColor color = new RGBColor(0,0,0);
    /**
     * Test created to verify the correct
     * creation of a Segment by also
     * checking the various exceptions.
     */
    @Test
    public void testCreation(){
        Position tmp = new Position(3,4);
        Position tmp1 = new Position(5, 6);
        Segment s = new Segment(tmp, tmp1, 1, color);
        assertEquals(3, s.getInitialCoordinate().getX());
        assertEquals(4, s.getInitialCoordinate().getY());
        assertEquals(5, s.getFinalCoordinate().getX());
        assertEquals(6, s.getFinalCoordinate().getY());
        assertThrows(NullPointerException.class, () -> new Segment(null, tmp1, 1, color));
        assertThrows(NullPointerException.class, () -> new Segment(tmp, null, 1, color));
    }

    /**
     * Test the correct values after call
     * get method for the initial Coordinate of
     * this Segment.
     */
    @Test
    public void testStartPosition(){
        Position tmp = new Position(3,4);
        Position tmp1 = new Position(5, 6);
        Segment s = new Segment(tmp, tmp1, 1, color);
        assertEquals(tmp, s.getInitialCoordinate());
        assertThrows(NullPointerException.class, () -> new Segment(null, tmp1 , 1, color));

    }

    /**
     * Test the correct values after call
     * get method for the final Coordinate of this
     * Segment.
     */
    @Test
    public void testEndPosition(){
        Position tmp = new Position(3,4);
        Position tmp1 = new Position(5, 6);
        Segment s = new Segment(tmp, tmp1, 1, color);
        assertSame(tmp1, s.getFinalCoordinate());
        assertThrows(NullPointerException.class, () -> new Segment(tmp, null, 1, color));
    }


    /**
     * Test created to verify the correct
     * value of a length of a Segment
     * through its start and end Coordinate.
     */
    @Test
    public void testSegmentLenght(){
        Position tmp = new Position(5,5);
        Position tmp1 = new Position(5,7);
        Segment s = new Segment(tmp, tmp1, 1, color);
        assertEquals(2, s.calculateLength());
        tmp = new Position(4,5);
        tmp1 = new Position(5,5);
        s = new Segment(tmp, tmp1, 1, color);
        assertEquals(1, s.calculateLength());
        tmp = new Position(4,5);
        tmp1 = new Position(9,8);
        s = new Segment(tmp, tmp1, 1, color);
        assertEquals(5.830951894845301, s.calculateLength());
    }

    /**
     * Test the equals method.
     */
    @Test
    public void testEquals(){
        Position tmp = new Position(3,4);
        Position tmp1 = new Position(5,6);
        Segment s = new Segment(tmp, tmp1, 1, color);
        Segment s1 = new Segment(tmp, tmp1, 1, color);
        assertEquals(s, s1);
        Position f = new Position(6,6);
        Segment s2 = new Segment(tmp, f, 2, color);
        assertNotEquals(s, s2);

    }
}
