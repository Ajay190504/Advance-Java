//Read a float number as grades and print the corresponding grade letter
import java.util.Scanner;

public class PrintGrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your grades: ");
       float grades = scanner.nextFloat();
       
       if(grades >= 90) {
           System.out.println("Your grade is A.");
       } else if(grades >= 80) {
           System.out.println("Your grade is B.");
       } else if(grades >= 70) {
           System.out.println("Your grade is C.");
       } else if(grades >= 60) {
           System.out.println("Your grade is D.");
       } else {
           System.out.println("Your grade is F.");
       }
    }
    }