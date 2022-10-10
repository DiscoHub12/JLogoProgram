//
// @author Alessio Giacché
//
package JLogoTest;

import JLogo.Model.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {

    /**
     * Test the correct values after call
     * get method for x values.
     */
    @Test
    public void testGetXPoint(){
        double x = 5;
        Position tmp = new Position(x, 12);
        assertEquals(x, tmp.getX());
        int x1 = Integer.MAX_VALUE;
        assertThrows(IllegalArgumentException.class, () -> new Position(x1, 10));
    }

    /**
     * Test the correct values after call
     * set methods whit modify x values.
     */
    @Test
    public void testSetXPoint(){
        Position tmp = new Position(12.5, 12.5);
        assertThrows(IllegalArgumentException.class, () -> tmp.setX(Integer.MAX_VALUE));
        tmp.setX(15);
        assertEquals(15, tmp.getX());
        tmp.setX(20);
        assertEquals(20, tmp.getX());

    }

    /**
     * Test the correct values after call
     * get method for y values.
     */
    @Test
    public void testGetYPoint(){
        double y = 12.5;
        Position tmp = new Position(10, y);
        assertEquals(y, tmp.getY());
        int yM = Integer.MAX_VALUE;
        assertThrows(IllegalArgumentException.class, () -> new Position(10, yM));
    }

    /**
     * Test the correct values after call
     * set methods whit modify y values.
     */
    @Test
    public void testSetYPoint(){
        Position tmp = new Position(12.5,12.5);
        assertThrows(IllegalArgumentException.class, () -> tmp.setY(Integer.MAX_VALUE));
        tmp.setY(15);
        assertEquals(15, tmp.getY());
        tmp.setY(20);
        assertEquals(20, tmp.getY());
    }

    /**
     * Test the equals methods.
     */
    @Test
    public void testEquals(){
        Position one = new Position(2,3);
        Position two = new Position(2,3);
        assertEquals(one, two);
        Position three = new Position(4,5);
        assertNotEquals(one, three);
    }
}
