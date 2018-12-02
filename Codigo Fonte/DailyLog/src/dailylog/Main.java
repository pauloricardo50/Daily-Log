/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailylog;

import banco.Conexao;
import java.text.ParseException;
import java.util.ArrayList;
/**
 *
 * @author Jardielma e Paulo Ricardo
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws ParseException {

        Conexao conexaoSQLite = new Conexao(); // criando conexao
        try{
            Conexao.conectar(true); //conectando 
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
        //Teste de Busca de usuario
        try{
//            Usuario teste01 = new Usuario();
//            teste01.setId(3);
//            if(teste01.buscarUsuario() == null){
//                System.out.println("Usuário não encontrado");
//            }else{
//                System.out.println(teste01.getNome() + ' '+teste01.getPerfil().getDescricao());
//            }
            }catch(Exception e){
                System.out.println(e);
        }
        try{
            
          Expediente expediente = new Expediente();
          expediente.setId(2);
          expediente.setData("2111/11/11");
          expediente.setHorarioInicial("10:00:00");
          expediente.setHorarioFinal("18:00:00");
          expediente.setFlag_ativo("A");
          expediente.salvar(1);
          System.out.println(expediente.getData()+expediente.getHorarioInicial()+expediente.getHorarioFinal());
//          ArrayList<Categoria> lista = categoria.listarCategoria();
//          if(lista == null){
//              System.out.println("Nenhum perfil encontrado");
//          }
//          else{
//            for (Categoria variavel: lista) {
//                System.out.println(variavel.getId() + variavel.getDescricao());
//            }
//          }
         }catch(Exception e){
            System.out.println(e);
        }
        
        
        
        
        
    }
}

    

