package com.javarush.task.task35.task3513;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TestFrame extends JFrame {

    private JLabel label;

    public TestFrame() {
        super("Test frame");
        createGUI();
    }

    public void createGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setFocusable(true);

        label = new JLabel();
        label.setFont(new Font("Calibri", Font.PLAIN, 20));
        label.setHorizontalAlignment(JLabel.CENTER);

        panel.addKeyListener(new KeyAdapter() {

            public void keyReleased(KeyEvent e) {
                System.out.println(e.getKeyCode());
                label.setText(e.getKeyText(e.getKeyCode()));
            }

        });

        panel.add(label, BorderLayout.CENTER);

        setPreferredSize(new Dimension(200, 200));
        getContentPane().add(panel);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                TestFrame frame = new TestFrame();
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}