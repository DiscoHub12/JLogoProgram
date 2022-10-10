//
// @author Alessio Giacché
//
package JLogoTest;

import JLogo.Model.RGBColor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RGBColorTest {

    /**
     * Test the illegal value.
     */
    @Test
    public void checkIllegalValue(){
        assertThrows(IllegalArgumentException.class, () -> new RGBColor(-1,256,257));
        RGBColor tmp = new RGBColor(200,200,200);
        assertThrows(IllegalArgumentException.class, () -> tmp.setFirstByteColor(256));
        assertThrows(IllegalArgumentException.class, () -> tmp.setSecondByteColor(300));
        assertThrows(IllegalArgumentException.class, () -> tmp.setThirdByteColor(-1));
    }

    /**
     * Test the correct values after call
     * get method for the first byte of this color.
     */
    @Test
    public void testFirstByteColor(){
        int f = 120;
        RGBColor tmp = new RGBColor(f, 200, 240);
        assertEquals(f, tmp.getFirstByteColor());
        int f1 = 344;
        assertThrows(IllegalArgumentException.class, () -> new RGBColor(f1, 200, 200));
    }

    /**
     * Test the correct values after call
     * set methods for the first byte of this color
     */
    @Test
    public void testSetFirstByte(){
        RGBColor tmp = new RGBColor(200,200,200);
        assertThrows(IllegalArgumentException.class, () ->tmp.setFirstByteColor(-1));
        assertThrows(IllegalArgumentException.class, () ->tmp.setFirstByteColor(256));
        tmp.setFirstByteColor(190);
        assertEquals(190, tmp.getFirstByteColor());
    }

    /**
     * Test the correct values after call
     * get method for the second  byte of this color.
     */
    @Test
    public void testSecondByteColor(){
        int f = 98;
        RGBColor tmp = new RGBColor(100, f, 200);
        assertEquals(f, tmp.getSecondByteColor());
        int f1 = 256;
        assertThrows(IllegalArgumentException.class, () -> new RGBColor(100, f1, 200));
    }

    /**
     * Test the correct values after call
     * set methods for the second byte of this color
     */
    @Test
    public void testSetSecondByte(){
        RGBColor tmp = new RGBColor(200,200,200);
        assertThrows(IllegalArgumentException.class, () -> tmp.setSecondByteColor(-1));
        assertThrows(IllegalArgumentException.class, () -> tmp.setSecondByteColor(256));
        tmp.setSecondByteColor(232);
        assertEquals(232, tmp.getSecondByteColor());
    }

    /**
     * Test the correct values after call
     * get method for the third byte of this color.
     */
    @Test
    public void testThirdByteColor(){
        int f = 90;
        RGBColor tmp = new RGBColor(100,100, f);
        assertEquals(f, tmp.getThirdByteColor());
        int f1 = 256;
        assertThrows(IllegalArgumentException.class, () -> new RGBColor(100,100,f1));
    }

    /**
     * Test the correct values after call
     * set methods for the third byte of this color
     */
    @Test
    public void testSetThirdByte(){
        RGBColor tmp = new RGBColor(200,200,200);
        assertThrows(IllegalArgumentException.class, () -> tmp.setThirdByteColor(-1));
        assertThrows(IllegalArgumentException.class, () -> tmp.setThirdByteColor(256));
        tmp.setThirdByteColor(123);
        assertEquals(123, tmp.getThirdByteColor());
    }

    /**
     * Test the equals method.
     */
    @Test
    public void testEquals(){
        RGBColor tmp = new RGBColor(234, 234, 234);
        RGBColor eq = new RGBColor(234, 234, 234);
        assertEquals(tmp, eq);
        RGBColor f = new RGBColor(234,234,235);
        assertNotEquals(tmp, f);
    }
}
