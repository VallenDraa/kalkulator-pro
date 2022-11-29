package Components;
import javax.swing.*;

import Styles.Palletes;

import java.awt.*;

public class Frame extends JFrame {
  public static final Display display = new Display("0");
  public static final GroupTombolKiri groupTombolKiri = new GroupTombolKiri();
  public static final GroupTombolKanan groupTombolKanan = new GroupTombolKanan(); 
  
  private JScrollBar scrollBar = new JScrollBar(JScrollBar.HORIZONTAL);
  private JPanel displayPanel = new JPanel();
  private BoundedRangeModel rangeModel = display.getHorizontalVisibility();
  
  public Frame() {
    super("Kalkulator");

    // setting sifat dari display panel agar memiliki scrollbar
    displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));
    scrollBar.setModel(rangeModel);
    displayPanel.add(display);
    displayPanel.add(scrollBar);

    // setting sifat dari frame
    setLayout(new FlowLayout(0, 0, 0));
    getContentPane().setBackground(Palletes.slate700);
    setSize(370, 550);
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // menambahkn komponen-komponen ke frame utama
    add(displayPanel);
    add(groupTombolKiri);
    add(groupTombolKanan);

    setVisible(true);
  }
}

