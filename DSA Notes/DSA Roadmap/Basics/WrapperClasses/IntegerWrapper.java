public class IntegerWrapper {

    public static void main(String[] args) {

        // ===== Properties =====
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.SIZE);      // bits
        System.out.println(Integer.BYTES);     // bytes
        System.out.println(Integer.TYPE);

        // ===== Autoboxing =====
        int a = 10;
        Integer obj1 = a;

        // ===== Unboxing =====
        int b = obj1;

        // valueOf(int i)
        Integer obj2 = Integer.valueOf(20);

        // valueOf(String s)
        Integer obj3 = Integer.valueOf("30");

        // parseInt(String s)
        int x = Integer.parseInt("40");

        // parseInt(String s, int radix)
        int y = Integer.parseInt("1010",2);

        // compare(int x, int y)
        System.out.println(Integer.compare(10,20));

        // compareTo(Integer anotherInteger)
        System.out.println(obj1.compareTo(obj2));

        // equals(Object obj)
        System.out.println(obj1.equals(10));

        // sum(int a,int b)
        System.out.println(Integer.sum(10,20));

        // max(int a,int b)
        System.out.println(Integer.max(10,20));

        // min(int a,int b)
        System.out.println(Integer.min(10,20));

        // toBinaryString(int i)
        System.out.println(Integer.toBinaryString(10));

        // toOctalString(int i)
        System.out.println(Integer.toOctalString(10));

        // toHexString(int i)
        System.out.println(Integer.toHexString(10));

        // intValue()
        System.out.println(obj1.intValue());
    }
}