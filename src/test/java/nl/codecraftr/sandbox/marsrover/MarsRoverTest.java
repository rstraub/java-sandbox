package nl.codecraftr.sandbox.marsrover;

import static nl.codecraftr.sandbox.marsrover.Command.TURN_LEFT;
import static nl.codecraftr.sandbox.marsrover.Direction.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import lombok.With;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MarsRoverTest {
    private static MarsRover aRover = new MarsRover(new Position(0, 0), NORTH);

    @ParameterizedTest
    @MethodSource("turnLeft")
    void turnLeftChangesDirection(Direction initialDirection, Direction expectedDirection) {
        var result = aRover.withDirection(initialDirection).instruct(TURN_LEFT);

        assertThat(result.direction()).isEqualTo(expectedDirection);
    }

    private static Stream<Arguments> turnLeft() {
        return Stream.of(
                Arguments.of(NORTH, WEST),
                Arguments.of(WEST, SOUTH),
                Arguments.of(SOUTH, EAST),
                Arguments.of(EAST, NORTH));
    }
}

record Position(int x, int y) {}

record MarsRover(Position position, @With Direction direction) {
    public MarsRover instruct(Command command) {
        if (command == TURN_LEFT) {
            return turnLeft();
        }
        return this;
    }

    private MarsRover turnLeft() {
        var direction =
                switch (direction()) {
                    case NORTH -> WEST;
                    case WEST -> SOUTH;
                    case SOUTH -> EAST;
                    case EAST -> NORTH;
                };
        return withDirection(direction);
    }
}

enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST
}

enum Command {
    TURN_LEFT,
    TURN_RIGHT
}
