package nl.codecraftr.sandbox.marsrover;

import static nl.codecraftr.sandbox.marsrover.Direction.*;
import static nl.codecraftr.sandbox.marsrover.Direction.EAST;

import lombok.With;

record MarsRover(Position position, @With Direction direction) {
    public MarsRover instruct(Command command) {
        if (command == Command.TURN_LEFT) {
            return turnLeft();
        }
        if (command == Command.TURN_RIGHT) {
            return turnRight();
        }
        return this;
    }

    private MarsRover turnRight() {
        var direction =
                switch (direction()) {
                    case NORTH -> EAST;
                    case EAST -> SOUTH;
                    case SOUTH -> WEST;
                    case WEST -> NORTH;
                };
        return withDirection(direction);
    }

    private MarsRover turnLeft() {
        var direction =
                switch (direction()) {
                    case NORTH -> WEST;
                    case WEST -> SOUTH;
                    case SOUTH -> EAST;
                    case EAST -> NORTH;
                };
        return withDirection(direction);
    }
}
