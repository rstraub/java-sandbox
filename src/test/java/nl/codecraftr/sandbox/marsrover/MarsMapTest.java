package nl.codecraftr.sandbox.marsrover;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class MarsMapTest {
    private static final MarsMap marsMap = MarsMapParser.parse("""
        .X
        """);

    @Test
    void returnsTrueGivenPositionHasGround() {
        assertThat(marsMap.canMoveTo(new Position(0, 0))).isTrue();
    }

    @Test
    void returnsFalseGivenPositionHasObstacle() {
        assertThat(marsMap.canMoveTo(new Position(1, 0))).isFalse();
    }

    @Test
    @Disabled("TODO cover edge cases")
    void returnsFalseGivenPositionOutsideOfMap() {
        assertThat(marsMap.canMoveTo(new Position(1, 0))).isFalse();
    }
}
