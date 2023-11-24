package Pertemuan9.Membership.member;

import javax.swing.table.*;
class MemberTableModel extends AbstractTableModel{

    private String[] columnNames = {"Nama", "Jenis Member"};
    private java.util.List<Member> data;

    public MemberTableModel(java.util.List<Member> data) {
        this.data = data;
    }

    public int getColumnCount() {
        return this.columnNames.length;
    }

    public int getRowCount() {
        return this.data.size();
    }

    public String getColumnName(int col) {
        return this.columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        Member rowItem = data.get(row);
        String value = "";

        switch (col) {
            case 0:
                value = rowItem.getNama();
                break;
            case 1:
                value = rowItem.getJenisMember().getNama();
                break;
        }
        return value;
    }

    public boolean isCellEditable(int row, int col) {
        return false;
    }

    public void add(Member value) {
        data.add(value);
        fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    }
}
