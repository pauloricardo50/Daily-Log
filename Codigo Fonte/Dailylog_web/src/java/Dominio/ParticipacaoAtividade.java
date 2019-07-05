/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.ArrayList;
import persistencia.ParticipacaoAtividadeBD;

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
    private String titulo;
    private String descricao;
    private String horarioInicial;
    private String horarioFinal;
    private String dataInicial;
    private String dataFinal;
    private int idAtividade;
    private int idUsuario;
    private ParticipacaoAtividadeBD persistencia;

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getIdAtividade() {
        return idAtividade;
    }

    public void setIdAtividade(int idAtividade) {
        this.idAtividade = idAtividade;
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
    
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }
    
    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }
    
     public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    

        
    public ParticipacaoAtividade buscarParticipacaoAtividade(){
//        Usuario retorno;
//        try{
//            //busca o Usuario
//            retorno = UsuarioBD.buscar(this.id);
//            this.nome = retorno.nome;
//            this.perfil= retorno.perfil;
//        }catch(Exception e ){identificarUsuarioDiferente
//            System.out.println(e);
//        }
//        return this;
        return null;
    }
    
        public ParticipacaoAtividade buscar(int idParticipacaoAtividade){
        ParticipacaoAtividade retorno;
        persistencia = new ParticipacaoAtividadeBD();
        try{
            //busca o Usuario
            retorno = persistencia.buscar(idParticipacaoAtividade);
            //verifica se encontrou registro
            if(retorno == null){
                //retorna objeto como null caso não encontra
                return null;
            }
            this.titulo = retorno.titulo;
            this.descricao = retorno.descricao;
            this.horarioFinal = retorno.horarioFinal;
            this.horarioInicial = retorno.horarioInicial;
            this.dataInicial = retorno.dataInicial;
            this.dataFinal = retorno.dataFinal;
            this.idUsuario = retorno.idUsuario;
            this.idAtividade = retorno.idAtividade;
            this.id = retorno.id;
            
        }catch(Exception e ){
            System.out.println(e);
        }
        return this;
    }
    
    public String salvar(){
        persistencia = new ParticipacaoAtividadeBD();
        ParticipacaoAtividade retorno;
        try{
            retorno = persistencia.salvar(this);
            
            //Atualiza o id do usuario, tendo em vista que o usuario criado não tinha
            this.id = retorno.getId();
        }
        catch(Exception e ){
            System.out.println(e);
        }
        return "Participaçã atividade Salvo com sucesso";
    }
    
    public void deletarParticipacaoAtividade(){
        persistencia = new ParticipacaoAtividadeBD();
        //ParticipacaoAtividade retorno;
        try{
            persistencia.deletar(this.getId());
            
            //Atualiza o id do usuario, tendo em vista que o usuario criado não tinha
            //this.id = retorno.getId();
        }
        catch(Exception e ){
            System.out.println(e);
        }
        //return "Participaçã atividade Salvo com sucesso";
    }
    public void deletarParticipacaoAtividade(boolean atividade){
        persistencia = new ParticipacaoAtividadeBD();
        //ParticipacaoAtividade retorno;
        try{
            persistencia.deletar(this.getIdAtividade(),true);
            
            //Atualiza o id do usuario, tendo em vista que o usuario criado não tinha
            //this.id = retorno.getId();
        }
        catch(Exception e ){
            System.out.println(e);
        }
        //return "Participaçã atividade Salvo com sucesso";
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
