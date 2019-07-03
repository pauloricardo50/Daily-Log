/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailylog;

import java.util.ArrayList;
import persistencia.PermissaoBD;

/**
 *
 * @author Jardielma e Paulo Ricardo
 */
public class Permissao {
    private int id;
    private String descricao;
    private PermissaoBD persistencia;

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
    
    
    
    public Permissao buscar(){
        
        Permissao retorno = new Permissao();
        persistencia = new PermissaoBD();
        try{
            //busca o Usuario
            retorno = persistencia.buscar(this.id);
            //verifica se encontrou registro
            if(retorno == null){
                //retorna objeto como null caso não encontra
                return null;
            }
            this.descricao = retorno.descricao;
        }catch(Exception e ){
            System.out.println(e);
        }
        return this;
        
    }
    
    public String salvar(){
//            
        persistencia = new PermissaoBD();
        Permissao permissaoRetorno = new Permissao();
        try{
            //salva o perfil do usuario
            if(this.getDescricao().length() == 0){
                return "Descrição Não preenchida";
            }
            //salva o perfil
            permissaoRetorno = persistencia.salvar(this);
            //Atualiza o id do usuario, tendo em vista que o usuario criado não tinha
            this.id = permissaoRetorno.getId();
            
        }catch(Exception e ){
            System.out.println(e);
        }
         return "Perfil Salvo com sucesso";
    }
    
    public void deletar(){
        //Função não implementada
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Permissao> listar(){
        persistencia = new PermissaoBD();
        try{
            //salva o perfil do usuario
            return persistencia.listar();
            
        }catch(Exception e ){
            System.out.println(e);
        }
        return null;
    }
    
    
    
}
