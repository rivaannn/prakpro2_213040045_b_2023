package Pertemuan6;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class HelloTable2 extends JFrame {

    // Konstruktor untuk kelas HelloTable2
    public HelloTable2(){

        // Atur agar aplikasi berhenti saat jendela ditutup
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Buat label dengan tulisan "Nama" dan tentukan posisinya
        JLabel labelInput = new JLabel("Nama : ");
        labelInput.setBounds(15,40,350,10);

        // Buat kotak teks untuk memasukkan nama
        JTextField textFieldInput = new JTextField();
        textFieldInput.setBounds(15,60,350,30);

        // Buat label dengan tulisan "No. HP" dan tentukan posisinya
        JLabel labelInputTelp = new JLabel("No. HP : ");
        labelInputTelp.setBounds(15,100,350,10);

        // Buat kotak teks untuk memasukkan nomor HP
        JTextField textFieldInputTelp = new JTextField();
        textFieldInputTelp.setBounds(15,110,350,30);

        // Buat label untuk jenis kelamin
        JLabel labelRadio = new JLabel("Jenis Kelamin");
        labelRadio.setBounds(15,150,350,10);

        // Buat pilihan radio untuk jenis kelamin
        JRadioButton radioButton1 = new JRadioButton("Laki - Laki", true);
        radioButton1.setBounds(15,170,350,30);
        JRadioButton radioButton2 = new JRadioButton("Perempuan");
        radioButton2.setBounds(15,210,350,30);

        // Kelompokkan radio button supaya hanya satu yang bisa dipilih
        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);

        // Buat checkbox untuk menandai apakah Warga Negara Asing atau tidak
        JCheckBox checkWNA = new JCheckBox("Warga Negara Asing");
        checkWNA.setBounds(15,250,350,30);

        // Buat tombol untuk simpan data yang telah dimasukkan
        JButton button = new JButton("Simpan");
        button.setBounds(15,290,100,40);

        // Buat tabel untuk menampilkan data yang telah dimasukkan
        JTable table = new JTable();
        JScrollPane scrolllableTable = new JScrollPane(table);
        scrolllableTable.setBounds(15,340,350,200);

        // Set model untuk tabel tersebut
        MyTableModel2 tableModel = new MyTableModel2();
        table.setModel(tableModel);

        // Tindakan saat tombol "Simpan" ditekan
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = textFieldInput.getText();
                String noHP = textFieldInputTelp.getText();
                String jenisKelamin = radioButton1.isSelected() ? "Laki - Laki" : "Perempuan";
                String wna = checkWNA.isSelected() ? "WNA" : "WNI";

                ArrayList<String> data = new ArrayList<String>(Arrays.asList(nama, noHP, jenisKelamin, wna));
                tableModel.add(data);
            }
        });

        // Tambahkan semua komponen ke jendela
        this.add(button);
        this.add(checkWNA);
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
                HelloTable2 h = new HelloTable2();
                h.setVisible(true);
            }
        });
    }
}
