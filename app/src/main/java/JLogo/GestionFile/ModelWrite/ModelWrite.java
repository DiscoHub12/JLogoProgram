//
// @author Alessio Giacché
//
package JLogo.GestionFile.ModelWrite;

/**
 * This is an interface that takes a generic
 * element, and allows to trasform it into a
 * String then return and print its important
 * properties.
 *
 * @param <W> the generic element.
 */
@FunctionalInterface
public interface ModelWrite<W> {

    /**
     * This method returns the String containing its
     * most important characteristics (for example a Segment
     * element will be given a print containing its starting,
     * ending Position etc.)
     *
     * @param element the element.
     * @return the string representing the element.
     */
    String stringOfElement(W element);
}
