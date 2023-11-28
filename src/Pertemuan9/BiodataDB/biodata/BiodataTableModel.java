package Pertemuan9.BiodataDB.biodata;

import javax.swing.table.*;
import java.util.ArrayList;
import java.util.List;

public class BiodataTableModel extends AbstractTableModel {
    private String[] columnNames = {"ID", "Nama", "Alamat", "No HP", "Jenis Kelamin", "Status"};
    private List<Biodata> data;

    public BiodataTableModel(List<Biodata> data) {
        this.data = data;
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.size();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        Biodata rowItem = data.get(row);
        String value = "";

        switch(col) {
            case 0:
                value = rowItem.getId();
                break;
            case 1:
                value = rowItem.getNama();
                break;
            case 2:
                value = rowItem.getAlamat();
                break;
            case 3:
                value = rowItem.getNoHp();
                break;
            case 4:
                value = rowItem.getJenisKelamin();
                break;
            case 5:
                value = rowItem.getStatus();
                break;
        }
        return value;
    }

    public boolean isCellEditable(int row, int col) {
        return true;
    }

    public void add(Biodata value) {
        data.add(value);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }

    public void set(int row, int col, Biodata value) {
        Biodata rowItem = data.get(row);
        data.set(row, rowItem);
        fireTableRowsUpdated(row, row);
    }

    public void delete(int row) {
        data.remove(row);
        fireTableRowsDeleted(row, row);
    }
}
