//
// @author Alessio Giacché
//
package JLogo.TerminalLogo;

import JLogo.GestionFile.ModelWrite.ColorWrite;
import JLogo.GestionFile.ReadFile;
import JLogo.GestionFile.WriteFile;
import JLogo.MVCControl.Controller;
import JLogo.Model.Area;
import JLogo.Model.RGBColor;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.exit;

/**
 * This class rapresents the LOGO Program that
 * can be executed and started from the terminal.
 * The User can run the program through many choices
 * and features that are taken as input.
 */
public class TerminalAppLogo {

    /**
     * The Area of the LOGO Program.
     */
    private final Area area;

    /**
     * The Controller since the User gives the
     * input not directly to the code but to the
     * Controller takes care of calling and executing
     * the right methods.
     */
    private final Controller control;

    /**
     * ReadHome class useful for calling the
     * home of the program for file reading.
     */
    private final ReadHome readHome;

    /**
     * WriteHome class useful for calling the
     * home of the program for Writing to files.
     */
    private final WriteHome writeHome;

    /**
     * Scanner for user input.
     */
    private final Scanner sc;

    public TerminalAppLogo(Area area) throws IOException {
        this.area = area;
        this.control = new Controller(area);
        this.sc = new Scanner(System.in);
        this.writeHome = new WriteHome(new WriteFile(this.area));
        this.readHome = new ReadHome(new ReadFile());
    }

    /**
     * The Home of the LOGO Program. Show the users
     * that actions that he can perform.
     *
     * @throws IOException this exception is thrown
     *                     in case there is any problem/exception caused by
     *                     user input.
     */
    public void home() throws IOException {
        System.out.println("""
                \t--LOGO PROGRAM--
                Welcome to the Logo program.
                Enter:\s
                1. Start the Logo Program from Terminal.
                2. Start the Write Program.
                3. Start the Read Program.
                4. Terminate program.
                """);
        int x = sc.nextInt();
        switch (x) {
            case 1:
                showOption();
                logoTerminal();
            case 2:
                this.writeHome.showHome();
            case 3:
                this.readHome.showHome();
            case 4:
                exit(0);
        }
    }

    /**
     * This method shows all possibile controls/actions/
     * movements that can be done via terminal input.
     *
     * @throws IOException this exception is thrown
     *                     in case there is any problem/exception caused by
     *                     user input.
     */
    public void showOption() throws IOException {
        System.out.print("""
                \nList the actions you can do:
                1. Moves the cursor forward by a given distance.
                2. Moves the cursor backward by a given distance.
                3. Rotate the cursor counterclockwise by a given angle.
                4. Rotate the cursor clockwise by a given angle.
                5. Clear the screen.
                6. Return cursor to the Home. (central position)
                7. Remove the pen from the paper.
                8. Stick the pen from the paper.
                9. Set the Pen color.
                10. Set the Fill color.
                11. Set the Screen color.
                12. Set the Pen size.
                13. Return tho the Logo Home Program.
                14. Exit the Logo Program.
                """);
        System.out.print("Enter the number corresponding to the action you want to start:\n");
        logoTerminal();
    }


    /**
     * Primary method that provides an implementation
     * for all handling of program method calls based
     * on user choices. This start the
     * corresponding method.
     *
     * @throws IOException this exception is thrown
     *                     in case there is any problem/exception caused by
     *                     user input.
     */
    public void logoTerminal() throws IOException {
        double var;
        int var1;
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter the distance for movement: ");
                var = sc.nextDouble();
                this.control.movForward(var);
                System.out.println("\nThe Cursor has moved to the position: " + this.area.getCursor().getPosition());
                returnToHome();
            case 2:
                System.out.println("Enter the distance for the movement: ");
                var = sc.nextDouble();
                this.control.movBackward(var);
                System.out.println("The Cursor has moved to the position: " + this.area.getCursor().getPosition());
                returnToHome();
            case 3:
                System.out.println("Enter the angle: ");
                var1 = sc.nextInt();
                this.control.movLeft(var1);
                System.out.println("The Cursor has rotated to the angle: " + this.area.getCursor().getDirection());
                returnToHome();
            case 4:
                System.out.println("Enter the angle: ");
                var1 = sc.nextInt();
                this.control.movRight(var1);
                System.out.println("The Cursor has rotated to the angle: " + this.area.getCursor().getDirection());
                returnToHome();
            case 5:
                this.control.movClearScreen();
                System.out.println("The Screen is cleared.");
                returnToHome();
            case 6:
                this.control.movHome();
                System.out.println("The Cursor has returned to the Home.");
                returnToHome();
            case 7:
                this.control.movPenUp();
                returnToHome();
            case 8:
                this.control.movPenDown();
                returnToHome();
            case 9:
                System.out.println("Enter 3 integer for the rgb color: ");
                RGBColor color = setColor();
                this.control.movSetPenColor(color.getFirstByteColor(), color.getSecondByteColor(), color.getThirdByteColor());
                System.out.println("Pen color set to: " + new ColorWrite().stringOfElement(this.area.getCursor().getColorLine()));
                returnToHome();
            case 10:
                System.out.println("Enter 3 integer for the rgb color: ");
                RGBColor color1 = setColor();
                this.control.movSetFillColor(color1.getFirstByteColor(), color1.getSecondByteColor(), color1.getThirdByteColor());
                System.out.println("Fill color set to: " + new ColorWrite().stringOfElement(this.area.getCursor().getColorFill()));
                returnToHome();
            case 11:
                System.out.println("Enter 3 integer for the rgb color: ");
                RGBColor color2 = setColor();
                this.control.movSetScreenColor(color2.getFirstByteColor(), color2.getSecondByteColor(), color2.getThirdByteColor());
                System.out.println("Screen color set to: " + new ColorWrite().stringOfElement(this.area.getColorPlane()));
                returnToHome();
            case 12:
                System.out.println("Enter the pen size: ");
                var1 = sc.nextInt();
                this.control.movSetPenSize(var1);
                System.out.println("Pen size: " + this.area.getCursor().getPenSize());
                returnToHome();
            case 13:
                home();
            case 14:
                exit(0);
        }
    }

    /**
     * This method follows the same specification as
     * the WriteFile and ReadFile Home methods.
     * Once action chosen by the user has finished,
     * it allows you to ask if you want
     * to continue the execution of the program
     * or if you want to terminate it.
     *
     * @throws IOException this exception is thrown
     *                     in case there is any problem/exception caused by
     *                     user input.
     */
    private void returnToHome() throws IOException {
        int v;
        System.out.print("""
                \nPress:
                1.To continue.
                2.Return to the Logo Program Home.
                3.Exit the program.
                """);
        v = sc.nextInt();
        if (v == 1) {
            System.out.println("Enter the number corresponding to the action you want to start: ");
            logoTerminal();
        } else if (v == 2) {
            home();
        } else if (v == 3) {
            exit(0);
        }
    }

    /**
     * This method, unlike single 1-value
     * inputs, allows you to request three values
     * in input, and will be used for those methods
     * that deal with RGBColor.
     *
     * @return the RGBColor based on user input.
     */
    private RGBColor setColor() {
        int b1 = sc.nextInt();
        int b2 = sc.nextInt();
        int b3 = sc.nextInt();
        return new RGBColor(b1, b2, b3);
    }
}
