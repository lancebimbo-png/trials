import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PostureReminder reminder = new PostureReminder();
        boolean running = true;

        while (running) {
            System.out.println("\n=== POSTURE REMINDER SYSTEM ===");
            System.out.println("1. Set reminder interval (minutes)");
            System.out.println("2. Start reminder");
            System.out.println("3. View reminder history");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter interval in minutes: ");
                int minutes = scanner.nextInt();
                reminder.setInterval(minutes);
                System.out.println("Interval set to " + minutes + " minutes.");
            } else if (choice == 2) {
                reminder.start();
                System.out.println("Reminder started.");
            } else if (choice == 3) {
                reminder.printHistory();
            } else if (choice == 4) {
                running = false;
                reminder.stop();
                System.out.println("Program exited.");
            } else {
                System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}
