//Read filename, print extension

import java.util.Scanner;

public class FileExtension {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the filename: ");
        String filename = scanner.nextLine();
        
        int dotIndex = filename.lastIndexOf('.');
        if (dotIndex != -1 && dotIndex != filename.length() - 1) {
            String extension = filename.substring(dotIndex + 1);
            System.out.println("The file extension is: " + extension);
        } else {
            System.out.println("No file extension found.");
        }
        
        scanner.close();
    }
}