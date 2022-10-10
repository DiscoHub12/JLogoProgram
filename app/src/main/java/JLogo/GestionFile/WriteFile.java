//
// @author Alessio Giacché
//
package JLogo.GestionFile;

import JLogo.GestionFile.ModelWrite.PlaneWrite;
import JLogo.Model.Area;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteFile implements I_Write_F {

    /**
     * The path of the chosen file.
     */
    private String fullPath;

    /**
     * Scanner that allows to take Strings as
     * input within the methods provided to prompt
     * the User for certain thins , for example
     * the path of the file.
     */
    private final Scanner sc;

    /**
     * The Area of the LOGO program that
     * we are dealing with.
     * It is fundamental as the whole part of
     * the writing of the result depends on the Area
     * of the Logo Program, the segments inside it and other.
     */
    private final Area area;

    /**
     * PlaneWrite which allows us to retrieve
     * all the data in the form of a String and
     * then print them within the chosen file.
     */
    private final PlaneWrite write;

    public WriteFile(Area area) {
        this.sc = new Scanner(System.in);
        this.area = area;
        this.write = new PlaneWrite();
    }

    @Override
    public boolean checkFileExists(String path) {
        File f = new File(path);
        return f.exists() && !f.isDirectory();
    }

    @Override
    public void createFile() throws IOException {
        System.out.print("\nEnter the path and name of the file you want to create to print the result: \n");
        this.fullPath = sc.nextLine();
        if (checkFileExists(this.fullPath)) {
            System.out.printf("\nFile already exists:" + this.fullPath + "\nEnter a different file: \n");
            this.fullPath = sc.nextLine();
        }
        FileWriter fw = new FileWriter(this.fullPath);
        fw.close();
    }

    @Override
    public void createFileInsideLogo() throws IOException {
        File file = new File("printResult.txt");
        this.fullPath = file.getPath();
        FileWriter fw = new FileWriter(file);
        fw.close();
    }

    @Override
    public void printInFile() throws IOException {
        FileWriter fw = new FileWriter(this.fullPath);
        fw.append(write.stringOfElement(this.area));
        fw.close();
        System.out.print("Print to file successful.\n");
    }

    @Override
    public String printInTerminal() {
        return write.stringOfElement(this.area);
    }

}
