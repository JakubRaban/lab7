package agh.cs.lab5;

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
        Position[] positions = cars.keySet().toArray(new Position[] {});
        int size = positions.length;
        for(int i = 0; i < directions.length; i++) {
            Car movingCar = cars.get(positions[i % size]);
            Position initialPosition = movingCar.getPosition();
            movingCar.move(directions[i]);
            if(!movingCar.getPosition().equals(initialPosition)) {
                cars.put(movingCar.getPosition(), cars.remove(initialPosition));
                positions[i % size] = movingCar.getPosition();
            }
        }
    }

    @Override
    public void positionChange(Position oldPosition, Position newPosition) {
        cars.put(newPosition, cars.remove(oldPosition));
    }
}
