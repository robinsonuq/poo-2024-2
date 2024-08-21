package co.edu.uniquindio.poo.application;

import javax.swing.JOptionPane;

import co.edu.uniquindio.poo.model.Estudiante;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
       
        Estudiante est1 = new Estudiante("Juan",
         "alzate", "2345678",
          "juana@uqvirtual.edu.co", "1234567",(byte)19);
          System.out.println(est1.toString());
          est1.setNombres("Juan carlos");
          System.out.println(est1.toString());
  
          est1.setNota1(4);
          est1.setNota2(2);
          est1.setNota3(1);
          est1.setNota4(4);
          est1.setNota5(3);

          double notaDefinitiva=est1.calcularNotaDefinitiva();


          Estudiante est2 = new Estudiante("Alejandro", "Valencia", "2345678", "alejandro@uqvirtual.edu.co", "3214566543", (byte) 18);

        JOptionPane.showMessageDialog(null, "El estudiante "+ est2.toString());

        if (est1.equals(est2)) {
            JOptionPane.showMessageDialog(null, "Los estudiantes son iguales ");
        } else {
            JOptionPane.showMessageDialog(null, "Los estudiante no son iguales ");
        }
        
    JOptionPane.showMessageDialog(null,"La nota definitiva del estudiante es : "+ notaDefinitiva);   
        
    }

    
}
