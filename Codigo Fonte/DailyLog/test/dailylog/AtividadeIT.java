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
            Conexao.conectar();
            
            Atividade novaAtividade = new Atividade();
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
        
            novaAtividade.setTitulo("Teste unitario");
            novaAtividade.setDescricao("Teste Criar Atividade.");
            novaAtividade.setHorarioInicial("12:00:00");
            novaAtividade.setHorarioFinal("18:00:00");
            novaAtividade.setData("2018/12/07");
        
            novaAtividade.salvar(user,expediente,subCategoria); 
            ArrayList<Atividade> lista = novaAtividade.listar(user);
            
            Main.imprimeListaAtividade(lista);
            
            for (Atividade a : lista){
                if(a.getId() == novaAtividade.getId()) {
                    System.out.println("Atividade Salva com Sucesso!");
                }
            }         
            
            novaAtividade.deletar();
        }
        catch(Exception e){
            System.out.println(e);
            fail("Teste Salvar atividade falhou!"); 
        }
        finally{
            Conexao.desconectar(true);
        }
    }
    
}
