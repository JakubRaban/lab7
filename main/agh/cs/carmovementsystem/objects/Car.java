package agh.cs.carmovementsystem.objects;
import agh.cs.carmovementsystem.IPositionChangeObserver;
import agh.cs.carmovementsystem.MoveDirection;
import agh.cs.carmovementsystem.utilities.OptionsParser;
import agh.cs.carmovementsystem.Position;
import agh.cs.carmovementsystem.maps.AbstractWorldMap;
import agh.cs.carmovementsystem.maps.IWorldMap;
import agh.cs.carmovementsystem.maps.MapDirection;
import agh.cs.carmovementsystem.maps.UnboundedMap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static agh.cs.carmovementsystem.maps.MapDirection.*;
import static agh.cs.carmovementsystem.MoveDirection.*;
/**
 * Created by student25 on 2018-10-15.
 */
public class Car {

    private MapDirection dir;
    private Position position;
    private IWorldMap map;
    private List<IPositionChangeObserver> observers = new LinkedList<>();

    public Car() {
        this.dir = NORTH;
        this.position = new Position(2,2);
    }

    public Car(AbstractWorldMap map) {
        this();
        this.map = map;
        addObserver(map);
    }

    public Car(AbstractWorldMap map, Position initialPosition) {
        this(map);
        this.position = initialPosition;
    }

    public void addObserver(IPositionChangeObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer) {
        observers.remove(observer);
    }

    public void positionChanged(Position oldPosition, Position newPosition) {
        for(IPositionChangeObserver observer : observers) {
            observer.positionChange(oldPosition, newPosition);
        }
    }

    public Position getPosition() {
        return this.position;
    }

    public String toString() {
        return Character.toString(this.dir.name().charAt(0)).toUpperCase();
    }

    public void move(MoveDirection direction) {
        if(direction == RIGHT) {
            dir = dir.next();
            return;
        }
        if(direction == LEFT) {
            dir = dir.prev();
            return;
        }
        Position newPosition = this.position;
        int x = 0, y = 0;
        switch(this.dir) {
            case NORTH:
                x = 0; y = 1;
                break;
            case WEST:
                x = -1; y = 0;
                break;
            case SOUTH:
                x = 0; y = -1;
                break;
            case EAST:
                x = 1; y = 0;
                break;
        }
        if(direction == BACKWARD) {
            x = -x;
            y = -y;
        }
        newPosition = newPosition.add(new Position(x, y));
        if(this.map.canMoveTo(newPosition)) {
            positionChanged(this.position, newPosition);
            this.position = newPosition;
        }
    }

    public boolean isOutOfBounds(Position p) {
        return p.x > 4 || p.y > 4 || p.x < 0 || p.y < 0;
    }

    public static void main(String ... args) {
        try {
            MoveDirection[] directions = OptionsParser.parse(args);
            List<Haystack> haystacks = new ArrayList<>();
            haystacks.add(new Haystack(new Position(4,4)));
            AbstractWorldMap map = new UnboundedMap(haystacks);
            map.place(new Car(map));
            map.place(new Car(map, new Position(7, 7)));
            System.out.println(map);
            map.run(directions);
            System.out.println(map);
        } catch (IllegalArgumentException e) {
            System.out.println("haha BUONT xDDD");
        }

    }

}
