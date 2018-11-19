package agh.cs.lab5;
import static agh.cs.lab5.MoveDirection.*;
/**
 * Created by student25 on 2018-10-15.
 */
public class OptionsParser {

    public static MoveDirection[] parse(String ... args) {
        MoveDirection[] tab = new MoveDirection[args.length];
        int index = 0;
        for(String arg : args) {
            arg = arg.toLowerCase();
            if(arg.equals("b") || arg.equals("backward")) tab[index] = BACKWARD;
            else if(arg.equals("f") || arg.equals("forward")) tab[index] = FORWARD;
            else if(arg.equals("l") || arg.equals("left")) tab[index] = LEFT;
            else if(arg.equals("r") || arg.equals("right")) tab[index] = RIGHT;
            else throw new IllegalArgumentException(arg + " is not legal move direction");
            index++;
        }
        return tab;
    }

}
