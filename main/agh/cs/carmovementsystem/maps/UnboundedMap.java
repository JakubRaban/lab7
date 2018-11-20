package agh.cs.carmovementsystem.maps;

import agh.cs.carmovementsystem.objects.Car;
import agh.cs.carmovementsystem.objects.Haystack;
import agh.cs.carmovementsystem.Position;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by student25 on 2018-10-29.
 */
public class UnboundedMap extends AbstractWorldMap implements IWorldMap {

    private Map<Position, Haystack> haystacks = new LinkedHashMap<>();
    static int a;

    public UnboundedMap(List<Haystack> haystacks) {
        for(Haystack haystack : haystacks) {
            this.haystacks.put(haystack.getPosition(), haystack);
        }
    }

    @Override
    public boolean canMoveTo(Position position) {
        return !isOccupied(position);
    }

    @Override
    public Object objectAt(Position position) {
        Object found = super.objectAt(position);
        if (found == null) {
            found = haystacks.get(position);
        }
        return found;
    }

    @Override
    public String toString() {
        Position minPosition = new Position(Integer.MAX_VALUE, Integer.MAX_VALUE);
        Position maxPosition = new Position(Integer.MIN_VALUE, Integer.MIN_VALUE);
        for (Map.Entry<Position, Car> entry: cars.entrySet()) {
            minPosition = minPosition.lowerLeft(entry.getKey());
            maxPosition = maxPosition.upperRight(entry.getKey());
        }
        for (Map.Entry<Position,Haystack> entry: haystacks.entrySet()) {
            minPosition = minPosition.lowerLeft(entry.getKey());
            maxPosition = maxPosition.upperRight(entry.getKey());
        }
        return visualizer.draw(minPosition, maxPosition);
    }
}
