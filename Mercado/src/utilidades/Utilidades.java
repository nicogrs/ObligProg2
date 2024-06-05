package utilidades;
import java.awt.Color;
public class Utilidades {
    
    public final static Color COLOR_ROJO = Color.RED;
    public final static Color COLOR_NEGRO = Color.BLACK;
    
    public boolean validarTxt(String txt){ //Valida que este compuesto solo por espacios y que sea vacío
        boolean valido = true;
        String txtSinEspacios = txt.trim();
        if(txtSinEspacios.isEmpty()){
            valido = false;
        }
        return valido;
    }
    
    public static String devolverTipoVentaAMostrar(String tipo, int cantidad){ // Muestra el tipo de venta producto en función de la cantidad
        String res = "";
        if(tipo.equals("Unidad")){
            if (cantidad > 1) {
                res = "unidades";
            } else {
                res = "unidad";
            }
        }else{
            if (cantidad > 1) {
                res = "kilogramos";
            } else {
                res = "kilogramo";
            }
            
        }
        return res;
    }
}
