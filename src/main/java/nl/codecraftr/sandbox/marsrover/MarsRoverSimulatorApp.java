package nl.codecraftr.sandbox.marsrover;

import lombok.experimental.UtilityClass;

@UtilityClass
/* https://codingdojo.org/kata/mars-rover/
 */
class MarsRoverSimulatorApp {
    public static String run(String initialPosition, String initialDirection, String map, String commands) {
        var position = PositionParser.parse(initialPosition);
        var direction = DirectionParser.parse(initialDirection);

        var rover = new MarsRover(position, direction);
        return "Marsrover at '%s' heading '%s'".formatted(rover.position(), rover.direction());
    }
}
