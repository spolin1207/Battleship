package ships;

public class Destroyer extends Ship {
    private int size;
    private boolean isSunk;

    public Destroyer(int xCoordinate, int yCoordinate, String orientation) {
        super(xCoordinate, yCoordinate, orientation);
        this.size = 2;
        this.isSunk = false;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isSunk() {
        return this.isSunk;
    }
}
