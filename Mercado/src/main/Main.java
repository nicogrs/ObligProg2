package main; // Nicolas Rodriguez y Manuel Ackerman
import dominio.Sistema;
import interfaz.VentanaMenuPrincipal;
import interfaz.VentanaInicial;
import java.io.*;
import javax.swing.*;

public class Main implements Serializable{

    public static void main(String[] args) throws ClassNotFoundException {
        
        Sistema s1 = new Sistema(); 
        VentanaInicial ventanaInicial = new VentanaInicial(s1);
        ventanaInicial.setVisible(true);
        }
} // Nicolas Rodriguez y Manuel Ackerman
