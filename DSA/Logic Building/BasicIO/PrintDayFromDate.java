//Read date (dd/mm/yyyy), print day
import java.util.Scanner;
public class PrintDayFromDate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter date (dd/mm/yyyy): ");
        String date = scanner.nextLine();
        
        // Split the date string by "/"
        String[] parts = date.split("/");
        
        // Extract the day part
        String day = parts[0];
        
        // Print the day
        System.out.println("Day: " + day);
        
        scanner.close();
    }
}