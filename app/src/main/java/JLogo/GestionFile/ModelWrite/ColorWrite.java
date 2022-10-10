//
// @author Alessio Giacché
//
package JLogo.GestionFile.ModelWrite;

import JLogo.Model.RGBColor;
import java.util.Objects;

/**
 * This class is used to transform the Color into a String with
 * the byte of the Color.
 */
public class ColorWrite implements ModelWrite<RGBColor> {

    @Override
    public String stringOfElement(RGBColor element) {
        Objects.requireNonNull(element);
        return element.toString();
    }
}
