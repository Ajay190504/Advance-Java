public class IntegerConversion {

    public static void main(String[] args) {

        int i = 100;

        // Widening
        long l = i;
        float f = i;
        double d = i;

        System.out.println("Widening: " + l + " " + f + " " + d);

        // Narrowing
        long num = 1000;
        int i2 = (int) num;

        System.out.println("Narrowing long -> int: " + i2);

        // String conversion
        String str = Integer.toString(i);

        int parsed = Integer.parseInt("200");

        System.out.println("String: " + str);
        System.out.println("Parsed int: " + parsed);
    }
}