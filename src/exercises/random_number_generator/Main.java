package exercises.random_number_generator;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int firstBound, secondBound;
        while (true) {
            try {
                System.out.print("First Bound (should be non-negative): ");
                firstBound = input.nextInt();
                if (firstBound < 0) {
                    System.out.println(firstBound + " is invalid...");
                    continue;
                }
                break;
            } catch (InputMismatchException ignore1) {
                System.out.println("Type a valid integer...");
                input.next();
            }
        }
        while (true) {
            try {
                System.out.print("Second bound (greater than " + firstBound + "): ");
                secondBound = input.nextInt();
                if (secondBound <= firstBound) {
                    System.out.println("Second bound " + secondBound + " is invalid...");
                    continue;
                }
                break;
            } catch (InputMismatchException exception) {
                System.out.println("Type a valid integer...");
                input.next();
            }
        }
        System.out.println("Generated pseudorandom number: " + randomNumber(firstBound, secondBound));
    }

    private static int randomNumber(int firstBound, int secondBound) {
        return firstBound + (int) (Math.random() * (secondBound + 1 - firstBound));
    }
}
