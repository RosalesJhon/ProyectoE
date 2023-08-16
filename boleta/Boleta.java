
package com.mycompany.boleta;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

public class Boleta {

    public static void main(String[] args) {
        
        // Creacion de ventana
        JFrame ventana = new JFrame("Boleta");
        ventana.setSize(500,600);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Crearcion de panel
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        
        // Titulo
        JLabel h1 = new JLabel("AliensWare");
        h1.setFont(new Font("Arial", Font.BOLD, 20));
        h1.setBounds(0, 10, 500, 50);
        h1.setHorizontalAlignment(JLabel.CENTER);
        h1.setForeground(Color.BLACK);
        h1.setBackground(Color.WHITE);
        h1.setOpaque(true);
        panel.add(h1);
        
        //  Datos 
        
        JLabel nombre = new JLabel("Nombres");
        nombre.setFont(new Font("Arial", Font.PLAIN, 15));
        nombre.setBounds(10, 200, 100, 20);
        nombre.setBackground(Color.BLACK);
        nombre.setOpaque(true);
        nombre.setBackground(Color.WHITE);
        panel.add(nombre);
        
        ventana.add(panel);
        ventana.setVisible(true);
    }
}