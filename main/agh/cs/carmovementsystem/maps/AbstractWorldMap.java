package agh.cs.carmovementsystem.maps;

import agh.cs.carmovementsystem.*;
import agh.cs.carmovementsystem.objects.Car;
import agh.cs.carmovementsystem.utilities.MapVisualizer;

import java.util.*;

/**
 * Created by student25 on 2018-10-29.
 */
public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {

    protected Map<Position, Car> cars = new LinkedHashMap<>();
    protected MapVisualizer visualizer = new MapVisualizer(this);

    public boolean isOccupied(Position position) {
        return objectAt(position) != null;
    }

    public boolean place(Car car) {
        if(canMoveTo(car.getPosition())) {
            cars.put(car.getPosition(), car);
            return true;
        } else throw new IllegalArgumentException(car.getPosition() + " is already occupied");
    }

    public Object objectAt(Position position) {
        return cars.get(position);
    }

    public void run(MoveDirection[] directions) {
        Car[] carsArray = Arrays.copyOf(cars.values().toArray(new Car[0]), cars.values().size());
        int size = carsArray.length;
        for(int i = 0; i < directions.length; i++) {
            Car movingCar = carsArray[i % size];
            movingCar.move(directions[i]);
            System.out.println(this);
        }
    }

    @Override
    public void positionChange(Position oldPosition, Position newPosition) {
        cars.put(newPosition, cars.remove(oldPosition));
    }
}
