package nl.codecraftr.sandbox.marsrover;

import java.util.List;
import lombok.experimental.UtilityClass;

@UtilityClass
class MarsRoverSimulator {
    MarsRover simulate(MarsRover rover, List<Command> commands) {
        return commands.stream().reduce(rover, MarsRover::instruct, (rover1, rover2) -> rover1);
    }
}
