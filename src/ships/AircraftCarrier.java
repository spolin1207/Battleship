package ships;

public class AircraftCarrier extends Ship {
    private int size;
    private boolean isSunk;

    public AircraftCarrier(int xCoordinate, int yCoordinate, String orientation) {
        super(xCoordinate, yCoordinate, orientation);
        this.size = 5;
        this.isSunk = false;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isSunk() {
        return this.isSunk;
    }
}
