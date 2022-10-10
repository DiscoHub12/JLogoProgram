//
// @author Alessio Giacché
//
package JLogo.Model;

import java.util.List;
import java.util.Objects;

/**
 * This class provides a default implementation of the
 * I_Polygon interface. It Allows you to rapresent a Polygon/figure
 * closed, within our draweing Area.
 * The Polygon or closed area will surely be formed through segments
 * that create a closed area, then by moving the cursor.
 */
public class Polygon implements I_Polygon {

    /**
     * A list of Segments that form the closed area.
     * So When minimum of 3 Segments are consecutive and the
     * utility returns to the initial position ,
     * a closed area/Polygon is formed.
     */
    private final List<Segment> polySegment;

    /**
     * The RGBColor for the Polygon/closed Area.
     */
    private final RGBColor colorFill;


    public Polygon(List<Segment> segments, RGBColor color){
        Objects.requireNonNull(segments);
        Objects.requireNonNull(color);
        this.polySegment = segments;
        this.colorFill = color;
    }


    @Override
    public List<Segment> getPolySegment() {
        return this.polySegment;
    }

    @Override
    public RGBColor getColorFill() {
        return this.colorFill;
    }

    public String toString(){
        return "\nPOLYGON" + "<" + this.polySegment.size() + ">" + this.colorFill;
    }
}
