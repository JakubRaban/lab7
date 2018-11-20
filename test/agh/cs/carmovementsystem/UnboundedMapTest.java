package agh.cs.carmovementsystem;

import agh.cs.carmovementsystem.maps.UnboundedMap;
import agh.cs.carmovementsystem.objects.Car;
import agh.cs.carmovementsystem.objects.Haystack;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UnboundedMapTest {

    private UnboundedMap map = new UnboundedMap(new ArrayList<>());

    @Test
    public void testUnbounded() {
        Car c = new Car(map, new Position(0, Integer.MAX_VALUE));
        map.place(c);
        map.run(new MoveDirection[] {MoveDirection.FORWARD} );
        assertEquals(new Position(0, Integer.MIN_VALUE), c.getPosition());
    }

    @Test
    public void testHaystackPlacement() {
        List<Haystack> list = new ArrayList<>();
        list.add(new Haystack(new Position(3,5)));
        list.add(new Haystack(new Position(7,10)));
        map = new UnboundedMap(list);
        assertTrue(map.objectAt(new Position(3,5)) instanceof Haystack);
        assertTrue(map.objectAt(new Position(7,10)) instanceof Haystack);

    }

    @Test
    public void testObjectAt() {
        List<Haystack> haystacks = new ArrayList<>();
        haystacks.add(new Haystack(new Position(3,4)));
        map = new UnboundedMap(haystacks);
        Car c = new Car(map, new Position(5,0));
        map.place(c);
        assertEquals(map.objectAt(new Position(3,4)), haystacks.get(0));
        assertEquals(map.objectAt(new Position(5,0)), c);
        assertNull(map.objectAt(new Position(0,0)));
    }

    @Test
    public void testCanMoveTo() {
        List<Haystack> haystacks = new ArrayList<>();
        haystacks.add(new Haystack(new Position(3,4)));
        map = new UnboundedMap(haystacks);
        map.place(new Car(map, new Position(4,6)));
        assertFalse(map.canMoveTo(new Position(4,6)));
        assertFalse(map.canMoveTo(new Position(3,4)));
    }

}
