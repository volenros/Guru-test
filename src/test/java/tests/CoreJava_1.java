package tests;

public class CoreJava_1 {
    public static void main(String[] args) {
        int a = 8;
        int b = 4;
        double c = 8.8;
        int d = 128;

        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b));

        System.out.println("b + c = " + (b + c));
        System.out.println("a - c = " + (a - c));

        if (a > b) {
            System.out.println("A больше B");
        } else {
            System.out.println("A меньше B");
        }

        if (d >= a) {
            System.out.println("D больше A");
        } else if (d == a) {
            System.out.println("D равна A");
        } else {
            System.out.println("D меньше A");
        }

        int maxInt = Integer.MAX_VALUE;
        System.out.println("Integer.MAX_VALUE = " + maxInt);
        System.out.println("Integer.MAX_VALUE + 1 = " + (maxInt + 1));
    }
}