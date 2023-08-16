
package com.mycompany.boleta;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

public class Boleta {

    public static void main(String[] args) {
        
        //creacion de ventana
        JFrame ventana = new JFrame("Boleta");
        ventana.setSize(500,600);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);

        JLabel h1 = new JLabel("AlienzWare");
        h1.setFont(new Font("Arial", Font.BOLD, 20));
        h1.setBounds(0, 10, 500, 50);
        h1.setHorizontalAlignment(JLabel.CENTER);
        h1.setForeground(Color.BLACK);
        h1.setBackground(Color.WHITE);
        h1.setOpaque(true);
        panel.add(h1);
        
        JLabel imagenLabel = new JLabel(new ImageIcon("Logo.png"));
        imagenLabel.setBounds(100, 100, imagenLabel.getIcon().getIconWidth(), imagenLabel.getIcon().getIconHeight());
        panel.add(imagenLabel);
        
        ventana.add(panel);
        ventana.setVisible(true);
    }
}