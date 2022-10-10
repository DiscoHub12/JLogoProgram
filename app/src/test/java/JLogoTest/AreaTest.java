//
// @author Alessio Giacché
//
package JLogoTest;

import JLogo.Model.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AreaTest {

    /**
     * Test the Get method for
     * the Base of the Area.
     */
    @Test
    public void testBase() {
        int x = 10;
        Area a = new Area(x, 4);
        assertEquals(10, a.getBase());

    }

    /**
     * Test the Get method for
     * the height of the Area.
     */
    @Test
    public void testHeight() {
        double x = 5.4;
        Area a = new Area(10, x);
        assertEquals(5.4, a.getHeight());

    }


    /**
     * Test the correct get color Area
     * after call the set method to modify color.
     */
    @Test
    public void testColorPlane() {
        Area a = new Area(10, 10);
        a.setColorPlane(new RGBColor(10, 11, 12));
        assertEquals(10, a.getColorPlane().getFirstByteColor());
        assertEquals(11, a.getColorPlane().getSecondByteColor());
        assertEquals(12, a.getColorPlane().getThirdByteColor());
    }

    /**
     * Test the method to return the cursor.
     */
    @Test
    public void testCursor() {
        Area a = new Area(10, 10);
        Cursor c = new Cursor(new Position(5, 5));
        c.setDirection(0);
        assertEquals(a.getCursor().getPosition(), c.getPosition());
        assertEquals(a.getCursor().getDirection(), (c.getDirection()));
    }

    /**
     * Test the correct values returned
     * after the homeCoordinate method. That
     * return the home coordinate of a Area.
     */
    @Test
    public void testHomePosition() {
        Area a = new Area(10, 10);
        assertEquals(5, a.homeCoordinate().getX());
        assertEquals(5, a.homeCoordinate().getY());
        Area b = new Area(14, 16);
        assertEquals(7, b.homeCoordinate().getX());
        assertEquals(8, b.homeCoordinate().getY());
        Area c = new Area(8, 10);
        assertEquals(4, c.homeCoordinate().getX());
        assertEquals(5, c.homeCoordinate().getY());
    }

    /**
     * Test the correct method that
     * verify if a determinate Coordinate values
     * is ok inside the area.
     */
    @Test
    public void testCoordinateInside() {
        Area a = new Area(10, 10);
        Position tmp = new Position(2, 5);
        assertTrue(a.coordinateInside(tmp));
        Position tmp1 = new Position(6.7, 8.9);
        assertTrue(a.coordinateInside(tmp1));
        Position tmp2 = new Position(0, 0);
        assertTrue(a.coordinateInside(tmp2));
        Position tmp3 = new Position(10, 10);
        assertTrue(a.coordinateInside(tmp3));
        Position f = new Position(12, 11);
        assertFalse(a.coordinateInside(f));
    }


    @Test
    public void testCoordinateInsidePoint() {
        Area a = new Area(10, 10);
        assertTrue(a.coordinateInside(new Position(4, 3)));
        assertTrue(a.coordinateInside(new Position(2, 9)));
        assertTrue(a.coordinateInside(new Position(10, 2)));
        assertTrue(a.coordinateInside(new Position(5, 8)));
        assertTrue(a.coordinateInside(new Position(9, 1)));
        assertFalse(a.coordinateInside(new Position(15, 19)));
        assertFalse(a.coordinateInside(new Position(15, 19)));
        assertFalse(a.coordinateInside(new Position(41, 89)));
        assertFalse(a.coordinateInside(new Position(71, 16)));
    }

    /**
     * Test the correct Coordinate
     * after call the applyMaxCoord method
     * that return the max coordinate inside Area.
     */
    @Test
    public void testApplyMaxCoord() {
        Area a = new Area(15, 15);
        Position f = new Position(16, 16);
        f = a.applyMaxCoordinate(f);
        assertEquals(15, f.getX());
        assertEquals(15, f.getY());
        Position t = new Position(17, 15);
        t = a.applyMaxCoordinate(t);
        assertEquals(15, t.getX());
        assertEquals(15, t.getY());
        Position d = new Position(25, 10);
        d = a.applyMaxCoordinate(d);
        assertEquals(15, d.getX());
        assertEquals(10, d.getY());
        Area b = new Area(6.80, 7.80);
        Position g = new Position(7.55, 8.98);
        g = b.applyMaxCoordinate(g);
        assertEquals(6.80, g.getX());
        assertEquals(7.80, g.getY());
    }

    /**
     * Test the correct method that
     * verify if the segment is present inside Area.
     */
    @Test
    public void testSegmentPresent() {
        Area a = new Area(10, 10);
        Segment s = new Segment(new Position(5, 5), new Position(7, 5), a.getCursor().getPenSize(), new RGBColor(0, 0, 0));
        a.segmentList().add(s);
        assertTrue(a.isSegmentPresent(s));
        Segment s1 = new Segment(new Position(4, 5), new Position(6, 7), a.getCursor().getPenSize(), new RGBColor(0, 0, 0));
        assertFalse(a.isSegmentPresent(s1));
        a.segmentList().add(s1);
        assertTrue(a.isSegmentPresent(s1));
    }

    /**
     * Test that checks the correct functioning
     * of adding a Segment inside the Area (Segment
     * created by the moving the Cursor inside it).
     * In this case, Segments have been created in order
     * to avoid moving the cursor again.
     */
    @Test
    public void testAddSegment() {
        Area a = new Area(10, 10);
        Segment s = new Segment(new Position(5, 5), new Position(7, 5), a.getCursor().getPenSize(), a.getCursor().getColorLine());
        Segment s2 = new Segment(new Position(7, 5), new Position(9, 5), a.getCursor().getPenSize(), a.getCursor().getColorLine());
        Segment s3 = new Segment(new Position(9, 5), new Position(9, 7), a.getCursor().getPenSize(), a.getCursor().getColorLine());
        Segment s4 = new Segment(new Position(9, 7), new Position(9, 9), a.getCursor().getPenSize(), a.getCursor().getColorLine());
        Segment s5 = new Segment(new Position(7, 9), new Position(7, 7), a.getCursor().getPenSize(), a.getCursor().getColorLine());
        a.addSegment(s);
        a.addSegment(s2);
        a.addSegment(s3);
        a.addSegment(s4);
        a.addSegment(s5);
        assertTrue(a.isSegmentPresent(s));
        assertTrue(a.isSegmentPresent(s2));
        assertTrue(a.isSegmentPresent(s3));
        assertTrue(a.isSegmentPresent(s4));
        assertTrue(a.isSegmentPresent(s5));
        assertThrows(IllegalArgumentException.class, () -> a.addSegment(s));
        assertThrows(IllegalArgumentException.class, () -> a.addSegment(s2));
        assertThrows(IllegalArgumentException.class, () -> a.addSegment(s3));
        assertThrows(IllegalArgumentException.class, () -> a.addSegment(s4));
        assertThrows(IllegalArgumentException.class, () -> a.addSegment(s5));
    }

    /**
     * Test that checks the correct functioning of
     * the presence or absence of the Polygon within
     * the Area of the Logo program. Again, Segments
     * hav been created by forming a Polygon in order to
     * avoid moving the Cursor.
     */
    @Test
    public void testPolygon() {
        Area a = new Area(10, 10);
        assertFalse(a.isPresentPolygon());
        assertThrows(NullPointerException.class, () -> a.addPolygon(null));
        Segment s = new Segment(new Position(5, 5), new Position(7, 5), a.getCursor().getPenSize(), a.getCursor().getColorLine());
        Segment s2 = new Segment(new Position(7, 5), new Position(7, 7), a.getCursor().getPenSize(), a.getCursor().getColorLine());
        Segment s3 = new Segment(new Position(7, 7), new Position(5, 7), a.getCursor().getPenSize(), a.getCursor().getColorLine());
        Segment s4 = new Segment(new Position(5, 7), new Position(5, 5), a.getCursor().getPenSize(), a.getCursor().getColorLine());
        List<Segment> tst = new ArrayList<>();
        tst.add(s);
        tst.add(s2);
        tst.add(s3);
        tst.add(s4);
        Polygon poly = new Polygon(tst, a.getCursor().getColorFill());
        a.addPolygon(poly);
        assertTrue(a.isPresentPolygon());
    }

    /**
     * Test thath checks the correct
     * functioning of Polygon addition within the LOGO
     * program Area.
     */
    @Test
    public void testAddPolygon() {
        Area a = new Area(10, 10);
        Segment s = new Segment(new Position(5, 5), new Position(5, 7), a.getCursor().getPenSize(), a.getCursor().getColorLine());
        Segment s1 = new Segment(new Position(5, 7), new Position(7, 7), a.getCursor().getPenSize(), a.getCursor().getColorLine());
        Segment s2 = new Segment(new Position(7, 7), new Position(7, 5), a.getCursor().getPenSize(), a.getCursor().getColorLine());
        Segment s3 = new Segment(new Position(7, 5), new Position(5, 5), a.getCursor().getPenSize(), a.getCursor().getColorLine());
        List<Segment> list = new ArrayList<>();
        list.add(s);
        list.add(s1);
        list.add(s2);
        list.add(s3);
        Polygon poly = new Polygon(list, a.getCursor().getColorFill());
        a.addPolygon(poly);
        assertTrue(a.isPresentPolygon());
        Polygon poly2 = new Polygon(list, a.getCursor().getColorFill());
        assertThrows(IllegalArgumentException.class, () -> a.addPolygon(poly2));
    }
}
