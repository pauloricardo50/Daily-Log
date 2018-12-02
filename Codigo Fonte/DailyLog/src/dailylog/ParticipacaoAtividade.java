/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailylog;

import java.util.ArrayList;

/**
 *
 * @author Jardielma e Paulo Ricardo
 */
public class ParticipacaoAtividade {
    private int id;
    /**
  * Javadoc
  * Descrição da Participação do usuário na atividade
  */
    private String descricao;
    private String horarioInicial;
    private String horarioFinal;
    private Atividade atividade;

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

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }
    
    
    
    
    public ParticipacaoAtividade buscarParticipacaoAtividade(){
//        Usuario retorno;
//        try{
//            //busca o Usuario
//            retorno = UsuarioBD.buscar(this.id);
//            this.nome = retorno.nome;
//            this.perfil= retorno.perfil;
//        }catch(Exception e ){
//            System.out.println(e);
//        }
//        return this;
        return null;
    }
    
    public void salvarParticipacaoAtividade(){
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
    
    public void deletarParticipacaoAtividade(){
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
    public ArrayList<ParticipacaoAtividade> listaParticipacaoAtividade(){
//        Permissao retorno;
//        ArrayList<Permissao> lista = null;
//        try{
//            //busca o Usuario
//            retorno = UsuarioBD.buscar(this.id);
//            return lista;
//        }catch(Exception e ){
//            System.out.println(e);
//        }
        return null;
    }
 
}
