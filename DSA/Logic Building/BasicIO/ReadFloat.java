//Read float, print 2 decimals.

import java.util.Scanner;

public class ReadFloat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a float number: ");
        float number = scanner.nextFloat();
        System.out.printf("You entered: %.2f%n", number);
    }
}   