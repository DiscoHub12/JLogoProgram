//
// @author Alessio Giacché
//
package JLogoTest;

import JLogo.Model.Area;
import JLogo.Model.FoldPoly;
import JLogo.Model.Position;
import JLogo.Model.Segment;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FoldPolyTest {

    Area a = new Area(10, 10);
    FoldPoly fold = new FoldPoly();

    /**
     * Test that checks if a Polygon or closed area
     * is formed if the movement of the Cursor generating
     * Segments, these segments are consecutive and form
     * the correct closed Area.
     * This test, to avoid making many movements with
     * the Cursor, tests the correct creation with examples
     * of already created Segments.
     */
    @Test
    public void testIsPolyCreated() {
        Position ini = new Position(5, 5);
        Segment s = new Segment(new Position(5, 5), new Position(5, 7), a.getCursor().getPenSize(), a.getCursor().getColorLine());
        Segment s1 = new Segment(new Position(5, 7), new Position(7, 7), a.getCursor().getPenSize(), a.getCursor().getColorLine());
        Segment s2 = new Segment(new Position(7, 7), new Position(7, 5), a.getCursor().getPenSize(), a.getCursor().getColorLine());
        Segment s3 = new Segment(new Position(7, 5), new Position(5, 5), a.getCursor().getPenSize(), a.getCursor().getColorLine());
        a.addSegment(s);
        assertEquals(ini, a.segmentList().get(0).getInitialCoordinate());
        assertFalse(fold.isPolyCreated(s, a));
        a.addSegment(s1);
        assertEquals(ini, a.segmentList().get(0).getInitialCoordinate());
        assertFalse(fold.isPolyCreated(s1, a));
        a.addSegment(s2);
        assertEquals(ini, a.segmentList().get(0).getInitialCoordinate());
        assertFalse(fold.isPolyCreated(s2, a));
        a.addSegment(s3);
        assertEquals(ini, a.segmentList().get(0).getInitialCoordinate());
        assertTrue(fold.isPolyCreated(s3, a));
    }

    /**
     * Test that checks if the Segments are consecutive.
     * Examples of Segments of Lists of Segments were used
     * to verify the correct functioning of the method.
     */
    @Test
    public void testIsConsecutive() {
        Segment s = new Segment(new Position(5, 5), new Position(5, 7), a.getCursor().getPenSize(), a.getCursor().getColorLine());
        Segment s1 = new Segment(new Position(5, 7), new Position(7, 7), a.getCursor().getPenSize(), a.getCursor().getColorLine());
        Segment s2 = new Segment(new Position(7, 7), new Position(7, 5), a.getCursor().getPenSize(), a.getCursor().getColorLine());
        Segment s3 = new Segment(new Position(7, 5), new Position(5, 5), a.getCursor().getPenSize(), a.getCursor().getColorLine());
        Segment s4 = new Segment(new Position(8, 9), new Position(9, 9), a.getCursor().getPenSize(), a.getCursor().getColorLine());
        List<Segment> list = new ArrayList<>();
        list.add(s);
        list.add(s1);
        list.add(s2);
        list.add(s3);
        assertTrue(fold.isConsecutive(list, a));
        list.add(s4);
        assertFalse(fold.isConsecutive(list, a));
        Segment f = new Segment(new Position(5, 5), new Position(5, 7), a.getCursor().getPenSize(), a.getCursor().getColorLine());
        Segment f1 = new Segment(new Position(5, 7), new Position(7, 7), a.getCursor().getPenSize(), a.getCursor().getColorLine());
        Segment f2 = new Segment(new Position(7, 7), new Position(7, 5), a.getCursor().getPenSize(), a.getCursor().getColorLine());
        Segment f3 = new Segment(new Position(7, 5), new Position(5, 5), a.getCursor().getPenSize(), a.getCursor().getColorLine());
        Segment f4 = new Segment(new Position(5, 5), new Position(9, 9), a.getCursor().getPenSize(), a.getCursor().getColorLine());
        List<Segment> listo = new ArrayList<>();
        listo.add(f);
        listo.add(f1);
        listo.add(f2);
        listo.add(f3);
        listo.add(f4);
        assertTrue(fold.isConsecutive(listo, a));
        Segment r = new Segment(new Position(5, 5), new Position(7, 5), a.getCursor().getPenSize(), a.getCursor().getColorLine());
        Segment r1 = new Segment(new Position(7, 5), new Position(7, 7), a.getCursor().getPenSize(), a.getCursor().getColorLine());
        Segment r2 = new Segment(new Position(7, 7), new Position(7, 5), a.getCursor().getPenSize(), a.getCursor().getColorLine());
        Segment r3 = new Segment(new Position(3, 7), new Position(5, 5), a.getCursor().getPenSize(), a.getCursor().getColorLine());
        List<Segment> listo1 = new ArrayList<>();
        listo1.add(r);
        listo1.add(r1);
        listo1.add(r2);
        listo1.add(r3);
        assertFalse(fold.isConsecutive(listo1, a));
    }

}
