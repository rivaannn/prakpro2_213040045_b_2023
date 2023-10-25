package Pertemuan3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Nama : Muhamad Rivan Sahronie
// NPM : 213040045
// Kelas : B

public class HelloRadioButton extends JFrame {

    // Konstruktor dari kelas HelloRadioButton
    public HelloRadioButton() {
        // Mengatur operasi default saat frame ditutup (keluar aplikasi)
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Membuat dan mengatur label untuk input nama
        JLabel labelInput = new JLabel("Nama : ");
        labelInput.setBounds(15, 40, 350, 10);

        // Membuat dan mengatur field untuk input nama
        JTextField textField = new JTextField();
        textField.setBounds(15, 60, 350, 30);

        // Membuat dan mengatur label untuk radio button jenis member
        JLabel labelRadio = new JLabel("Jenis Member : ");
        labelRadio.setBounds(15, 100, 350, 10);

        // Membuat dan mengatur radio button untuk member tipe Silver dengan default terpilih
        JRadioButton radioButton1 = new JRadioButton("Silver", true);
        radioButton1.setBounds(15, 120, 100, 30);

        // Membuat dan mengatur radio button untuk member tipe Gold
        JRadioButton radioButton2 = new JRadioButton("Gold");
        radioButton2.setBounds(115, 120, 100, 30);

        // Membuat dan mengatur radio button untuk member tipe Platinum
        JRadioButton radioButton3 = new JRadioButton("Platinum");
        radioButton3.setBounds(215, 120, 100, 30);

        // Membuat grup tombol agar memastikan hanya satu radio button yang dapat dipilih
        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);
        bg.add(radioButton3);

        // Membuat dan mengatur tombol untuk simpan data
        JButton button = new JButton("Simpan");
        button.setBounds(15, 205, 100, 40);

        // Membuat dan mengatur area teks untuk menampilkan output
        JTextArea txtOuput = new JTextArea("");
        txtOuput.setBounds(15, 250, 350, 100);

        // Menambahkan listener ke tombol simpan untuk menghandle ketika tombol ditekan
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String jenisMember = "";
                // Mendapatkan jenis member berdasarkan radio button yang dipilih
                if (radioButton1.isSelected()) {
                    jenisMember = radioButton1.getText();
                }
                if (radioButton2.isSelected()) {
                    jenisMember = radioButton2.getText();
                }
                if (radioButton3.isSelected()) {
                    jenisMember = radioButton3.getText();
                }
                // Mengambil data dari field nama
                String nama = textField.getText();
                // Menampilkan hasil ke dalam area teks
                txtOuput.append("Hello " + nama + "!\n");
                txtOuput.append("Anda adalah member " + jenisMember + "\n");
                // Mereset field nama setelah data disimpan
                textField.setText("");
            }
        });

        // Menambahkan komponen-komponen ke frame
        this.add(button);
        this.add(textField);
        this.add(labelRadio);
        this.add(radioButton1);
        this.add(radioButton2);
        this.add(radioButton3);
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
                HelloRadioButton h = new HelloRadioButton();
                h.setVisible(true);
            }
        });
    }
}
