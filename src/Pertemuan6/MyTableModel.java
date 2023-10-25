package Pertemuan6;

import javax.swing.table.AbstractTableModel;
import javax.swing.*;
import java.util.ArrayList;

// Kelas MyTableModel mengextend AbstractTableModel untuk membuat model tabel kustom
public class MyTableModel extends AbstractTableModel {

    // Definisikan nama kolom tabel
    private String[] columnNames = {"Nama", "Jenis Member"};
    // Buat variabel data untuk menyimpan data tabel dalam bentuk ArrayList of ArrayList
    private ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();

    // Mendapatkan jumlah kolom tabel
    public int getColumnCount() {
        return columnNames.length;
    }

    // Mendapatkan jumlah baris tabel
    public int getRowCount() {
        return data.size();
    }

    // Mendapatkan nama dari kolom tertentu
    public String getColumnName(int col) {
        return columnNames[col];
    }

    // Mendapatkan nilai dari sel tabel tertentu
    public Object getValueAt(int row, int col) {
        return data.get(row).get(col);
    }

    // Menentukan apakah sel tabel bisa diedit atau tidak. Di sini, semua sel diatur untuk tidak bisa diedit
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    // Menambahkan baris data ke dalam tabel
    public void add(ArrayList<String> value) {
        data.add(value);
        // Beri tahu tabel bahwa data telah berubah sehingga tampilannya perlu diperbarui
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }
}
