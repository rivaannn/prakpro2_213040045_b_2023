package Pertemuan5;

import javax.swing.*;
import java.awt.*;


public class HelloGridBagLayout extends JFrame {

    // Konstruktor dari class "HelloGridBagLayout"
    public HelloGridBagLayout() {
        // Menentukan operasi default ketika jendela ditutup (EXIT_ON_CLOSE berarti program akan berakhir)
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Membuat label untuk header dengan teks "Layout Manager - GridBagLayout" dan alignment tengah
        JLabel headerLabel = new JLabel("Layout Manager - GridBagLayout", JLabel.CENTER);

        // Membuat panel untuk control dengan layout FlowLayout
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        // Membuat panel utama dengan background warna abu-abu gelap dan ukuran 300x300 pixel
        JPanel panel = new JPanel();
        panel.setBackground(Color.darkGray);
        panel.setSize(300, 300);
        // Menentukan layout manager untuk panel ini sebagai GridBagLayout
        panel.setLayout(new GridBagLayout());
        // Membuat objek GridBagConstraints untuk menentukan konstraints bagi setiap komponen dalam GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();

        // Menambahkan tombol ke panel dengan menggunakan GridBagConstraints
        gbc.fill = GridBagConstraints.HORIZONTAL; // Komponen akan memenuhi sel secara horizontal
        gbc.gridx = 0; // Kolom 0
        gbc.gridy = 0; // Baris 0
        panel.add(new JButton("Button 1"), gbc);

        gbc.gridx = 1; // Kolom 1
        gbc.gridy = 0; // Baris 0
        panel.add(new JButton("Button 2"), gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 20; // Menambah padding vertikal sebesar 20 pixel
        gbc.gridx = 0; // Kolom 0
        gbc.gridy = 1; // Baris 1
        panel.add(new JButton("Button 3"), gbc);

        gbc.gridx = 1; // Kolom 1
        gbc.gridy = 1; // Baris 1
        panel.add(new JButton("Button 4"), gbc);

        gbc.gridx = 0; // Kolom 0
        gbc.gridy = 2; // Baris 2
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2; // Tombol ini akan memenuhi dua kolom
        panel.add(new JButton("Button 5"), gbc);

        // Menambahkan panel ke controlPanel
        controlPanel.add(panel);

        // Menentukan layout manager untuk frame ini sebagai GridLayout dengan 2 baris dan 1 kolom
        this.setLayout(new GridLayout(2,1));
        this.add(headerLabel);    // Menambahkan header label ke frame
        this.add(controlPanel);   // Menambahkan controlPanel ke frame
        this.setSize(400, 400);   // Menentukan ukuran jendela sebesar 400x400 pixel
    }

    // Metode main - titik awal eksekusi program
    public static void main(String[] args) {
        // Menggunakan SwingUtilities.invokeLater untuk memastikan bahwa tampilan GUI dibuat dalam thread Event Dispatch Thread (EDT)
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                HelloGridBagLayout h = new HelloGridBagLayout(); // Membuat instance dari class "HelloGridBagLayout"
                h.setVisible(true); // Menampilkan jendela (membuatnya terlihat)
            }
        });
    }
}
