package agh.cs.lab5;

import java.lang.Math;

/**
 * Created by student25 on 2018-10-08.
 */
public class Position {

    public final int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }

    boolean smaller(Position p) {
        return this.x <= p.x && this.y <= p.y;
    }

    boolean larger(Position p) {
        return this.x >= p.x && this.y >= p.y;
    }

    Position upperRight(Position p) {
        return new Position(Math.max(this.x, p.x), Math.max(this.y, p.y));
    }

    Position lowerLeft(Position p) {
        return new Position(Math.min(this.x, p.x), Math.min(this.y, p.y));
    }

    Position add(Position p) {
        return new Position(this.x + p.x, this.y + p.y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (x != position.x) return false;
        if (y != position.y) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
