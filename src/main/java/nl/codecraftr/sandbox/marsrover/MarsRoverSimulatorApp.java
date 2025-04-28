package nl.codecraftr.sandbox.marsrover;

/* https://codingdojo.org/kata/mars-rover/
 */
public class MarsRoverSimulatorApp {
    public static String run(String rawPosition, String rawDirection, String rawMap, String rawCommands) {
        var initialPosition = PositionParser.parse(rawPosition);
        var initialDirection = DirectionParser.parse(rawDirection);
        var rover = new MarsRover(initialPosition, initialDirection);

        var commands = CommandParser.parse(rawCommands);

        var map = MarsMapParser.parse(rawMap);
        System.out.println(map);

        var simulatedRover = MarsRoverSimulator.simulate(rover, commands);

        return formatResults(simulatedRover);
    }

    private static String formatResults(MarsRover simulatedRover) {
        return "Marsrover at '%s' heading '%s'".formatted(simulatedRover.position(), simulatedRover.direction());
    }
}
