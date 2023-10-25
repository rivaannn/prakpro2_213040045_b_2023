package Pertemuan3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Nama : Muhamad Rivan Sahronie
// NPM : 213040045
// Kelas : B

public class LatCheckRadio extends JFrame {

    // Konstruktor dari kelas LatCheckRadio
    public LatCheckRadio() {

        // Mengatur operasi default saat frame ditutup (keluar aplikasi)
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Membuat dan mengatur label untuk input nama
        JLabel inputNama = new JLabel("Nama : ");
        inputNama.setBounds(15, 40, 350, 10);

        // Membuat dan mengatur field untuk input nama
        JTextField fieldNama = new JTextField();
        fieldNama.setBounds(15, 60, 350, 30);

        // Membuat dan mengatur label untuk input nomor telepon
        JLabel inputNoTelp = new JLabel("Nomor HP : ");
        inputNoTelp.setBounds(15, 100, 350, 10);

        // Membuat dan mengatur field untuk input nomor telepon
        JTextField fieldNoTelp = new JTextField();
        fieldNoTelp.setBounds(15, 120, 350, 30);

        // Membuat dan mengatur label untuk input jenis kelamin
        JLabel inputJenisKelamin = new JLabel("Jenis Kelamin : ");
        inputJenisKelamin.setBounds(15, 160, 350, 10);

        // Membuat dan mengatur radio button untuk pilihan jenis kelamin laki-laki
        JRadioButton radioLaki = new JRadioButton("Laki-laki");
        radioLaki.setBounds(15, 180, 100, 30);

        // Membuat dan mengatur radio button untuk pilihan jenis kelamin perempuan
        JRadioButton radioPerempuan = new JRadioButton("Perempuan");
        radioPerempuan.setBounds(15, 210, 100, 30);

        // Membuat dan mengatur checkbox untuk pilihan Warga Negara Asing
        JCheckBox checkWNA = new JCheckBox("Warga Negara Asing");
        checkWNA.setBounds(15, 240, 350, 30);

        // Membuat dan mengatur tombol untuk melakukan aksi simpan
        JButton buttonSimpan = new JButton("Simpan");
        buttonSimpan.setBounds(15, 280, 100, 30);

        // Membuat dan mengatur area teks untuk menampilkan hasil
        JTextArea txtOuput = new JTextArea("");
        txtOuput.setBounds(15, 320, 350, 200);

        // Menambahkan listener ke tombol simpan untuk menangani aksi ketika tombol ditekan
        buttonSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mengambil data dari field nama
                String nama = fieldNama.getText();
                // Mengambil data dari field nomor telepon
                String noTelp = fieldNoTelp.getText();
                // Mengatur default value untuk jenis kelamin
                String jenisKelamin = "";
                if (radioLaki.isSelected()) {
                    jenisKelamin = "Laki-laki";
                } else if (radioPerempuan.isSelected()) {
                    jenisKelamin = "Perempuan";
                }
                // Menentukan apakah checkbox WNA dipilih atau tidak
                String wna = checkWNA.isSelected() ? "Ya" : "Bukan";
                // Menyusun hasil untuk ditampilkan
                String hasil = "Nama : " + nama + "\n" +
                        "Nomor HP : " + noTelp + "\n" +
                        "Jenis Kelamin : " + jenisKelamin + "\n" +
                        "Kewarganegaraan : " + wna + "\n" +
                        "============================================ \n";
                // Menampilkan hasil pada area teks
                txtOuput.setText(hasil);
            }
        });

        // Menambahkan komponen-komponen ke frame
        this.add(buttonSimpan);
        this.add(fieldNama);
        this.add(fieldNoTelp);
        this.add(radioLaki);
        this.add(radioPerempuan);
        this.add(checkWNA);
        this.add(inputNama);
        this.add(inputNoTelp);
        this.add(inputJenisKelamin);
        this.add(txtOuput);

        // Mengatur ukuran dan layout dari frame
        this.setSize(400, 600);
        this.setLayout(null);

    }

    // Metode main untuk menjalankan aplikasi
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Membuat objek dari kelas ini dan menampilkan frame
                LatCheckRadio gui = new LatCheckRadio();
                gui.setVisible(true);
            }
        });
    }
}
