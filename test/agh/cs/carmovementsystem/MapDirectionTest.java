package agh.cs.carmovementsystem;

import agh.cs.carmovementsystem.maps.MapDirection;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by student25 on 2018-10-08.
 */
public class MapDirectionTest {

    @Test
    public void testNext(){
        MapDirection dir = MapDirection.EAST;
        assertEquals(dir.next(), MapDirection.SOUTH);
        dir = dir.next();
        assertEquals(dir.next(), MapDirection.WEST);
        dir = dir.next();
        assertEquals(dir.next(), MapDirection.NORTH);
        dir = dir.next();
        assertEquals(dir.next(), MapDirection.EAST);
    }

    @Test
    public void testPrev() {
        MapDirection dir = MapDirection.NORTH;
        assertEquals(dir.prev(), MapDirection.WEST);
        dir = dir.prev();
        assertEquals(dir.prev(), MapDirection.SOUTH);
        dir = dir.prev();
        assertEquals(dir.prev(), MapDirection.EAST);
        dir = dir.prev();
        assertEquals(dir.prev(), MapDirection.NORTH);
    }

    @Test
    public void testToString() {
        assertEquals(MapDirection.NORTH.toString(), "Północ");
        assertEquals(MapDirection.EAST.toString(), "Wschód");
        assertEquals(MapDirection.SOUTH.toString(), "Południe");
        assertEquals(MapDirection.WEST.toString(), "Zachód");
    }

}
