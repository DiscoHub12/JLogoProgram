//
// @author Alessio Giacché
//
package JLogo.GestionFile.ModelWrite;

import JLogo.Model.Segment;

/**
 * This class is used to transform a Segment into a String with
 * the properties of Segment (Position initial, final, color, penSize)
 */
public class SegmentWrite implements ModelWrite<Segment> {

    private final PositionWrite posWrite;

    private final ColorWrite colorWrite;

    public SegmentWrite() {
        this.posWrite = new PositionWrite();
        this.colorWrite = new ColorWrite();
    }

    @Override
    public String stringOfElement(Segment element) {
        return posWrite.stringOfElement(element.getInitialCoordinate()) +
                posWrite.stringOfElement(element.getFinalCoordinate()) + colorWrite.stringOfElement(element.getColorSegment()) +
                "<" + element.getPenSize() + ">";
    }
}
