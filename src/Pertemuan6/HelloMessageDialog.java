package Pertemuan6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloMessageDialog extends JFrame {

    // Metode pembuat untuk kelas HelloMessageDialog
    public HelloMessageDialog() {

        // Mengatur agar aplikasi berhenti saat jendela ditutup
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Mengatur tampilan komponen dalam jendela dengan tata letak 'FlowLayout'
        this.setLayout(new FlowLayout());

        // Membuat tombol dengan tulisan "Klik"
        JButton button = new JButton("Klik");
        // Menentukan posisi dan ukuran tombol
        button.setBounds(130, 100, 100, 40);

        // Memberikan aksi pada tombol saat diklik
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Menampilkan pesan selamat datang saat tombol "Klik" ditekan
                JOptionPane.showMessageDialog(HelloMessageDialog.this, "Halo, Selamat Datang di Praktikum Pemograman II");
            }
        });

        // Menambahkan tombol ke dalam jendela
        this.add(button);
        // Mengatur ukuran jendela
        this.setSize(200,200);
    }

    // Metode utama yang menjadi titik awal aplikasi
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Membuat dan menampilkan jendela HelloMessageDialog
                HelloMessageDialog h = new HelloMessageDialog();
                h.setVisible(true);
            }
        });
    }
}
