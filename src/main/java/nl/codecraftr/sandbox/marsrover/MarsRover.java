package nl.codecraftr.sandbox.marsrover;

import static nl.codecraftr.sandbox.marsrover.Direction.*;

import lombok.With;

record MarsRover(@With Position position, @With Direction direction, @With boolean operational) {
    public MarsRover instruct(Command command) {
        if (!operational()) {
            return this;
        }

        return switch (command) {
            case TURN_LEFT -> turnLeft();
            case TURN_RIGHT -> turnRight();
            case FORWARD -> moveForward();
            case BACKWARD -> moveBackward();
        };
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

    public MarsRover crashed() {
        return withOperational(false);
    }
}
