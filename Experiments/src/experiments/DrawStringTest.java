package experiments;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;
import myutil.Tools;

public class DrawStringTest extends JPanel {

    public static void main(String[] args) {
        JPanel panel = new DrawStringTest();

        panel.setPreferredSize(new Dimension(500, 200));
        Tools.framePanel(panel);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        paintWithSetPaint(g2);
        paintWithTextAttributeMap(g2);
        paintWithIterator(g2);

    }
    void paintWithSetPaint(Graphics2D g2){
        g2.setFont(new Font("Monospaced", Font.PLAIN, 30));
        g2.setPaint(new Color(255, 0, 0));
        g2.drawString("12345\n678", 0, 30);
    }
    
    void paintWithTextAttributeMap(Graphics2D g2){
        Map<TextAttribute, Object> map = new HashMap<TextAttribute, Object>();
        map.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
        map.put(TextAttribute.FOREGROUND, new Color(0,255,0));
        
        Font font = new Font("Monospaced", Font.PLAIN, 30);
        
        g2.setFont(font.deriveFont(map));
        g2.drawString("12345\n678", 0, 50);        
    }
    
    void paintWithIterator(Graphics2D g2){
        AttributedString text = new AttributedString("Blah blah\nSpam spam spam");
        text.addAttribute(TextAttribute.FONT, new Font("Serif", Font.BOLD, 40));
        // only add for chatacters between 1 and 3
        text.addAttribute(TextAttribute.FOREGROUND, new Color(0,0,255), 1, 3);
        
        AttributedCharacterIterator it = text.getIterator();
        FontRenderContext frc = g2.getFontRenderContext();
        //TextLayout is an immutable graphical representation of text
        TextLayout layout = new TextLayout(it, frc);
        layout.draw(g2, 20, 70);
    }
    
    
}
