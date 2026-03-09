public class ShortConversion {

    public static void main(String[] args) {

        short s = 100;

        // Widening
        int i = s;
        long l = s;
        float f = s;
        double d = s;

        System.out.println("Widening: " + i + " " + l + " " + f + " " + d);

        // Narrowing
        int num = 200;
        short s2 = (short) num;

        System.out.println("Narrowing int -> short: " + s2);

        // String conversion
        String str = Short.toString(s);

        short parsed = Short.parseShort("150");

        System.out.println("String: " + str);
        System.out.println("Parsed short: " + parsed);
    }
}