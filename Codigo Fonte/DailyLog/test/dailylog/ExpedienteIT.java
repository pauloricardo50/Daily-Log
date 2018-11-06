/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailylog;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jardielma
 */
public class ExpedienteIT {
    
    public ExpedienteIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testBuscarExpediente(){
        System.out.println("Buscar Atividade");
        Expediente expediente = new Expediente();       
        try{
           expediente.bucarExpediente(); 
        }
        catch (Exception falha){
            fail(falha.getMessage());
        }          
    } 
    
    
}
