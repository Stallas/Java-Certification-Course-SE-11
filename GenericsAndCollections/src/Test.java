public class Test {
    public static void main(String[] args) {
        // >>>  right shift unsigned
        System.out.println("result of unsigned right shift (" +
                "10000010_00000010_00000010_00000010 >>> 1 ) = "
                + String.format("%32s",Integer.toBinaryString(
                        0b10000010_00000010_00000010_00000010 >>> 1)).
                replace(' ', '0'));

        //  Compare right shift unsigned to right shift results
        System.out.println("result of signed right shift   (" +
                "10000010_00000010_00000010_00000010 >>  1 ) = "
                + String.format("%32s",Integer.toBinaryString(
                        0b10000010_00000010_00000010_00000010 >> 1)).
                replace(' ', '0'));

        // This code results in an overflow
        byte testByte = 127;
        testByte += 1;
        System.out.println("testByte = " + testByte);
        // This code results in a compiler error
//        byte testByte2 = 127;
//        testByte2 = testByte2 + 1;
//        System.out.println("testByte2 = " + testByte2);

    }
}
