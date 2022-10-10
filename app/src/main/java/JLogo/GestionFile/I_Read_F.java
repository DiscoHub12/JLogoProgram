//
// @author Alessio Giacché
//
package JLogo.GestionFile;

/**
 * This interface provides methods that
 * deal with reading file. As you can go and
 * take file and read it within out LOGO program.
 */
public interface I_Read_F {

    /**
     * This method checks if the path passed
     * as arguments to the method is a
     * path then if the path exists.
     *
     * @param path the full path of path.
     * @return true if exists, false otherwise.
     */
    boolean checkFileExists(String path);

    /**
     * This method prompts the user
     * for the file to read.
     */
    void choicheFileForRead();

    /**
     * This method allows you to
     * read the chosen file. If the file
     * has not yet been chosen, the method
     * calls the choicheFileForRead()
     */
    void readFile();

    /**
     * This methods write the words read
     * from the file into the terminal.
     */
    void printInTerminal();

}
