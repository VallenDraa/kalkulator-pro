import javax.swing.*;

import Components.Display;
import Components.Buttons.GroupTombolKanan;
import Components.Buttons.GroupTombolKiri;
import Styles.Palletes;

import java.awt.*;

public class Kalkulator {
  public static void main(String[] args) {
    // inisialisasi frame
    JFrame frame = new JFrame("Kalkulator");

    // setting sifat dari frame
    frame.setLayout(new FlowLayout(0, 0, 0));
    frame.getContentPane().setBackground(Palletes.slate700);
    frame.setSize(370, 530);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // menambahkn komponen-komponen ke frame utama
    frame.add(new Display("0"));
    frame.add(new GroupTombolKiri());
    frame.add(new GroupTombolKanan());

    frame.setVisible(true);
  }
}
