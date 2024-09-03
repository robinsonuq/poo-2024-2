package Model;

import java.time.LocalTime;
import java.util.Arrays;
import java.time.LocalDate;

public class Reunion {

    private String descripcion;
    private LocalDate fecha;
    private LocalTime hora;
    private int maximosAsistentes;
    private Contacto[] listaAsisistentes;

    public Reunion(String descripcion, LocalDate fecha, LocalTime hora, int maximosAsistentes) {

        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
        this.maximosAsistentes = maximosAsistentes;
        this.listaAsisistentes = new Contacto[maximosAsistentes];
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public int getMaximosAsistentes() {
        return maximosAsistentes;
    }

    public void setMaximosAsistentes(int maximosAsistentes) {
        this.maximosAsistentes = maximosAsistentes;
    }

    public Contacto[] getListaAsisistentes() {
        return listaAsisistentes;
    }

    public void setListaAsisistentes(Contacto[] listaAsisistentes) {
        this.listaAsisistentes = listaAsisistentes;
    }

    @Override
    public String toString() {
        return "\nReunion [descripcion=" + descripcion + ", fecha=" + fecha + ", hora=" + hora + ", maximosAsistentes="
                + maximosAsistentes + ", listaAsisistentes=" + Arrays.toString(listaAsisistentes) + "]";
    }

    /*
     * Este método almacena un nuevo contacto, solo si hay espacios disponibles y el
     * contacto aun no ha sido registrado.
     */
    public String añadirContacto(String nombre, String telefono, Agenda todosLosContactos) {

        String mensaje = "";
        int posicionDisponible = 0;
        Contacto contactoEncontrado = null;

        posicionDisponible = buscarPosicionDisponible();

        if (posicionDisponible == -1) {
            mensaje = "No hay espacio para un nuevo contacto.";
            return mensaje;
        } else {
            contactoEncontrado = buscarContacto(nombre, telefono);

            if (contactoEncontrado != null) {
                mensaje = "El contacto ya se encuentra registrado.";
            } else {
                contactoEncontrado = todosLosContactos.buscarContacto(nombre, telefono);
                if(contactoEncontrado == null){
                    mensaje = "El contacto que intenta ingresar no existe.";
                }else{
                    listaAsisistentes[posicionDisponible] = contactoEncontrado;
                    mensaje = "El contacto se a almacenado exitosamente.";
                }
            } 
        }

        return mensaje;
    }

    /*
     * Este método busca una posición disponible y la retorna, en caso de no haber,
     * retorna -1.
     */
    private int buscarPosicionDisponible() {
        int posicionDisponible = -1;

        for (int i = 0; i < listaAsisistentes.length; i++) {
            Contacto contacto = listaAsisistentes[i];
            if (contacto == null) {
                posicionDisponible = i;
                return posicionDisponible;
            }
        }

        return posicionDisponible;
    }

    /*
     * Este método busca un contacto un base a su nombre y número de teléfono.
     */
    private Contacto buscarContacto(String nombre, String telefono) {
        Contacto contactoEncontrado = null;

        for (int i = 0; i < listaAsisistentes.length; i++) {
            Contacto contactoAux = listaAsisistentes[i];
            if (contactoAux != null) {
                if (contactoAux.getNombre().equals(nombre) && contactoAux.getTelefono().equals(telefono)) {
                    contactoEncontrado = contactoAux;
                    break;
                }
            }
        }

        return contactoEncontrado;
    }

    /*
     * Este método elimina un contacto, si lo encuentra.
     */
    public String eliminarContacto(String nombre, String telefono) {
        String mensaje = "El contacto no existe.";

        for (int i = 0; i < listaAsisistentes.length; i++) {
            Contacto contactoAux = listaAsisistentes[i];
            if (contactoAux != null) {
                if (contactoAux.getNombre().equals(nombre) && contactoAux.getTelefono().equals(telefono)) {
                    listaAsisistentes[i] = null;
                    mensaje = "El contacto ha sido eliminado correctamente.";
                    return mensaje;
                }            
            }
        }

        return mensaje;
    }

}
