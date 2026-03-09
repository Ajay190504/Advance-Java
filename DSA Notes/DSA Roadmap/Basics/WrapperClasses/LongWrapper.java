public class LongWrapper {

    public static void main(String[] args) {

        System.out.println(Long.MIN_VALUE);
        System.out.println(Long.MAX_VALUE);
        System.out.println(Long.SIZE);
        System.out.println(Long.BYTES);
        System.out.println(Long.TYPE);

        long a = 1000L;

        // Autoboxing
        Long obj = a;

        // Unboxing
        long b = obj;

        // valueOf(long l)
        Long obj2 = Long.valueOf(2000);

        // parseLong(String s)
        long x = Long.parseLong("3000");

        // compare(long x,long y)
        System.out.println(Long.compare(1000,2000));

        // compareTo(Long anotherLong)
        System.out.println(obj.compareTo(obj2));

        // equals(Object obj)
        System.out.println(obj.equals(1000L));

        // sum(long a,long b)
        System.out.println(Long.sum(1000,2000));

        // max(long a,long b)
        System.out.println(Long.max(1000,2000));

        // min(long a,long b)
        System.out.println(Long.min(1000,2000));

        // longValue()
        System.out.println(obj.longValue());
    }
}