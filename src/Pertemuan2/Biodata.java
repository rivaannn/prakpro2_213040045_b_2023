package Pertemuan2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Biodata extends JFrame {

    public Biodata() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelNama = new JLabel("Nama : ");
        labelNama.setBounds(130,40,400,20);

        JTextField textField = new JTextField();
        textField.setBounds(130,60,100,30);

        JLabel labelNoTelp = new JLabel("No Telefon : ");
        labelNoTelp.setBounds(130,90,400,20);

        JTextField noTelpField = new JTextField();
        noTelpField.setBounds(130,110,100,30);

        JButton button = new JButton("Click");
        button.setBounds(130,150,100,40);

        JTextArea txtOutput = new JTextArea();
        txtOutput.setBounds(130,200,300,200);


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = textField.getText();
                String noTelp = noTelpField.getText();
                txtOutput.append(nama+ " - " + noTelp+"\n");
                textField.setText("");
                noTelpField.setText("");
            }
        });

        this.add(button);
        this.add(textField);
        this.add(noTelpField);
        this.add(labelNama);
        this.add(labelNoTelp);
        this.add(txtOutput);


        this.setSize(400,500);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Biodata b = new Biodata();
                b.setVisible(true);
            }
        });
    }
}
