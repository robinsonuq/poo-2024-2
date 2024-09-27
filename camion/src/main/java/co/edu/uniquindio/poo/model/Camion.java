package co.edu.uniquindio.poo.model;

import java.util.LinkedList;
import java.util.Random;
import java.util.Collection;


/**
 * Clase que representa un camión que puede contener varias canastas.
 */
public class Camion {
    private String placa;
    private Collection<Canasta> canastas;

    /**
     * Constructor del camión.
     * 
     * @param placa Placa identificadora del camión.
     */
    public Camion(String placa) {
        this.placa = placa;
        this.canastas = new LinkedList<>();
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * Agrega una canasta al camión si no existe otra con el mismo código.
     * 
     * @param canasta La canasta a agregar.
     * @return true si se agregó con éxito, false si ya existe una canasta con el mismo código.
     */
    public boolean agregarCanasta(Canasta canasta) throws Exception{

        if(canasta == null){
             throw new Exception("Error datos nulos");
        }
        for (Canasta c : canastas) {
            if (c.getCodigo().equals(canasta.getCodigo())) {
                System.out.println("Error: Ya existe una canasta con el código " + canasta.getCodigo());
                return false; // No se agregó
            }
        }
        this.canastas.add(canasta);
        return true; // Se agregó con éxito
    }

    /**
     * Muestra todas las canastas en el camión.
     */
    public void mostrarCanastas() {
        if (canastas.isEmpty()) {
            System.out.println("No hay canastas en el camión.");
        } else {
            for (Canasta canasta : canastas) {
                System.out.println(canasta);
            }
        }
    }

    /**
     * Actualiza una canasta existente en el camión.
     * 
     * @param codigo     Código de la canasta a actualizar.
     * @param nuevoPeso  Nuevo peso de la canasta.
     * @param nuevoTipo  Nuevo tipo de contenido de la canasta.
     * @return true si se actualizó con éxito, false si no se encontró la canasta.
     */
    public boolean actualizarCanasta(String codigo, double nuevoPeso, String nuevoTipo) {
        for (Canasta canasta : canastas) {
            if (canasta.getCodigo().equals(codigo)) {
                canasta.setPeso(nuevoPeso);
                canasta.setTipo(nuevoTipo);
                return true; // Actualización exitosa
            }
        }
        return false; // No se encontró la canasta
    }

    /**
     * Elimina una canasta del camión.
     * 
     * @param codigo Código de la canasta a eliminar.
     * @return true si se eliminó con éxito, false si no se encontró la canasta.
     */
    public boolean eliminarCanasta(String codigo) {
        return canastas.removeIf(canasta -> canasta.getCodigo().equals(codigo));
    }

     /**
     * Carga 10 canastas con datos aleatorios en el camión.
     */
    public void cargarCamion() throws Exception {
        Random random = new Random();
        for (int i = 1; i <= 10; i++) {
            String codigo = "C" + String.format("%03d", i); // C001, C002, ..., C010
            double peso = 1 + (random.nextDouble() * 9); // Peso aleatorio entre 1 y 10
            String tipo = generarTipo(); // Tipo aleatorio
            agregarCanasta(new Canasta(codigo, peso, tipo));
        }
    }
      /**
     * Genera un tipo aleatorio de contenido para las canastas.
     * 
     * @return Un tipo de canasta aleatorio.
     */
    private String generarTipo() {
        Random random = new Random();
        String[] tipos = {"Fruta", "Verdura", "Cereal", "Lácteo", "Carnes"};
        return tipos[random.nextInt(tipos.length)];
    }

    /**
     * @return the canastas
     */
    public Collection<Canasta> getCanastas() {
        return canastas;
    }

    /**
     * @param canastas the canastas to set
     */
    public void setCanastas(Collection<Canasta> canastas) {
        this.canastas = canastas;
    }

    
}
