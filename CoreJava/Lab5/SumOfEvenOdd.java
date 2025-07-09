package CoreJava.Lab5;

public class SumOfEvenOdd {
    public static void main(String[] args) {

        int sumEven = 0;
        int sumOdd = 0;

        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                sumEven += i;
            } else {
                sumOdd += i;
            }
        }

        System.out.println("Sum of even numbers from 1 to 100: " + sumEven);
        System.out.println("Sum of odd numbers from 1 to 100: " + sumOdd);
    }
}
