package ships;

public class Cruiser extends Ship {
    private int size;
    private boolean isSunk;

    public Cruiser(int xCoordinate, int yCoordinate, String orientation) {
        super(xCoordinate, yCoordinate, orientation);
        this.size = 3;
        this.isSunk = false;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isSunk() {
        return this.isSunk;
    }
}
