//
// @author Alessio Giacché
//
package JLogo.Main;

import JLogo.Model.Area;
import JLogo.TerminalLogo.TerminalAppLogo;

import java.io.IOException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the base and the height for the Area of Logo.\n");
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        while(x <= 0 || y <= 0){
             System.out.println("Illegal value. Re-enter the base and the height for the Area of Logo:\n");
             x = sc.nextDouble();
             y = sc.nextDouble();
        }
        Area area = new Area(x, y);
        TerminalAppLogo terminal = new TerminalAppLogo(area);
        terminal.home();
    }
}
