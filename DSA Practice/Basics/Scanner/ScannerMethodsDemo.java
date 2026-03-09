import java.util.Scanner;
import java.util.regex.Pattern;

public class ScannerMethodsDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // next()
        System.out.print("Enter a single word: ");
        String word = sc.next();
        System.out.println("You entered word: " + word);

        // nextLine()
        sc.nextLine(); // clear buffer
        System.out.print("Enter a full sentence: ");
        String sentence = sc.nextLine();
        System.out.println("Sentence: " + sentence);

        // nextInt()
        System.out.print("Enter an integer: ");
        int num = sc.nextInt();
        System.out.println("Integer: " + num);

        // nextDouble()
        System.out.print("Enter a double: ");
        double d = sc.nextDouble();
        System.out.println("Double: " + d);

        // nextFloat()
        System.out.print("Enter a float: ");
        float f = sc.nextFloat();
        System.out.println("Float: " + f);

        // nextLong()
        System.out.print("Enter a long number: ");
        long l = sc.nextLong();
        System.out.println("Long: " + l);

        // nextShort()
        System.out.print("Enter a short number: ");
        short s = sc.nextShort();
        System.out.println("Short: " + s);

        // nextByte()
        System.out.print("Enter a byte number: ");
        byte b = sc.nextByte();
        System.out.println("Byte: " + b);

        // nextBoolean()
        System.out.print("Enter true or false: ");
        boolean bool = sc.nextBoolean();
        System.out.println("Boolean: " + bool);

        // hasNextInt()
        System.out.print("Check if next input is integer: ");
        if (sc.hasNextInt()) {
            int x = sc.nextInt();
            System.out.println("Valid integer: " + x);
        } else {
            System.out.println("Not an integer.");
            sc.next(); 
        }

        // hasNextDouble()
        System.out.print("Check if next input is double: ");
        if (sc.hasNextDouble()) {
            double y = sc.nextDouble();
            System.out.println("Valid double: " + y);
        } else {
            System.out.println("Not a double.");
            sc.next();
        }

        // useDelimiter()
        Scanner sc2 = new Scanner("Java,Python,C++");
        sc2.useDelimiter(",");

        System.out.println("\nUsing delimiter ','");

        while (sc2.hasNext()) {
            System.out.println(sc2.next());
        }

        // delimiter()
        Pattern p = sc2.delimiter();
        System.out.println("Current delimiter: " + p);

        // close()
        sc.close();
        sc2.close();
    }
}