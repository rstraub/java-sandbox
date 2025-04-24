package nl.codecraftr.sandbox.marsrover;

import static nl.codecraftr.sandbox.marsrover.Command.TURN_LEFT;
import static nl.codecraftr.sandbox.marsrover.Command.TURN_RIGHT;
import static nl.codecraftr.sandbox.marsrover.Direction.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
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

    @ParameterizedTest
    @MethodSource("turnRight")
    void turnRightChangesDirection(Direction initialDirection, Direction expectedDirection) {
        var result = aRover.withDirection(initialDirection).instruct(TURN_RIGHT);

        assertThat(result.direction()).isEqualTo(expectedDirection);
    }

    private static Stream<Arguments> turnRight() {
        return Stream.of(
                Arguments.of(NORTH, EAST),
                Arguments.of(EAST, SOUTH),
                Arguments.of(SOUTH, WEST),
                Arguments.of(WEST, NORTH));
    }
}
