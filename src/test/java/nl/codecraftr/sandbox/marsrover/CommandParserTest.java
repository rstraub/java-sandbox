package nl.codecraftr.sandbox.marsrover;

import static nl.codecraftr.sandbox.marsrover.Command.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class CommandParserTest {
    @Test
    void shouldParseValidCommands() {
        var input = "LRFB";

        assertThat(CommandParser.parse(input)).containsExactly(TURN_LEFT, TURN_RIGHT, FORWARD, BACKWARD);
    }

    @Test
    @Disabled("TODO handle invalid cases")
    void shouldReturnEmptyGivenInvalidCommands() {}
}
