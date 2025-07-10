package CoreJava.Lab8;

import java.util.Scanner;

public class Sort {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of an array: ");
        int size = sc.nextInt();

        int[] array = new int[size];

        System.out.print("Enter " + size + " elements: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        System.out.print("Choose: 1. Ascending 2. Descending: ");
        int choice = sc.nextInt();

        if (choice == 1) {
            for (int i = 0; i < size - 1; i++) {
                for (int j = 0; j < size - i - 1; j++) {
                    if (array[j] > array[j + 1]) {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }
        } else if (choice == 2) {
            for (int i = 0; i < size - 1; i++) {
                for (int j = 0; j < size - i - 1; j++) {
                    if (array[j] < array[j + 1]) {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }
        } else {
            System.out.println("Invalid choice.");
        }

        System.out.print("Sorted array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        sc.close();
    }
}
