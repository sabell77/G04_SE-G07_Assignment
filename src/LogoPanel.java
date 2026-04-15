import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Class: LogoPanel
 * Purpose: Custom painting to create a circular logo with text.
 */
public class LogoPanel extends JPanel {

    public LogoPanel() {
        // Set the size of the logo container
        setPreferredSize(new Dimension(150, 150));
        setOpaque(false); // Make the panel background transparent
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // --- Quality Settings ---
        // Turn on antialiasing for smooth circles and text
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // --- Draw the Circle ---
        int size = 100; // Diameter of the circle
        int x = (getWidth() - size) / 2; // Center horizontally
        int y = (getHeight() - size) / 2; // Center vertically

        // Set circle color (e.g., a "cute" light blue)
        g2d.setColor(new Color(145, 95, 239)); 
        g2d.fill(new Ellipse2D.Double(x, y, size, size)); // Fill the circle

        
        // --- Draw the Text ---
        g2d.setColor(Color.WHITE); // Text color
        g2d.setFont(new Font("Arial", Font.BOLD, 18)); // Font style

        // Calculate text position to be centered inside the circle
        String text1 = "String";
        String text2 = "Encoder";
        FontMetrics metrics = g2d.getFontMetrics(g2d.getFont());
        
        // Horizontal centers
        int x1 = (getWidth() - metrics.stringWidth(text1)) / 2;
        int x2 = (getWidth() - metrics.stringWidth(text2)) / 2;
        
        // Vertical positions (calculated relative to the circle's y)
        int centerY = y + (size / 2);
        int y1 = centerY - (metrics.getHeight() / 4); // Line 1 slightly above center
        int y2 = centerY + (metrics.getHeight() / 2); // Line 2 slightly below center

        g2d.drawString(text1, x1, y1);
        g2d.drawString(text2, x2, y2);
    }
}