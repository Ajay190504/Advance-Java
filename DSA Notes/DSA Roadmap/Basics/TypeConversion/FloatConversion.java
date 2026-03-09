public class FloatConversion {

    public static void main(String[] args) {

        float f = 10.5f;

        // Widening
        double d = f;

        System.out.println("Widening float -> double: " + d);

        // Narrowing
        double num = 20.7;
        float f2 = (float) num;

        System.out.println("Narrowing double -> float: " + f2);

        // String conversion
        String str = Float.toString(f);

        float parsed = Float.parseFloat("15.6");

        System.out.println("String: " + str);
        System.out.println("Parsed float: " + parsed);
    }
}