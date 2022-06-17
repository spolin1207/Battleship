import java.util.Scanner;
import boards.AttackBoard;
import boards.MyBoard;
import boards.EnemyBoard;
import ships.AircraftCarrier;
import ships.Battleship;
import ships.Cruiser;
import ships.Destroyer;
import ships.Submarine;
import java.util.Random;

/*
This class contains the game logic and provides functionality for the game. 
*/
public class Driver {
    public static void main(String[] args) {
        // Initialize board, ships, and add them to the game board
        MyBoard myBoard = new MyBoard();
        AircraftCarrier a = new AircraftCarrier(4, 3, "r");
        Battleship b = new Battleship(3, 0, "u");
        Cruiser c = new Cruiser(8, 8, "u");
        Destroyer d1 = new Destroyer(0, 9, "l");
        Destroyer d2 = new Destroyer(6, 1, "d");
        Submarine s1 = new Submarine(1, 6, "r");
        Submarine s2 = new Submarine(9, 4, "l");
        myBoard.insertShip(a);
        myBoard.insertShip(b);
        myBoard.insertShip(c);
        myBoard.insertShip(d1);
        myBoard.insertShip(d2);
        myBoard.insertShip(s1);
        myBoard.insertShip(s2);
        myBoard.print();

        // Initialize enemy gameboard. Ships already added in predetermined locations
        EnemyBoard enemyBoard = new EnemyBoard();

        // Initialize attack board, which will record your attacks and misses
        AttackBoard attackBoard = new AttackBoard();

        Scanner sc = new Scanner(System.in);

        // Game logic. Loop will run until someone loses
        while (!enemyBoard.hasLost() && !myBoard.hasLost()) {
            // You attack first
            // Enter attack coordinates
            System.out.print("Enter 1st coordinate value: ");
            int xAttack = sc.nextInt();
            System.out.print("Enter 2nd coordinate value: ");
            int yAttack = sc.nextInt();
            if (xAttack < 0 || xAttack > 9) {
                System.out.println("Invalid X coordinate entered!");
                continue;
            } else if (yAttack < 0 || yAttack > 9) {
                System.out.println("Invalid Y coordinate entered!");
                continue;
            }
            // Mark the enemy board with an X only if a ship has been hit. Output which type
            // of ship was hit.
            boolean hit;
            hit = enemyBoard.giveAttack(xAttack, yAttack); /////////////
            // Mark your attack board for the attack. Record "O" for miss and "X" for hit.
            attackBoard.markAttack(xAttack, yAttack, hit); /////////////

            // Enemys turn
            // Enemy enters attack coordinates (randomly generated)
            Random random = new Random();
            int xEnemy = random.nextInt(10);
            int yEnemy = random.nextInt(10);

            // Attack the spot. If it was a miss, do nothing. If it was a hit, put an "X" at
            // that particular spot
            myBoard.receiveAttack(xEnemy, yEnemy); ////////////

            // Output attack board and your board
            System.out.println("\nYour gameboard: ");
            myBoard.print();
            System.out.println("\nA record of your attacks: ");
            attackBoard.print();
            System.out.println("\n");

            // System.out.println(enemy.hasLost());
        }

        sc.close();

        // After game is completed, output who won.
        if (enemyBoard.hasLost()) {
            System.out.println("You've won the game!");
        } else if (myBoard.hasLost()) {
            System.out.println("You've lost the game!");
        }
    }
}
