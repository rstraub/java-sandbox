package nl.codecraftr.sandbox.marsrover;

import java.util.List;
import lombok.experimental.UtilityClass;

@UtilityClass
class MarsRoverSimulator {
    MarsRover simulate(MarsRover rover, MarsMap map, List<Command> commands) {
        var initial = new MoveResult(rover, Result.MOVED);

        var reduce = commands.stream()
                .reduce(initial, (result, command) -> moveRover(result, map, command), (result1, result2) -> result1);

        return reduce.rover();
    }

    private MoveResult moveRover(MoveResult moveResult, MarsMap map, Command command) {
        var moved = moveResult.rover.instruct(command);

        if (map.canMoveTo(moveResult.rover.position())) {
            return new MoveResult(moved, Result.MOVED);
        }

        return new MoveResult(moveResult.rover, Result.CRASHED);
    }

    private record MoveResult(MarsRover rover, Result result) {}

    private enum Result {
        MOVED,
        CRASHED
    }
}
