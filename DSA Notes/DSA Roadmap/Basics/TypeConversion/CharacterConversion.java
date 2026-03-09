public class CharacterConversion {

    public static void main(String[] args) {

        char ch = 'A';

        // char -> int (ASCII/Unicode value)
        int i = ch;

        System.out.println("char -> int: " + i);

        // int -> char
        int num = 66;
        char ch2 = (char) num;

        System.out.println("int -> char: " + ch2);

        // String conversion
        String str = Character.toString(ch);

        char parsed = "Hello".charAt(0);

        System.out.println("String: " + str);
        System.out.println("Parsed char: " + parsed);
    }
}