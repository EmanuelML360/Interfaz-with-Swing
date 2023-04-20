/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package interfaz.with.swing;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.*;


public class InterfazSwing implements ActionListener {
    
    private int[] numeros;
    private int contador;
    JTextField texto;
    JTextArea area;
    
    public InterfazSwing(){
        initComponents();
        numeros = new int[10];
        contador = 0;
    }
    
    private void initComponents() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(560, 480);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Tarea 4");
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.getContentPane().add(panel);
        Component[] components = panel.getComponents();
        
        
        area = new JTextArea();
        area.setVisible(true);
        panel.add(area);
        area.setBounds(40, 350, 400, 80);
        
        texto = new JTextField(); 
        texto.setVisible(true);
        panel.add(texto);
        texto.setBounds(130, 120, 300, 20);
        
        JLabel textoB = new JLabel("Bienvenido");
        textoB.setVisible(true);
        panel.add(textoB);
        textoB.setBounds(185, 60, 300, 50);
        Font font = new Font("Arial", Font.BOLD, 36);
        textoB.setFont(font);
        Color color = new Color(255, 255,255);
        textoB.setForeground(color);
        
        JLabel texto2 = new JLabel("Ingresa un numero aleatorio de 1-100");
        texto2.setVisible(true);
        panel.add(texto2);
        texto2.setBounds(125, 135, 400, 50);
        Font font2 = new Font("Arial", Font.BOLD, 18);
        texto2.setFont(font2);
        Color color2 = new Color(212, 212,212);
        texto2.setForeground(color2);
        
        JLabel fondo = new JLabel();
        fondo.setIcon(new ImageIcon("C:\\Interfaz with Swing\\src\\imagenes\\fondoAzul.jpg"));
        textoB.setVisible(true);
        panel.add(fondo);
        fondo.setBounds(0, 0, 560, 480);
        
        
        JButton button1 = new JButton("Agregar");
        button1.setVisible(true);
        panel.add(button1);
        button1.setBounds(180, 180, 200, 50);
        button1.setVisible(true);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
            // Llamar al método jButton1ActionPerformed
            jButton1ActionPerformed(evt);
            try{
                int numero = Integer.parseInt(texto.getText());
                if(1 <= numero && numero <= 100){
                if (contador <10){
                    numeros[contador] = numero;
                    contador++;
                    JOptionPane.showMessageDialog(null, "Numero ingresado correctamente");
                }else{
                    JOptionPane.showMessageDialog(null, "No se puede ingresar más números. El vector está lleno.", "Advertencia", JOptionPane.WARNING_MESSAGE);    
                }
                }else{
                    JOptionPane.showMessageDialog(null, "El número ingresado no es válido. Por favor, ingrese un número entre 1 y 100.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                texto.setText("");
            }catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "El número ingresado no es válido. Por favor, ingrese un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            }
        });
         
        JButton button2 = new JButton("Mostrar ordenamiento");
        button2.setVisible(true);
        panel.add(button2);
        button2.setBounds(180, 260, 200, 50);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
            // Llamar al método jButton1ActionPerformed
            jButton2ActionPerformed(evt);
            ordenarPorSeleccion(numeros);
            area.setText("Numeros ordenados:");
            for(int n: numeros){
                area.append( n + " ");
            }
            }
        });
        
        JButton button3 = new JButton("Vaciar");
        button3.setVisible(true);
        panel.add(button3);
        button3.setBounds(450, 350, 80, 80);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
            // Llamar al método jButton1ActionPerformed
            jButton3ActionPerformed(evt);
            Arrays.fill(numeros, 0);
            area.setText("Vector vacio:");
            for(int n: numeros){
                area.append( n + " ");
            }
            }
        });
       
    }
    public static void main(String[] args) {
        InterfazSwing interfaz = new InterfazSwing();
    }
    public void ordenarPorSeleccion(int[] vector) {
        for (int i = 0; i < vector.length - 1; i++) {
            int maximo = i;
            for (int j = i + 1; j < vector.length; j++) {
                // Cambiar el signo de la comparación
                if (vector[j] > vector[maximo]) {
                    maximo = j;
                }
            }
            int aux = vector[i];
            vector[i] = vector[maximo];
            vector[maximo] = aux;
        }
    }
                                             
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
    }                                        
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
    }                                        
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
       
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }    
}
