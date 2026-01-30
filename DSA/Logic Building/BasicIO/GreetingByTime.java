//Read time (HH:MM), print greeting
import java.util.Scanner;

public class GreetingByTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter time (HH:MM): ");
        String timeInput = scanner.nextLine();
        
        String[] timeParts = timeInput.split(":");
        int hour = Integer.parseInt(timeParts[0]);
        
        if (hour >= 5 && hour < 12) {
            System.out.println("Good morning");
        } else if (hour >= 12 && hour < 18) {
            System.out.println("Good afternoon");
        } else if (hour >= 18 && hour < 22) {
            System.out.println("Good evening");
        } else {
            System.out.println("Good night");
        }
        
        scanner.close();
    }
}