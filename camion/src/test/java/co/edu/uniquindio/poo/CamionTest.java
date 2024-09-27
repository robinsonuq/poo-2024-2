package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

import co.edu.uniquindio.poo.model.Camion;
import co.edu.uniquindio.poo.model.Canasta;


public class CamionTest {
    private static final Logger LOG = Logger.getLogger(AppTest.class.getName());

    @Test
    public void agregarCanastaTest(){
        LOG.info("Iniciado test agregarCamionTest");


        LOG.info("Finalizdo test agregarCamionTest");
    }
    @Test
    public void agregarCanastaListaTest(){
        LOG.info("Iniciado test agregarCamionTest");
        Camion camion = new Camion("CRA23A");
        assertThrows(Throwable.class,() -> camion.agregarCanasta(null));
        LOG.info("Finalizdo test agregarCamionTest");
    }











    @Test
    public void crearCanasta(){
        LOG.info("Iniciado test agregarCamionTest");

       
        Canasta canasta = new Canasta("C001", 100, "frutas");
        
        assertEquals("C001", canasta.getCodigo());
        LOG.info("Finalizdo test agregarCamionTest");
    }


}
