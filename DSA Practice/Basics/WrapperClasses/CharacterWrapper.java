public class CharacterWrapper{

    public static void main(String[] args) {

        // ===== Properties =====
        System.out.println("MIN_VALUE: " + (int)Character.MIN_VALUE);
        System.out.println("MAX_VALUE: " + (int)Character.MAX_VALUE);
        System.out.println("SIZE: " + Character.SIZE);      // bits
        System.out.println("BYTES: " + Character.BYTES);
        System.out.println("TYPE: " + Character.TYPE);

        // ===== Autoboxing =====
        char primitive = 'A';
        Character obj = primitive;

        // ===== Unboxing =====
        char unboxed = obj;

        // valueOf(char ch)
        Character obj2 = Character.valueOf('B');

        // ===== Character Classification =====

        // isLetter(char ch)
        System.out.println(Character.isLetter('A'));

        // isDigit(char ch)
        System.out.println(Character.isDigit('5'));

        // isLetterOrDigit(char ch)
        System.out.println(Character.isLetterOrDigit('A'));

        // isUpperCase(char ch)
        System.out.println(Character.isUpperCase('A'));

        // isLowerCase(char ch)
        System.out.println(Character.isLowerCase('a'));

        // isWhitespace(char ch)
        System.out.println(Character.isWhitespace(' '));

        // isAlphabetic(int codePoint)
        System.out.println(Character.isAlphabetic('A'));

        // isSpaceChar(char ch)
        System.out.println(Character.isSpaceChar(' '));

        // ===== Identifier methods =====

        // isJavaIdentifierStart(char ch)
        System.out.println(Character.isJavaIdentifierStart('A'));

        // isJavaIdentifierPart(char ch)
        System.out.println(Character.isJavaIdentifierPart('1'));

        // ===== Case conversion =====

        // toUpperCase(char ch)
        System.out.println(Character.toUpperCase('b'));

        // toLowerCase(char ch)
        System.out.println(Character.toLowerCase('A'));

        // ===== Numeric conversion =====

        // getNumericValue(char ch)
        System.out.println(Character.getNumericValue('9'));

        // digit(char ch, int radix)
        System.out.println(Character.digit('A', 16));

        // ===== Unicode information =====

        // getType(char ch)
        System.out.println(Character.getType('A'));

        // getDirectionality(char ch)
        System.out.println(Character.getDirectionality('A'));

        // ===== Comparison =====

        // compare(char x, char y)
        System.out.println(Character.compare('A', 'B'));

        // equals(Object obj)
        System.out.println(obj.equals('A'));

        // ===== Primitive extraction =====

        // charValue()
        System.out.println(obj.charValue());

        System.out.println("Unboxed value: " + unboxed);
    }
}