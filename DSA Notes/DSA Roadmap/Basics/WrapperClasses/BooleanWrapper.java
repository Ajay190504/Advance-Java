public class BooleanWrapper {

    public static void main(String[] args) {

        // ===== Properties =====
        System.out.println("TYPE: " + Boolean.TYPE);
        System.out.println("TRUE: " + Boolean.TRUE);
        System.out.println("FALSE: " + Boolean.FALSE);

        // Autoboxing
        boolean a = true;
        Boolean obj = a;

        // Unboxing
        boolean b = obj;

        // valueOf(boolean b)
        Boolean obj2 = Boolean.valueOf(false);

        // valueOf(String s)
        Boolean obj3 = Boolean.valueOf("true");

        // parseBoolean(String s)
        boolean val = Boolean.parseBoolean("true");

        // compare(boolean x, boolean y)
        System.out.println(Boolean.compare(true, false));

        // compareTo(Boolean anotherBoolean)
        System.out.println(obj.compareTo(obj2));

        // equals(Object obj)
        System.out.println(obj.equals(true));

        // logicalAnd(boolean a, boolean b)
        System.out.println(Boolean.logicalAnd(true, false));

        // logicalOr(boolean a, boolean b)
        System.out.println(Boolean.logicalOr(true, false));

        // logicalXor(boolean a, boolean b)
        System.out.println(Boolean.logicalXor(true, false));

        // booleanValue()
        System.out.println(obj.booleanValue());
    }
}