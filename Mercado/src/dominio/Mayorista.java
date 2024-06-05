package dominio; // Nicolas Rodriguez y Manuel Ackerman
import java.io.Serializable;
import java.util.ArrayList;

public class Mayorista implements Serializable {

    private String rut;
    private String nombre;
    private String direccion;
    private ArrayList<Producto> listaProductos;
    public Mayorista(String rut, String nombre, String direccion, ArrayList<Producto> productos) {
        this.rut = rut;
        this.nombre = nombre;
        this.direccion = direccion;
        this.listaProductos = productos;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> productos) {
        this.listaProductos = productos;
    }

    @Override
    public String toString() {
        return "Nombre: " + this.getNombre() + " | RUT: " + this.getRut() + " | Direccion: " + this.getDireccion();
    }

} // Nicolas Rodriguez y Manuel Ackerman
