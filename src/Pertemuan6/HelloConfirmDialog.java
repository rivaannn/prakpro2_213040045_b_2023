package Pertemuan6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloConfirmDialog extends JFrame{

    // Ini adalah constructor atau metode pembuat untuk kelas HelloConfirmDialog.
    public HelloConfirmDialog() {
        // Mengatur tindakan default ketika jendela ditutup menjadi keluar dari aplikasi.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Mengatur susunan tata letak komponen dalam jendela ke FlowLayout.
        this.setLayout(new FlowLayout());

        // Membuat tombol baru dengan label "Exit".
        JButton button = new JButton("Exit");
        // Menetapkan posisi dan ukuran tombol di jendela.
        button.setBounds(130, 100, 100, 40);

        // Menambahkan pendengar aksi ke tombol. Ini akan merespons saat tombol diklik.
        button.addActionListener(new ActionListener() {
            @Override
            // Metode ini akan dijalankan setiap kali tombol "Exit" diklik.
            public void actionPerformed(ActionEvent e) {
                // Menampilkan dialog konfirmasi untuk memastikan pengguna benar-benar ingin keluar.
                int confirmation = JOptionPane.showConfirmDialog(
                        HelloConfirmDialog.this,
                        "Apakah anda yakin ingin keluar dari aplikasi?",
                        "Konfirmasi",
                        JOptionPane.YES_NO_OPTION
                );

                // Jika pengguna mengklik tombol "YES", aplikasi akan ditutup.
                if (confirmation == JOptionPane.YES_OPTION) {
                    System.exit(0);
                } else {
                    // Jika pengguna mengklik tombol "NO", pesan ini akan ditampilkan.
                    JOptionPane.showMessageDialog(HelloConfirmDialog.this, "Anda menekan tombol NO");
                }
            }
        });

        // Menambahkan tombol ke jendela.
        this.add(button);
        // Menetapkan ukuran jendela.
        this.setSize(200, 200);
    }

    // Metode utama yang digunakan untuk menjalankan aplikasi.
    public static void main(String[] args) {
        // Memastikan bahwa tampilan jendela dijalankan di thread Event Dispatching.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Membuat instance dari HelloConfirmDialog dan menampilkan jendelanya.
                HelloConfirmDialog h = new HelloConfirmDialog();
                h.setVisible(true);
            }
        });
    }
}
