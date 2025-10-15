
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Student
 */
public class LoopsLab {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Select Activity");
        System.out.println("Multiplication Table Generator");
        System.out.println("Sum of Natural Numbers");
        System.out.println("Factorial Calculator");
        System.out.println("Even and Odd Numbers");
        System.out.println("Reverse Digits of a Number");
        int choice = input.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Enter a Number");
                int num = input.nextInt();
                for (int a = 1; a <= 10; a++) {
                    System.out.println(num + " x " + a + " = " + (num * a));
                }
                break;

            case 2:
                System.out.println("Enter a Number");
                int b = input.nextInt();
                int sum = 0;
                int c = 1;
                while (c <= b) {
                    sum = sum + c;
                    c++;
                }

                System.out.println("Sum = " + sum);
                break;

            case 3:
                System.out.println("Enter a Number");
                int d = input.nextInt();
                int factorial = 1;
                int e = 1;
                do {
                    factorial = factorial * e;
                    e++;
                } while (e <= d);
                System.out.println("Factorial = " + factorial);
                break;
            
            case 4:
                System.out.println("Enter a Number");
                int f = input.nextInt();
                System.out.println("Even Numbers");
                for (int g = 1; g <= f; g++) {
                    if (g % 2 == 0){
                    System.out.println(f + "");
                }
                }
                System.out.println("Odd Numbers");
                for  (int g = 1; g <= f; g++) {
                    if (g % 2 != 0) {
                    System.out.println(g + "");
                }
                }
                System.out.println("");
                break;
            case 5:
                system.out.println("Enter a Number");
                int number = intout.nextInt();
                int reversed = 0;
                while (number ! = 0) {
                    int digit = number % 10;
                    reversed = reversed 10 * 10 + digit;
                    number = number / 10;
                }
                System.out.println("Reversed" + reversed)
        }

    }
}


