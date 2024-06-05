package dominio; // Nicolas Rodriguez y Manuel Ackerman
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Puesto implements Serializable {

    private String identificacion;
    private Dueño dueño;
    private String ubicacion;
    private int cantEmpleados;
    private HashMap<Producto, Integer> productosXCantidad;

    public Puesto(String identificacion, Dueño dueño, String ubicacion, int cantEmpleados) {
        this.productosXCantidad = new HashMap<>();
        this.identificacion = identificacion;
        this.dueño = dueño;
        this.ubicacion = ubicacion;
        this.cantEmpleados = cantEmpleados;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public Dueño getDueño() {
        return dueño;
    }

    public void setDueño(Dueño dueño) {
        this.dueño = dueño;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCantEmpleados() {
        return cantEmpleados;
    }

    public void setCantEmpleados(int cantEmpleados) {
        this.cantEmpleados = cantEmpleados;
    }

    public HashMap<Producto, Integer> getProductosXCantidad() {
        return productosXCantidad;
    }

    public boolean existeProducto(Producto prod) {
        boolean res = false;
        if (this.getProductosXCantidad().containsKey(prod)) {
            res = true;
        }
        return res;
    }

    public int obtenerStockProducto(Producto prod) {
        int stockActual = 0;
        if (this.getProductosXCantidad().containsKey(prod)) {
            stockActual = this.getProductosXCantidad().get(prod);
        }
        return stockActual;
    }

    public void comprarProducto(Producto prod, int cantidad) {
        if (this.getProductosXCantidad().containsKey(prod)) {
            int stockActual = this.getProductosXCantidad().get(prod);
            this.getProductosXCantidad().put(prod, stockActual + cantidad);
        } else {
            this.getProductosXCantidad().put(prod, cantidad);
        }
    }

    public boolean venderProducto(Producto prod, int cantidad) {
        boolean res = false;
        if (this.getProductosXCantidad().containsKey(prod)) {
            int stockActual = this.getProductosXCantidad().get(prod);
            if (stockActual >= cantidad) {
                this.getProductosXCantidad().put(prod, stockActual - cantidad);
                res = true;
            }
        }
        return res;
    }

    public ArrayList<Producto> obtenerProductos() {
        ArrayList<Producto> productos = new ArrayList<>(this.getProductosXCantidad().keySet());
        return productos;
    }

    @Override
    public String toString() {
        return getIdentificacion();
    }
} // Nicolas Rodriguez y Manuel Ackerman
