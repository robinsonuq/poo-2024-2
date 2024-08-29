package co.edu.uniquindio.poo.model;


import java.util.Arrays;

public class Tienda {

    private String nombre;
    private Producto[] listaProductos;
    private int numeroProductos;
    
    public Tienda(String nombre,int numeroProductos){
        this.nombre = nombre;
        this.numeroProductos = numeroProductos;
        this.listaProductos = new Producto[numeroProductos];
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the listaProductos
     */
    public Producto[] getListaProductos() {
        return listaProductos;
    }

    /**
     * @param listaProductos the listaProductos to set
     */
    public void setListaProductos(Producto[] listaProductos) {
        this.listaProductos = listaProductos;
    }

    /**
     * @return the numeroProductos
     */
    public int getNumeroProductos() {
        return numeroProductos;
    }

    /**
     * @param numeroProductos the numeroProductos to set
     */
    public void setNumeroProductos(int numeroProductos) {
        this.numeroProductos = numeroProductos;
    }

    @Override
    public String toString() {
        return "Curso [nombre=" + nombre + ", listaProductos=" + Arrays.toString(listaProductos)
                + ", numeroProductos=" + numeroProductos + "]";
    }


    /**
     * Este metodo registra un nuevo Producto en el curso, 
     * solo si hay cupo y no esta registrado
     * @param nuevoProducto
     * @return
     */
    public String crearProducto(Producto nuevoProducto){
        String mensaje = "";
        int posDisponible = 0;
        Producto ProductoEncontrado = null;

        posDisponible = buscarPosicionDisponible();
        if(posDisponible == -1){
            mensaje = "No hay cupo para un nuevo Producto";
        }else{
            ProductoEncontrado = buscarProducto(nuevoProducto.getNombre());
            if(ProductoEncontrado != null){
                mensaje = "El Producto ya esta registrado";
            }else{
                listaProductos[posDisponible] = nuevoProducto;
                mensaje = "El Producto ha sido registrado exitosamente";
            }
        }
        return mensaje;
    }

    private Producto buscarProducto(String numeroIdentificacion) {
        Producto ProductoEncontrado = null;
        for (Producto productoAux : listaProductos) {
            if(productoAux.getNombre().equals(numeroIdentificacion)){
                return productoAux;
            }
        }
        return ProductoEncontrado;
     }

    private int buscarPosicionDisponible() {
        int posDisponible = -1;
        boolean flag = false;
        for(int i = 0; i < listaProductos.length && flag == false;i++){
            Producto Producto = listaProductos[i];
            if(Producto == null){
                posDisponible = i;
                flag = true;
            }
        }
        return posDisponible;
     }
    

     /**
      * Este metodo busca con el numero identificacion a un Producto y lo elimina de la lista
      * @param numeroIdentificacion
      * @return
      */
     public String eliminarProducto(String numeroIdentificacion){
        String mensaje = "El Producto no existe";

        for (int i = 0; i < listaProductos.length; i++) {
            Producto ProductoAux = listaProductos[i];
            if(ProductoAux.getNombre().equals(numeroIdentificacion)){
                listaProductos [i] = null;
                mensaje = "El estudiannte ha sido eliminado";
                return mensaje;
            }
        }
        return mensaje;
     }

     /**
      * Este metodo actualiza la informacion de un Producto
      * @param numeroIdentificacion
      * @param nombres
      * @param apellidos
      * @param correo
      * @param edad
      * @param telefono
      * @return
      */
     public String actualizarProducto(String numeroIdentificacion,String nombres,String apellidos,String correo,byte edad, String telefono){

        String mensaje = "Producto no encontrado";
        Producto ProductoEncontrado = buscarProducto(numeroIdentificacion);
        if(ProductoEncontrado != null){
           
            mensaje = "Producto actualizado exitosamente";
        }
        return mensaje;
     }

}
