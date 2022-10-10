//
// @author Alessio Giacché
//
package JLogo.MVCControl;

import JLogo.Model.Area;
import JLogo.Model.Movement;


/**
 * This class rapresents the MVC pattern Control
 * of the LOGO Program. It is called and used in Terminal part
 * of program, so that the user does not make choices or start commands
 * from the Model, but it is the Controller that manages this, acting
 * as an intermediary between the View and the Model by the user.
 * The User will give input to the Controller commands and will not
 * interact with the code directly.
 */
public class Controller {

    /**
     * The Movements or all the actions that
     * the user of the program, cursor can perform.
     */
    private final Movement mov;

    //Constructor:
    public Controller(Area area){
        this.mov = new Movement(area);
    }

    public void movForward(double dist) {
        this.mov.forward(dist);
    }

    public void movBackward(double dist) {
        this.mov.backward(dist);
    }

    public void movLeft(int angle) {
        this.mov.left(angle);
    }

    public void movRight(int angle) {
        this.mov.right(angle);
    }

    public void movClearScreen() {
        this.mov.clearScreen();
    }

    public void movHome() {
        this.mov.home();
    }

    public void movPenUp() {
        this.mov.penUp();
    }

    public void movPenDown() {
        this.mov.penDown();
    }

    public void movSetPenColor(int b, int c, int d) {
        this.mov.setPenColor(b, c, d);
    }

    public void movSetFillColor(int b, int c, int d) {
        this.mov.setFillColor(b, c, d);
    }

    public void movSetScreenColor(int b, int c, int d) {
        this.mov.setScreenColor(b, c, d);
    }

    public void movSetPenSize(int size) {
        this.mov.setPenSize(size);
    }

}
