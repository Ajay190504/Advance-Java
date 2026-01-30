//Read percentage, print division

import java.util.Scanner;
public class PercentageToDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter percentage: ");
        int percentage = scanner.nextInt();
        
        if (percentage >= 60) {
            System.out.println("First Division");
        } else if (percentage >= 45) {
            System.out.println("Second Division");
        } else if (percentage >= 33) {
            System.out.println("Third Division");
        } else {
            System.out.println("Fail");
        }
        
        scanner.close();
    }
}