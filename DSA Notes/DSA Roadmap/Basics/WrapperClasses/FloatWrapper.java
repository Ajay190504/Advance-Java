public class FloatWrapper {

    public static void main(String[] args) {

        System.out.println(Float.MIN_VALUE);
        System.out.println(Float.MAX_VALUE);
        System.out.println(Float.SIZE);
        System.out.println(Float.BYTES);
        System.out.println(Float.TYPE);

        // Autoboxing
        float a = 5.5f;
        Float obj = a;

        // Unboxing
        float b = obj;

        // valueOf(float f)
        Float obj2 = Float.valueOf(7.5f);

        // parseFloat(String s)
        float x = Float.parseFloat("8.9");

        // compare(float f1,float f2)
        System.out.println(Float.compare(5.5f,7.5f));

        // compareTo(Float anotherFloat)
        System.out.println(obj.compareTo(obj2));

        // equals(Object obj)
        System.out.println(obj.equals(5.5f));

        // max(float a,float b)
        System.out.println(Float.max(5.5f,7.5f));

        // min(float a,float b)
        System.out.println(Float.min(5.5f,7.5f));

        // sum(float a,float b)
        System.out.println(Float.sum(5.5f,7.5f));

        // isNaN(float v)
        System.out.println(Float.isNaN(5.5f));

        // floatValue()
        System.out.println(obj.floatValue());
    }
}