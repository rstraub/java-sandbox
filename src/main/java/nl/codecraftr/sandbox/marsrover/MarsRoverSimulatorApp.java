package nl.codecraftr.sandbox.marsrover;

import lombok.experimental.UtilityClass;

@UtilityClass
/* https://codingdojo.org/kata/mars-rover/
 */
class MarsRoverSimulatorApp {
    public static String run(String rawPosition, String rawDirection, String rawMap, String rawCommands) {
        var initialPosition = PositionParser.parse(rawPosition);
        var initialDirection = DirectionParser.parse(rawDirection);
        var rover = new MarsRover(initialPosition, initialDirection);

        var commands = CommandParser.parse(rawCommands);

        var changedRover = rover.instruct(commands.getFirst());

        return "Marsrover at '%s' heading '%s'".formatted(changedRover.position(), changedRover.direction());
    }
}
