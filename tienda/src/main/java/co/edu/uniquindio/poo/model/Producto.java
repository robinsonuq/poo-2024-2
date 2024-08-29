package co.edu.uniquindio.poo.model;

public class Producto {
    private String nombre;
    private double precioCompra;
    private String tipo;

    public Producto(String nombre, double precioCompra, String tipo) {
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.tipo = tipo;
    }

    public double calcularPrecioVenta() {
        double incremento = 0.0;

        switch (tipo.toLowerCase()) {
            case "refrigerado":
                incremento = 0.10;
                break;
            case "perecedero":
                incremento = 0.15;
                break;
            case "no perecedero":
                incremento = 0.05;
                break;
            default:
                System.out.println("Tipo de producto no reconocido.");
                return precioCompra; // Retorna el precio de compra sin cambios si el tipo no es reconocido.
        }

        return precioCompra * (1 + incremento);
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
     * @return the precioCompra
     */
    public double getPrecioCompra() {
        return precioCompra;
    }

    /**
     * @param precioCompra the precioCompra to set
     */
    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Precio de Compra: " + precioCompra + ", Tipo: " + tipo + ", Precio de Venta: " + calcularPrecioVenta();
    }
}