package ships;

public class Submarine extends Ship {
    private int size;
    private boolean isSunk;

    public Submarine(int xCoordinate, int yCoordinate, String orientation) {
        super(xCoordinate, yCoordinate, orientation);
        this.size = 1;
        this.isSunk = false;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isSunk() {
        return this.isSunk;
    }
}
