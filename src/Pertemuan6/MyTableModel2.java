package Pertemuan6;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

// Kelas MyTableModel2 mengextend AbstractTableModel untuk membuat model tabel kustom
public class MyTableModel2 extends AbstractTableModel {

    // Definisikan nama kolom tabel dengan empat kolom: "Nama", "No HP", "Jenis Kelamin", dan "WNA"
    private final String[] columnNames = {"Nama", "No HP", "Jenis Kelamin", "WNA"};

    // Buat variabel data untuk menyimpan data tabel dalam bentuk ArrayList of ArrayList
    // Setiap ArrayList akan menyimpan satu baris data dalam tabel
    private final ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();

    // Mendapatkan jumlah kolom tabel
    public int getColumnCount() {
        return columnNames.length;
    }

    // Mendapatkan jumlah baris tabel
    public int getRowCount() {
        return data.size();
    }

    // Mendapatkan nama dari kolom tertentu berdasarkan indeks kolom yang diberikan
    public String getColumnName(int col) {
        return columnNames[col];
    }

    // Mengambil data dari sel tertentu dalam tabel berdasarkan baris dan kolom
    public Object getValueAt(int row, int col) {
        return data.get(row).get(col);
    }

    // Menentukan apakah sel tabel bisa diedit atau tidak
    // Di sini, semua sel diatur untuk tidak bisa diedit, sehingga fungsi ini selalu mengembalikan `false`
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    // Menambahkan baris data ke dalam tabel
    // Setelah menambahkan baris baru, metode fireTableRowsInserted dipanggil untuk memberi tahu komponen tabel bahwa data telah berubah dan perlu diperbarui
    public void add(ArrayList<String> value) {
        data.add(value);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }
}
