package Pertemuan4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Nama : Muhamad Rivan Sahronie
// NPM : 213040045
// Kelas : B

public class HelloBorderLayout extends JFrame {

    // Konstruktor dari kelas HelloBorderLayout
    public HelloBorderLayout() {
        // Mengatur operasi default saat frame ditutup (keluar aplikasi)
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Membuat dan mengatur label pertanyaan
        JLabel labelPertanyaan = new JLabel(("Apakah ibukota Indonesia?"));
        // Membuat dan mengatur label untuk menampilkan hasil jawaban
        JLabel labelHasil = new JLabel("Jawab Pertanyaan di atas");

        // Membuat tombol-tombol pilihan jawaban
        JButton buttonA = new JButton("Jakarta");
        JButton buttonB = new JButton("Bandung");
        JButton buttonC = new JButton("Surabaya");

        // Menambahkan action listener ke tombol A (Jakarta) yang merupakan jawaban benar
        buttonA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelHasil.setText("Jawaban anda benar");
            }
        });

        // Menambahkan action listener ke tombol B (Bandung) yang merupakan jawaban salah
        buttonB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelHasil.setText("Jawaban anda salah");
            }
        });

        // Menambahkan action listener ke tombol C (Surabaya) yang merupakan jawaban salah
        buttonC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelHasil.setText("Jawaban anda salah");
            }
        });

        // Menambahkan komponen ke frame dengan menggunakan layout BorderLayout
        this.add(labelPertanyaan, BorderLayout.NORTH); // Label pertanyaan di bagian atas
        this.add(labelHasil, BorderLayout.SOUTH);      // Label hasil di bagian bawah
        this.add(buttonA, BorderLayout.WEST);          // Tombol A di bagian kiri
        this.add(buttonB, BorderLayout.CENTER);       // Tombol B di bagian tengah
        this.add(buttonC, BorderLayout.EAST);         // Tombol C di bagian kanan

        this.setSize(400, 200); // Mengatur ukuran frame
    }

    // Metode main untuk menjalankan aplikasi
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HelloBorderLayout h = new HelloBorderLayout(); // Membuat objek dari kelas ini
                h.setVisible(true); // Menampilkan frame
            }
        });
    }
}
