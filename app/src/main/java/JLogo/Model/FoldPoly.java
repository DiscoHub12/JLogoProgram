//
// @author Alessio Giacché
//
package JLogo.Model;

import java.util.List;
import java.util.Objects;

/**
 * Class that implmements the "ControlPoly" interface.
 * It allows to verify the actual creation of polygon, in fact,
 * these methods offered are often called on the cursor movements,
 * when the cursor actually generates the path or not.
 */
public class FoldPoly implements ControlPoly {

    @Override
    public boolean isPolyCreated(Segment s, Area area) {
        Objects.requireNonNull(s);
        Objects.requireNonNull(area);
        Position ini = area.segmentList().get(0).getInitialCoordinate();
        if (area.segmentList().size() < 3 || area.isPresentPolygon())
            return false;
        return ini.equals(s.getFinalCoordinate()) && isConsecutive(area.segmentList(), area);
    }

    @Override
    public void createPoly(Segment s, Area area) {
        if (isPolyCreated(s, area)) {
            List<Segment> segment = area.segmentList();
            Polygon n = new Polygon(segment, area.getCursor().getColorFill());
            area.addPolygon(n);
        }
    }

    @Override
    public boolean isConsecutive(List<Segment> segment, Area area) {
        Objects.requireNonNull(segment);
        int c = 0;
        Segment[] arr = segment.toArray(Segment[]::new);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].getFinalCoordinate().equals(arr[i + 1].getInitialCoordinate()))
                c++;
        }
        return c == arr.length - 1;
    }
}

