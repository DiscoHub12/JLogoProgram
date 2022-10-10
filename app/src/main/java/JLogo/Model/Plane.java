//
// @author Alessio Giacché
//
package JLogo.Model;

import java.util.List;

/**
 * This is the interface for the plane,
 * is implemented in the Area class and provides a
 * number of useful methods that will be
 * used into the program and permits to get, set,
 * and change values or variables. Especially composed
 * of methods that allow you to add Segment inside it, if
 * possible and has controls such as checking if a Coordinate
 * is ok inside the plane or not.
 */

public interface Plane {

    /**
     * Get method useful for
     * returning the base of the
     * area.
     *
     * @return the base of the area.
     */
    double getBase();

    /**
     * Get method useful for
     * returning the height of
     * the area.
     *
     * @return the height of the area.
     */
    double getHeight();

    /**
     * Get method useful for
     * returning the RGB Color of
     * the area.
     *
     * @return the RGB Color of the area.
     */
    RGBColor getColorPlane();

    /**
     * This method permit to set a new
     * color for the Area background.
     *
     * @param color the new RGB clor.
     */
    void setColorPlane(RGBColor color);

    /**
     * Get method useful for
     * returning the principal cursor
     * of this area.
     *
     * @return the cursor.
     */
    Cursor getCursor();

    /**
     * Get method useful for
     * returnin (if exists) the
     * Polugon created inside the Area.
     *
     * @return the Polygon in te Area.
     */
    Polygon getPolygon();

    /**
     * Method to calculate the home coordinate
     * then the central coordinate of the area.
     *
     * @return the new home coordinate.
     */
    Position homeCoordinate();

    /**
     * Useful method to check if
     * a given coordinate pased as parameters
     * can be inside the area or not.
     *
     * @param position the coordinate to check.
     * @return true if coordinate is ok inside area, false otherwise.
     */
    boolean coordinateInside(Position position);

    /**
     * Fondamental method for calculating
     * the maximum coordinate when passing a
     * coordinate that exceeds the base or area
     * of the area.
     *
     * @param position the coordinate to be checked.
     * @return the max coordinate.
     */
    Position applyMaxCoordinate(Position position);

    /**
     * Useful method to check if a segment is present
     * in the past two coordinates.
     *
     * @param s the segment to check.
     * @return true if segment is present, false otherwise.
     */
    boolean isSegmentPresent(Segment s);

    /**
     * This method is called when the
     * cursor (with the pen attached to the sheet)
     * generates a line (Segment) , and allows you
     * to check if that segment is present or not,
     * if not, it adds into the Area.
     *
     * @param s the Segment to add into the Area.
     */
    void addSegment(Segment s);

    /**
     * Useful method to check if a
     * Polygon already exists in the Area.
     *
     * @return true if a Polygon exists, false otherwise.
     */
    boolean isPresentPolygon();

    /**
     * This method permit to add the
     * Polygon to the Area created by
     * the segments, created by the
     * cursor movement to the Area
     *
     * @param polygon the polygon.
     */
    void addPolygon(Polygon polygon);

    /**
     * Useful method to get
     * all segment inside the list (the plane)
     *
     * @return the list of the segment.
     */
    List<Segment> segmentList();

    /**
     * This methods allow to delete the
     * draw segments/Polygon (by moving the
     * cursor) in the Area. New Clean Plane.
     */
    void clear();
}
