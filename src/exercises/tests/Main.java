package exercises.tests;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long number;
        while (true) {
            number = input.nextLong();
            if (number < 0) break;
            for (int i = 0; i < fact(number); i++) { //T(n) = n!
                System.out.println(i + 1);
            }
        }
    }

    private static long fact(long num) {
        if (num <= 1) return 1;
        long result = 1;
        while (num > 1) {
            result *= num--;
        }
        return result;
    }
}
