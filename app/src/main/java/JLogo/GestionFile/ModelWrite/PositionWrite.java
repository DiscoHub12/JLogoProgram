//
// @author Alessio Giacché
//
package JLogo.GestionFile.ModelWrite;

import JLogo.Model.Position;
import java.util.Objects;

/**
 * This class is used to transform the Position (Coordinate) into a String with
 * the position x and y.
 */
public class PositionWrite implements ModelWrite<Position> {

    @Override
    public String stringOfElement(Position element) {
        Objects.requireNonNull(element);
        return " <" + element.getX() + "><" + element.getY() + ">";
    }
}
