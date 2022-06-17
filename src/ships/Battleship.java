package ships;

public class Battleship extends Ship {
    private int size;
    private boolean isSunk;

    public Battleship(int xCoordinate, int yCoordinate, String orientation) {
        super(xCoordinate, yCoordinate, orientation);
        this.size = 4;
        this.isSunk = false;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isSunk() {
        return this.isSunk;
    }
}
