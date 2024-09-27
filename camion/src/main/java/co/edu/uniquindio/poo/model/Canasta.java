package co.edu.uniquindio.poo.model;

/**
 * Clase que representa una canasta con un código, peso y tipo.
 */
public class Canasta {
    private String codigo;
    private double peso;
    private String tipo;

    /**
     * Constructor de la canasta.
     * 
     * @param codigo Código identificador de la canasta.
     * @param peso   Peso de la canasta.
     * @param tipo   Tipo de contenido de la canasta.
     */
    public Canasta(String codigo, double peso, String tipo) {
        this.codigo = codigo;
        this.peso = peso;
        this.tipo = tipo;
    }

    // Getters y Setters

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
  
