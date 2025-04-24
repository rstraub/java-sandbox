package nl.codecraftr.sandbox.marsrover;

import lombok.With;

record MarsRover(Position position, @With Direction direction) {
    public MarsRover instruct(Command command) {
        if (command == Command.TURN_LEFT) {
            return turnLeft();
        }
        return this;
    }

    private MarsRover turnLeft() {
        var direction =
                switch (direction()) {
                    case Direction.NORTH -> Direction.WEST;
                    case Direction.WEST -> Direction.SOUTH;
                    case Direction.SOUTH -> Direction.EAST;
                    case Direction.EAST -> Direction.NORTH;
                };
        return withDirection(direction);
    }
}
