package CoreJava.Lab7;

import java.util.Scanner;

public class ArraySum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of an array: ");
        int size = sc.nextInt();

        int[] array = new int[size];

        System.out.print("Enter " + size + " elements of an array: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        int sum = 0;

        System.out.print("Array: ");
        for (int num : array) {
            System.out.print(num + " ");
            sum += num;
        }

        System.out.println("\nSum of elements of the array: " + sum);

        sc.close();
    }
}