package dominio; // Nicolas Rodriguez y Manuel Ackerman

import java.io.Serializable;

public class Producto implements Serializable, Comparable<Producto> {

    private String nombre;
    private String descripcion;
    private String tipoProducto;
    private String formaVenta;
    private String rutaImagen;

    public Producto(String nombre, String descripcion, String tipo, String formaVenta, String rutaImagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipoProducto = tipo;
        this.formaVenta = formaVenta;
        this.rutaImagen = rutaImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipo) {
        this.tipoProducto = tipo;
    }

    public String getFormaVenta() {
        return formaVenta;
    }

    public void setFormaVenta(String formaVenta) {
        this.formaVenta = formaVenta;
    }

    public String getRutaImagen() {
        return this.rutaImagen;
    }

    public void setImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    @Override
    public String toString() {
        return this.getNombre();
    }

    public int compare(Producto p1, Producto p2) {
        int res;
        if (p1.getTipoProducto().equals("Fruta") && p2.getTipoProducto().equals("Verdura")) {
            res = -1;
        } else if (p1.getTipoProducto().equals("Verdura") && p2.getTipoProducto().equals("Fruta")) {
            res = 1;
        } else {
            // Ordenar alfabéticamente
            res = p1.getNombre().compareTo(p2.getNombre());
        }
        return res;

    }

    @Override
    public int compareTo(Producto p2) {
        // Primero las frutas y luego las verduras
        int res = 0;
        if (this.getTipoProducto().equals("Fruta") && p2.getTipoProducto().equals("Verdura")) {
            res = -1;
        } else if (this.getTipoProducto().equals("Verdura") && p2.getTipoProducto().equals("Fruta")) {
            res = 1;
        } else {
            res = this.getNombre().compareTo(p2.getNombre());
        }
        return res;
    }
} // Nicolas Rodriguez y Manuel Ackerman
