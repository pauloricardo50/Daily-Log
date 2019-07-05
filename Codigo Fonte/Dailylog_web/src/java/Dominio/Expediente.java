/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import banco.Conexao;
import java.util.ArrayList;
import persistencia.ExpedienteBD;

/**
 *
 * @author Jardielma e Paulo Ricardo
 */
public class Expediente 
{
    private int id;
    private String data;
    private String horarioInicial;
    private String horarioFinal;
    ExpedienteBD persistencia = new ExpedienteBD();
    private String flagAtivo;
    private Usuario usuario;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorarioInicial() {
        return horarioInicial;
    }

    public void setHorarioInicial(String horarioInicial) {
        this.horarioInicial = horarioInicial;
    }

    public String getHorarioFinal() {
        return horarioFinal;
    }

    public void setHorarioFinal(String horarioFinal) {
        this.horarioFinal = horarioFinal;
    }
    
    public String getFlagAtivo() {
        return flagAtivo;
    }

    public void setFlagAtivo(String flagAtivo) {
        this.flagAtivo = flagAtivo;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Busca o usuario pelo id do objeto
     * Caso encontre, retorna o usuário encontrado e seta as váriaveis do objeto no objeto atual
     * Caso não encontre, retorna null.
     * @return
     */
    public Expediente buscar(){
        Expediente retorno;
        persistencia = new ExpedienteBD();
        try{
            //busca o Usuario
            retorno = persistencia.buscar(this.id);
            //verifica se encontrou registro
            if(retorno == null){
                //retorna objeto como null caso não encontra
                return null;
            }
            this.data = retorno.data;
            this.horarioInicial = retorno.horarioInicial;
            this.horarioFinal = retorno.horarioFinal;
            this.usuario = retorno.usuario;
            this.flagAtivo = retorno.flagAtivo;
            
        }catch(Exception e ){
            System.out.println(e);
        }
        return this;
    }
    
    
    public String salvar(int id){
        persistencia = new ExpedienteBD();
        Expediente retorno;
        
        try{
//            if(this.getData().length() == 0){
//                return "Não possui data";
//            }
//            if(this.getHorarioFinal().length() == 0){
//                return "Não possui hora";
//            }
//            if(this.getHorarioInicial().length() == 0){
//                return "Não possui hora";
//            }
//            if(this.getUsuario().getId() == 0){
//                return "Não possui usuario";
//            }
            this.flagAtivo = "A";
            //salva o usuario
            retorno = persistencia.salvar(this);
            //Atualiza o id do usuario, tendo em vista que o usuario criado não tinha
            this.id = retorno.getId();
        }
        catch(Exception e ){
            System.out.println(e);
        }
        return "Expediente Salvo com sucesso";
    }
    
    public String deletar(){
//        persistencia = new UsuarioBD();
//        this.setFlag_ativo("D");
//        try{
//            //busca o Usuario
//            persistencia.salvar(this);
//        }catch(Exception e ){
//            System.out.println(e);
//        }
//            return "Usuário excluido com sucesso";
return "";
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Expediente> listar(){
        try{
            persistencia = new ExpedienteBD();
            //busca o Usuario
            return persistencia.listar();
        }catch(Exception e ){
            System.out.println(e);
        }
        return null;
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Expediente> listar(Usuario user){
        try{
            persistencia = new ExpedienteBD();
            //busca o Usuario
            return persistencia.listar(user.getId());
        }catch(Exception e ){
            System.out.println(e);
        }
        return null;
    }
    
    
    
}
