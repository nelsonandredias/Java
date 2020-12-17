package com.polarising;

public class Main {

    public static void main(String[] args) {

        int myValue = 10000;

        int myMinIntValue = Integer.MIN_VALUE;
        int myMaxIntValue = Integer.MAX_VALUE;

        System.out.println("Integer Minimum Value = " + myMinIntValue);
        System.out.println("Integer Maximum Value = " + myMaxIntValue);

        System.out.println("Busted MAX Value = " + (myMaxIntValue + 1));
        System.out.println("Busted MIN Value = " + (myMinIntValue - 1));


        byte myMinByteValue = Byte.MIN_VALUE;
        byte myMaxByteValue = Byte.MAX_VALUE;

        System.out.println("Byte Minimum Value = " + myMinByteValue);
        System.out.println("Byte Maximum Value = " + myMaxByteValue);

        System.out.println("Busted MAX Byte Value = " + (myMaxByteValue + 1));
        System.out.println("Busted MIN Byte Value = " + (myMinByteValue - 1));

        short myMinShortValue = Short.MIN_VALUE;
        short myMaxShortValue = Short.MAX_VALUE;

        System.out.println("Short Minimum Value = " + myMinShortValue);
        System.out.println("Short Maximum Value = " + myMaxShortValue);

        System.out.println("Busted MAX Short Value = " + (myMaxShortValue + 1));
        System.out.println("Busted MIN Short Value = " + (myMinShortValue - 1));

        long myLongValue = 100L;
        System.out.println("myLongValue = " + myLongValue);

        long myMinLongValue = Long.MIN_VALUE;
        long myMaxLongValue = Long.MAX_VALUE;

        System.out.println("Long Minimum Value = " + myMinLongValue);
        System.out.println("Long Maximum Value = " + myMaxLongValue);

        System.out.println("Busted MAX Long Value = " + (myMaxLongValue + 1));
        System.out.println("Busted MIN Long Value = " + (myMinLongValue - 1));

        long beforeLongLiteralValue = 2147483647;
        System.out.println("beforeLongLiteralValue = " + beforeLongLiteralValue);
        long bigLongLiteralValue = 2147483647234L;
        System.out.println("bigLongLiteralValue = " + bigLongLiteralValue);

        int myTotal = (myMinIntValue / 2);
        System.out.println("myTotal = " + myTotal);

        byte myNewByteValue = (byte) (myMinByteValue / 2);
        System.out.println("myNewByteValue = " + myNewByteValue);

        short myNewShortValue = (short) (myMinShortValue / 2);
        System.out.println("myNewShortValue = " + myNewShortValue);

        
    }
}
