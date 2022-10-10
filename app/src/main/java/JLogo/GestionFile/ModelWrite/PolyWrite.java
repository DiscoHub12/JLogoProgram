//
// @author Alessio Giacché
//
package JLogo.GestionFile.ModelWrite;

import JLogo.Model.Polygon;
import JLogo.Model.Segment;
import java.util.Objects;

/**
 * This class is used to transform the Polygon into a String with
 * the all segment that are composed and the color of the closed area.
 */
public class PolyWrite implements ModelWrite<Polygon> {

    private final SegmentWrite segWrite;

    private final ColorWrite colorWrite;

    public PolyWrite() {
        this.segWrite = new SegmentWrite();
        this.colorWrite = new ColorWrite();
    }

    public String strinOfPolySegment(Polygon poly) {
        Objects.requireNonNull(poly);
        String tmp = "";
        for (Segment s : poly.getPolySegment()) {
            tmp += "\n" + segWrite.stringOfElement(s);
        }
        return tmp;
    }

    @Override
    public String stringOfElement(Polygon element) {
        Objects.requireNonNull(element);
        return "POLYGON <" + element.getPolySegment().size() + ">" + colorWrite.stringOfElement(element.getColorFill()) +
                strinOfPolySegment(element);
    }
}
