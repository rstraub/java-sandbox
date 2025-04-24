package nl.codecraftr.sandbox.marsrover;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PositionParserTest {
    @ParameterizedTest
    @MethodSource("validCases")
    void shouldParseValidStringToPosition(String input, Position expected) {
        assertThat(PositionParser.parse(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> validCases() {
        return Stream.of(
                Arguments.of("0,0", new Position(0, 0)),
                Arguments.of("0,4", new Position(0, 4)),
                Arguments.of("3,0", new Position(3, 0)),
                Arguments.of("1,4", new Position(1, 4)));
    }

    @Test
    @Disabled("TODO cover unhappy paths")
    void throwsExceptionGivenInvalidString() {}
}
