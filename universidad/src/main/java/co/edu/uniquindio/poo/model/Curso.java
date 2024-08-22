package co.edu.uniquindio.poo.model;

public class Curso {

    private String nombre;
    private Estudiante[] listaEstudiantes;
    private int numeroEstudiantes;
    
    public Curso(String nombre,int numeroEstudiantes){
        this.nombre = nombre;
        this.numeroEstudiantes = numeroEstudiantes;
        this.listaEstudiantes = new Estudiante[numeroEstudiantes];
    }


}