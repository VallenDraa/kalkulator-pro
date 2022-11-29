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
  
  public static void setDisplayValue(Display display, String value) {
    display.setText(value);
  }

  public static void appendNumber(Display display, String value) {
    if (display.getText().equals("0")) {
      display.setText(value);
    } else {
      display.setText(display.getText() + value);
    }
  }

  public static void appendComma(Display display) {
    String prevInputs = display.getText();

    if (prevInputs.charAt(prevInputs.length() - 1) == '.') {
      display.setText(prevInputs.substring(0, prevInputs.length() - 1));
    } else {
      display.setText(prevInputs + ".");
    }
  }

  public static void appendOperand(Display display, String value) {
    String prevInputs = display.getText();
    
    // check apakah input sebelumnya adalah angka
    try {
      Integer.parseInt(String.valueOf(prevInputs.charAt(prevInputs.length() - 1)));
      display.setText(display.getText() + value);
    } catch (NumberFormatException e) {
      display.setText(prevInputs.substring(0, prevInputs.length() - 3) + value);
    }
  }

  public static void clearDisplayValue(Display display) {
    display.setText("0");
  }  
}
