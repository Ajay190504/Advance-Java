//Read salary, calculate income tax.
import java.util.Scanner;

public class CalcIncomeTax{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount: ");
        double salary = scanner.nextDouble();
        
        if (salary < 250000) {
            System.out.println("No tax");
        } else if (salary <= 500000) {
            double tax = salary * 0.05;
            System.out.println("Tax amount: " + tax);
        } else if (salary <= 1000000) {
            double tax = salary * 0.20;
            System.out.println("Tax amount: " + tax);
        } else {
            double tax = salary * 0.30;
            System.out.println("Tax amount: " + tax);
        }
    }
}