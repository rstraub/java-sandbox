package nl.codecraftr.sandbox.marsrover;

import static nl.codecraftr.sandbox.marsrover.Terrain.Ground;
import static nl.codecraftr.sandbox.marsrover.Terrain.Obstacle;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class MarsMapParserTest {
    @Test
    void shouldParseValidMap() {
        var map = """
            X.
            X.
            """;

        var result = MarsMapParser.parse(map);

        assertThat(result)
                .isEqualTo(new MarsMap(List.of(
                        new Location(new Position(0, 0), Obstacle),
                        new Location(new Position(1, 0), Ground),
                        new Location(new Position(0, 1), Obstacle),
                        new Location(new Position(1, 1), Ground))));
    }
}
