import java.util.Timer;
import java.util.TimerTask;

public class PostureReminder {
    private int intervalMinutes = 1;
    private Timer timer;
    private String[] history = new String[10];
    private int historyIndex = 0;

    public void setInterval(int minutes) {
        if (minutes > 0) {
            intervalMinutes = minutes;
        }
    }

    public void start() {
        stop();
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                new ReminderPopup();
                logHistory("Posture reminder triggered.");
            }
        }, intervalMinutes * 60 * 1000, intervalMinutes * 60 * 1000);
    }

    public void stop() {
        if (timer != null) {
            timer.cancel();
        }
    }

    private void logHistory(String message) {
        if (historyIndex < history.length) {
            history[historyIndex] = message;
            historyIndex++;
        }
    }

    public void printHistory() {
        System.out.println("\n--- Reminder History ---");
        if (historyIndex == 0) {
            System.out.println("No reminders yet.");
        } else {
            for (int i = 0; i < historyIndex; i++) {
                System.out.println((i + 1) + ". " + history[i]);
            }
        }
    }
}
