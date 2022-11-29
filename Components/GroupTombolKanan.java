package Components;

import javax.script.ScriptException;
import javax.swing.*;

import Data.DataKalkulator;
import Data.Operasi;
import Styles.Palletes;

import java.awt.*;

public class GroupTombolKanan extends JPanel {
  private Tombol bagi = new Tombol("/", new Dimension(98, 80), Palletes.amber500, Palletes.slate700);
  private Tombol kali = new Tombol("*", new Dimension(98, 80), Palletes.amber500, Palletes.slate700);
  private Tombol kurang = new Tombol("-", new Dimension(98, 80), Palletes.amber500, Palletes.slate700);
  private Tombol tambah = new Tombol("+", new Dimension(98, 80), Palletes.amber500, Palletes.slate700);
  private Tombol hasil = new Tombol("=", new Dimension(98, 80), Palletes.amber500, Palletes.slate700);
  
  
  public GroupTombolKanan() {
    super(new FlowLayout(0, 0, 0));

    setPreferredSize(new Dimension(98, 400));
    setBackground(Palletes.amber500);
    add(bagi);
    add(kali);
    add(kurang);
    add(tambah);
    add(hasil);
    actionListenerInit();
  }

  private void actionListenerInit() {
    tambah.addActionListener((e) -> Display.appendOperand(Frame.display, " + ", Operasi.tambah));
    kurang.addActionListener((e) -> Display.appendOperand(Frame.display, " - ", Operasi.kurang));
    kali.addActionListener((e) -> Display.appendOperand(Frame.display, " * ", Operasi.kali));
    bagi.addActionListener((e) -> Display.appendOperand(Frame.display, " / ", Operasi.bagi));
    hasil.addActionListener((e) -> {
      try {
        DataKalkulator.hitung();
        Display.setDisplayValue(Frame.display, String.valueOf(DataKalkulator.getHasil()));
      } catch (ScriptException e1) {
        e1.printStackTrace();
      }
    });
  }
}
