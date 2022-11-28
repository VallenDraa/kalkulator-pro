package Components;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.*;

import Styles.Fonts;
import Styles.Palletes;

public class Display extends JTextField {
  
  public Display(String text) {
    super(text);
    
    setEditable(false);
    setBackground(Palletes.slate800);
    setForeground(Palletes.slate100);
    setHorizontalAlignment(SwingConstants.RIGHT);
    setFont(Fonts.display);
    setPreferredSize(new Dimension(368, 100));
    setBorder(new EmptyBorder(20, 20, 20, 20));
  }
}
