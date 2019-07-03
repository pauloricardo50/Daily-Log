/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailylog;

import java.util.ArrayList;
import persistencia.AvisoBD;

/**
 *
 * @author jardielma
 */
public class Aviso {
    
    //variaveis
    private int id_user;
    private int id;
    private String mensagem;
    private String flag_ativo;
    private AvisoBD persistencia;
    
    //gets e sets
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getId_User() {
        return id_user;
    }

    public void setId_User(int id_user) {
        this.id_user = id_user;
    }
    
     public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    public String getFlag_ativo() {
        return flag_ativo;
    }

    public void setFlag_ativo(String flag_ativo) {
        this.flag_ativo = flag_ativo;
    }
    
    
    //buscar
        public Aviso buscar(){
        Aviso retorno;
        persistencia = new AvisoBD();
        try{
            //busca o Usuario
            retorno = persistencia.buscar(this.id);
            //verifica se encontrou registro
            if(retorno == null){
                //retorna objeto como null caso não encontra
                return null;
            }
            this.mensagem = retorno.mensagem;
            this.flag_ativo= retorno.flag_ativo;
            this.id_user = retorno.id_user;
            
        }catch(Exception e ){
            System.out.println(e);
        }
        return this;
    }
    //salvar
    public String salvar(){
        persistencia = new AvisoBD();
        Aviso retorno;
        
        try{
            retorno = persistencia.salvar(this);
            //Atualiza o id do usuario, tendo em vista que o usuario criado não tinha
            this.id = retorno.getId();
        }
        catch(Exception e ){
            System.out.println(e);
        }
        return "Aviso Salvo com sucesso";
    }
        
    //excluir
    public String deletar(){
        persistencia = new AvisoBD();
        this.setFlag_ativo("N");
        try{
            //busca o Usuario
            persistencia.salvar(this);
        }catch(Exception e ){
            System.out.println(e);
        }
            return "Usuário excluido com sucesso";
    }
    
    //listar por usuario
    public ArrayList<Aviso> listar(){
        try{
            persistencia = new AvisoBD();
            //busca o Usuario
            return persistencia.listar(this.id_user);
        }catch(Exception e ){
            System.out.println(e);
        }
        return null;
    }
}
