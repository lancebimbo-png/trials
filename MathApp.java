import java.util.Scanner;
public class MathApp {
  public static void main (string {} args) {
  Scanner input = new Scanner(System.in);
    System.out.println(" Math App Menu ")
    System.out.println("1. Addition of two numbers");
    System.out.println("2. Subtraction of two numbers");
    System.out.println("3. Multiplication of two numbers");
    System.out.println("4. Division of two numbers");
    System.out.println("5. Factorial of a number");
    System.out.println("6. Power (x^y)");
    System.out.println("7. Sum of numbers 1 to N");
    System.out.println("8. Check if a number is prime");
    System.out.println("0. Exit");
    System.out.println("Enter your choice");
    choice = input.nextInt();

    switch choice {
      case 1:
        System.out.println("Enter First Number");
        Double add1 = input.nextDouble();
        System.out.println("Enter Second Number");
        Double add2 = input.nextDouble();
        System.out.println("Results" (add1 + add2));
        break;

      case 2:
        System.out.println("Enter First Number");
        Double sub1 = input.nextDouble();
        System.out.println("Enter Second Number");
        Double sub2 = input.nextDouble();
        System.out.println("Results" (sub1 - sub2));
        break;

      case 3:
        System.out.println("Enter First Number");
        Int mul1 = input.nextInt();
        System.out.println("Enter Second Number");
        Int mul2 = input.nextInt();
        System.out.println("Results" (mul1 * mul2));
        break;

      case 4:
        System.out.println("Enter First Number");
        Int div1 = input.nextInt();
        System.out.println("Enter Second Number");
        Int div2 = input.nextInt();
        if (div2 = 0) {
        System.out.println("undefined");
        }else {
        System.out.println("Results:" (div1 / div2));
        }
        break;
      
          case 5:
                    System.out.print("Enter a number: ");
                    int n = input.nextInt();
                    if (n < 0) {
                        System.out.println("Error: Factorial of negative number not possible!");
                    } else {
                        long fact = 1;
                        int i = 1;
                        while (i <= n) {
                            fact *= i;
                            i++;
                        }
                        System.out.println("Factorial = " + fact);
                    }
                    break;

                case 6:
                    System.out.print("Enter base (x): ");
                    double base = input.nextDouble();
                    System.out.print("Enter exponent (y): ");
                    double exp = input.nextDouble();
                    double result = Math.pow(base, exp);
                    System.out.println("Result: " + result);
                    break;

                case 7:
                    System.out.print("Enter N: ");
                    int num = input.nextInt();
                    int sum = 0;
                    for (int j = 1; j <= num; j++) {
                        sum += j;
                    }
                    System.out.println("Sum of numbers 1 to " + num + " = " + sum);
                    break;

                case 8:
                    System.out.print("Enter a number: ");
                    int primeNum = input.nextInt();
                    if (primeNum <= 1) {
                        System.out.println(primeNum + " is NOT a prime number.");
                    } else {
                        boolean isPrime = true;
                        for (int k = 2; k <= primeNum / 2; k++) {
                            if (primeNum % k == 0) {
                                isPrime = false;
                                break;
                            }
                        }
                        if (isPrime) {
                            System.out.println(primeNum + " is a prime number.");
                        } else {
                            System.out.println(primeNum + " is NOT a prime number.");
                        }
                    }
                    break;

                case 0:
                    System.out.println("Thank you for using Math App!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

            System.out.print("Do you want to perform another computation? (yes/no): ");
            again = input.next();

        } while (again.equalsIgnoreCase("yes"));

        System.out.println("Thank you for using Math App!");
        input.close();
    }
}
}
