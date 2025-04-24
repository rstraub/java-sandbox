package nl.codecraftr.sandbox.marsrover;

record Position(int x, int y) {
    @Override
    public String toString() {
        return x + "," + y;
    }
}
