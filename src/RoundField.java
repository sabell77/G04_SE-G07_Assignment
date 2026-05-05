import javax.swing.*;
import java.awt.*;

/**
 * Class: RoundField
 * Purpose: A custom JTextField with rounded corners and padding.
 */
public class RoundField extends JTextField {
    private int radius;

    public RoundField(int columns, int radius) {
        super(columns);
        this.radius = radius;
        setOpaque(false); // Allows the custom background to show
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Internal padding
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Paint the background
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
        
        super.paintComponent(g);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Paint the border color
        g2.setColor(new Color(180, 180, 180));
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
        
        g2.dispose();
    }
}
