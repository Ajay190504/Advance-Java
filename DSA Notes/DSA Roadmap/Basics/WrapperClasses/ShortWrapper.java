public class ShortWrapper{

    public static void main(String[] args) {

        System.out.println(Short.MIN_VALUE);
        System.out.println(Short.MAX_VALUE);
        System.out.println(Short.SIZE);
        System.out.println(Short.BYTES);
        System.out.println(Short.TYPE);

        short a = 10;

        // Autoboxing
        Short obj = a;

        // Unboxing
        short b = obj;

        // valueOf(short s)
        Short obj2 = Short.valueOf((short)20);

        // parseShort(String s)
        short x = Short.parseShort("30");

        // compare(short x,short y)
        System.out.println(Short.compare((short)10,(short)20));

        // compareTo(Short anotherShort)
        System.out.println(obj.compareTo(obj2));

        // equals(Object obj)
        System.out.println(obj.equals((short)10));

        // shortValue()
        System.out.println(obj.shortValue());
    }
}