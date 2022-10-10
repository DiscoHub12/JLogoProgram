//
// @author Alessio Giacché
//
package JLogo.GestionFile.ModelWrite;

import JLogo.Model.Area;
import JLogo.Model.Segment;
import java.util.Objects;

/**
 * This class is used to transform the all Properties Area into a String with
 * the size of Area, the segment inside, the polygon.
 */
public class PlaneWrite implements ModelWrite<Area> {

    /**
     * This Object is fot printing the
     * RGBColor for the affected elements providing
     * a rapresentation in the form of String.
     */
    private final ColorWrite color;

    /**
     * This Object is to print all the characteristics
     * of the Polygon providing a rapresentation in
     * the form of a String.
     */
    private final PolyWrite polyWrite;

    /**
     * This Object is for printing all the
     * characteristics of the Segments providing
     * a rapresentation in the form of String.
     */
    private final SegmentWrite segmentWrite;

    public PlaneWrite() {
        this.color = new ColorWrite();
        this.polyWrite = new PolyWrite();
        this.segmentWrite = new SegmentWrite();
    }

    private String stringOfAreaSegment(Area element) {
        Objects.requireNonNull(element);
        int c = 1;
        String tmp = "";
        for (Segment s : element.segmentList()) {
            tmp += "\nLINE" + c + ":" + segmentWrite.stringOfElement(s);
            c++;
        }
        return tmp;
    }

    private String stringPolyIfExists(Area element) {
        Objects.requireNonNull(element);
        String tmp = "";
        if (element.isPresentPolygon()) {
            tmp = polyWrite.stringOfElement(element.getPolygon());
        } else tmp = "";
        return tmp;
    }

    @Override
    public String stringOfElement(Area element) {
        Objects.requireNonNull(element);
        return "SIZE <" + element.getBase() + "> <" + element.getHeight() + "> <" +
                color.stringOfElement(element.getColorPlane()) + stringOfAreaSegment(element) + "\n" +
                stringPolyIfExists(element);
    }
}
