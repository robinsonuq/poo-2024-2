package co.edu.uniquindio.poo.model;

import java.util.Arrays;

public class Curso {

    private String nombre;
    private Estudiante[] listaEstudiantes;
    private int numeroEstudiantes;
    
    public Curso(String nombre,int numeroEstudiantes){
        this.nombre = nombre;
        this.numeroEstudiantes = numeroEstudiantes;
        this.listaEstudiantes = new Estudiante[numeroEstudiantes];
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
     * @return the listaEstudiantes
     */
    public Estudiante[] getListaEstudiantes() {
        return listaEstudiantes;
    }

    /**
     * @param listaEstudiantes the listaEstudiantes to set
     */
    public void setListaEstudiantes(Estudiante[] listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    /**
     * @return the numeroEstudiantes
     */
    public int getNumeroEstudiantes() {
        return numeroEstudiantes;
    }

    /**
     * @param numeroEstudiantes the numeroEstudiantes to set
     */
    public void setNumeroEstudiantes(int numeroEstudiantes) {
        this.numeroEstudiantes = numeroEstudiantes;
    }

    @Override
    public String toString() {
        return "Curso [nombre=" + nombre + ", listaEstudiantes=" + Arrays.toString(listaEstudiantes)
                + ", numeroEstudiantes=" + numeroEstudiantes + "]";
    }


    /**
     * Este metodo registra un nuevo estudiante en el curso, 
     * solo si hay cupo y no esta registrado
     * @param nuevoEstudiante
     * @return
     */
    public String crearEstudiante(Estudiante nuevoEstudiante){
        String mensaje = "";
        int posDisponible = 0;
        Estudiante estudianteEncontrado = null;

        posDisponible = buscarPosicionDisponible();
        if(posDisponible == -1){
            mensaje = "No hay cupo para un nuevo estudiante";
        }else{
            estudianteEncontrado = buscarEstudiante(nuevoEstudiante.getNumeroIdentificacion());
            if(estudianteEncontrado != null){
                mensaje = "El estudiante ya esta registrado";
            }else{
                listaEstudiantes[posDisponible] = nuevoEstudiante;
                mensaje = "El estudiante ha sido registrado exitosamente";
            }
        }
        return mensaje;
    }

    private Estudiante buscarEstudiante(String numeroIdentificacion) {
        Estudiante estudianteEncontrado = null;
        for (Estudiante estudianteAux : listaEstudiantes) {
            if(estudianteAux.getNumeroIdentificacion().equals(numeroIdentificacion)){
                return estudianteAux;
            }
        }
        return estudianteEncontrado;
     }

    private int buscarPosicionDisponible() {
        int posDisponible = -1;
        boolean flag = false;
        for(int i = 0; i < listaEstudiantes.length && flag == false;i++){
            Estudiante estudiante = listaEstudiantes[i];
            if(estudiante == null){
                posDisponible = i;
                flag = true;
            }
        }
        return posDisponible;
     }
    

     /**
      * Este metodo busca con el numero identificacion a un estudiante y lo elimina de la lista
      * @param numeroIdentificacion
      * @return
      */
     public String eliminarEstudiante(String numeroIdentificacion){
        String mensaje = "El estudiante no existe";

        for (int i = 0; i < listaEstudiantes.length; i++) {
            Estudiante estudianteAux = listaEstudiantes[i];
            if(estudianteAux.getNumeroIdentificacion().equals(numeroIdentificacion)){
                listaEstudiantes [i] = null;
                mensaje = "El estudiannte ha sido eliminado";
                return mensaje;
            }
        }
        return mensaje;
     }

     /**
      * Este metodo actualiza la informacion de un estudiante
      * @param numeroIdentificacion
      * @param nombres
      * @param apellidos
      * @param correo
      * @param edad
      * @param telefono
      * @return
      */
     public String actualizarEstudiante(String numeroIdentificacion,String nombres,String apellidos,String correo,byte edad, String telefono){

        String mensaje = "Estudiante no encontrado";
        Estudiante estudianteEncontrado = buscarEstudiante(numeroIdentificacion);
        if(estudianteEncontrado != null){
            estudianteEncontrado.setApellidos(apellidos);
            estudianteEncontrado.setCorreo(correo);
            estudianteEncontrado.setEdad(edad);
            estudianteEncontrado.setTelefono(telefono);
            estudianteEncontrado.setNombres(nombres);
            mensaje = "Estudiante actualizado exitosamente";
        }
        return mensaje;
     }

}