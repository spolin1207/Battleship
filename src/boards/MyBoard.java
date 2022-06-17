package boards;

import ships.Ship;

/* 
This is the board that the main player will use. Can insert ships on the board
as you please.
*/
public class MyBoard {
    private String[][] board;

    public MyBoard() {
        board = new String[10][10];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = ".";
            }
        }
    }

    public boolean insertShip(Ship ship) {
        int size = ship.getSize();
        int xVal = ship.getXCoordinate();
        int yVal = ship.getYCoordinate();

        // Check if ship has valid insertion indexes
        if (ship.getXCoordinate() > 9 || ship.getXCoordinate() < 0) {
            System.out.println("Ship Insertion out of bounds");
            return false;
        }
        if (ship.getYCoordinate() > 9 || ship.getYCoordinate() < 0) {
            System.out.println("Ship Insertion out of bounds");
            return false;
        }

        // Check if ship can be inserted in these positions without leaving the board
        if (ship.getOrientation().equals("u")) {
            if (xVal - size < -1) {
                System.out.println("Ship Insertion out of bounds");
                return false;
            }

        } else if (ship.getOrientation().equals("d")) {
            if (xVal + size > 9) {
                System.out.println("Ship Insertion out of bounds");
                return false;
            }
        } else if (ship.getOrientation().equals("l")) {
            if (yVal - size < -1) {
                System.out.println("Ship Insertion out of bounds");
                return false;
            }
        } else if (ship.getOrientation().equals("r")) {
            if (yVal + size > 9) {
                System.out.println("Ship Insertion out of bounds");
                return false;
            }
        }

        // Check that another ship is not already at this location
        if (ship.getOrientation().equals("u")) {
            for (int i = xVal; i > xVal - size; i--) {
                if (!board[i][yVal].equals(".")) {
                    System.out.println("Position occupied by another ship");
                    return false;
                }
            }
        } else if (ship.getOrientation().equals("d")) {
            for (int i = xVal; i < xVal + size; i++) {
                if (!board[i][yVal].equals(".")) {
                    System.out.println("Position occupied by another ship");
                    return false;
                }
            }
        } else if (ship.getOrientation().equals("l")) {
            for (int i = yVal; i > yVal - size; i--) {
                if (!board[xVal][i].equals(".")) {
                    System.out.println("Position occupied by another ship");
                    return false;
                }
            }
        } else if (ship.getOrientation().equals("r")) {
            for (int i = yVal; i < yVal + size; i++) {
                if (!board[xVal][i].equals(".")) {
                    System.out.println("Position occupied by another ship");
                    return false;
                }
            }
        }

        // Insert the ship into the board
        if (ship.getOrientation().equals("u")) {
            for (int i = xVal; i > xVal - size; i--) {
                if (size == 4) {
                    board[i][yVal] = "B";
                }
                if (size == 5) {
                    board[i][yVal] = "A";
                }
                if (size == 3) {
                    board[i][yVal] = "C";
                }
                if (size == 2) {
                    board[i][yVal] = "D";
                }
                if (size == 1) {
                    board[i][yVal] = "S";
                }
            }
        } else if (ship.getOrientation().equals("d")) {
            for (int i = xVal; i < xVal + size; i++) {
                if (size == 4) {
                    board[i][yVal] = "B";
                }
                if (size == 5) {
                    board[i][yVal] = "A";
                }
                if (size == 3) {
                    board[i][yVal] = "C";
                }
                if (size == 2) {
                    board[i][yVal] = "D";
                }
                if (size == 1) {
                    board[i][yVal] = "S";
                }
            }
        } else if (ship.getOrientation().equals("l")) {
            for (int i = yVal; i > yVal - size; i--) {
                if (size == 4) {
                    board[xVal][i] = "B";
                }
                if (size == 5) {
                    board[xVal][i] = "A";
                }
                if (size == 3) {
                    board[xVal][i] = "C";
                }
                if (size == 2) {
                    board[xVal][i] = "D";
                }
                if (size == 1) {
                    board[xVal][i] = "S";
                }
            }
        } else if (ship.getOrientation().equals("r")) {
            for (int i = yVal; i < yVal + size; i++) {
                if (size == 4) {
                    board[xVal][i] = "B";
                }
                if (size == 5) {
                    board[xVal][i] = "A";
                }
                if (size == 3) {
                    board[xVal][i] = "C";
                }
                if (size == 2) {
                    board[xVal][i] = "D";
                }
                if (size == 1) {
                    board[xVal][i] = "S";
                }
            }
        }

        return true;
    }

    public void receiveAttack(int xAttack, int yAttack) {
        if (board[xAttack][yAttack].equals("A")) {
            board[xAttack][yAttack] = "X";
            System.out.println("The enemy hit your Aircraft Carrier");
        } else if (board[xAttack][yAttack].equals("B")) {
            board[xAttack][yAttack] = "X";
            System.out.println("The enemy hit your Battleship");
        } else if (board[xAttack][yAttack].equals("C")) {
            board[xAttack][yAttack] = "X";
            System.out.println("The enemy hit your Cruiser");
        } else if (board[xAttack][yAttack].equals("D")) {
            board[xAttack][yAttack] = "X";
            System.out.println("The enemy hit your Destroyer");
        } else if (board[xAttack][yAttack].equals("S")) {
            board[xAttack][yAttack] = "X";
            System.out.println("The enemy hit your Submarine");
        } else {
            System.out.println("The enemy missed!");
        }
    }

    public boolean hasLost() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!board[i][j].equals(".") && !board[i][j].equals("X")) {
                    return false;
                }
            }
        }
        return true;
    }

    public String print() {
        String answer = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                answer += " ";
                answer += board[i][j];
                answer += " ";
            }
            answer += "\n";
        }
        System.out.println(answer);
        return answer;
    }
}
