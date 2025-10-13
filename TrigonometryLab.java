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

 
        System.out.println("Trigonometric Calculator");
        System.out.print("Enter an angle in degrees: ");
        double angleDeg = input.nextDouble();

        double angleRad = toRadians(angleDeg);

        System.out.println("Choose a function: ");
        System.out.println("1. Sine");
        System.out.println("2. Cosine");
        System.out.println("3. Tangent");
        System.out.println("4. All three");
        int choice = input.nextInt();

        if (choice == 1) {
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

        
        // 1. Why do we need to convert angles from degrees to radians?
        // - I convert angles from degrees to radians because Java’s Math functions work in radians. If I don’t convert them, I’ll get wrong results since the formulas depend on radians.
        // 2. What makes tangent undefined?
        // - Tangent becomes undefined when cosine equals zero, like at 90° and 270°. At those points, dividing by zero makes the value undefined.
        // 3. How to add reciprocal functions?
        // - I can add extra formulas for reciprocal functions:
            //cosecant = 1 / sin(θ)
            //secant = 1 / cos(θ)
            //cotangent = 1 / tan(θ)
            //Before dividing, I’ll check that the denominator isn’t zero to avoid errors.
        



        System.out.println("Problem 2: Angle Quadrant Detector");
        System.out.print("Enter an angle in degrees: ");
        double angle = input.nextDouble();

        
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

        

        // 1. Why is it important to normalize angles before determining their quadrant?
        // - I normalize angles to keep them between 0° and 360°. This helps me find the correct quadrant because angles can repeat or wrap around the circle.
        // 2.How does the sign of trigonometric functions change across different quadrants?
        // - I learned that each quadrant changes which trig functions are positive:
            //Quadrant I: all are positive
        1   //Quadrant II: only sine is positive
            //Quadrant III: only tangent is positive
            //Quadrant IV: only cosine is positive
        // 3. What special considerations are needed for angles exactly on the axes?
        // - When the angle is 0°, 90°, 180°, or 270°, I treat them as special cases. They don’t belong to any quadrant, and some trig values become zero or undefined, so I handle them separately.
        

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


        // 1. Why must we validate that angles in a right triangle are less than 90°?
        // - I make sure that the other angles are less than 90° because a right triangle can only have one 90° angle. If another angle is 90° or more, it’s not a right triangle anymore.
        // 2. How does your program handle the different cases of known values?
        // - I let the user choose what they know—two sides or one side and one angle. Then I use the right formula, like sine, cosine, or tangent, to find the missing values.
        // 3. What would happen if a user entered values that don't form a valid right triangle?
        // - If someone enters invalid values, the program shows impossible results or math errors. I handle that by checking if the values follow the Pythagorean rule before solving.
        


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


        // 1. Why do we need a tolerance when comparing floating-point values?
        // - I use a small tolerance because computers can’t store perfect decimal numbers. Tiny rounding errors happen, so I compare values within a small range, like ±0.0001.
        // 2. Which identity might be most susceptible to floating-point precision issues and why?
        // - I noticed that the identity 1 + tan²θ = sec²θ has more precision problems. When the angle is near 90°, tangent and secant get very large, which increases rounding errors.
        // 3. How could you extend this program to verify more complex identities?
        // -I can add more formulas, like double-angle or reciprocal identities. I’ll compute both sides and check if they’re equal within the same tolerance.
        

        System.out.println("Problem 5: Wave Analyzer");
        System.out.print("Enter amplitude: ");
        double amp = input.nextDouble();
        System.out.print("Enter frequency: ");
        double freq = input.nextDouble();
        System.out.print("Enter phase shift (degrees): ");
        double phase = input.nextDouble();
        System.out.print("Enter time: ");
        double t = input.nextDouble();

        double phaseRad = toRadians(phase);
        
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

        double nextPeakTime = (PI / 2 - phaseRad) / (2 * PI * freq);
        if (nextPeakTime < t) {
            nextPeakTime += 1.0 / freq;
        }
        System.out.println("Next peak at time = " + nextPeakTime);

        input.close();


        // 1. How did you determine if the wave is at a peak or trough?
        // - I check the sine value. If it equals 1, the wave is at a peak; if it equals -1, the wave is at a trough.
        // 2. What mathematical approach did you use to find the next peak?
        // - I use the period formula T = 1 / frequency. Then I add one period to the current time to find the next peak position.
        // 3. How would you modify this program to handle non-sinusoidal waves?
        // - I can change the sine equation to another wave type, like square or triangle waves. I’ll also update how I check for peaks and troughs to match that wave’s shape.
    }
}




