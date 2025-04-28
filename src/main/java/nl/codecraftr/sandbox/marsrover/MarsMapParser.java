package nl.codecraftr.sandbox.marsrover;

import java.util.List;
import java.util.stream.IntStream;
import lombok.experimental.UtilityClass;

@UtilityClass
@SuppressWarnings("StringSplitter")
class MarsMapParser {
    static MarsMap parse(String map) {
        var lines = map.split("\n");

        var locations = IntStream.range(0, lines.length)
                .mapToObj(i -> parseRow(lines[i], i))
                .flatMap(List::stream)
                .toList();

        return new MarsMap(locations);
    }

    private List<Location> parseRow(String line, int lineNumber) {
        var chars = line.split("");

        return IntStream.range(0, chars.length)
                .mapToObj(i -> toLocation(chars[i], lineNumber, i))
                .toList();
    }

    private Location toLocation(String character, int lineNumber, int columnNumber) {
        return new Location(new Position(columnNumber, lineNumber), parseTerrain(character));
    }

    private Terrain parseTerrain(String character) {
        return switch (character) {
            case "." -> Terrain.Ground;
            case "X" -> Terrain.Obstacle;
            default -> throw new IllegalArgumentException();
        };
    }
}
