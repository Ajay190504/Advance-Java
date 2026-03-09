public class BooleanConversion {

    public static void main(String[] args) {

        boolean b = true;

        // String conversion
        String str = Boolean.toString(b);

        boolean parsed = Boolean.parseBoolean("false");

        System.out.println("String: " + str);
        System.out.println("Parsed boolean: " + parsed);
    }
}