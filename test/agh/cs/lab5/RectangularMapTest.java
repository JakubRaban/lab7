package agh.cs.lab5;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by student25 on 2018-10-29.
 */
public class RectangularMapTest {

    AbstractWorldMap map;

    @Test
    public void testCanMoveTo() {
        map = new RectangularMap(10, 10);
        map.place(new Car(map, new Position(9, 8)));
        map.place(new Car(map, new Position(9,10)));
        map.run(new MoveDirection[] {MoveDirection.FORWARD, MoveDirection.FORWARD} );
        assertNotNull(map.objectAt(new Position(9,9)));
        assertNotNull(map.objectAt(new Position(9, 10)));
        assertFalse(map.canMoveTo(new Position(9,10)));
        assertTrue(map.canMoveTo(new Position(1,1)));
        assertFalse(map.canMoveTo(new Position(9,11)));
    }

}
