package nl.codecraftr.sandbox.marsrover;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MarsRoverAcceptanceTest {
    private static final String MAP = """
      ..X..
      .....
      ...X.
      .X...
      .....
      """;

    @Test
    void roverShouldTraverseMap() {
        var result = MarsRoverSimulator.run("4,0", "E", MAP, "FFLFFFRFFLF");

        assertThat(result).isEqualTo("Marsrover at '0,4' heading 'North'");
    }

    @Test
    void roverShouldCrashWhenItHitsAnObstacle() {
        var result = MarsRoverSimulator.run("4,0", "E", MAP, "FLF");

        assertThat(result).isEqualTo("Marsrover crashed at '3,1' heading 'North'");
    }
}
