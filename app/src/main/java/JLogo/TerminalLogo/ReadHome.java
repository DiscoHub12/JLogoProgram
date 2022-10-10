//
// @author Alessio Giacché
//
package JLogo.TerminalLogo;

import JLogo.GestionFile.ReadFile;

import java.util.Scanner;

import static java.lang.System.exit;

/**
 * This class implements the I_Home interface. It aims
 * to provide a default implementation for the showHome and
 * returnHome methods, concerning the program part for reading
 * the file. It used only by the TerminalAppLogo class and
 * called if the user decides to start the program for reading.
 * It has the purpose , if the user starts this part of the
 * program, to call the specific and corresponding methds
 * for reading files based on User input.
 */
public class ReadHome implements I_Home<ReadFile> {

    /**
     * The Scanner to request input from
     * the User.
     */
    private final Scanner sc = new Scanner(System.in);

    /**
     * The ReadFile class that provides us with methods
     * that can be chosen and started by the User
     * for reading files.
     */
    private final ReadFile read;

    public ReadHome(ReadFile read) {
        this.read = read;
    }

    @Override
    public void showHome() {
        int c;
        System.out.print("""
                READ HOME.
                Enter:
                1. Read inside the file.
                2. Print the word inside file to the terminal.
                3. Exit the program.
                """);
        c = sc.nextInt();
        switch (c) {
            case 1:
                this.read.readFile();
                returnHome();
            case 2:
                this.read.printInTerminal();
                returnHome();
            case 3:
                exit(0);
        }
    }

    @Override
    public void returnHome() {
        int a;
        System.out.print("""
                Enter:
                1. Return to home.
                2. Exit the program.""");
        a = sc.nextInt();
        if (a == 1) {
            showHome();
        } else exit(0);
    }
}
