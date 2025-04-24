package nl.codecraftr.sandbox.marsrover;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DirectionParserTest {
    @ParameterizedTest
    @CsvSource({"N,NORTH", "E,EAST", "S,SOUTH", "W,WEST"})
    void parsesValidDirection(String raw, String expectedDirection) {
        var expected = Direction.valueOf(expectedDirection);

        assertThat(DirectionParser.parse(raw)).isEqualTo(expected);
    }

    @Test
    @Disabled("TODO cover unhappy paths")
    void shouldReturnEmptyGivenInvalidDirection() {}
}
