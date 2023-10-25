package Pertemuan7;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Tugas extends JFrame {

    private void saveToFile(ArrayList<ArrayList<String>> data) {
        try {
            // Tulis data ke file
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\mriva\\IdeaProjects\\PraktikumPemogramanII\\src\\Pertemuan7\\data.txt"));
            for (ArrayList<String> row : data) {
                for (String s : row) {
                    writer.write(s + "\t"); // memisahkan setiap data dengan tab
                }
                writer.newLine(); // pindah ke baris baru untuk data berikutnya
            }
            writer.close();
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan ke data.txt");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat menyimpan data");
            e.printStackTrace();
        }
    }

    public Tugas(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tambahkan window listener untuk menangani event saat jendela ditutup
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
 //                Jika tombol "Yes" ditekan maka program akan berhenti
                if (JOptionPane.showConfirmDialog(null,
                        "Apakah Anda yakin ingin menutup aplikasi ini?",
                        "Konfirmasi",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                        System.exit(0);
                } else {
//                    Jika tombol "No" ditekan maka program akan tetap berjalan
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });

        JLabel labelInput = new JLabel("Nama : ");
        labelInput.setBounds(15,40,350,10);

        JTextField textFieldInput = new JTextField();
        textFieldInput.setBounds(15,60,350,30);

        JLabel labelInputTelp = new JLabel("No. HP : ");
        labelInputTelp.setBounds(15,100,350,10);

        JTextField textFieldInputTelp = new JTextField();
        textFieldInputTelp.setBounds(15,110,350,30);

        JLabel labelRadio = new JLabel("Jenis Kelamin");
        labelRadio.setBounds(15,150,350,10);

        JRadioButton radioButton1 = new JRadioButton("Laki - Laki");
        radioButton1.setBounds(15,170,350,30);
        JRadioButton radioButton2 = new JRadioButton("Perempuan");
        radioButton2.setBounds(15,210,350,30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);

        JLabel labelAlamat = new JLabel("Alamat : ");
        labelAlamat.setBounds(15,250,350,10);

        JTextArea textAreaAlamat = new JTextArea();
        textAreaAlamat.setBounds(15,270,350,110);

        JButton button = new JButton("Simpan");
        button.setBounds(15,400,100,40);

        JButton buttonEdit = new JButton("Edit");
        buttonEdit.setBounds(120,400,100,40);

        JButton buttonHapus = new JButton("Hapus");
        buttonHapus.setBounds(225,400,100,40);

        JButton buttonSimpan = new JButton("Simpan ke File");
        buttonSimpan.setBounds(330,400,150,40);

        JTable table = new JTable();
        JScrollPane scrolllableTable = new JScrollPane(table);
        scrolllableTable.setBounds(15,450,750,300);

        MyTugasModel tableModel = new MyTugasModel();
        table.setModel(tableModel);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = textFieldInput.getText();
                String noHP = textFieldInputTelp.getText();
                String jenisKelamin;
                if (radioButton1.isSelected()) {
                    jenisKelamin = "Laki - Laki";
                } else if (radioButton2.isSelected()) {
                    jenisKelamin = "Perempuan";
                } else {
                    JOptionPane.showMessageDialog(null, "Silahkan pilih jenis kelamin terlebih dahulu!");
                    return;
                }
                String alamat = textAreaAlamat.getText();

                if (nama.isEmpty() || noHP.isEmpty() || alamat.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Tolong isi semua data terlebih dahulu!");
                    return;
                }

//                Ketika button simpan ditekan tampilkan konfirmasi
                if (JOptionPane.showConfirmDialog(null,
                        "Apakah Anda yakin ingin menyimpan data ini?",
                        "Konfirmasi",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                        JOptionPane.showMessageDialog(null, "Data berhasil disimpan!");
                } else {
//                    Jika tombol "No" ditekan maka program akan tetap berjalan
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }

                ArrayList<String> data = new ArrayList<String>(Arrays.asList(nama, noHP, jenisKelamin, alamat));
                tableModel.add(data);

                textFieldInput.setText("");
                textFieldInputTelp.setText("");
                labelRadio.setText("");
                textAreaAlamat.setText("");
            }
        });

        // Edit Data
        buttonEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(null, "Silahkan pilih data yang ingin diubah!");
                    return;
                }

                String nama = textFieldInput.getText();
                String noHP = textFieldInputTelp.getText();
                String jenisKelamin;
                if (radioButton1.isSelected()) {
                    jenisKelamin = "Laki - Laki";
                } else if (radioButton2.isSelected()) {
                    jenisKelamin = "Perempuan";
                } else {
                    JOptionPane.showMessageDialog(null, "Silahkan pilih jenis kelamin terlebih dahulu!");
                    return;
                }
                String alamat = textAreaAlamat.getText();

                if (nama.isEmpty() || noHP.isEmpty() || alamat.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Tolong isi semua data terlebih dahulu!");
                    return;
                }

                if (JOptionPane.showConfirmDialog(null,
                        "Apakah Anda yakin ingin mengubah data ini?",
                        "Konfirmasi",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                        JOptionPane.showMessageDialog(null, "Data berhasil diubah!");
                } else {
//                    Jika tombol "No" ditekan maka program akan tetap berjalan
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }

                ArrayList<String> data = new ArrayList<String>(Arrays.asList(nama, noHP, jenisKelamin, alamat));
                tableModel.edit(data, row);

                textFieldInput.setText("");
                textFieldInputTelp.setText("");
                labelRadio.setText("");
                textAreaAlamat.setText("");
            }
        });


        // Simpan File
        buttonSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveToFile(tableModel.getData());
            }
        });

        // hapus data
        buttonHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(null, "Silahkan pilih data yang ingin dihapus!");
                    return;
                }

                if (JOptionPane.showConfirmDialog(null,
                        "Apakah Anda yakin ingin menghapus data ini?",
                        "Konfirmasi",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                        JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
                } else {
//                    Jika tombol "No" ditekan maka program akan tetap berjalan
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
                tableModel.remove(row);
            }
        });


        // Tambahkan semua komponen ke jendela
        this.add(button);
        this.add(buttonEdit);
        this.add(buttonHapus);
        this.add(buttonSimpan);
        this.add(labelAlamat);
        this.add(textAreaAlamat);
        this.add(textFieldInput);
        this.add(textFieldInputTelp);
        this.add(labelRadio);
        this.add(radioButton1);
        this.add(radioButton2);
        this.add(labelInput);
        this.add(labelInputTelp);
        this.add(scrolllableTable);

        // Atur ukuran dan layout jendela
        this.setSize(400, 500);
        this.setLayout(null);
    }
    // Metode utama untuk menjalankan program
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Buat dan tampilkan jendela aplikasi
                Tugas h = new Tugas();
                h.setVisible(true);
            }
        });
    }
}
