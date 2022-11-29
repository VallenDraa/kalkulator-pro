package Components;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Data.DataKalkulator;
import Data.Operasi;

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
    if (Double.parseDouble(value) % 1 == 0) {
      display.setText(String.valueOf(Math.round(Double.parseDouble(value))));
    } else {
      display.setText(value);
    }
  }

  public static void appendNumber(Display display, String value) {
    if (display.getText().equals("0")) {
      display.setText(value);
    } else {
      display.setText(display.getText() + value);
    }

    DataKalkulator.addDigit(value);
  }

  public static void appendComma(Display display) {
    String prevInputs = display.getText();

    if (prevInputs.charAt(prevInputs.length() - 1) == '.') {
      display.setText(prevInputs.substring(0, prevInputs.length() - 1));
      DataKalkulator.removeDigit();
    } else {
      // pengecekan apakah input sudah berupa decimal ketika input sebelumnya bukan koma 
      int idx = prevInputs.length() - 1;

      while (true) {
        if (prevInputs.charAt(idx) == ' ' || idx == 0) {
          DataKalkulator.addKoma();
          display.setText(prevInputs + ".");
          break;
        } else if (prevInputs.charAt(idx) == '.') {
          break;
        }
        idx -= 1;
      }
    }
  }

  public static void appendOperand(Display display, String value, Operasi operasi) {
    String prevInputs = display.getText();
    
    // check apakah input sebelumnya adalah angka
    try {
      Integer.parseInt(String.valueOf(prevInputs.charAt(prevInputs.length() - 1)));
      display.setText(display.getText() + value);
      DataKalkulator.addOperasi(operasi);
    } catch (NumberFormatException e) {
      // cancel operand jika input operand user yang baru sama dengan yang lama
      if (String.valueOf(prevInputs.charAt(prevInputs.length() - 2)).equals(value.trim())) {
        display.setText(prevInputs.substring(0, prevInputs.length() - 3));
        DataKalkulator.popOperasi();
      } else {
        // ganti dengan operand baru jika beda dengan input yang lama
        display.setText(prevInputs.substring(0, prevInputs.length() - 3) + value);
        DataKalkulator.replaceOperasi(operasi);
      }
    }
  }

  public static void clearDisplayValue(Display display) {
    display.setText("0");
    DataKalkulator.clear();
  }  
}
