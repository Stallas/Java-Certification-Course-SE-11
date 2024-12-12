public class BinaryExample {
    public static void main(String[] args) {

        // 8-bit 'byte' values:
        byte byte1 = (byte) 0b01111111; // 127
        byte byte2 = (byte) 0b10000000; // -128
        byte byte3 = (byte) 0b00100001; // 33

        // A 16-bit 'short' value:
        short short1 = (short) 0b10100001_01000101; // -24251

        // Some 32-bit 'int' values:
        int int1 = 0b10100001_01000101_10100001_0100101; // -1589272251

        // The B in literal can be upper/lower case.
        int int2 = 0b101; // 5
        int int3 = 0B101; // 5
        int int4 = 0B00000000_00000000_00000000_00000101;  // 5

        System.out.println(byte1);
        System.out.println(byte2);
        System.out.println(byte3);

        System.out.println(short1);

        System.out.println(int1);
        System.out.println(int2);
        System.out.println(int3);
        System.out.println(int4);

//        System.out.println(long1); // -6825............251 it starts with 0b101......L 64 bit
//        System.out.println(long2); // 5
    }
}
