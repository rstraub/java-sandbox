package nl.codecraftr.sandbox.marsrover;

import static nl.codecraftr.sandbox.marsrover.Terrain.Ground;

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

    boolean canMoveTo(Position position) {
        return map.get(position).equals(Ground);
    }
}

record Location(Position position, Terrain terrain) {}

enum Terrain {
    Ground,
    Obstacle
}
