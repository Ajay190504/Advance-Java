public class DataTypeInfo {

    public static void main(String[] args) {

        System.out.println("===== JAVA PRIMITIVE DATA TYPES INFORMATION =====\n");

        // byte
        System.out.println("Data Type : byte");
        System.out.println("Size (bits)  : " + Byte.SIZE);     // returns size in bits
        System.out.println("Size (bytes) : " + Byte.BYTES);    // returns size in bytes
        System.out.println("Minimum Value: " + Byte.MIN_VALUE);
        System.out.println("Maximum Value: " + Byte.MAX_VALUE);
        System.out.println();

        // short
        System.out.println("Data Type : short");
        System.out.println("Size (bits)  : " + Short.SIZE);
        System.out.println("Size (bytes) : " + Short.BYTES);
        System.out.println("Minimum Value: " + Short.MIN_VALUE);
        System.out.println("Maximum Value: " + Short.MAX_VALUE);
        System.out.println();

        // int
        System.out.println("Data Type : int");
        System.out.println("Size (bits)  : " + Integer.SIZE);
        System.out.println("Size (bytes) : " + Integer.BYTES);
        System.out.println("Minimum Value: " + Integer.MIN_VALUE);
        System.out.println("Maximum Value: " + Integer.MAX_VALUE);
        System.out.println();

        // long
        System.out.println("Data Type : long");
        System.out.println("Size (bits)  : " + Long.SIZE);
        System.out.println("Size (bytes) : " + Long.BYTES);
        System.out.println("Minimum Value: " + Long.MIN_VALUE);
        System.out.println("Maximum Value: " + Long.MAX_VALUE);
        System.out.println();

        // float
        System.out.println("Data Type : float");
        System.out.println("Size (bits)  : " + Float.SIZE);
        System.out.println("Size (bytes) : " + Float.BYTES);
        System.out.println("Minimum Value: " + Float.MIN_VALUE);
        System.out.println("Maximum Value: " + Float.MAX_VALUE);
        System.out.println();

        // double
        System.out.println("Data Type : double");
        System.out.println("Size (bits)  : " + Double.SIZE);
        System.out.println("Size (bytes) : " + Double.BYTES);
        System.out.println("Minimum Value: " + Double.MIN_VALUE);
        System.out.println("Maximum Value: " + Double.MAX_VALUE);
        System.out.println();

        // char
        System.out.println("Data Type : char");
        System.out.println("Size (bits)  : " + Character.SIZE);
        System.out.println("Size (bytes) : " + Character.BYTES);
        System.out.println("Minimum Value: " + (int) Character.MIN_VALUE);
        System.out.println("Maximum Value: " + (int) Character.MAX_VALUE);
        System.out.println();

        // boolean (no size constants in Java)
        System.out.println("Data Type : boolean");
        System.out.println("Size (bits)  : JVM dependent");
        System.out.println("Size (bytes) : JVM dependent");
        System.out.println("Possible Values: true or false");
        System.out.println();
    }
}