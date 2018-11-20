package agh.cs.carmovementsystem;

/**
 * Created by student26 on 2018-10-22.
 */
public class RectangularMap extends AbstractWorldMap implements IWorldMap {

    private int height, width;

    public RectangularMap(int height, int width) {
        if(height < 0 || width < 0) throw new IllegalArgumentException("Bad world boundaries: " + width + ", " + height);
        this.height = height;
        this.width = width;
    }

    @Override
    public boolean canMoveTo(Position position) {
       return position.x >= 0 && position.x <= this.width
                && position.y >= 0 && position.y <= this.height
                && !isOccupied(position);
    }

    @Override
    public String toString() {
        return visualizer.draw(new Position(0,0), new Position(width, height));
    }
}
