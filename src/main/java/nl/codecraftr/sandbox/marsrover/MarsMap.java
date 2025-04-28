package nl.codecraftr.sandbox.marsrover;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
class MarsMap {
    private final HashMap<Position, Terrain> map;

    MarsMap(List<Location> locations) {
        map = locations.stream()
                .collect(Collectors.toMap(
                        Location::position, Location::terrain, (existing, replacement) -> existing, HashMap::new));
    }
}

record Location(Position position, Terrain terrain) {}

enum Terrain {
    Ground,
    Obstacle
}
