public class ByteConversion {

    public static void main(String[] args) {

        byte b = 10;

        // Widening conversions (automatic)
        short s = b;
        int i = b;
        long l = b;
        float f = b;
        double d = b;

        System.out.println("Widening: " + s + " " + i + " " + l + " " + f + " " + d);

        // Narrowing conversion (explicit cast)
        int num = 130;
        byte b2 = (byte) num;

        System.out.println("Narrowing int -> byte: " + b2);

        // String conversion
        String str = Byte.toString(b);

        byte parsed = Byte.parseByte("20");

        System.out.println("String: " + str);
        System.out.println("Parsed byte: " + parsed);
    }
}