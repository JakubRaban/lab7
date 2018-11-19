package agh.cs.lab5;

/**
 * Created by student25 on 2018-10-08.
 */
public enum MapDirection {

    NORTH, EAST, SOUTH, WEST;

    public String toString() {
        switch(this) {
            case NORTH:
                return "Północ";
            case SOUTH:
                return "Południe";
            case WEST:
                return "Zachód";
            case EAST:
                return "Wschód";
            default: return "";
        }
    }

    public MapDirection next() {
        return MapDirection.values()[(this.ordinal() + 1) % MapDirection.values().length];
    }

    public MapDirection prev() {
        int newIndex = ordinal() - 1;
        if(newIndex == -1) newIndex = MapDirection.values().length - 1;
        return MapDirection.values()[newIndex];
    }

}
