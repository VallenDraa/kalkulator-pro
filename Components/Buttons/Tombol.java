package Components.Buttons;

import javax.swing.*;
import java.awt.*;

import Styles.Fonts;
import Styles.Palletes;

public class Tombol extends JButton {
  public Tombol(String text, Dimension size) {
    super(text);
    
    setDefaultStyle();
    setPreferredSize(size);
  }
  
  public Tombol(String text, Dimension size, Color color) {
    super(text);
    
    setDefaultStyle();
    setPreferredSize(size);
    setBackground(color);
  }

  public Tombol(String text, Dimension size, Color bgColor, Color textColor) {
    super(text);
    
    setDefaultStyle();
    setPreferredSize(size);
    setBackground(bgColor);
    setForeground(textColor);
  }
  
  private void setDefaultStyle() {
    setBackground(Palletes.slate700);
    setForeground(Palletes.slate300);
    setBorder(null);
    setFocusable(false);
    setFont(Fonts.tombol);
  }
}
