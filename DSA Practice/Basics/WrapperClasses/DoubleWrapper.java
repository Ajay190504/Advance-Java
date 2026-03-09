public class DoubleWrapper{

    public static void main(String[] args) {

        // ===== Properties =====
        System.out.println(Double.MIN_VALUE);
        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.SIZE);
        System.out.println(Double.BYTES);
        System.out.println(Double.TYPE);

        // Autoboxing
        double a = 10.5;
        Double obj = a;

        // Unboxing
        double b = obj;

        // valueOf(double d)
        Double obj2 = Double.valueOf(20.6);

        // valueOf(String s)
        Double obj3 = Double.valueOf("30.5");

        // parseDouble(String s)
        double x = Double.parseDouble("40.8");

        // compare(double d1,double d2)
        System.out.println(Double.compare(10.5,20.5));

        // compareTo(Double anotherDouble)
        System.out.println(obj.compareTo(obj2));

        // equals(Object obj)
        System.out.println(obj.equals(10.5));

        // sum(double a,double b)
        System.out.println(Double.sum(10.5,20.5));

        // max(double a,double b)
        System.out.println(Double.max(10.5,20.5));

        // min(double a,double b)
        System.out.println(Double.min(10.5,20.5));

        // isNaN(double v)
        System.out.println(Double.isNaN(10.5));

        // isInfinite(double v)
        System.out.println(Double.isInfinite(10.5));

        // doubleValue()
        System.out.println(obj.doubleValue());
    }
}