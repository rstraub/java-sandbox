package nl.codecraftr.sandbox.marsrover;

import java.util.Arrays;
import lombok.experimental.UtilityClass;

@UtilityClass
class PositionParser {
    Position parse(String raw) {
        var numbers = Arrays.stream(raw.split(",")).map(Integer::parseInt).toList();

        return new Position(numbers.getFirst(), numbers.getLast());
    }
}
