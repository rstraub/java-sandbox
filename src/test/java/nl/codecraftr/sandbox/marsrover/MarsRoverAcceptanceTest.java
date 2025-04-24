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
        var result = MarsRoverSimulator.run("0,4", "E", MAP, "FFLFFFRFFLFR");

        assertThat(result).isEqualTo("Marsrover at '4,0' heading 'East'");
    }

    @Test
    void roverShouldCrashWhenItHitsAnObstacle() {
        var result = MarsRoverSimulator.run("5,1", "S", MAP, "BRFF");

        assertThat(result).isEqualTo("Marsrover crashed at '1,3' heading 'North'");
    }
}
