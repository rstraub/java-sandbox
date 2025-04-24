package nl.codecraftr.sandbox.marsrover;

record Position(int x, int y) {
    public Position increaseY() {
        return new Position(x, y + 1);
    }

    public Position decreaseY() {
        return new Position(x, y - 1);
    }

    public Position increaseX() {
        return new Position(x + 1, y);
    }

    public Position decreaseX() {
        return new Position(x - 1, y);
    }

    @Override
    public String toString() {
        return x + "," + y;
    }
}
