package nl.codecraftr.sandbox.marsrover;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MarsRoverSimulatorAppTest {
    private static final String MAP = """
      ..X..
      .....
      ...X.
      .X...
      .....
      """;

    @Test
    void roverShouldTraverseMap() {
        var result = MarsRoverSimulatorApp.run("0,4", "E", MAP, "FFLFFFRFFLFR");

        assertThat(result).isEqualTo("Marsrover moved to '4,0' heading 'East'");
    }

    @Test
    void roverShouldCrashWhenItHitsAnObstacle() {
        var result = MarsRoverSimulatorApp.run("4,1", "S", MAP, "BRFF");

        assertThat(result).isEqualTo("Marsrover crashed at '2,0' heading 'West'");
    }
}
