package Pertemuan6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloMessageDialog2 extends JFrame {

    public HelloMessageDialog2() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        JButton button = new JButton("Klik Error Message");
        button.setBounds(130, 100, 100, 40);

        JButton button2 = new JButton("Klik Information Message");
        button2.setBounds(130, 100, 100, 40);

        JButton button3 = new JButton("Klik Warning Message");
        button3.setBounds(130, 100, 100, 40);

        JButton button4 = new JButton("Klik Plain Message");
        button4.setBounds(130, 100, 100, 40);

        JButton button5 = new JButton("Klik Question Message");
        button5.setBounds(130, 100, 100, 40);

    //        Menampilkan Message Type untuk JOptionPane, [Error_Message, Information_Message, Warning_Message, Plain_Message]
         button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(HelloMessageDialog2.this, "Hello World", "Error Message", JOptionPane.ERROR_MESSAGE);

                }
            });

        button2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Hello World", "Information Message", JOptionPane.INFORMATION_MESSAGE);
                }
            });

        button3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Hello World", "Warning Message", JOptionPane.WARNING_MESSAGE);
                }
            });

        button4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Hello World", "Plain Message", JOptionPane.PLAIN_MESSAGE);
                }
            });

        button5.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(null, "Hello World", "Question Message", JOptionPane.QUESTION_MESSAGE);
                    }
                });

        this.add(button);
        this.add(button2);
        this.add(button3);
        this.add(button4);
        this.add(button5);
        this.setSize(200,200);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                HelloMessageDialog2 h = new HelloMessageDialog2();
                h.setVisible(true);
            }
        });
    }
}
