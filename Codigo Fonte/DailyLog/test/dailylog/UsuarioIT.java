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
public class UsuarioIT {
    
    public UsuarioIT() {
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
     * Teste para verifica se o campo senha foi preenchido.      
     */
    @Test
    public void testSetSenha(){
        System.out.println("Teste set Senha.");
        Usuario instance = new Usuario();
        try {
            instance.setSenha("testeEstaPreenchido");
        } catch (Exception ex) {
            fail(ex.getMessage());
        }  
    }
    
    @Test
    public void testSelecionarUsuario(){
        System.out.println("Buscar Usuario:");
        Usuario usuario = new Usuario();
              
        try{
           usuario.bucarUsuario();
        }
        catch (Exception falha){
            fail(falha.getMessage());
        }          
    } 
}    