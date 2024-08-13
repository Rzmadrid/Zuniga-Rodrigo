package test;

import dao.impl.OdontologoDaoH2;
import dao.impl.OdontologoDaoMemoria;
import model.Odontologo;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.OdontologoService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OdontologoServiceMemoriaTest {
    static Logger logger = Logger.getLogger(OdontologoServiceMemoriaTest.class);
    OdontologoService odontologoService = new OdontologoService(new OdontologoDaoMemoria());

    @BeforeAll
    static void cargarLista(){

    }

    @Test
    @DisplayName("Testear el registro de un odontologo en la Memoria")
    void caso1(){
        //dado
        Odontologo odontologo = new Odontologo(3,"ra","zu");
        // cuando
        Odontologo odontologoDesdeMem = odontologoService.guardarOdontologo(odontologo);
        // entonces
        assertNotNull(odontologoDesdeMem.getId());
    }

    @Test
    @DisplayName("Testear que liste todos los odontologos en memoria")
    void caso2(){
        //dado
        List<Odontologo> odontologos = new ArrayList<>();
        Odontologo odontologo1 = new Odontologo(3,"Luciano", "Jara");
        odontologoService.guardarOdontologo(odontologo1);
        Odontologo odontologo2 = new Odontologo(4,"david", "Zamora");
        odontologoService.guardarOdontologo(odontologo2);
        //cuando
        odontologos = odontologoService.listarTodos();
        //entonces
        assertTrue(odontologos.size()!= 0);
    }
}
