import javax.swing.*;
import java.awt.*;

public class RoundButton extends JButton {
    public RoundButton(String label) {
        super(label);
        setContentAreaFilled(false); // Let us paint our own background
        setFocusPainted(false);
        setBorderPainted(false);     // We'll draw our own border
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Change color based on whether it's pressed
        if (getModel().isPressed()) {
            g2.setColor(getBackground().darker());
        } else {
            g2.setColor(getBackground());
        }

        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20); // Rounded edges
        super.paintComponent(g);
        g2.dispose();
    }
}

