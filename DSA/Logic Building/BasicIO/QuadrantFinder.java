//Read coordinates, print quadrant.

import java.util.Scanner;
public class QuadrantFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter X coordinate: ");
        int x = scanner.nextInt();

        System.out.print("Enter Y coordinate: ");
        int y = scanner.nextInt();

        if (x > 0 && y > 0) {
            System.out.println("The point is in Quadrant 1.");
        } else if (x < 0 && y > 0) {
            System.out.println("The point is in Quadrant 2.");
        } else if (x < 0 && y < 0) {
            System.out.println("The point is in Quadrant 3.");
        } else if (x > 0 && y < 0) {
            System.out.println("The point is in Quadrant 4.");
        } else if (x == 0 && y == 0) {
            System.out.println("The point is at the origin.");
        } else if (x == 0) {
            System.out.println("The point is on the Y axis.");
        } else {
            System.out.println("The point is on the X axis.");
        }

        scanner.close();
    }
}