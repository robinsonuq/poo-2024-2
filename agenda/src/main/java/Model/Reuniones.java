package Model;

import java.util.Arrays;

public class Reuniones {

    private String nombre;
    private Reunion[] reuniones;

    public Reuniones(){

        this.nombre = "listaReuniones";
        this.reuniones = new Reunion[50];

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Reunion[] getReuniones() {
        return reuniones;
    }

    public void setReuniones(Reunion[] reuniones) {
        this.reuniones = reuniones;
    }

    @Override
    public String toString() {
        return "Reuniones [nombre=" + nombre + ", reuniones=" + Arrays.toString(reuniones) + "]";
    }

    /*
     * Este método almacena una reunion en la lista de reuniones, unicamente si hay espacio disponible y no hay otra reunion con la misma descripción.
     */
    public String guardarReunion(Reunion nuevaReunion){
        String mensaje = "";
        int posicionDisponible = -1;
        Reunion reunionEncontrada = null;

        posicionDisponible = buscarPosicionDisponible();

        if (posicionDisponible == -1) {
            mensaje = "Has alcanzado el máximo de reuniones posibles.";
            return mensaje;
        } else {
            reunionEncontrada = buscarReunion(nuevaReunion.getDescripcion());

            if (reunionEncontrada != null) {
                mensaje = "Ya hay una reunion registrada con esa descripción.";
            } else {
                reuniones[posicionDisponible] = nuevaReunion;
                mensaje = "La reunion se a almacenado exitosamente.";
            }
        }

        return mensaje;
    }

    /*
     * Este método busca una posición disponible y la retorna, en caso de no haber,
     * retorna -1.
     */
    private int buscarPosicionDisponible(){
        int posicionDisponible = -1;

        for (int i = 0; i < reuniones.length; i++) {
            Reunion reunionAux = reuniones[i];
            if (reunionAux == null) {
                posicionDisponible = i;
                return posicionDisponible;
            }
        }

        return posicionDisponible;
    }


    /*
     * Este método busca una reunion con base en su descripcion.
     */
    public Reunion buscarReunion(String descripcionBuscada){
        Reunion reunionEncontrada = null;

        for (int i = 0; i < reuniones.length; i++) {
            Reunion reunionAux = reuniones[i];
            if (reunionAux != null) {
                if (reunionAux.getDescripcion().equals(descripcionBuscada)) {
                    reunionEncontrada = reunionAux;
                    break;
                }
                break;
            }
        }

        return reunionEncontrada;
    }

    /*
     * Este método elimina una reunion, si lo encuentra.
     */
    public String eliminarReunion(String descripcion) {
        String mensaje = "No se pudo encontrar la reunion.";

        for (int i = 0; i < reuniones.length; i++) {
            Reunion reuninAux = reuniones[i];
            if (reuninAux != null) {
                if (reuninAux.getDescripcion().equals(descripcion)) {
                    reuniones[i] = null;
                    mensaje = "La reunion ha sido eliminado correctamente.";
                    return mensaje;
                }                
            }           
        }
        return mensaje;
    }
}
