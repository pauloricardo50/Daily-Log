/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailylog;

import banco.Conexao;
import java.util.ArrayList;
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

    /**
     * Test of salvar method, of class Atividade.
     */
    @Test
    public void testSalvar(){
        try{
            Conexao.conectar(true);
            
            Atividade atividade = new Atividade();
            Usuario user = new Usuario();
            Expediente expediente = new Expediente();
            SubCategoria subCategoria = new SubCategoria();
        
            //Buscando usuário:
            user.setId(1);
            user.buscar();
            //Buncando Expediente:
            expediente.setId(2);
            expediente.buscar();
            //Buscando Subcategoria:
            subCategoria.setId(1);
            subCategoria.buscar();
        
            atividade.setTitulo("Teste unitario");
            atividade.setDescricao("Teste Criar Atividade.");
            atividade.setHorarioInicial("12:00:00");
            atividade.setHorarioFinal("18:00:00");
            atividade.setData("2018/12/07");
        
            atividade.salvar(user,expediente,subCategoria); 
            ArrayList<Atividade> lista = atividade.listar(user);
            
            Main.imprimeListaAtividade(lista);
            
            for (Atividade a : lista){
                if(a.getId() == atividade.getId()) {
                    System.out.println("Atividade Salva com Sucesso!");
                }
            }         
            
            atividade.deletar();
        }
        catch(Exception e){
            System.out.println(e);
            fail("Teste Salvar atividade falhou!"); 
        }
        finally{
            Conexao.desconectar(true);
        }
    }

    /**
     * Test of deletar method, of class Atividade.
     * @param atividade
     */
    //@Test
    /*public void testDeletar(Atividade atividade) {
        System.out.println("deletar");
        Atividade instance = new Atividade();
        instance.deletar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listar method, of class Atividade.
     * @param atividade
     */
    /*@Test
    public void testListar(Atividade atividade) {
        
    }*/
    
}
