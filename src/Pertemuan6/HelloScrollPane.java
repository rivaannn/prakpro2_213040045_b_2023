package Pertemuan6;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloScrollPane extends JFrame {

    // Konstruktor untuk kelas HelloScrollPane
    public HelloScrollPane(){

        // Atur agar aplikasi berhenti saat jendela ditutup
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Buat label dengan tulisan "Input Nama" dan tentukan posisinya
        JLabel labelInput = new JLabel("Input Nama");
        labelInput.setBounds(130,40,100,10);

        // Buat kotak teks untuk memasukkan nama
        JTextField textField = new JTextField();
        textField.setBounds(100,60,100,30);

        // Buat tombol dengan tulisan "Klik" dan tentukan posisinya
        JButton button = new JButton("Klik");
        button.setBounds(130,100,100,40);

        // Buat area teks yang bisa di-scroll untuk menampilkan output
        JTextArea txtOuput = new JTextArea("");
        JScrollPane scrolllableTextArea = new JScrollPane(txtOuput);
        scrolllableTextArea.setBounds(130,150,100,100);
        // Atur agar scroll bar muncul sesuai kebutuhan
        scrolllableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrolllableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Tambahkan aksi ke tombol "Klik"
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ambil teks dari kotak inputan
                String nama = textField.getText();
                // Tambahkan teks ke area output dan tambahkan baris baru setiap kali
                txtOuput.append("Hello "+nama+ "\n");
                // Hapus teks dari kotak inputan setelah ditambahkan ke area output
                textField.setText("");
            }
        });

        // Tambahkan semua komponen ke jendela
        this.add(button);
        this.add(textField);
        this.add(labelInput);
        this.add(scrolllableTextArea);

        // Atur ukuran jendela dan layout-nya
        this.setSize(400,500);
        this.setLayout(null);
    }

    // Metode utama untuk menjalankan program
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                // Buat dan tampilkan jendela aplikasi
                HelloScrollPane h = new HelloScrollPane();
                h.setVisible(true);
            }
        });
    }
}
