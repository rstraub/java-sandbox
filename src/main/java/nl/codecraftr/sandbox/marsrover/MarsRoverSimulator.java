package nl.codecraftr.sandbox.marsrover;

import java.util.List;
import lombok.experimental.UtilityClass;

@UtilityClass
class MarsRoverSimulator {
    MarsRover simulate(MarsRover rover, MarsMap map, List<Command> commands) {
        return commands.stream()
                .reduce(rover, (current, command) -> moveRover(current, map, command), (rover1, rover2) -> rover1);
    }

    private MarsRover moveRover(MarsRover rover, MarsMap map, Command command) {
        if (!rover.operational()) {
            return rover;
        }

        var moved = rover.instruct(command);

        if (map.canMoveTo(moved.position())) {
            return moved;
        }

        return moved.crashed();
    }
}
