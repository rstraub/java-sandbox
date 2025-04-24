package nl.codecraftr.sandbox.marsrover;

import static nl.codecraftr.sandbox.marsrover.Direction.*;

import lombok.experimental.UtilityClass;

@UtilityClass
class DirectionParser {
    static Direction parse(String raw) {
        return switch (raw) {
            case "N" -> NORTH;
            case "E" -> EAST;
            case "S" -> SOUTH;
            case "W" -> WEST;
            default -> throw new IllegalArgumentException();
        };
    }
}
