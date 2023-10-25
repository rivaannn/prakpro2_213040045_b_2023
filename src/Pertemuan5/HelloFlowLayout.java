package Pertemuan5; // Menyatakan package atau paket dari kode ini, yaitu "Pertemuan5"

import javax.swing.*; // Mengimpor semua class yang ada di package javax.swing (komponen GUI)
import java.awt.*; // Mengimpor semua class yang ada di package java.awt (antarmuka dan class untuk pemrograman grafis)

// Class "HelloFlowLayout" yang merupakan subkelas dari JFrame (jenis jendela GUI)
public class HelloFlowLayout extends JFrame {

    // Konstruktor dari class "HelloFlowLayout"
    public HelloFlowLayout() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Menentukan operasi default ketika jendela ditutup (EXIT_ON_CLOSE berarti program akan berakhir)

        // Membuat tombol-tombol dengan label berupa angka
        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton button4 = new JButton("4");
        JButton button5 = new JButton("5");
        JButton button6 = new JButton("6");
        JButton button7 = new JButton("7");
        JButton button8 = new JButton("8");
        JButton button9 = new JButton("9");
        JButton button10 = new JButton("10");

        // Menentukan layout manager untuk JFrame ini sebagai FlowLayout dengan alignment tengah dan jarak antar komponen sebesar 10 pixel secara vertikal dan horizontal
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // Menambahkan tombol-tombol ke JFrame
        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);
        this.add(button5);
        this.add(button6);
        this.add(button7);
        this.add(button8);
        this.add(button9);
        this.add(button10);

        this.setSize(400, 400); // Menentukan ukuran jendela sebesar 400x400 pixel
    }

    // Metode main - titik awal eksekusi program
    public static void main(String[] args) {
        // Menggunakan SwingUtilities.invokeLater untuk memastikan bahwa tampilan GUI dibuat dalam thread Event Dispatch Thread (EDT)
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                HelloFlowLayout h = new HelloFlowLayout(); // Membuat instance dari class "HelloFlowLayout"
                h.setVisible(true); // Menampilkan jendela (membuatnya terlihat)
            }
        });
    }
}
