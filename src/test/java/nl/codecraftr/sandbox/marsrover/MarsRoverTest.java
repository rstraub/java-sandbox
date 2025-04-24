package nl.codecraftr.sandbox.marsrover;

import static nl.codecraftr.sandbox.marsrover.Command.*;
import static nl.codecraftr.sandbox.marsrover.Direction.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MarsRoverTest {
    private static final MarsRover aRover = new MarsRover(new Position(0, 0), NORTH);

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

    @ParameterizedTest
    @MethodSource("forwards")
    void forwardChangesCoordinate(Direction initialDirection, Position initialPosition, Position expectedPosition) {
        var result = aRover.withDirection(initialDirection)
                .withPosition(initialPosition)
                .instruct(FORWARD);

        assertThat(result.position()).isEqualTo(expectedPosition);
    }

    private static Stream<Arguments> forwards() {
        return Stream.of(
                Arguments.of(SOUTH, new Position(0, 0), new Position(0, 1)),
                Arguments.of(NORTH, new Position(0, 4), new Position(0, 3)),
                Arguments.of(EAST, new Position(0, 0), new Position(1, 0)),
                Arguments.of(WEST, new Position(4, 0), new Position(3, 0)));
    }

    @ParameterizedTest
    @MethodSource("backwards")
    void backwardChangesCoordinate(Direction initialDirection, Position initialPosition, Position expectedPosition) {
        var result = aRover.withDirection(initialDirection)
                .withPosition(initialPosition)
                .instruct(BACKWARD);

        assertThat(result.position()).isEqualTo(expectedPosition);
    }

    private static Stream<Arguments> backwards() {
        return Stream.of(
                Arguments.of(SOUTH, new Position(0, 4), new Position(0, 3)),
                Arguments.of(NORTH, new Position(0, 0), new Position(0, 1)),
                Arguments.of(EAST, new Position(4, 0), new Position(3, 0)),
                Arguments.of(WEST, new Position(0, 0), new Position(1, 0)));
    }
}
