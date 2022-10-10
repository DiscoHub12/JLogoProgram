//
// @author Alessio Giacché
//
package JLogo.GestionFile;

import java.io.*;
import java.util.Scanner;

/**
 * This class provides a default implementation for
 * the I_Read_F interface.
 * It deals with the part of file reading program,
 * used into the Logo program from the Terminal and
 * allows to read a file.
 */
public class ReadFile implements I_Read_F {

    /**
     * The path of the chosen file.
     */
    private String filePath;

    /**
     * Scanner that allows to take Strings as
     * input within the methods provided to prompt
     * the User for certain thins , for example
     * the path of the file.
     */
    private final Scanner sc;

    /**
     * This String array is used to save
     * the words we find inside the file. It
     * has a set length of a maximum of 100 words.
     */
    private final String[] wordInside;

    private int c = 0;

    public ReadFile() {
        this.sc = new Scanner(System.in);
        this.wordInside = new String[100];
    }

    @Override
    public boolean checkFileExists(String path) {
        File f = new File(String.valueOf(path));
        return f.exists() && !f.isDirectory();
    }

    @Override
    public void choicheFileForRead() {
        System.out.print("Insert the path and the name of the file to read inside: \n");
        String path = sc.next();
        if (!checkFileExists(path)) {
            throw new IllegalArgumentException("File not exists.");
        }
        this.filePath = path;
    }

    @Override
    public void readFile() {
        if (this.filePath == null)
            choicheFileForRead();
        try {
            FileInputStream fStream = new FileInputStream(this.filePath);
            DataInputStream in = new DataInputStream(fStream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                this.wordInside[c] = strLine;
                c++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void printInTerminal() {
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < c; i++) {
            tmp.append("\n").append(this.wordInside[i]);
        }
        System.out.printf("Word inside the File: \n" + tmp);
    }
}
