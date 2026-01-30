//Read 5 numbers, print max.
import java.util.Scanner;
public class MaxOfFive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = Integer.MIN_VALUE;

        System.out.println("Enter 5 numbers:");

        for (int i = 0; i < 5; i++) {
            int number = scanner.nextInt();
            if (number > max) {
                max = number;
            }
        }

        System.out.println("The maximum number is: " + max);
        scanner.close();
    }
}