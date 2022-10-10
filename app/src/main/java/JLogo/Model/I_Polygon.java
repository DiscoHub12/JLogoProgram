//
// @author Alessio Giacché
//
package JLogo.Model;

import java.util.List;

/**
 * Interface implemented in the Polygon class for creating
 * Polygon. It is composed of two return methods, the firs a
 * List of Segment on which the Polygon is formed, the
 * second the Color of its internal area once formed.
 */
public interface I_Polygon {

    /**
     * Method that returns the list
     * of Segments on which the Polygon
     * is composed.
     *
     * @return the list of segment.
     */
    List<Segment> getPolySegment();

    /**
     * Method that returns the RGB Color
     * of the area inside the Polygon.
     *
     * @return the RGB color of internal area.
     */
    RGBColor getColorFill();
}
