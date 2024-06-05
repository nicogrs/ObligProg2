package dominio; // Nicolas Rodriguez y Manuel Ackerman

import java.io.Serializable;

public class Dueño implements Serializable, Comparable<Dueño> {

    private String nombre;
    private int edad;
    private int añosExp;

    public Dueño(String nombre, int edad, int añosExp) {
        this.nombre = nombre;
        this.edad = edad;
        this.añosExp = añosExp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getAñosExp() {
        return añosExp;
    }

    public void setAñosExp(int añosExp) {
        this.añosExp = añosExp;
    }
    
    @Override
    public String toString(){
        return this.getNombre();
    }
    
    public int compareTo(Dueño o) {
        return this.getNombre().compareTo(o.getNombre());
    }
    

}// Nicolas Rodriguez y Manuel Ackerman
