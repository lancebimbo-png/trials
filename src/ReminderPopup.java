import javax.swing.*;
import java.awt.*;

public class ReminderPopup {
    public ReminderPopup() {
        JFrame frame = new JFrame("Posture Reminder");
        frame.setSize(350, 150);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.setAlwaysOnTop(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel label = new JLabel("🧍 Time to fix your posture!", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 16));

        frame.add(label, BorderLayout.CENTER);
        frame.setVisible(true);

        new javax.swing.Timer(5000, e -> frame.dispose()).start();
    }
}
