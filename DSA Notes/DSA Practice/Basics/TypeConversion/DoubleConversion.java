public class DoubleConversion {

    public static void main(String[] args) {

        double d = 25.7;

        // Narrowing
        float f = (float) d;
        long l = (long) d;
        int i = (int) d;

        System.out.println("Double -> float: " + f);
        System.out.println("Double -> long: " + l);
        System.out.println("Double -> int: " + i);

        // String conversion
        String str = Double.toString(d);

        double parsed = Double.parseDouble("30.9");

        System.out.println("String: " + str);
        System.out.println("Parsed double: " + parsed);
    }
}