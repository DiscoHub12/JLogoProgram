//
// @author Alessio Giacché
//
package JLogo.GestionFile;

import java.io.IOException;

/**
 * This interface provides methods made avaible
 * that will be implemented by the WriteFile class
 * and take care of the program part to write the
 * Result of the LOGO program inside a chosen file.
 */
public interface I_Write_F {

    /**
     * This method checks if the path passed
     * as arguments to the method is a
     * file then if the file exists.
     *
     * @param path the full path of file.
     * @return true if exists, false otherwise.
     */
    boolean checkFileExists(String path);

    /**
     * This method permit to create file
     * in a chosen path.
     *
     * @throws IOException if an I/O exception
     *                     of any kind is reported by the user.
     */
    void createFile() throws IOException;

    /**
     * This method allows you to create a file
     * within our LOGO program, in this case,
     * it will be used to print the result
     * of the LOGO program.
     *
     * @throws IOException if an I/O exception
     *                     of any kind is reported by the user.
     */
    void createFileInsideLogo() throws IOException;

    /**
     * This method allows you yo print the LOGO
     * result in the chosen file.
     *
     * @throws IOException if an I/O exception
     *                     of any kind is reported by the user.
     */
    void printInFile() throws IOException;

    /**
     * This method allows you to print
     * the LOGO result in the terminal.
     */
    String printInTerminal();

}
