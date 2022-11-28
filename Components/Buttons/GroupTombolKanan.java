package Components.Buttons;

import javax.swing.*;

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
  }
}
