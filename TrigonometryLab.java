/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trigonometrylab;

import java.util.Scanner;
import static java.lang.Math.*;

public class TrigonometryLab {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // PROBLEM 1: Trigonometric Calculator
 
        System.out.println("Trigonometric Calculator");
        System.out.print("Enter an angle in degrees: ");
        double angleDeg = input.nextDouble();

        // convert degrees to radians (because Math.sin/cos/tan only work with radians)
        // reference: https://www.w3schools.com/java/java_math.asp
        double angleRad = toRadians(angleDeg);

        System.out.println("Choose a function: ");
        System.out.println("1. Sine");
        System.out.println("2. Cosine");
        System.out.println("3. Tangent");
        System.out.println("4. All three");
        int choice = input.nextInt();

        if (choice == 1) { // if user chose sine
            System.out.println("sin(" + angleDeg + ") = " + sin(angleRad));
        } else if (choice == 2) { // cosine
            System.out.println("cos(" + angleDeg + ") = " + cos(angleRad));
        } else if (choice == 3) { // tangent
            // check for undefined tangent at 90° and 270°
            if ((angleDeg % 180) == 90) {
                System.out.println("Tangent is undefined at " + angleDeg + " degrees.");
            } else {
                System.out.println("tan(" + angleDeg + ") = " + tan(angleRad));
            }
        } else if (choice == 4) { // all three
            System.out.println("sin(" + angleDeg + ") = " + sin(angleRad));
            System.out.println("cos(" + angleDeg + ") = " + cos(angleRad));
            if ((angleDeg % 180) == 90) {
                System.out.println("Tangent is undefined at " + angleDeg + " degrees.");
            } else {
                System.out.println("tan(" + angleDeg + ") = " + tan(angleRad));
            }
        } else {
            System.out.println("Invalid choice.");
        }

        // Critical Thinking (Problem 1):
        // - Why convert to radians? Because Math trig functions use radians not degrees.
        // - Tangent undefined at 90 and 270 because cos=0, and tan = sin/cos (division by zero).
      
        // PROBLEM 2: Angle Quadrant Detector

        System.out.println("Problem 2: Angle Quadrant Detector");
        System.out.print("Enter an angle in degrees: ");
        double angle = input.nextDouble();

        // normalize angle between 0 and 360 using modulus
        // reference: https://www.w3schools.com/java/ref_keyword_mod.asp
        angle = angle % 360;
        if (angle < 0) {
            angle += 360;
        }

        if (angle == 0 || angle == 180) {
            System.out.println("Angle is on the x-axis.");
        } else if (angle == 90 || angle == 270) {
            System.out.println("Angle is on the y-axis.");
        } else if (angle > 0 && angle < 90) {
            System.out.println("Quadrant I: sin +, cos +, tan +");
        } else if (angle > 90 && angle < 180) {
            System.out.println("Quadrant II: sin +, cos -, tan -");
        } else if (angle > 180 && angle < 270) {
            System.out.println("Quadrant III: sin -, cos -, tan +");
        } else if (angle > 270 && angle < 360) {
            System.out.println("Quadrant IV: sin -, cos +, tan -");
        }

        // Critical Thinking (Problem 2):
        // - Normalize so angle is always between 0-360.
        // - Signs change based on unit circle (only sin positive in Quadrant II, etc.)
        // - Special angles (0, 90, 180, 270) lie on axes.

        // PROBLEM 3: Right Triangle Solver

        System.out.println("Problem 3: Right Triangle Solver");
        System.out.println("What do you know?");
        System.out.println("1. Two sides");
        System.out.println("2. One side and one angle");
        int know = input.nextInt();

        double a = 0, b = 0, c = 0; // sides
        double A = 0, B = 0, C = 90; // angles (C = right angle)

        if (know == 1) {
            System.out.print("Enter side a: ");
            a = input.nextDouble();
            System.out.print("Enter side b: ");
            b = input.nextDouble();
            c = sqrt(a * a + b * b); // Pythagorean theorem
            A = toDegrees(atan(a / b)); // find angle A
            B = 90 - A; // other angle
        } else if (know == 2) {
            System.out.print("Enter the side you know (a): ");
            a = input.nextDouble();
            System.out.print("Enter angle A (less than 90): ");
            A = input.nextDouble();
            if (A >= 90) {
                System.out.println("Invalid angle.");
            } else {
                double Arad = toRadians(A);
                B = 90 - A;
                c = a / sin(Arad); // sin(A) = a/c
                b = sqrt(c * c - a * a);
            }
        } else {
            System.out.println("Invalid choice.");
        }

        System.out.println("Sides: a=" + a + " b=" + b + " c=" + c);
        System.out.println("Angles: A=" + A + " B=" + B + " C=" + C);
        double area = (a * b) / 2;
        System.out.println("Area = " + area);

        // Critical Thinking (Problem 3):
        // - Angles must be <90 (since only one right angle).
        // - Different inputs lead to different trig calculations.
        // - Wrong inputs mean invalid triangle.

        // PROBLEM 4: Trigonometric Identity Verifier

        System.out.println("Problem 4: Identity Verifier");
        System.out.print("Enter an angle in degrees: ");
        double ang = input.nextDouble();
        double angRad = toRadians(ang);

        double left1 = pow(sin(angRad), 2) + pow(cos(angRad), 2);
        System.out.println("sin^2 + cos^2 = " + left1 + " (should be 1)");

        double left2 = 1 + pow(tan(angRad), 2);
        double right2 = 1 / pow(cos(angRad), 2);
        System.out.println("1 + tan^2 = " + left2 + " and sec^2 = " + right2);

        double left3 = sin(2 * angRad);
        double right3 = 2 * sin(angRad) * cos(angRad);
        System.out.println("sin(2θ) = " + left3 + " and 2sinθcosθ = " + right3);

        // Critical Thinking (Problem 4):
        // - Floating point is not exact, so we use tolerance (difference small).
        // - 1 + tan^2 = sec^2 might fail near 90° because tan gets huge.

        // PROBLEM 5: Wave Properties Analyzer

        System.out.println("Problem 5: Wave Analyzer");
        System.out.print("Enter amplitude: ");
        double amp = input.nextDouble();
        System.out.print("Enter frequency: ");
        double freq = input.nextDouble();
        System.out.print("Enter phase shift (degrees): ");
        double phase = input.nextDouble();
        System.out.print("Enter time: ");
        double t = input.nextDouble();

        // convert phase to radians
        double phaseRad = toRadians(phase);

        // formula: y(t) = A * sin(2πft + phase)
        double value = amp * sin(2 * PI * freq * t + phaseRad);
        System.out.println("Instantaneous value = " + value);

        if (abs(value - amp) < 0.0001) {
            System.out.println("At a peak");
        } else if (abs(value + amp) < 0.0001) {
            System.out.println("At a trough");
        } else if (abs(value) < 0.0001) {
            System.out.println("At zero-crossing");
        } else {
            System.out.println("At some other point of the wave");
        }

        // next peak time: when sine = 1
        double nextPeakTime = (PI / 2 - phaseRad) / (2 * PI * freq);
        if (nextPeakTime < t) {
            nextPeakTime += 1.0 / freq;
        }
        System.out.println("Next peak at time = " + nextPeakTime);

        // Critical Thinking (Problem 5):
        // - Peak/trough found when value equals amplitude or -amplitude.
        // - Next peak time depends on frequency and phase.
        // - For non-sinusoidal waves, formula would change.

        input.close();
    }
}

