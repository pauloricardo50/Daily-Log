/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailylog;

import java.text.ParseException;
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
public class AtividadeIT {
    
    public AtividadeIT() {
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
    public void testAdicionarAtividade() throws ParseException {
        System.out.println("Adicionar Atividade");
        
        Atividade atividade = new Atividade();
        
        atividade.setId(22);
        atividade.setTitulo("Reunião com o PJE");
        atividade.setDescricao("Reuniao para homologação da versão 2.0");
        atividade.setHorarioInicial("13:30");
        atividade.setHorarioFinal("14:30");
        atividade.setIdCategoria(1);
        atividade.setIdSubCategoria(1);
        
        boolean expResult = true;
        boolean result = atividade.adicionarAtividade(atividade);
        
        try{
            assertEquals(expResult, result);
        }
        catch (Exception falha){
            fail(falha.getMessage());
        }
    }
    
    /**
     * Test of setIdSubCategoria method, of class Atividade.
     */
    @Test
    public void testCamposCategoria() {
        System.out.println("verificar campos preenchido.");
        
        Atividade atividade = new Atividade();
        try{
            atividade.setId(1);
            atividade.setTitulo("Reunião com o PJE");
            atividade.setDescricao("Reuniao para homologação da versão 2.0");
            atividade.setHorarioInicial("13:30");
            atividade.setHorarioFinal("14:30");
            atividade.setIdCategoria(1);
            atividade.setIdSubCategoria(1);
        }
        catch (Exception falha){
            fail(falha.getMessage());
        }
    }
    /**
     * Test of exibirAtividade method, of class Atividade.
     */
    
    @Test
    public void testBuscarAtividade(){
        System.out.println("Buscar Atividade");
        Atividade atividade = new Atividade();       
        try{
           atividade.bucarAtividade(); 
        }
        catch (Exception falha){
            fail(falha.getMessage());
        }          
    } 
}
