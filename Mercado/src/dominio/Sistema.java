package dominio; // Nicolas Rodriguez y Manuel Ackerman

import java.beans.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import utilidades.*;

public class Sistema implements Serializable {

    public final static String FORMA_VENTA[] = {"Unidad", "Kilogramo"}; // Helper para ventanas
    public final static String TIPO_PRODUCTO[] = {"Fruta", "Verdura"};

    private ArrayList<Producto> listaProductos;
    private ArrayList<Puesto> listaPuestos;
    private ArrayList<Movimiento> listaMovimientos;
    private ArrayList<Mayorista> listaMayoristas;
    private ArrayList<Dueño> listaDueños;
    transient private PropertyChangeSupport manejador;

    public Sistema() {
        this.setManejador();
        listaProductos = new ArrayList();
        listaPuestos = new ArrayList();
        listaMovimientos = new ArrayList();
        listaMayoristas = new ArrayList();
        listaDueños = new ArrayList();
        this.crearArchivoErrores();
    }

    public static String[] getFORMA_VENTA() {
        return FORMA_VENTA;
    }

    public static String[] getTIPO_PRODUCTO() {
        return TIPO_PRODUCTO;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public PropertyChangeSupport getManejador() {
        return manejador;
    }

    public void setManejador() {
        this.manejador = new PropertyChangeSupport(this);
    }

    public void setListaProductos(ArrayList<Producto> productos) {
        this.listaProductos = productos;
    }

    public ArrayList<Puesto> getListaPuestos() {
        return listaPuestos;
    }

    public void setListaPuestos(ArrayList<Puesto> puestos) {
        this.listaPuestos = puestos;
    }

    public ArrayList<Movimiento> getListaMovimientos() {
        return listaMovimientos;
    }

    public void setListaMovimientos(ArrayList<Movimiento> movimientos) {
        this.listaMovimientos = movimientos;
    }

    public ArrayList<Mayorista> getListaMayoristas() {
        return listaMayoristas;
    }

    public void setListaMayoristas(ArrayList<Mayorista> mayoristas) {
        this.listaMayoristas = mayoristas;
    }

    public ArrayList<Dueño> getListaDueños() {
        return listaDueños;
    }

    public void setListaDueños(ArrayList<Dueño> dueños) {
        this.listaDueños = dueños;
    }

    public void agregarProducto(String nombre, String descripcion, String tipoVenta, String formaVenta, String rutaImagen) {
        Producto p1 = new Producto(nombre, descripcion, tipoVenta, formaVenta, rutaImagen);
        this.getListaProductos().add(p1);
        manejador.firePropertyChange("producto", null, p1);
    }

    public void agregarDueño(String nombre, int edad, int exp) {
        Dueño d1 = new Dueño(nombre, edad, exp);
        this.getListaDueños().add(d1);
        manejador.firePropertyChange("dueño", null, d1);
    }

    public void agregarMayorista(String rut, String nombre, String direccion, ArrayList<Producto> productos) {
        Mayorista m1 = new Mayorista(rut, nombre, direccion, productos);
        this.getListaMayoristas().add(m1);
        manejador.firePropertyChange("mayorista", null, m1);
    }

    public void agregarPuesto(String identificacion, Dueño dueño, String ubicacion, int cantEmpleados) {
        Puesto p1 = new Puesto(identificacion, dueño, ubicacion, cantEmpleados);
        this.getListaPuestos().add(p1);
        manejador.firePropertyChange("puesto", null, p1);
    }

    public void agregarMovimiento(int cantidad, int costo, Puesto puesto, Producto prod, String tipo) {
        Movimiento m1 = new Movimiento(cantidad, costo, puesto, prod, tipo);
        this.getListaMovimientos().add(m1);
        manejador.firePropertyChange("movimiento", null, m1);
    }

    public Producto obtenerProductoEnPuestoPorNombre(Puesto puesto, String nombre) {
        Producto res = null;
        for (Producto prod : puesto.obtenerProductos()) {
            if (prod.getNombre().equals(nombre)) {
                res = prod;
            }
        }
        return res;
    }

    public int obtenerStockProductoEnPuesto(Puesto puesto, Producto prod) {
        return puesto.obtenerStockProducto(prod);
    }

    public boolean realizarVentaProducto(Puesto puesto, Producto prod, int costo, int cantidad, String tipo) {
        boolean res = false;
        if (puesto.venderProducto(prod, cantidad)) {
            this.agregarMovimiento(cantidad, costo, puesto, prod, tipo);
            res = true;
            manejador.firePropertyChange("puesto", null, puesto);
        }
        return res;
    }

    public boolean precargarProductos() { // Toma los productos del archivo y los pasa a sistema, si devuelve false archivo productos contiene errores y se genera archivo errores
        boolean contieneErrores = false;
        ArchivoLectura productos = new ArchivoLectura("productos.txt");
        while (productos.hayMasLineas()) {
            String linea = productos.linea();
            if (validarArchivoProductos(linea)) { //Valida errores de linea
                String[] datosProducto = linea.split("@");
                if (validarDatosProductos(datosProducto, linea)) { //Valida errores en los datos de la linea
                    this.agregarProducto(datosProducto[0], datosProducto[1], datosProducto[2], datosProducto[3], validarImagenProducto(datosProducto));
                } else {
                    contieneErrores = true;
                }
            } else {
                contieneErrores = true;
            }
        }
        productos.cerrar();
        return contieneErrores;
    }

    public String validarImagenProducto(String[] datosProducto) { //Valida si imagen existe y devuelve nombreArchivoImagen segun corresponda
        String nombreArchivoImagen = "";
        if (datosProducto.length < 5) { //Si imagen de producto es vacía
            nombreArchivoImagen = "iconoSeleccionarImagen.jpg";
        } else {
            nombreArchivoImagen = datosProducto[4];
            File archivoImagen = new File("ImagenesOblig\\" + nombreArchivoImagen);
            if (!archivoImagen.exists()) { //Si imagen no se encuentra en carpeta de imagenes
                nombreArchivoImagen = "iconoSeleccionarImagen.jpg";
            }
        }
        return nombreArchivoImagen;
    }

    public boolean validarDatosProductos(String[] datosProducto, String linea) {
        boolean valido = true;
        String nombreProducto = datosProducto[0].trim();
        String tipoProducto = datosProducto[2].trim();
        String tipoVenta = datosProducto[3].trim();
        String mensajeError = "";
        if (nombreProducto.isEmpty()) { // Si nombre de producto es vacío
            mensajeError = "El dato 'nombre' del producto está vacío. ";
            valido = false;
        }
        if (!productoUnico(nombreProducto)) { // Si nombre de producto ya existe
            mensajeError += "El producto con el nombre '" + nombreProducto + "' ya existe. ";
            valido = false;
        }
        if (tipoProducto.isEmpty()) { // Si tipo de producto es vacío
            mensajeError += "El dato 'tipo de producto' está vacío. ";
            valido = false;
        }
        if (!tipoProducto.equals(TIPO_PRODUCTO[0]) && !tipoProducto.equals(TIPO_PRODUCTO[1])) { // Si tipo de producto no coincide
            mensajeError += "El dato 'tipo de producto' no es válido, debe ser 'Fruta' o 'Verdura'. ";
            valido = false;
        }
        if (tipoVenta.isEmpty()) { // Si tipo venta es vacío
            mensajeError += "El dato 'tipo de venta' del producto está vacío.";
            valido = false;
        }
        if (!tipoVenta.equals(FORMA_VENTA[0]) && !tipoVenta.equals(FORMA_VENTA[1])) { // Si tipo venta no coincide
            mensajeError += "El dato 'tipo de venta' del producto no es válido, debe ser 'Kilogramo' o 'Unidad'. ";
            valido = false;
        }
        if (!valido) {
            this.grabarArchivoErrores(mensajeError, linea);
        }
        return valido;
    }

    public boolean validarArchivoProductos(String linea) { //Valida errores de formato de la linea de un producto a precargar
        boolean valido = false;
        String mensajeError = "";
        if (!linea.trim().isEmpty()) { //Valida que linea no sea vacia
            int cantArrobas = 0;
            for (int i = 0; i < linea.length(); i++) { //Busca cantidad de arrobas en linea
                if (linea.charAt(i) == '@') {
                    cantArrobas++;
                }
            }
            if (cantArrobas == 4) {
                valido = true;
            } else {
                mensajeError = "La linea no cumple con el formato, debe contener 4 separadores('@') de datos.";
            }
        } else {
            mensajeError = "La linea es vacía.";
        }
        if (!valido) { //Grabar linea en archivo errores
            this.grabarArchivoErrores(mensajeError, linea);
        }
        return valido;
    }

    public void grabarArchivoErrores(String mensajeError, String linea) { //Graba nueva linea de archivo errores considerando los errores que ya estaban
        ArchivoLectura archivoViejo = new ArchivoLectura("errores.txt");
        ArrayList<String> errores = new ArrayList<>();
        while (archivoViejo.hayMasLineas()) {
            errores.add(archivoViejo.linea());
        }
        archivoViejo.cerrar();
        ArchivoGrabacion archivoNuevo = new ArchivoGrabacion("errores.txt");
        if (!errores.isEmpty()) { // Verifica que lista no este vacia
            for (String error : errores) { //Graba errores que ya existian
                archivoNuevo.grabarLinea(error);
            }
        }
        archivoNuevo.grabarLinea("Error: " + mensajeError + " ; Contenido de Linea: " + linea); // Nuevo error
        archivoNuevo.cerrar();
    }

    public String procesarRutaImagen(String rutaImagen) { // Devuelve el nombre del archivo de imagen
        String[] ruta = rutaImagen.split("\\\\");
        String nombreArchivo = ruta[ruta.length - 1]; // Agarra ultima pos del array
        return nombreArchivo;
    }

    public void crearArchivoErrores() { // Crea el archivo de errores y lo sobreescribe borrando los errores viejos
        try {
            File archivo = new File("errores.txt");
            FileWriter escritor = new FileWriter(archivo);
            escritor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int precioTotalXProducto(String nombreProducto, String tipo) { //Devuelve la sumatoria del valor total de coste de ventas o compras dado 1 Producto
        int total = 0;
        for (Movimiento mov : this.getListaMovimientos()) {
            String nombreAComparar = mov.getProd().getNombre();
            String tipoAComparar = mov.getTipo();
            if (nombreAComparar.equals(nombreProducto) && tipoAComparar.equals(tipo)) {
                total += mov.getCosto();
            }
        }
        return total;
    }

    public boolean hayProductos() {
        boolean hay = true;
        if (this.getListaProductos().isEmpty()) {
            hay = false;
        }
        return hay;
    }

    public boolean hayDueños() {
        boolean hay = true;
        if (this.getListaDueños().isEmpty()) {
            hay = false;
        }
        return hay;
    }

    public boolean hayMovimientos() {
        boolean hay = true;
        if (this.getListaMovimientos().isEmpty()) {
            hay = false;
        }
        return hay;
    }

    public boolean hayPuestos() {
        boolean hay = true;
        if (this.getListaPuestos().isEmpty()) {
            hay = false;
        }
        return hay;
    }

    public boolean hayMayoristas() {
        boolean hay = true;
        if (this.getListaMayoristas().isEmpty()) {
            hay = false;
        }
        return hay;
    }

    public int cantidadTotalXProducto(String nombreProducto, String tipo) { //Devuelve la sumatoria de la cantidad de ventas o compras dado 1 Producto
        int total = 0;
        for (Movimiento mov : this.getListaMovimientos()) {
            String nombreAComparar = mov.getProd().getNombre();
            String tipoAComparar = mov.getTipo();
            if (nombreAComparar.equals(nombreProducto) && tipoAComparar.equals(tipo)) {
                total += mov.getCantidad();
            }
        }
        return total;
    }

    public int getPrecioVentaMinXProducto(String nombreProducto) { //Devuelve el precio mas bajo de venta para el producto seleccionado
        int minimo = Integer.MAX_VALUE;
        boolean minimoEnCero = true;
        if (this.hayMovimientos()) {
            for (Movimiento mov : this.getListaMovimientos()) {
                String nombreAComparar = mov.getProd().getNombre();
                if (nombreAComparar.equals(nombreProducto) && mov.getTipo().equals("Venta")) {
                    int precio = mov.getCosto();
                    if (precio < minimo) {
                        minimo = precio;
                        minimoEnCero = false;
                    }
                }
            }
        }
        if (minimoEnCero) {
            minimo = 0;
        }
        return minimo;
    }

    public int getPrecioVentaMaxXProducto(String nombreProducto) { //Devuelve el precio mas alto de venta para el producto seleccionado
        int maximo = 0;
        for (Movimiento mov : this.getListaMovimientos()) {
            String nombreAComparar = mov.getProd().getNombre();
            if (nombreAComparar.equals(nombreProducto) && mov.getTipo().equals("Venta")) {
                int precio = mov.getCosto();
                if (precio > maximo) {
                    maximo = precio;
                }
            }
        }
        return maximo;
    }

    public ArrayList<Puesto> getPuestosXPrecioYProducto(String nombreProducto, int precio, String tipoVenta) { //Devuelve la lista de puestos dado un producto y un precio
        ArrayList<Puesto> lista = new ArrayList<>();
        for (Movimiento mov : this.getListaMovimientos()) {
            String nombreAComparar = mov.getProd().getNombre();
            if (nombreAComparar.equals(nombreProducto) && mov.getTipo().equals(tipoVenta) && !lista.contains(mov.getPuesto())) {
                int precioAComparar = mov.getCosto();
                if (precioAComparar == precio) {
                    lista.add(mov.getPuesto());
                }
            }
        }
        return lista;
    }

    public boolean generarReportePorMovimiento(String opcion, ArrayList<Puesto> puestos, int desde, int hasta) {
        int cantMovArch = 0;
        boolean res = false;
        ArchivoGrabacion reporte = new ArchivoGrabacion("reporte.txt");
        reporte.grabarLinea(obtenerFechaYHoraActual());
        String txt = "";
        if (this.hayMovimientos()) {
            if (opcion.equals("Todos")) {
                for (Movimiento mov : this.getListaMovimientos()) {
                    txt = mov.getIdMov() + "#" + mov.getProd() + "#" + mov.getPuesto().getIdentificacion()
                            + "#" + mov.getTipo() + "#" + mov.getCantidad() + "#" + mov.getCosto();
                    reporte.grabarLinea(txt);
                    cantMovArch++;
                }
            } else if (opcion.equals("Compra")) {
                for (Movimiento mov : this.getListaMovimientos()) {
                    if (mov.getTipo().equals("Compra")) {
                        txt = mov.getIdMov() + "#" + mov.getProd() + "#" + mov.getPuesto().getIdentificacion()
                                + "#" + mov.getTipo() + "#" + mov.getCantidad() + "#" + mov.getCosto();
                        reporte.grabarLinea(txt);
                        cantMovArch++;
                    }
                }
            } else if (opcion.equals("Venta")) {
                for (Movimiento mov : this.getListaMovimientos()) {
                    if (mov.getTipo().equals("Venta")) {
                        txt = mov.getIdMov() + "#" + mov.getProd() + "#" + mov.getPuesto().getIdentificacion()
                                + "#" + mov.getTipo() + "#" + mov.getCantidad() + "#" + mov.getCosto();
                        reporte.grabarLinea(txt);
                        cantMovArch++;
                    }
                }
            }
            res = true;
        }
        reporte.grabarLinea("Movimientos en totales en este archivo:" + cantMovArch);
        reporte.cerrar();
        return res;
    }
    
    public boolean generarReporte(String opcion, ArrayList<Puesto> puestos, int inicio, int fin) {
        int cantMovArch = 0;
        boolean res = false;
        ArchivoGrabacion reporte = new ArchivoGrabacion("reporte.txt");
        reporte.grabarLinea(obtenerFechaYHoraActual());
        String txt = "";
        if (this.hayMovimientos() && puestos != null) {
            if (inicio < this.getListaMovimientos().size() && fin < this.getListaMovimientos().size()) {
                for (int i = inicio; i <= fin; i++) {
                    Movimiento mov = this.getListaMovimientos().get(i);
                    if (opcion.equals("Todos")) {
                        if (puestos.contains(mov.getPuesto())) {
                            txt = mov.getIdMov() + "#" + mov.getProd() + "#" + mov.getPuesto().getIdentificacion()
                                    + "#" + mov.getTipo() + "#" + mov.getCantidad() + "#" + mov.getCosto();
                            reporte.grabarLinea(txt);
                            cantMovArch++;
                        }
                    } else {
                        if (mov.getTipo().equals(opcion) && puestos.contains(mov.getPuesto())) {
                            txt = mov.getIdMov() + "#" + mov.getProd() + "#" + mov.getPuesto().getIdentificacion()
                                    + "#" + mov.getTipo() + "#" + mov.getCantidad() + "#" + mov.getCosto();
                            reporte.grabarLinea(txt);
                            cantMovArch++;
                        }
                    }
                }
            }
        } else {
            if (inicio < this.getListaMovimientos().size() && fin < this.getListaMovimientos().size()) {
                for (int i = inicio; i <= fin; i++) {
                    Movimiento mov = this.getListaMovimientos().get(i);
                    if (opcion.equals("Todos")) {
                            txt = mov.getIdMov() + "#" + mov.getProd() + "#" + mov.getPuesto().getIdentificacion()
                                    + "#" + mov.getTipo() + "#" + mov.getCantidad() + "#" + mov.getCosto();
                            reporte.grabarLinea(txt);
                            cantMovArch++;
                    } else {
                        if (mov.getTipo().equals(opcion)) {
                            txt = mov.getIdMov() + "#" + mov.getProd() + "#" + mov.getPuesto().getIdentificacion()
                                    + "#" + mov.getTipo() + "#" + mov.getCantidad() + "#" + mov.getCosto();
                            reporte.grabarLinea(txt);
                            cantMovArch++;
                        }
                    }
                }
            }
        }
        reporte.grabarLinea("Movimientos en totales en este archivo:" + cantMovArch);
        reporte.cerrar();
        return res;
    }
    
    public String obtenerFechaYHoraActual() { //Devuelve fecha y hora actual del equipo.
        Date fechaHoraActual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String fechaHoraFormateada = formato.format(fechaHoraActual);
        return fechaHoraFormateada;
    }

    public boolean productoUnico(String nombre) {
        boolean esUnico = true;
        for (Producto producto : this.getListaProductos()) {
            String nombreAComparar = producto.getNombre();
            if (nombre.equals(nombreAComparar)) {
                esUnico = false;
            }
        }
        return esUnico;
    }

    public boolean dueñoUnico(String nombre) {
        boolean esUnico = true;
        for (Dueño dueño : this.getListaDueños()) {
            String nombreAComparar = dueño.getNombre();
            if (nombre.equals(nombreAComparar)) {
                esUnico = false;
            }
        }
        return esUnico;
    }

    public boolean puestoUnico(String identificacion) {
        boolean esUnico = true;
        for (Puesto puesto : this.getListaPuestos()) {
            String idAComparar = puesto.getIdentificacion();
            if (identificacion.equals(idAComparar)) {
                esUnico = false;
            }
        }
        return esUnico;
    }

    public boolean mayoristaUnico(String rut) {
        boolean esUnico = true;
        for (Mayorista mayorista : this.getListaMayoristas()) {
            String rutAComparar = mayorista.getRut();
            if (rut.equals(rutAComparar)) {
                esUnico = false;
            }
        }
        return esUnico;
    }

    //anota el listener
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        manejador.addPropertyChangeListener(listener);
    }

} // Nicolas Rodriguez y Manuel Ackerman
