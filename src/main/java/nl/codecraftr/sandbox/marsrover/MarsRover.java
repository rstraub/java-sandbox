package nl.codecraftr.sandbox.marsrover;

import static nl.codecraftr.sandbox.marsrover.Command.*;
import static nl.codecraftr.sandbox.marsrover.Direction.*;
import static nl.codecraftr.sandbox.marsrover.Direction.EAST;

import lombok.With;

record MarsRover(@With Position position, @With Direction direction) {
    public MarsRover instruct(Command command) {
        if (command == TURN_LEFT) {
            return turnLeft();
        }
        if (command == TURN_RIGHT) {
            return turnRight();
        }
        if (command == FORWARD) {
            return moveForward();
        }
        if (command == BACKWARD) {
            return moveBackward();
        }
        return this;
    }

    private MarsRover moveBackward() {
        var newPosition =
                switch (direction) {
                    case NORTH -> position.increaseY();
                    case EAST -> position.decreaseX();
                    case SOUTH -> position.decreaseY();
                    case WEST -> position.increaseX();
                };

        return withPosition(newPosition);
    }

    private MarsRover moveForward() {
        var newPosition =
                switch (direction) {
                    case NORTH -> position.decreaseY();
                    case EAST -> position.increaseX();
                    case SOUTH -> position.increaseY();
                    case WEST -> position.decreaseX();
                };

        return withPosition(newPosition);
    }

    private MarsRover turnRight() {
        var newDirection =
                switch (direction()) {
                    case NORTH -> EAST;
                    case EAST -> SOUTH;
                    case SOUTH -> WEST;
                    case WEST -> NORTH;
                };
        return withDirection(newDirection);
    }

    private MarsRover turnLeft() {
        var newDirection =
                switch (direction()) {
                    case NORTH -> WEST;
                    case WEST -> SOUTH;
                    case SOUTH -> EAST;
                    case EAST -> NORTH;
                };
        return withDirection(newDirection);
    }
}
