package CoreJava.Lab6;

import java.util.Scanner;

public class CheckPalindrome {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a positive number: ");
        int num = sc.nextInt();

        int copy = num;
        int digit, reversed = 0;

        while (copy != 0) {
            digit = copy % 10;
            reversed = reversed * 10 + digit;
            copy /= 10;
        }

        if (reversed == num) {
            System.out.println(num + " is palindrome.");
        } else {
            System.out.println(num + " isn't palindrome.");
        }

        sc.close();

    }
}