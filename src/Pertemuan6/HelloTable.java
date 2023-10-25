package Pertemuan6;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class HelloTable extends JFrame {

    // Konstruktor untuk kelas HelloTable
    public HelloTable(){

        // Atur agar aplikasi berhenti saat jendela ditutup
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Buat label dengan tulisan "Nama" dan tentukan posisinya
        JLabel labelInput = new JLabel("Nama");
        labelInput.setBounds(15,40,350,10);

        // Buat kotak teks untuk memasukkan nama
        JTextField textFieldInput = new JTextField();
        textFieldInput.setBounds(15,60,350,30);

        // Buat label untuk jenis member
        JLabel labelRadio = new JLabel("Jenis Member");
        labelRadio.setBounds(15,100,350,10);

        // Buat pilihan radio untuk jenis member
        JRadioButton radioButton1 = new JRadioButton("Silver", true);
        radioButton1.setBounds(15,115,350,30);
        JRadioButton radioButton2 = new JRadioButton("Gold");
        radioButton2.setBounds(15,145,350,30);
        JRadioButton radioButton3 = new JRadioButton("Platinum");
        radioButton3.setBounds(15,175,350,30);

        // Kelompokkan radio button supaya kita hanya bisa pilih salah satu
        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);
        bg.add(radioButton3);

        // Buat tombol untuk simpan data yang telah dimasukkan
        JButton button = new JButton("Simpan");
        button.setBounds(15,205,100,40);

        // Buat tabel untuk menampilkan data yang telah dimasukkan
        javax.swing.JTable table = new JTable();
        JScrollPane scrolllableTable = new JScrollPane(table);
        scrolllableTable.setBounds(15,250,350,200);

        // Set model untuk tabel tersebut
        MyTableModel tableModel = new MyTableModel();
        table.setModel(tableModel);

        // Tindakan saat tombol "Simpan" ditekan
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String jenisMember = "";
                if (radioButton1.isSelected()) {
                    jenisMember = radioButton1.getText();
                }
                if (radioButton2.isSelected()) {
                    jenisMember = radioButton2.getText();
                }
                if (radioButton3.isSelected()) {
                    jenisMember = radioButton3.getText();
                }

                // Ambil nama yang dimasukkan
                String nama = textFieldInput.getText();
                // Tambahkan nama dan jenis member ke tabel
                tableModel.add(new ArrayList<>((Arrays.asList(nama, jenisMember))));
            }
        });

        // Tambahkan semua komponen ke jendela
        this.add(button);
        this.add(textFieldInput);
        this.add(labelRadio);
        this.add(radioButton1);
        this.add(radioButton2);
        this.add(radioButton3);
        this.add(labelInput);
        this.add(scrolllableTable);

        // Atur ukuran dan layout jendela
        this.setSize(400, 500);
        this.setLayout(null);
    }

    // Metode utama untuk menjalankan program
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Buat dan tampilkan jendela aplikasi
                HelloTable h = new HelloTable();
                h.setVisible(true);
            }
        });
    }
}
