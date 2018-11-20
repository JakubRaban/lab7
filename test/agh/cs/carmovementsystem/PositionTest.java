package agh.cs.carmovementsystem;

import org.junit.Test;
import java.util.Random;
import static org.junit.Assert.*;

public class PositionTest {

    Random r = new Random();

    @Test
    public void testToString() {
        Position p = new Position(500, 955);
        assertNotNull(p);
        assertEquals(p.toString(), "(500,955)");
        assertEquals(new Position(-5,5).toString(), "(-5,5)");
    }

    @Test
    public void testSmaller() {
        assertTrue(new Position(2,2).smaller(new Position(4, 6)));
        assertTrue(new Position(3, 5).smaller(new Position(3, 5)));
        assertFalse(new Position(3, 5).smaller(new Position(5,3)));
    }

    @Test
    public void testLarger() {
        assertTrue(new Position(4,6).larger(new Position(2,2)));
        assertTrue(new Position(2,2).larger(new Position(2,-2)));
        assertFalse(new Position(5,7).larger(new Position(7,5)));
    }

    @Test
    public void testUpperRight() {
        assertEquals(new Position(2,4).upperRight(new Position(4,2)).toString(), "(4,4)");
        assertEquals(new Position(3,4).upperRight(new Position(6,7)).toString(), "(6,7)");
    }

    @Test
    public void testLowerLeft() {
        assertEquals(new Position(-1, 5).lowerLeft(new Position(1,3)).toString(), "(-1,3)");
        assertEquals(new Position(0,2).lowerLeft(new Position(1,4)).toString(), "(0,2)");
    }

    @Test
    public void testAdd() {
        Position p = new Position(2,4).add(new Position(4,3));
        assertNotNull(p);
        assertEquals(p.toString(), "(6,7)");
        Position a = new Position(r.nextInt(), r.nextInt());
        Position b = new Position(r.nextInt(), r.nextInt());
        assertEquals(a.add(b).toString(), "(" + (a.x + b.x) + "," + (a.y + b.y) + ")");
    }

}
