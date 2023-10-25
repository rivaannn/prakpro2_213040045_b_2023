package Pertemuan6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloInputDialog extends JFrame {

    // Ini adalah metode pembuat untuk aplikasi jendelanya.
    public HelloInputDialog(){

        // Saat kita tutup jendela, aplikasi akan berhenti.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Mengatur tampilan jendela supaya komponennya rapi.
        this.setLayout(new FlowLayout());

        // Membuat tombol dengan tulisan "Input".
        JButton button = new JButton("Input");
        // Menentukan posisi dan ukuran tombolnya.
        button.setBounds(130, 100, 100, 40);

        // Memberi tombol kemampuan untuk melakukan sesuatu saat diklik.
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Munculkan kotak kecil buat nulis nama.
                String nama = JOptionPane.showInputDialog(HelloInputDialog.this, "Inputkan nama anda");
                // Setelah kita tulis nama dan tekan OK, aplikasi bilang "Hello" dan nama kita.
                JOptionPane.showMessageDialog(HelloInputDialog.this, "Hello " + nama);
            }
        });

        // Menambahkan tombol ke jendela.
        this.add(button);
        // Mengatur ukuran jendela.
        this.setSize(200,200);
    }

    // Ini bagian yang membuat aplikasi berjalan saat kita mulai.
    public static void main(String[] args) {
        // Membuat dan menampilkan jendela aplikasinya.
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                HelloInputDialog h = new HelloInputDialog();
                h.setVisible(true);
            }
        });
    }
}
