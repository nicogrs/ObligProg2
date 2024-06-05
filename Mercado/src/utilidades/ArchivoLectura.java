package utilidades; // Nicolas Rodriguez y Manuel Ackerman
import java.nio.file.Paths;
import java.io.*;
import java.util.*;
public class ArchivoLectura {
    private Scanner in;
    private String linea;
    public ArchivoLectura(String nombre){
        try{
            in = new Scanner(Paths.get(nombre));
        }
        catch(IOException e){
            /*JOptionPane.showMessageDialog(null, "Error al buscar el archivo elegido.", "Error del Sistema.", JOptionPane.ERROR_MESSAGE); 
            System.exit(1);*/ //VER QUE HACER CON ESTO
        }
    }
    public boolean hayMasLineas(){
        boolean hay = false;
        linea = null;
        if(in.hasNext()){
            linea = in.nextLine();
            hay = true;
        }
        return hay;
    }
    public String linea(){
        return linea;
    }
    public void cerrar(){
        in.close();
    }
} // Nicolas Rodriguez y Manuel Ackerman
