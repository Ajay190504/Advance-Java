public class LongConversion {

    public static void main(String[] args) {

        long l = 1000L;

        // Widening
        float f = l;
        double d = l;

        System.out.println("Widening: " + f + " " + d);

        // Narrowing
        double num = 2000.5;
        long l2 = (long) num;

        System.out.println("Narrowing double -> long: " + l2);

        // String conversion
        String str = Long.toString(l);

        long parsed = Long.parseLong("3000");

        System.out.println("String: " + str);
        System.out.println("Parsed long: " + parsed);
    }
}