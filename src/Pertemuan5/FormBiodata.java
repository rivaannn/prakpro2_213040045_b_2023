package Pertemuan5;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormBiodata extends JFrame {

    public FormBiodata() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Mengatur judul frame
        this.setTitle("Form Biodata");

        // Menggunakan FlowLayout untuk frame
        this.setLayout(new FlowLayout());

        // Menggunakan JPanel untuk mengelompokkan beberapa komponen
        JLabel headerLabel = new JLabel("Form Biodata:", JLabel.CENTER);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Membuat komponen untuk panel
        JLabel inputNama = new JLabel("Nama : ");
        JTextField fieldNama = new JTextField(5);
        JLabel inputNoTelp = new JLabel("Nomor HP : ");
        JTextField fieldNoTelp = new JTextField(5);
        JLabel inputJenisKelamin = new JLabel("Jenis Kelamin : ");
        JRadioButton radioLaki = new JRadioButton("Laki-laki");
        JRadioButton radioPerempuan = new JRadioButton("Perempuan");
        JCheckBox checkWNA = new JCheckBox("Warga Negara Asing");
        JButton buttonSimpan = new JButton("Simpan");
        JTextArea txtOuput = new JTextArea(10, 5);

        // Menambahkan label dan field ke panel dengan posisi yang ditentukan
        // Berikut adalah kode untuk menambahkan komponen ke panel dengan mengatur posisi x dan y
        // ...
        // ... (Kode menambahkan komponen lainnya ke panel)
        // ...
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(inputNama, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(fieldNama, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(inputNoTelp, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(fieldNoTelp, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        mainPanel.add(inputJenisKelamin, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        mainPanel.add(radioLaki, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        mainPanel.add(radioPerempuan, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        mainPanel.add(checkWNA, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        mainPanel.add(buttonSimpan, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        mainPanel.add(txtOuput, gbc);

        // Mengatur layout frame
        this.setLayout(new GridLayout(2, 1));
        this.add(headerLabel);
        this.add(mainPanel);
        this.setSize(600, 600);

        // Mengatur event untuk button simpan
        buttonSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = fieldNama.getText();
                String noTelp = fieldNoTelp.getText();
                String jenisKelamin = "";
                if (radioLaki.isSelected()) { // Jika radio button laki-laki dipilih
                    jenisKelamin = "Laki-laki";
                } else if (radioPerempuan.isSelected()) { // Jika radio button perempuan dipilih
                    jenisKelamin = "Perempuan";
                }
                String wna = checkWNA.isSelected() ? "Ya" : "Bukan"; // Jika checkbox dipilih
                String hasil = "Nama : " + nama + "\n" +
                        "Nomor HP : " + noTelp + "\n" +
                        "Jenis Kelamin : " + jenisKelamin + "\n" +
                        "Kewarganegaraan : " + wna + "\n" +
                        "============================================ \n";
                txtOuput.setText(hasil);
            }
        });
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                FormBiodata gui = new FormBiodata();
                gui.setVisible(true);
            }
        });
    }
}

