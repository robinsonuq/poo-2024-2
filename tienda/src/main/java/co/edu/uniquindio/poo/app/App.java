package co.edu.uniquindio.poo.app;

import javax.swing.JOptionPane;

import co.edu.uniquindio.poo.model.Producto;
import co.edu.uniquindio.poo.model.Tienda;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
       
        JOptionPane.showMessageDialog(null,"Bienvendo a la tienda de la Abuela");

        String nombreTienda =leerStringVentana("Por favor ingrese el nombre de la Tienda");
        int numeroProductos = leerEnteroVentana("Por favor ingrese el numero de productos");


        Tienda tienda = new Tienda(nombreTienda, numeroProductos);

        Producto producto = new Producto("Arroz", 2500, "no perecedero");
       JOptionPane.showMessageDialog(null,tienda.crearProducto(producto));


        double precio = tienda.calcularPrecioVenta("Arroz");
        JOptionPane.showMessageDialog(null,precio);

    }

     /**
     * Permite leer un numero entero mediante una caja de dialogo 
     * @param mensaje El mensaje que verá el usuario 
     * @return el numero ingresado por el usuario
    */
    public static int leerEnteroVentana (String mensaje)
   {
    	int dato= Integer.parseInt(JOptionPane.showInputDialog(mensaje));
    	return dato;
   }

   public static String  leerStringVentana(String mensaje) {
    String respuesta = "";
    respuesta  = JOptionPane.showInputDialog(mensaje);
    return respuesta;

}


}
