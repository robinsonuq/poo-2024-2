package co.edu.uniquindio.poo.model;

public class Estudiante {

    private String nombres;
    private String apellidos;
    private String numeroIdentificacion;
    private String correo;
    private String telefono;
    private byte edad;
    private double nota1;
    private double nota2;
    private double nota3;
    private double nota4;
    private double nota5;
    


    public Estudiante(String nombres,String apellidos, String numeroIdentificacion,
                    String correo,String telefono,byte edad){
            this.nombres = nombres;
            this.apellidos = apellidos;
            this.numeroIdentificacion = numeroIdentificacion;
            this.telefono = telefono;
            this.correo = correo;
            this.edad = edad;
            this.nota1 = 0;
            this.nota2 = 0;
            this.nota3 = 0;
            this.nota4 = 0;
            this.nota5 = 0;
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the numeroIdentificacion
     */
    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    /**
     * @param numeroIdentificacion the numeroIdentificacion to set
     */
    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the edad
     */
    public byte getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(byte edad) {
        this.edad = edad;
    }

    
    /**
     * @return the nota1
     */
    public double getNota1() {
        return nota1;
    }

    /**
     * @param nota1 the nota1 to set
     */
    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    /**
     * @return the nota2
     */
    public double getNota2() {
        return nota2;
    }

    /**
     * @param nota2 the nota2 to set
     */
    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    /**
     * @return the nota3
     */
    public double getNota3() {
        return nota3;
    }

    /**
     * @param nota3 the nota3 to set
     */
    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    /**
     * @return the nota4
     */
    public double getNota4() {
        return nota4;
    }

    /**
     * @param nota4 the nota4 to set
     */
    public void setNota4(double nota4) {
        this.nota4 = nota4;
    }

    /**
     * @return the nota5
     */
    public double getNota5() {
        return nota5;
    }

    /**
     * @param nota5 the nota5 to set
     */
    public void setNota5(double nota5) {
        this.nota5 = nota5;
    }


    @Override
    public String toString() {
        return "Estudiante [nombres=" + nombres + ", apellidos=" + apellidos + ", numeroIdentificacion="
                + numeroIdentificacion + ", correo=" + correo + ", telefono=" + telefono + ", edad=" + edad + ", nota1="
                + nota1 + ", nota2=" + nota2 + ", nota3=" + nota3 + ", nota4=" + nota4 + ", nota5=" + nota5 + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((numeroIdentificacion == null) ? 0 : numeroIdentificacion.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Estudiante other = (Estudiante) obj;
        if (numeroIdentificacion == null) {
            if (other.numeroIdentificacion != null)
                return false;
        } else if (!numeroIdentificacion.equals(other.numeroIdentificacion))
            return false;
        return true;
    }

   public double calcularNotaDefinitiva(){
    double notaDefinitiva = 0;
    notaDefinitiva = (nota1 + nota2 + nota3 + nota4 + nota5)/5; 
    return notaDefinitiva;

   }

   

    
 
    
   


}
