//Read string, print length
import java.util.Scanner;
public class StrLength{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
     

        //way to find length of string using length() method
        int length = input.length();
        System.out.println("Length of the string: " + length);

        //way2 to find length of string using toCharArray() method
        char[] charArray = input.toCharArray();
        int length2 = charArray.length;
        System.out.println("Length of the string using toCharArray(): " + length2);

        //way3 to find length of string using iteration
        int count = 0;  
        for (char c : input.toCharArray()) {
            count++;
        }
        System.out.println("Length of the string using iteration: " + count);
    }
}