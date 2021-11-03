package threads.ex1;

import java.util.Scanner;

public class MathSum implements Runnable {
    @Override
    public void run(){
        Scanner input = new Scanner(System.in);
        System.out.print("Number 1: ");
        double n1 = input.nextDouble();
        System.out.print("Number 2: ");
        double n2 = input.nextDouble();
        System.out.println("-------------------------------");
        System.out.println("Sum is " + (n1 + n2));
    }
}
