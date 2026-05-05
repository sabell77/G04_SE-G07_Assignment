import javax.swing.*;
import java.awt.*;

/**
 * Class: RoundScrollPane
 * Purpose: Custom scroll pane with rounded corners and bold purple border.
 */
public class RoundScrollPane extends JScrollPane {
    private int radius;
    private Color borderColor = new Color(106, 13, 173); // Bold Purple

    public RoundScrollPane(Component view, int radius) {
        super(view);
        this.radius = radius;
        setOpaque(false);
        getViewport().setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Padding
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Background color (matching the text area)
        g2.setColor(getViewport().getView().getBackground());
        g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
        
        // Border color
        g2.setColor(borderColor);
        g2.setStroke(new BasicStroke(2));
        g2.drawRoundRect(1, 1, getWidth() - 3, getHeight() - 3, radius, radius);
        
        g2.dispose();
    }
}

