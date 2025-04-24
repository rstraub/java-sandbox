package nl.codecraftr.sandbox.marsrover;

import static nl.codecraftr.sandbox.marsrover.Direction.NORTH;

import lombok.experimental.UtilityClass;

@UtilityClass
/* https://codingdojo.org/kata/mars-rover/
 */
class MarsRoverSimulator {
    public static String run(String initialPosition, String initialHeading, String map, String commands) {
        var position = PositionParser.parse(initialPosition);

        var rover = new MarsRover(position, NORTH);
        return "Marsrover at '%s' heading '%s'".formatted(rover.position(), rover.direction());
    }
}
