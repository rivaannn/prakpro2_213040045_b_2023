package Pertemuan3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

// Nama : Muhamad Rivan Sahronie
// NPM : 213040045
// Kelas : B

public class HelloCheckBox extends JFrame {

    // Variabel untuk menyimpan status checkbox (terpilih atau tidak)
    private boolean checkBoxSelected;

    // Konstruktor dari kelas HelloCheckBox
    public HelloCheckBox() {
        // Inisialisasi default checkbox sebagai tidak terpilih
        this.checkBoxSelected = false;

        // Mengatur operasi default saat frame ditutup (keluar aplikasi)
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Membuat dan mengatur label untuk input nama
        JLabel labelInput = new JLabel("Input Nama : ");
        labelInput.setBounds(15, 40, 350, 10);

        // Membuat dan mengatur field untuk input nama
        JTextField textField = new JTextField();
        textField.setBounds(15, 60, 350, 30);

        // Membuat dan mengatur checkbox untuk persetujuan syarat dan ketentuan
        JCheckBox checkBox = new JCheckBox("Saya menyetujui syarat dan ketentuan yang berlaku");
        checkBox.setBounds(15, 100, 350, 30);

        // Membuat dan mengatur tombol untuk simpan data
        JButton button = new JButton("Simpan");
        button.setBounds(15, 200, 350, 100);

        // Membuat dan mengatur area teks untuk menampilkan output
        JTextArea txtOuput = new JTextArea();
        txtOuput.setBounds(15, 200, 350, 100);

        // Menambahkan listener ke checkbox untuk menghandle perubahan statusnya
        checkBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // Memperbarui status checkBoxSelected berdasarkan status checkbox
                checkBoxSelected = e.getStateChange() == 1;
            }
        });

        // Menambahkan listener ke tombol simpan untuk menghandle ketika tombol ditekan
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mengecek apakah checkbox terpilih
                if (checkBoxSelected) {
                    // Jika ya, ambil data dari field nama dan tampilkan
                    String nama = textField.getText();
                    txtOuput.append("Hello " + nama + "!\n");
                    // Setelah data ditampilkan, reset field nama
                    textField.setText("");
                } else {
                    // Jika tidak, tampilkan pesan peringatan
                    txtOuput.append("Anda tidak mencentang kotak persetujuan \n");
                }
            }
        });

        // Menambahkan komponen-komponen ke frame
        this.add(button);
        this.add(textField);
        this.add(checkBox);
        this.add(labelInput);
        this.add(txtOuput);

        // Mengatur ukuran dan layout dari frame
        this.setSize(400, 500);
        this.setLayout(null);
    }

    // Metode main untuk menjalankan aplikasi
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Membuat objek dari kelas ini dan menampilkan frame
                HelloCheckBox h = new HelloCheckBox();
                h.setVisible(true);
            }
        });
    }
}
