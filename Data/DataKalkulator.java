package Data;

import java.util.ArrayList;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public abstract class DataKalkulator {
  private static int idxEntryAngka = 0;
  private static double hasil = 0;
  private static ArrayList<String> entryAngka = new ArrayList<>();
  private static ArrayList<Operasi> entryOperasi = new ArrayList<>();

  public static void clear() {
    entryAngka.clear();
    entryOperasi.clear();
    idxEntryAngka = 0;
  }

  // untuk arraylist operasi
  public static void addOperasi(Operasi operasi) {
    entryOperasi.add(operasi);
    idxEntryAngka += 1;
  }
  public static void popOperasi() {
    entryOperasi.remove(entryOperasi.size() - 1);
    idxEntryAngka -= 1;
  }
  public static void replaceOperasi(Operasi operasi) {
    entryOperasi.set(entryOperasi.size() - 1, operasi);
  }

  // untuk arraylist angka
  public static void addKoma() {
    if (idxEntryAngka == entryAngka.size()) {
      entryAngka.add(".");
    } else {
      if (!entryAngka.get(idxEntryAngka).contains(".")) {
        entryAngka.set(idxEntryAngka, entryAngka.get(idxEntryAngka).concat("."));
      }
    }
  }
  public static void addDigit(String angka) {
    if (idxEntryAngka == entryAngka.size()) {
      entryAngka.add(angka);
    } else {
      entryAngka.set(idxEntryAngka, entryAngka.get(idxEntryAngka).concat(angka));
    }
  }
  public static void removeDigit() {
    String currStr = entryAngka.get(idxEntryAngka);
    entryAngka.set(idxEntryAngka, currStr.substring(0, currStr.length() - 1));
  }

  // untuk hasil
  public static void hitung() throws ScriptException {
    // jika ukuran arraylist sama berarti input terakhir dari user adalah sebuah operand
    if (entryAngka.size() == entryOperasi.size()) return;
    
    String operasiUntukEvaluasi = "";
  
    for (int i = 0; i < entryAngka.size(); i++) {
      operasiUntukEvaluasi = operasiUntukEvaluasi.concat(entryAngka.get(i));

      if (i > entryOperasi.size() - 1) break;

      if (entryOperasi.get(i) != null) {
        if (entryOperasi.get(i) == Operasi.tambah) {
          operasiUntukEvaluasi = operasiUntukEvaluasi.concat("+");
        } else if (entryOperasi.get(i) == Operasi.kurang) {
          operasiUntukEvaluasi = operasiUntukEvaluasi.concat("-");
        } else if (entryOperasi.get(i) == Operasi.kali) {
          operasiUntukEvaluasi = operasiUntukEvaluasi.concat("*");
        } else {
          operasiUntukEvaluasi = operasiUntukEvaluasi.concat("/");
        }
      }
    }

    // hitung hasil 
    ScriptEngineManager mgr = new ScriptEngineManager();
    ScriptEngine engine = mgr.getEngineByName("js");
    hasil = Double.parseDouble(String.valueOf(engine.eval(operasiUntukEvaluasi)));     
  }
  public static double getHasil() {
    return hasil;
  }
}
