package Model;

import java.util.Arrays;

public class Grupo {

    private String nombre;
    private Contacto[] listaParticipantes = new Contacto[5];


    public Grupo(String nombre){
        this.nombre = nombre;
        this.listaParticipantes = new Contacto[5];

    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public Contacto[] getListaParticipantes() {
        return listaParticipantes;
    }


    public void setListaParticipantes(Contacto[] listaParticipantes) {
        this.listaParticipantes = listaParticipantes;
    }


    @Override
    public String toString() {
        return "Grupo [nombre=" + nombre + ", listaParticipantes="
                + Arrays.toString(listaParticipantes) + "]";
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
                    listaParticipantes[posicionDisponible] = contactoEncontrado;
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

        for (int i = 0; i < listaParticipantes.length; i++) {
            Contacto contacto = listaParticipantes[i];
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

        for (int i = 0; i < listaParticipantes.length; i++) {
            Contacto contactoAux = listaParticipantes[i];
            if (contactoAux != null) {
                if (contactoAux.getNombre().equals(nombre) && contactoAux.getTelefono().equals(telefono)) {
                    contactoEncontrado = contactoAux;
                    break;
                }
                break;
            }

        }

        return contactoEncontrado;
    }

    /*
     * Este método elimina un contacto, si lo encuentra.
     */
    public String eliminarContacto(String nombre, String telefono) {
        String mensaje = "El contacto no ha sido añadido al grupo.";

        for (int i = 0; i < listaParticipantes.length; i++) {
            Contacto contactoAux = listaParticipantes[i];
            if (contactoAux != null) {
                if (contactoAux.getNombre().equals(nombre) && contactoAux.getTelefono().equals(telefono)) {
                    listaParticipantes[i] = null;
                    mensaje = "El contacto ha sido eliminado correctamente.";
                    return mensaje;
                }          
            }
        }
        return mensaje;
    }
}
