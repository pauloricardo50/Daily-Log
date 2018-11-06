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
public class CategoriaIT {
    
    public CategoriaIT() {
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
    
    /**
     * Teste para verifica se o update está funcionando corretamente.      
     */
    @Test
    public void testAdicionarCategoria() {
        System.out.println("Adicionar Categoria:");
        Categoria categoria = new Categoria();
        categoria.setId(62);
        categoria.setNome("Teste");
        
        boolean expResult = true;
        boolean result = categoria.adicionarCategoria(categoria);
        
        try{
            assertEquals(expResult, result);
        }
        catch (Exception falha){
            fail(falha.getMessage());
        }
    }
   
    @Test
    public void testSelecionarCategoria(){
        System.out.println("Selecionar Categoria");
        Categoria categoria = new Categoria();
        
        categoria.setId(6);
        categoria.setNome("Teste");
        
        try{
           categoria.bucarCategoria(); 
        }
        catch (Exception falha){
            fail(falha.getMessage());
        }          
    }
    
    @Test
    public void testDeletarCategoria(){
        System.out.println("Deletar Categoria");
        Categoria categoria = new Categoria();
        
        categoria.setId(51);
        categoria.setNome("Teste");
        
        try{
           categoria.deletarCategoria( categoria.getId()); 
        }
        catch (Exception falha){
            fail(falha.getMessage());
        } 
    }
}
