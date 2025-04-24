package nl.codecraftr.sandbox.marsrover;

import static nl.codecraftr.sandbox.marsrover.Command.*;

import java.util.Arrays;
import java.util.List;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.NotNull;

@UtilityClass
class CommandParser {
    public List<Command> parse(String input) {
        return Arrays.stream(input.split(""))
                .map(s -> s.charAt(0))
                .map(CommandParser::parseCommand)
                .toList();
    }

    private static @NotNull Command parseCommand(char input) {
        return switch (input) {
            case 'L' -> TURN_LEFT;
            case 'R' -> TURN_RIGHT;
            case 'F' -> FORWARD;
            case 'B' -> BACKWARD;
            default -> throw new IllegalArgumentException();
        };
    }
}
