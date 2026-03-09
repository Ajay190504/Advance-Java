public class ByteWrapper {

    public static void main(String[] args) {

        System.out.println(Byte.MIN_VALUE);
        System.out.println(Byte.MAX_VALUE);
        System.out.println(Byte.SIZE);
        System.out.println(Byte.BYTES);
        System.out.println(Byte.TYPE);

        byte a = 5;

        // Autoboxing
        Byte obj = a;

        // Unboxing
        byte b = obj;

        // valueOf(byte b)
        Byte obj2 = Byte.valueOf((byte)10);

        // parseByte(String s)
        byte x = Byte.parseByte("20");

        // compare(byte x,byte y)
        System.out.println(Byte.compare((byte)5,(byte)10));

        // compareTo(Byte anotherByte)
        System.out.println(obj.compareTo(obj2));

        // equals(Object obj)
        System.out.println(obj.equals((byte)5));

        // byteValue()
        System.out.println(obj.byteValue());
    }
}