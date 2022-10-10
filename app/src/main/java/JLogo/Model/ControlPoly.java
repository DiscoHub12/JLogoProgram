//
// @author Alessio Giacché
//
package JLogo.Model;

import java.util.List;

/**
 * Useful interface for creation of a
 * Polygon, it provides a serie of methods that
 * allow to check if by moving the cursor to form
 * a Polygon, this is created or not, checking
 * if the segment are consecutive, if a
 * closed area is formed through a segment or not and
 * other.
 */
public interface ControlPoly {

    /**
     * This method allows to check whether
     * with a created segment (Segment s) it
     * returns to the starting point of
     * the drawing, creating a closed Area.
     *
     * @param s    the segment to check if it
     *             returns to the starting point
     * @param area the plane.
     * @return true if the Polygon is create ,
     * false otherwise.
     */
    boolean isPolyCreated(Segment s, Area area);

    /**
     * This method allows the actual creation
     * of the Polygon that will by passed to the
     * Area.
     *
     * @param s    the segment final.
     * @param area the plane.
     */
    void createPoly(Segment s, Area area);

    /**
     * This method allow to check if , when a
     * segment returns to its initial position,
     * the List of segment are consecutive or not,
     * at least, if the pen has always remained
     * attached to the plane.
     *
     * @param segment the List of segment to check.
     * @param area    the plane.
     * @return true if the list of segment is consecutive,
     * false otherwise.
     */
    boolean isConsecutive(List<Segment> segment, Area area);
}
