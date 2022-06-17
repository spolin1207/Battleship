package ships;

public class Ship {
    private int xCoordinate;
    private int yCoordinate;
    private String orientation;
    private int size;

    public Ship(int xCoordinate, int yCoordinate, String orientation) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.orientation = orientation;
    }

    public int getXCoordinate() {
        return this.xCoordinate;
    }

    public int getYCoordinate() {
        return this.yCoordinate;
    }

    public String getOrientation() {
        return this.orientation;
    }

    public int getSize() {
        return this.size;
    }
}
