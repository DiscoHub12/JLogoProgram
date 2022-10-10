//
// @author Alessio Giacché
//
package JLogo.TerminalLogo;

import java.io.IOException;

/**
 * This interface is implemented by the ReadHome and WriteHome
 * class, to provide two methods which aim to train and
 * describe to the User , the possible choices he can make
 * during the execution of the LOGO program on the part to
 * read and write file.
 *
 * @param <T> the generic type of the class we are dealing
 *            with, so ReadHome will have type ReadFile and
 *            WriteHome will have WriteFile.
 */
public interface I_Home<T> {

    /**
     * This method is used only for the terminal
     * application of LOGO program.
     * This method alows you yo provide a
     * rapresentation to the user of the possible actions
     * that a particular part of the program can perform
     * For example, the showHome for Reading file will show
     * the user all the possible actions he can perform.
     */
    void showHome() throws IOException;

    /**
     * This method is used only for the terminal
     * application of LOGO program.
     * since once the user has made his
     * choiche of the actions to start, it allows you
     * to ask if you want to return to the Home or
     * terminate the program.
     *
     * @throws IOException if an I/O exception
     *                     of any kind is reported by the user.
     */
    void returnHome() throws IOException;
}
