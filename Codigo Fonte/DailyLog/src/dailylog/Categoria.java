/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailylog;

import java.util.ArrayList;
import persistencia.CategoriaBD;


/**
 *
 * @author Jardielma e Paulo Ricardo
 */
public class Categoria 
{
    private int id;
    private String descricao;
    
    private CategoriaBD persistencia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
        
    public Categoria buscar(){
        Categoria retorno;
        persistencia = new CategoriaBD();
        try{
            //busca o Usuario
            retorno = persistencia.buscar(this.id);
            this.descricao = retorno.descricao;
        }catch(Exception e ){
            System.out.println(e);
        }
        return this;
    }
    
    public String salvar(){
        persistencia = new CategoriaBD();
        Categoria retorno;
        
        try{
            if(this.getDescricao().length() == 0){
                return "Categoria sem descricao";
            }
            
            //salva o usuario
            retorno = persistencia.salvar(this);
            //Atualiza o id do usuario, tendo em vista que o usuario criado não tinha
            this.id = retorno.getId();
        }
        catch(Exception e ){
            System.out.println(e);
        }
        return "Categoria Salva com sucesso";
    }
    
    public void deletarCategoria(){
//        Usuario retorno;
//        try{
//            //busca o Usuario
//            retorno = UsuarioBD.buscar(this.id);
//            this.nome = retorno.nome;
//            this.perfil= retorno.perfil;
//        }catch(Exception e ){
//            System.out.println(e);
//        }
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Categoria> listar(){
        persistencia = new CategoriaBD();
        try{
            //salva o perfil do usuario
            return persistencia.listar();
            
        }catch(Exception e ){
            System.out.println(e);
        }
        return null;
    }
      
}
