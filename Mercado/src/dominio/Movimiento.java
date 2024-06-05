package dominio; // Nicolas Rodriguez y Manuel Ackerman
import java.io.Serializable;

public class Movimiento implements Serializable {

    public static int contMov = 1; //variable de clase contador
    private int idMov;             //variable id de instancia
    private Puesto Puesto;
    private String tipo; // Venta o Compra
    private Producto prod;
    private int cantidad;
    private int costo;

    public Movimiento(int cantidad, int costo, Puesto puesto, Producto prod, String tipo) {
        this.Puesto = puesto;
        this.idMov = contMov;
        this.prod = prod;
        this.cantidad = cantidad;
        this.costo = costo;
        this.tipo = tipo;
        contMov = contMov + 1;
    }

    public Producto getProd() {
        return prod;
    }

    public void setProd(Producto prod) {
        this.prod = prod;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public static int getContMov() {
        return contMov;
    }

    public static void setContMov(int contMov) {
        Movimiento.contMov = contMov;
    }

    public int getIdMov() {
        return idMov;
    }

    public void setIdMov(int idMov) {
        this.idMov = idMov;
    }

    public Puesto getPuesto() {
        return Puesto;
    }

    public void setPuesto(Puesto Puesto) {
        this.Puesto = Puesto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "" + this.idMov;
    }

} // Nicolas Rodriguez y Manuel Ackerman
