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
        // - Java's Math function (like Math.sin()) only accept radians as input because that's the standard unit used in mathematical calculation, especially calculus. we convert to use the built in functions properly
        // 2. What makes tangent undefined?
        // - Tangent is sin (Θ)/cos (Θ). it becomes undefined whenever the cosine (cos (Θ)) is zero, which occurs at 90°, 270°, etc. division by zero is mathematically incorrect.
        // 3. How to add reciprocal functions?
        // - Calculate the standard fuctions (sin,cos,tan) first, and then find the reciprocals using division : csc(Θ) = 1/sin(Θ), sec(Θ) = 1/cos (Θ), and cot (Θ) = 1/tan(Θ). also check for new division by zero errors.
        



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
        // - Normalizing angles (to 0° - 360°) makes it easier to determine which quadrant the angle falls into.
        // 2.How does the sign of trigonometric functions change across different quadrants?
        // - in quadrant 1, all are positive, in quadrant 2 : sin positive, in quadrant 3 : tan positive, in quadrant 4 : cos positive
        // 3. What special considerations are needed for angles exactly on the axes?
        // - angles like 0°, 90°, 180°, and 270° need special handling, as some triogonometric values become undefined.

        

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
        // - the other two angles must be less than 90° for a valid right triangle.
        // 2. How does your program handle the different cases of known values?
        // - if sides are known, calculate angles with trig fuctions. if an angle and side are known, use inverse functions.
        // 3. the program will detect invalid triangles and give an error message.  
        


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
        // - computers cant always represent numbers exactly, so we use a small tolerance to compare values correctly.
        // 2. Which identity might be most susceptible to floating-point precision issues and why?
        // - sin(20°) = 2sin(0°)cos(°) can be more prone to errors due to floating point precision issues.
        // 3. How could you extend this program to verify more complex identities?
        // - add more checks for each identity and compare both sides within a tolerance.
        

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
    }
}



