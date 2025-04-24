package nl.codecraftr.sandbox.marsrover;

import static nl.codecraftr.sandbox.marsrover.Command.*;
import static nl.codecraftr.sandbox.marsrover.Direction.EAST;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class MarsRoverSimulatorTest {
    @Test
    void shouldHandleMultipleCommands() {
        var rover = new MarsRover(new Position(0, 0), EAST);
        var commands = List.of(
                FORWARD, // 1,0
                TURN_LEFT, // 1,0
                BACKWARD, // 1,1
                TURN_RIGHT, // 1,1
                FORWARD // 2,1
                );

        var expected = rover.instruct(FORWARD)
                .instruct(TURN_LEFT)
                .instruct(BACKWARD)
                .instruct(TURN_RIGHT)
                .instruct(FORWARD);

        var result = MarsRoverSimulator.simulate(rover, commands);

        assertThat(result).isEqualTo(expected);
    }
}
