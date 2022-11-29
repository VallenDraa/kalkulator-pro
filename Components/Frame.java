package Components;
import javax.swing.*;

import Styles.Palletes;

import java.awt.*;

public class Frame extends JFrame {
  public static final Display display = new Display("0");
  public static final GroupTombolKiri groupTombolKiri = new GroupTombolKiri();
  public static final GroupTombolKanan groupTombolKanan = new GroupTombolKanan(); 

  public Frame() {
    super("Kalkulator");
  
    // setting sifat dari frame
    setLayout(new FlowLayout(0, 0, 0));
    getContentPane().setBackground(Palletes.slate700);
    setSize(370, 530);
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // menambahkn komponen-komponen ke frame utama
    add(display);
    add(groupTombolKiri);
    add(groupTombolKanan);

    setVisible(true);
  }
}

