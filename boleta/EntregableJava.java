/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.boleta;

import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

public class EntregableJava {
    //Atributos 
    public String Dni;
    public String Nombre;
    public String Password;
    public float Saldo;
    int Intentos = 0;
    //Constructor
    public EntregableJava(String Dni, String Nombre, String Password, float Saldo) {
        this.Dni = Dni;
        this.Nombre = Nombre;
        this.Password = Password;
        this.Saldo = Saldo;
    }
    //Getters para retornar valor de los atributos
    public String getDni() {
        return Dni;
    }
    public String getNombre() {
        return Nombre;
    }
    public String getPassword() {
        return Password;
    }
    public float getSaldo() {
        return Saldo;
    }
    //Clase para la lista de usuarios
    public  class UserList{
        private ArrayList<EntregableJava> clientes;
        //constructor
        public UserList() {
            //Usuarios
            clientes = new ArrayList<>();
            clientes.add(new EntregableJava("71654843","Jhon Rosales","201104",1000));//admin
            clientes.add(new EntregableJava("12345678", "Juan Perez", "1234",200));
            clientes.add(new EntregableJava("23456789", "Maria Gomez", "5678",300));
            clientes.add(new EntregableJava("34567890", "Pedro Rodriguez", "9012",650));
            clientes.add(new EntregableJava("45678901","Carlos Romero","9097",720));
            clientes.add(new EntregableJava("56789012","Lius Zambrano","9097",432));
        }
        //Devolver la lista
        public ArrayList<EntregableJava> getClientes() {
            return clientes;
        }}
    public void VentanaLogin(){
        //ARRALIST
        UserList userList = new UserList();
        ArrayList<EntregableJava> cliente = userList.getClientes();
        //Ventan Login
        JFrame ventana = new JFrame("Entregable Final Java");
        ventana.setSize(500, 400);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        ventana.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Logo.jpg")));

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Panel
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null); // Cambiamos el layout del panel para poder posicionar los elementos
        // Título
        JLabel h1 = new JLabel("New Perú Bank");
        h1.setFont(new Font("Arial", Font.BOLD, 20));
        h1.setBounds(0, 10, 500, 50);
        h1.setHorizontalAlignment(JLabel.CENTER);
        h1.setForeground(Color.WHITE);
        h1.setBackground(Color.BLUE);
        h1.setOpaque(true);
        panel.add(h1);
        // Campo DNI
        JLabel dniLabel = new JLabel("DNI");
        dniLabel.setFont(new Font("Arial", Font.BOLD, 16));
        dniLabel.setBounds(100, 80, 50, 25);
        panel.add(dniLabel);
        //Entrada DNI
        JTextField entrada_dni = new JTextField();
        entrada_dni.setBorder(new LineBorder(Color.BLACK,2));
        entrada_dni.setHorizontalAlignment(JTextField.CENTER);
        entrada_dni.setFont(new Font("Arial", Font.PLAIN, 16));
        entrada_dni.setBounds(100, 110, 300, 35);
        panel.add(entrada_dni);
        // Campo Password
        JLabel pwdLabel = new JLabel("CONTRASEÑA");
        pwdLabel.setFont(new Font("Arial", Font.BOLD, 16));
        pwdLabel.setBounds(100, 160, 200, 25);
        panel.add(pwdLabel);
        //Entrada PWD
        JPasswordField entrada_password = new JPasswordField();
        entrada_password.setBorder(new LineBorder(Color.BLACK,2));
        entrada_password.setHorizontalAlignment(JTextField.CENTER);
        entrada_password.setFont(new Font("Arial", Font.PLAIN, 16));
        entrada_password.setBounds(100, 190, 300, 35);
        panel.add(entrada_password);
        //SELECCIONAR
        String[] items = {"Argentina","Bolivia","Brazil", "Colombia" ,"Ecuador","Perú"};
        JComboBox<String> comboBox = new JComboBox<>(items);
        comboBox.setSelectedIndex(0);
        comboBox.setBounds(200,240,100,30);
        comboBox.setBackground(Color.white);
        panel.add(comboBox);
        // Botón Ingresar
        JButton boton_ingresar = new JButton("Ingresar");
        boton_ingresar.setFont(new Font("Arial", Font.BOLD, 16));
        boton_ingresar.setBounds(100, 300, 100, 30);
        boton_ingresar.setBackground(Color.BLUE);
        boton_ingresar.setRolloverEnabled(true);
        boton_ingresar.setBorder(new LineBorder(Color.BLUE,2));
        boton_ingresar.setForeground(Color.WHITE);
        //Agregamos evento al boton Ingresar
        boton_ingresar.addActionListener((ActionEvent e) -> {
            Intentos ++;//inicializamos intentos
            if(Intentos>3){//si los intentos llegan a 3
                JOptionPane.showMessageDialog(null, "Maximo llegado",null,0);
                boton_ingresar.setEnabled(false);
                System.exit(0);
            }
            //bucle o ciclo for para optener valores de la lista
            for (EntregableJava client : cliente) {
                if(entrada_dni.getText().equals("71654843")){//verificamos dni
                    if(entrada_password.getText().equals("201104")){//verificamos contraseña
                        JOptionPane.showMessageDialog(null, "Usuario Admin\n\tBienvenido "+client.Nombre,null,1);
                        //ventana Admin
                        JFrame ventanaAd = new JFrame("Ventana De Administrador");
                        ventanaAd.setSize(500, 400);
                        ventanaAd.setResizable(false);
                        ventanaAd.setLocationRelativeTo(null);
                        ventanaAd.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Logo.jpg")));
                        ventanaAd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        //Panel ad
                        JPanel panelAd = new JPanel();
                        panelAd.setBackground(Color.WHITE);
                        panelAd.setLayout(null);
                        //h3
                        JLabel h3 = new JLabel("Bienvenido "+client.Nombre);
                        h3.setFont(new Font("Arial", Font.BOLD, 15));
                        h3.setBounds(0, 10, 500, 40);
                        h3.setHorizontalAlignment(JLabel.CENTER);
                        h3.setForeground(Color.BLACK);
                        h3.setBackground(Color.CYAN);
                        h3.setOpaque(true);
                        panelAd.add(h3);
                        //Botones
                        JButton ver_user = new JButton();
                        ver_user.setText("Ver Usuarios");
                        ver_user.setBounds(150,100,200,40);
                        ver_user.setBackground(Color.BLUE);
                        ver_user.setBorder(new LineBorder(Color.BLUE,2));
                        ver_user.setForeground(Color.WHITE);
                        //Accion boton ver user
                        ver_user.addActionListener(new ActionListener() {//accion listener o escuchador
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                UserList userList = new UserList();
                                ArrayList<EntregableJava> cliente = userList.getClientes();
                                JFrame ventana_ver = new JFrame();//ventana para tabla
                                ventana_ver.setSize(500, 200);
                                ventana_ver.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Logo.jpg")));
                                ventana_ver.setTitle("LISTA DE USUARIOS");

                                DefaultTableModel modelo = new DefaultTableModel();
                                //camoos de la tabla
                                modelo.addColumn("DNI");
                                modelo.addColumn("Nombre");
                                modelo.addColumn("Contraseña");
                                for (EntregableJava cliente_tb : cliente) {
                                    Object[] row = new Object[3];
                                    row[0] = cliente_tb.Dni;//contenido pra la tabla
                                    row[1] = cliente_tb.Nombre;
                                    row[2] = cliente_tb.Password;
                                    modelo.addRow(row);
                                }
                                JTable table = new JTable(modelo);
                                JScrollPane scrollPane = new JScrollPane(table);
                                scrollPane.setBounds(0,100,500,300);
                                ventana_ver.add(scrollPane);
                                ventana_ver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                ventana_ver.setLocationRelativeTo(null);
                                ventana_ver.setVisible(true);
                            }
                        });
                        panelAd.add(ver_user);
                        //Boton ver app
                        JButton ver_app = new JButton();
                        ver_app.setText("Ver APK");
                        ver_app.setBounds(150,150,200,40);
                        ver_app.setBackground(Color.BLUE);
                        ver_app.setBorder(new LineBorder(Color.BLUE,2));
                        ver_app.setForeground(Color.WHITE);
                        //Accion boton ver app
                        ver_app.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                //ventana de operaiones
                                JFrame ventanaOp = new JFrame("Ventana De Operaciones");
                                ventanaOp.setSize(500, 400);
                                ventanaOp.setResizable(false);
                                ventanaOp.setLocationRelativeTo(null);
                                ventanaOp.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Logo.jpg")));
                                //Panel ventanaOp
                                JPanel panelOp = new JPanel();
                                panelOp.setBackground(Color.WHITE);
                                panelOp.setLayout(null);
                                //Titulo 1
                                JLabel h2 = new JLabel("Bienvenido A New Perú Bank");
                                h2.setFont(new Font("Arial", Font.BOLD, 15));
                                h2.setBounds(0, 10, 500, 40);
                                h2.setHorizontalAlignment(JLabel.CENTER);
                                h2.setForeground(Color.BLACK);
                                h2.setBackground(Color.orange);
                                h2.setOpaque(true);
                                panelOp.add(h2);
                                //Hora y fecha a Tiempo Real
                                JLabel timerLabel = new JLabel();
                                timerLabel.setFont(new Font("Arial", Font.BOLD, 15));
                                timerLabel.setBounds(100,60,300,20);
                                timerLabel.setHorizontalAlignment(JLabel.CENTER);
                                panelOp.add(timerLabel);
                                Timer timer = new Timer(1000, new ActionListener(){
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        Date now = new Date();
                                        SimpleDateFormat sdf = new SimpleDateFormat("h:mm:ss a                         dd/MM/yyyy");
                                        String formattedDateTime = sdf.format(now);
                                        timerLabel.setText(formattedDateTime);
                                    }
                                });
                                timer.start();
                                //nombre del Usuario y pais
                                String selectedItem = (String) comboBox.getSelectedItem();
                                //panel para ubicar
                                JPanel panelver = new JPanel();
                                panelver.setBackground(Color.WHITE);
                                panelver.setBackground(Color.LIGHT_GRAY);
                                panelver.setBounds(0,80,500,300);
                                panelver.setLayout(null);
                                panelOp.add(panelver);
                                //nombres
                                JLabel nm = new JLabel();
                                nm.setText(client.Nombre);
                                nm.setBounds(30,20,200,30);
                                nm.setFont(new Font("Arial", Font.BOLD, 20));
                                panelver.add(nm);
                                //pais
                                JLabel pp = new JLabel();
                                pp.setText(selectedItem);
                                pp.setBounds(380,20,200,30);
                                pp.setFont(new Font("Arial", Font.BOLD, 20));
                                panelver.add(pp);
                                //SALDO MONTO
                                JLabel saldo = new JLabel();
                                saldo.setText("Saldo $/: "+Float.toString(client.Saldo));
                                saldo.setBounds(0,60,500,20);
                                saldo.setFont(new Font("Arial", Font.BOLD, 20));
                                saldo.setHorizontalAlignment(JLabel.CENTER);
                                panelver.add(saldo);
                                //Entrada para depositar o retirar
                                JTextField entrada_monto = new JTextField();
                                entrada_monto.setBorder(new LineBorder(Color.WHITE,2));
                                entrada_monto.setHorizontalAlignment(JTextField.CENTER);
                                entrada_monto.setFont(new Font("Arial", Font.BOLD, 16));
                                entrada_monto.setBounds(100, 100, 300, 35);
                                panelver.add(entrada_monto);
                                //Botones
                                //Boton retirar
                                JButton retirar = new JButton();
                                retirar.setBounds(60,170,100,40);
                                retirar.setText("Retirar");
                                retirar.setBackground(Color.BLUE);
                                retirar.setBorder(new LineBorder(Color.BLUE,2));
                                retirar.setForeground(Color.WHITE);
                                //Acciones boton retirar
                                //.addActionListener((ActionEvent e) ->
                                retirar.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        float monto = Float.parseFloat(entrada_monto.getText());
                                        if(monto > client.Saldo){
                                            JOptionPane.showMessageDialog(null, "El monto es insuficiente",null,2);
                                        }else{
                                            client.Saldo -= monto;
                                            saldo.setText("Saldo S/: "+Float.toString(client.Saldo));
                                        }
                                    }
                                });
                                panelver.add(retirar);
                                //Boton Depositar
                                JButton depositar = new JButton();
                                depositar.setBounds(190,170,100,40);
                                depositar.setText("Depositar");
                                depositar.setBackground(Color.green);
                                depositar.setBorder(new LineBorder(Color.green,2));
                                depositar.setForeground(Color.black);
                                //Acion boton depositar
                                depositar.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        float monto = Float.parseFloat(entrada_monto.getText());
                                        client.Saldo += monto;
                                        saldo.setText("Saldo $/: "+Float.toString(client.Saldo));
                                    }
                                });
                                panelver.add(depositar);
                                //Boton salir
                                JButton salir2 = new JButton();
                                salir2.setBounds(320,170,100,40);
                                salir2.setText("Salir");
                                salir2.setBackground(Color.red);
                                salir2.setBorder(new LineBorder(Color.red,2));
                                salir2.setForeground(Color.white);
                                salir2.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        JOptionPane.showMessageDialog(null, "Estas seguro de que desea salir ??",null,2);
                                       System.exit(0);
                                    }
                                });
                                panelver.add(salir2);
                                //VentanaOp y Panel Visibles
                                ventanaOp.add(panelOp);
                                ventanaOp.setVisible(true);
                            }
                        });
                        panelAd.add(ver_app);
                        //boton salir
                        JButton ver_sal = new JButton();
                        ver_sal.setText("Salir");
                        ver_sal.setBounds(150,200,200,40);
                        ver_sal.setBackground(Color.BLUE);
                        ver_sal.setBorder(new LineBorder(Color.BLUE,2));
                        ver_sal.setForeground(Color.WHITE);
                        //accion boton salir
                        ver_sal.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JOptionPane.showMessageDialog(null, "Estas seguro de que desea salir ??",null,2);
                                System.exit(0);
                            }
                        });
                        panelAd.add(ver_sal);
                        //Ventana y panel Visibles
                        ventanaAd.add(panelAd);
                        ventanaAd.setVisible(true);
                        break;
                    }
                }
                if(entrada_dni.getText().equals(client.Dni)){
                    if(entrada_password.getText().equals(client.Password)){
                        JOptionPane.showMessageDialog(null, "Usuario Encontrado\n\tBienvenido "+client.Nombre,null,1);
                        //ventana de operaiones
                        JFrame ventanaOp = new JFrame("Ventana De Operaciones");
                        ventanaOp.setSize(500, 400);
                        ventanaOp.setResizable(false);
                        ventanaOp.setLocationRelativeTo(null);
                        ventanaOp.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Logo.jpg")));
                        //Panel ventanaOp
                        JPanel panelOp = new JPanel();
                        panelOp.setBackground(Color.WHITE);
                        panelOp.setLayout(null);
                        //Titulo 1
                        JLabel h2 = new JLabel("Bienvenido A New Perú Bank");
                        h2.setFont(new Font("Arial", Font.BOLD, 15));
                        h2.setBounds(0, 10, 500, 40);
                        h2.setHorizontalAlignment(JLabel.CENTER);
                        h2.setForeground(Color.BLACK);
                        h2.setBackground(Color.orange);
                        h2.setOpaque(true);
                        panelOp.add(h2);
                        //Hora y fecha a Tiempo Real
                        JLabel timerLabel = new JLabel();
                        timerLabel.setFont(new Font("Arial", Font.BOLD, 15));
                        timerLabel.setBounds(100,60,300,20);
                        timerLabel.setHorizontalAlignment(JLabel.CENTER);
                        panelOp.add(timerLabel);
                        Timer timer = new Timer(1000, new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                Date now = new Date();
                                SimpleDateFormat sdf = new SimpleDateFormat("h:mm:ss a                        dd/MM/yyyy");
                                String formattedDateTime = sdf.format(now);
                                timerLabel.setText(formattedDateTime);
                            }
                        });
                        timer.start();
                        //nombre del Usuario y pais
                        String selectedItem = (String) comboBox.getSelectedItem();
                        //panel para ubicar
                        JPanel panelver = new JPanel();
                        panelver.setBackground(Color.WHITE);
                        panelver.setBackground(Color.LIGHT_GRAY);
                        panelver.setBounds(0,80,500,300);
                        panelver.setLayout(null);
                        panelOp.add(panelver);
                        //nombres
                        JLabel nm = new JLabel();
                        nm.setText(client.Nombre);
                        nm.setBounds(30,20,200,30);
                        nm.setFont(new Font("Arial", Font.BOLD, 20));
                        panelver.add(nm);
                        //pais
                        JLabel pp = new JLabel();
                        pp.setText(selectedItem);
                        pp.setBounds(380,20,200,30);
                        pp.setFont(new Font("Arial", Font.BOLD, 20));
                        panelver.add(pp);
                        //SALDO MONTO
                        JLabel saldo = new JLabel();
                        saldo.setText("Saldo $/: "+Float.toString(client.Saldo));
                        saldo.setBounds(0,60,500,20);
                        saldo.setFont(new Font("Arial", Font.BOLD, 20));
                        saldo.setHorizontalAlignment(JLabel.CENTER);
                        panelver.add(saldo);
                        //Entrada para depositar o retirar
                        JTextField entrada_monto = new JTextField();
                        entrada_monto.setBorder(new LineBorder(Color.WHITE,2));
                        entrada_monto.setHorizontalAlignment(JTextField.CENTER);
                        entrada_monto.setFont(new Font("Arial", Font.BOLD, 16));
                        entrada_monto.setBounds(100, 100, 300, 35);
                        panelver.add(entrada_monto);
                        //Botones
                        //Boton retirar
                        JButton retirar = new JButton();
                        retirar.setBounds(60,170,100,40);
                        retirar.setText("Retirar");
                        retirar.setBackground(Color.BLUE);
                        retirar.setBorder(new LineBorder(Color.BLUE,2));
                        retirar.setForeground(Color.WHITE);
                        //Acciones boton retirar
                        //.addActionListener((ActionEvent e) ->
                        retirar.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                float monto = Float.parseFloat(entrada_monto.getText());
                                
                                if(monto > client.Saldo){
                                    JOptionPane.showMessageDialog(null, "El monto es insuficiente",null,2);
                                }else{
                                    client.Saldo -= monto;
                                    saldo.setText("Saldo S/: "+Float.toString(client.Saldo));
                                }
                            }
                        });
                        panelver.add(retirar);
                        //Boton Depositar
                        JButton depositar = new JButton();
                        depositar.setBounds(190,170,100,40);
                        depositar.setText("Depositar");
                        depositar.setBackground(Color.green);
                        depositar.setBorder(new LineBorder(Color.green,2));
                        depositar.setForeground(Color.black);
                        //Acion boton depositar
                        depositar.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                float monto = Float.parseFloat(entrada_monto.getText());
                                client.Saldo += monto;
                                saldo.setText("Saldo $/: "+Float.toString(client.Saldo));
                            }
                        });
                        panelver.add(depositar);
                        //Boton salir
                        JButton salir2 = new JButton();
                        salir2.setBounds(320,170,100,40);
                        salir2.setText("Salir");
                        salir2.setBackground(Color.red);
                        salir2.setBorder(new LineBorder(Color.red,2));
                        salir2.setForeground(Color.white);
                        salir2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JOptionPane.showMessageDialog(null, "Estas seguro de que desea salir ??",null,2);
                               System.exit(0);
                            }
                        });
                        panelver.add(salir2);
                        //VentanaOp y Panel Visibles
                        ventanaOp.add(panelOp);
                        ventanaOp.setVisible(true);
                        break;
                    }else{
                        JOptionPane.showMessageDialog(null,"Contraseña Incorrecta",null,0);
                    }
                }
            }
        });
        panel.add(boton_ingresar);
        //Boton Salir
        JButton boton_salir = new JButton(" Salir");
        boton_salir.setFont(new Font("Arial", Font.BOLD, 16));
        boton_salir.setBounds(300, 300, 100, 30);
        boton_salir.setBackground(Color.BLUE);
        boton_salir.setRolloverEnabled(true);
        boton_salir.setBorder(new LineBorder(Color.BLUE,2));
        boton_salir.setForeground(Color.WHITE);
        boton_salir.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(null, "Estas seguro de que desea salir ??",null,2);
            System.exit(0);
        });
        panel.add(boton_salir);
        // Agregar panel a la ventana
        ventana.add(panel);
        ventana.setVisible(true);
    }
}