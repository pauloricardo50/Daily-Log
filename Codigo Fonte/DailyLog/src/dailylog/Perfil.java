/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailylog;

import java.util.ArrayList;
import persistencia.PerfilBD;

/**
 *
 * @author Jardielma e Paulo Ricardo
 */
public class Perfil {
    private int id;
    private String descricao;
    private String horarioPadraoInicial;
    private String horarioPadraoFinal;
    private int tamanhoFonte;
    private boolean autoContraste;
    private PerfilBD persistencia;
    private ArrayList<Permissao> permissoes;
   
    /* Getters e Setters */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHorarioPadraoInicial() {
        return horarioPadraoInicial;
    }

    public void setHorarioPadraoInicial(String horarioPadraoInicial) {
        this.horarioPadraoInicial = horarioPadraoInicial;
    }

    public String getHorarioPadraoFinal() {
        return horarioPadraoFinal;
    }

    public void setHorarioPadraoFinal(String horarioPadraoFinal) {
        this.horarioPadraoFinal = horarioPadraoFinal;
    }

    public int getTamanhoFonte() {
        return tamanhoFonte;
    }

    public void setTamanhoFonte(int tamanhoFonte) {
        this.tamanhoFonte = tamanhoFonte;
    }

    public boolean getAutoContraste() {
        return autoContraste;
    }

    public void setAutoContraste(boolean autoContraste) {
        this.autoContraste = autoContraste;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public ArrayList<Permissao> getPemissoes() {
        return permissoes;
    }

    public void setPermissoes(ArrayList<Permissao> permissao) {
        this.permissoes = permissao;
    }
   
    public Perfil buscar(){
        
        persistencia = new PerfilBD();
        Perfil perfilRetorno = new Perfil();
        
        try{
            //busca e retorna o perfil do usuario
            perfilRetorno =  persistencia.buscar(this.id);
            
            this.id = perfilRetorno.getId();
            this.descricao = perfilRetorno.getDescricao();
            this.horarioPadraoInicial = perfilRetorno.getHorarioPadraoInicial();
            this.horarioPadraoFinal = perfilRetorno.getHorarioPadraoFinal();
            this.tamanhoFonte = perfilRetorno.getTamanhoFonte();
            this.autoContraste = perfilRetorno.getAutoContraste();
            
        }catch(Exception e ){ 
            System.out.println(e);
        }
        return this;
    }
   
     /**
     * Salva o Perfil
     * Método utilizado para salvar e atualizar o perfil do usuário
     * @return
     */
    public String salvar(){
        
        persistencia = new PerfilBD();
        Perfil perfilRetorno;
        
        try{
            //salva o perfil do usuario
            if(this.getDescricao().length() == 0){
                return "Descrição Não preenchida";
            }
            if(this.getHorarioPadraoInicial().length() == 0){
                return "Horario padrão inicial não informado";
            }
             if(this.getHorarioPadraoFinal().length() == 0){
                return "Horario padrão final não informado";
            }
            if(this.getTamanhoFonte() < 10){
                return "O tamanho da fonte deve ser maior";
            } 

            //salva o perfil
            perfilRetorno = persistencia.salvar(this);
            //Atualiza o id do usuario, tendo em vista que o usuario criado não tinha
            this.id = perfilRetorno.getId();
            
        }catch(Exception e ){
            System.out.println(e);
        }
         return "Perfil Salvo com sucesso";
    }
    
    public ArrayList<Perfil> listar(){
        
        PerfilBD perfilBD = new PerfilBD();
        try{
            //salva o perfil do usuario
            return perfilBD.listar();
            
        }catch(Exception e ){
            System.out.println(e);
        }
        return null;
    }
}
