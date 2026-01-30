// Read two integers from user input and perform basic arithmetic operations
imoort java.util.Scanner;
public class IoCalc{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();
        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();

        int sum = num1 + num2;
        System.out.println("Sum: " + sum);

        int diff = num1 - num2;
        System.out.println("Difference: " + diff);

        int prod = num1 * num2;
        System.out.println("Product: " + prod);
        
        if(num2 != 0){
            double quot = (double)num1 / num2;
            System.out.println("Quotient: " + quot);
        } else {
            System.out.println("Quotient: Division by zero is not allowed.");
        }
        sc.close();
    }
}