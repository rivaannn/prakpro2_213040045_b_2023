package Pertemuan4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Nama : Muhamad Rivan Sahronie
// NPM : 213040045
// Kelas : B

public class HelloGridLayout extends JFrame implements ActionListener {

    private JButton buttonA;
    private JButton buttonB;
    private JButton buttonC;
    private JButton buttonD;
    private JButton buttonE;
    private JButton buttonF;
    private JButton buttonG;
    private JButton buttonH;
    private JButton buttonI;

    private JButton[] buttons;
    private boolean gameOver;

    // Konstruktor dari kelas HelloGridLayout
    public HelloGridLayout() {
        // Mengatur operasi default saat frame ditutup (keluar aplikasi)
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Inisialisasi game belum berakhir
        gameOver = false;

        // Membuat tombol dengan label kosong
        buttonA = new JButton("");
        buttonB = new JButton("");
        buttonC = new JButton("");
        buttonD = new JButton("");
        buttonE = new JButton("");
        buttonF = new JButton("");
        buttonG = new JButton("");
        buttonH = new JButton("");
        buttonI = new JButton("");

        // Menyimpan semua tombol ke dalam array untuk akses yang lebih mudah
        buttons = new JButton[]{buttonA, buttonB, buttonC, buttonD, buttonE, buttonF, buttonG, buttonH, buttonI};

        // Menambahkan action listener ke setiap tombol
        for (JButton button : buttons) {
            button.addActionListener(this);
        }

        // Mengatur layout frame menjadi 3x3 grid
        this.setLayout(new GridLayout(3, 3));

        // Menambahkan setiap tombol ke frame
        for (JButton button : buttons) {
            this.add(button);
        }

        this.setSize(300, 300);
    }

    // Method yang dipanggil ketika sebuah tombol ditekan
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            JButton button = (JButton) e.getSource();
            if (button.getText().isEmpty()) {
                button.setText("0");
                checkWinner();
                if (!gameOver) {
                    for (JButton btn : buttons) {
                        if (btn.getText().isEmpty()) {
                            btn.setText("X");
                            break;
                        }
                    }
                    checkWinner();
                }
            }
        }
    }

    // Method untuk memeriksa apakah ada pemenang dalam game ini
    private void checkWinner() {
        String winner = "";
        // Memeriksa setiap kemungkinan baris, kolom, dan diagonal untuk pemenang
        if (!buttonA.getText().isEmpty() && buttonA.getText().equals(buttonB.getText()) && buttonA.getText().equals(buttonC.getText())) {
            winner = buttonA.getText();
            buttonA.setForeground(Color.RED);
            buttonB.setForeground(Color.RED);
            buttonC.setForeground(Color.RED);
        } else if (!buttonD.getText().isEmpty() && buttonD.getText().equals(buttonE.getText()) && buttonD.getText().equals(buttonF.getText())) {
            winner = buttonD.getText();
            buttonD.setForeground(Color.RED);
            buttonE.setForeground(Color.RED);
            buttonF.setForeground(Color.RED);
        } else if (!buttonG.getText().isEmpty() && buttonG.getText().equals(buttonH.getText()) && buttonG.getText().equals(buttonI.getText())) {
            winner = buttonG.getText();
            buttonG.setForeground(Color.RED);
            buttonH.setForeground(Color.RED);
            buttonI.setForeground(Color.RED);
        } else if (!buttonA.getText().isEmpty() && buttonA.getText().equals(buttonD.getText()) && buttonA.getText().equals(buttonG.getText())) {
            winner = buttonA.getText();
            buttonA.setForeground(Color.RED);
            buttonD.setForeground(Color.RED);
            buttonG.setForeground(Color.RED);
        } else if (!buttonB.getText().isEmpty() && buttonB.getText().equals(buttonE.getText()) && buttonB.getText().equals(buttonH.getText())) {
            winner = buttonB.getText();
            buttonB.setForeground(Color.RED);
            buttonE.setForeground(Color.RED);
            buttonH.setForeground(Color.RED);
        } else if (!buttonC.getText().isEmpty() && buttonC.getText().equals(buttonF.getText()) && buttonC.getText().equals(buttonI.getText())) {
            winner = buttonC.getText();
            buttonC.setForeground(Color.RED);
            buttonF.setForeground(Color.RED);
            buttonI.setForeground(Color.RED);
        } else if (!buttonA.getText().isEmpty() && buttonA.getText().equals(buttonE.getText()) && buttonA.getText().equals(buttonI.getText())) {
            winner = buttonA.getText();
            buttonA.setForeground(Color.RED);
            buttonE.setForeground(Color.RED);
            buttonI.setForeground(Color.RED);
        } else if (!buttonC.getText().isEmpty() && buttonC.getText().equals(buttonE.getText()) && buttonC.getText().equals(buttonG.getText())) {
            winner = buttonC.getText();
            buttonC.setForeground(Color.RED);
            buttonE.setForeground(Color.RED);
            buttonG.setForeground(Color.RED);
        }
        // Jika ada pemenang, perbarui status game menjadi berakhir
        gameOver = !winner.isEmpty();
    }

    // Metode main untuk menjalankan aplikasi
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            HelloGridLayout h = new HelloGridLayout();
            h.setVisible(true);
        });
    }
}
