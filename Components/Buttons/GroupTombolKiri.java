package Components.Buttons;

import javax.swing.*;

import Styles.Palletes;

import java.awt.*;

public class GroupTombolKiri extends JPanel {
  private Tombol clear = new Tombol("Clear", new Dimension(270, 80));
  private Tombol koma = new Tombol(",", new Dimension(90, 80));
  private Tombol[] angka = new Tombol[10];
  private JPanel gridAngka = new JPanel();


  public GroupTombolKiri() {
    super(new FlowLayout(0, 0, 0));
    
    // setting sifat panel groupTombolKiri
    setPreferredSize(new Dimension(270, 400));  
    setBackground(Palletes.slate700);
    
    // setting sifat grid angka
    gridAngka.setLayout(new GridLayout(3, 3, 0, 0));

    // menambah grid angka ke grouptombolkiri
    add(gridAngka);

    // menambahkan tombol ke panel
    tambahTombolKePanel();
    actionListenerInit();
  }

  private void tambahTombolKePanel() {
    // inisialisasi tombol-tombol angka
    for (int i = 0; i < angka.length; i++) {
      if (i > 0) {
        angka[i] = new Tombol(String.valueOf(i), new Dimension(90, 80));
        gridAngka.add(angka[i]);      
      } else {
        angka[i] = new Tombol(String.valueOf(i), new Dimension(180, 80));
      }
    }
    
    add(angka[0]);
    add(koma);
    add(clear);
  }

  private void actionListenerInit() {

  }
}