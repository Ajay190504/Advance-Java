// Read sentence, print word count.
import java.util.Scanner;
public class WordCount {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();
       
       //way1 - using split method
        String[] words = sentence.trim().split("\\s+");
        int wordCount = words.length;
        System.out.println("Word count: " + wordCount);

        //way2 - using loop
        int count = 0;
        for (char c : sentence.toCharArray()) {
            if (c == ' ') {
                count++;
            }
        }   
        System.out.println("Word count (using loop): " + (count + 1));
    }
} 