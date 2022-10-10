//
// @author Alessio Giacché
//
package JLogo.TerminalLogo;

import JLogo.GestionFile.WriteFile;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.exit;

/**
 * This class implements the I_Home interface.
 * It aims to provide a default implementation for
 * showHome and returnHome methods, concerning the
 * program part for writing the file. It is used
 * only by the TerminalAppLogo class and called
 * if the user decides to start the program for writing.
 * It the user starts this part of the program,
 * it has the purpose of calling the specific and corresponding
 * methods for writing the file, the result of execution of the LOGO
 * program based on the user's input.
 */
public class WriteHome implements I_Home<WriteFile> {

    /**
     * The Scanner to request input
     * from the user.
     */
    private final Scanner sc = new Scanner(System.in);

    /**
     * The WriteFile class that provides us
     * with methods that can be chosen and started
     * by the user for writing file and print the
     * result of execution of Logo program.
     */
    private final WriteFile write;

    public WriteHome(WriteFile write) {
        this.write = write;
    }

    @Override
    public void showHome() throws IOException {
        int c;
        System.out.println("""
                WRITE HOME.
                Enter:
                1. Create file inside the Project Logo.
                2. Create file within a chosen path.
                3. Print the Logo result inside the file.
                4. Print the Logo result in terminal.
                5. Exit the program.
                """);
        c = sc.nextInt();
        switch (c) {
            case 1:
                this.write.createFileInsideLogo();
                returnHome();
            case 2:
                this.write.createFile();
                returnHome();
            case 3:
                this.write.printInFile();
                returnHome();
            case 4:
                this.write.printInTerminal();
                returnHome();
            case 5:
                exit(1);
        }
    }

    @Override
    public void returnHome() throws IOException {
        int a;
        System.out.print("""
                Enter:
                1. Return to home.
                2. Exit the program.
                """);
        a = sc.nextInt();
        if (a == 1) {
            showHome();
        } else exit(0);
    }
}
