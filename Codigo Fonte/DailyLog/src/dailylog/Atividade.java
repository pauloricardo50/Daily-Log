/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailylog;

import java.util.ArrayList;
import java.util.Calendar;
import persistencia.AtividadeBD;

/**
 *
 * @author Jardielma e Paulo Ricardo
 */
public class Atividade extends Observado{
    private int id;
    private String titulo;
    private String descricao;
    private String horarioInicial;
    private String horarioFinal;
    private int idCategoria;
    private int idSubCategoria;
    private int idExpediente;
    private int idUsuario;
    private String data;
    private AtividadeBD persistencia;
    private ArrayList<ParticipacaoAtividade> listaParticipacaoAtividade ;
    
    public int getId() {
        return id;
        
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public ArrayList<ParticipacaoAtividade> getlistaParticipacaoAtividade() {
        return listaParticipacaoAtividade;
        
    }

    public void setlistaParticipacaoAtividade(ArrayList<ParticipacaoAtividade> listaParticipacaoAtividade) {
        this.listaParticipacaoAtividade = listaParticipacaoAtividade;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public void setHorarioFinal(String horarioFinal){
        this.horarioFinal = horarioFinal;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdSubCategoria() {
        return idSubCategoria;
    }

    public void setIdSubCategoria(int idSubCategoria) {
        this.idSubCategoria = idSubCategoria;
    }
    
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
     public int getIdExpediente() {
        return idExpediente;
    }

    public void setIdExpediente(int idExpediente) {
        this.idExpediente = idExpediente;
    }
    
     public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public String salvar(Usuario user, Expediente expediente, SubCategoria subcategoria){
        persistencia = new AtividadeBD();
        Atividade retorno;
        try{
            retorno = persistencia.salvar(this,user.getId(),expediente.getId(),subcategoria.getId());
            
            //Atualiza o id do usuario, tendo em vista que o usuario criado não tinha
            this.id = retorno.getId();
        }
        catch(Exception e ){
            System.out.println(e);
        }
        return "Atividade Salvo com sucesso";
    }
    
    public void deletar(){
        persistencia = new AtividadeBD();
        try{
            //busca o Usuario
            persistencia.deletar(this.getId());
        }catch(Exception e ){
            System.out.println(e);
        }
    }
    
    public void adicionarParticipacao(ParticipacaoAtividade novaParticipacao){
        this.listaParticipacaoAtividade.add(novaParticipacao);
    }
    
    /**
     *
     * @param user
     * @return
     */
    public ArrayList<Atividade>listar(Usuario user){
        ArrayList<Atividade> lista = null;
        persistencia = new AtividadeBD();
        try{
            //busca o Usuario
            lista = persistencia.listar(user.getId());
            return lista;
        }catch(Exception e ){
            System.out.println(e);
        }
        return null;
    }
    
    
    
    
    /**
     * Busca o usuario pelo id do objeto
     * Caso encontre, retorna o usuário encontrado e seta as váriaveis do objeto no objeto atual
     * Caso não encontre, retorna null.
     * @return
     */
    public Atividade buscar(int idAtividade){
        Atividade retorno;
        persistencia = new AtividadeBD();
        try{
            //busca o Usuario
            retorno = persistencia.buscar(idAtividade);
            //verifica se encontrou registro
            if(retorno == null){
                //retorna objeto como null caso não encontra
                return null;
            }
            this.titulo = retorno.titulo;
            this.descricao = retorno.descricao;
            this.horarioFinal = retorno.horarioFinal;
            this.horarioInicial = retorno.horarioInicial;
            this.idCategoria = retorno.idCategoria;
            this.idExpediente = retorno.idExpediente;
            this.idSubCategoria = retorno.idSubCategoria;
            this.idUsuario = retorno.idUsuario;
            this.listaParticipacaoAtividade = retorno.listaParticipacaoAtividade;
        }catch(Exception e ){
            System.out.println(e);
        }
        return this;
    }
    
    public String identificarUsuarioDiferente(ParticipacaoAtividade participacaoAtividade){
        
        if(participacaoAtividade.getIdUsuario()==this.idUsuario){
            //não é usuario diferente
            return "";
        }
        int i = 0;
        for(ParticipacaoAtividade participacaoRegistrada: this.listaParticipacaoAtividade){
            
            if(participacaoRegistrada.getIdUsuario()==participacaoAtividade.getIdUsuario()){
                i++;
            }
        }
        if(i==0){
            Usuario usuario = new Usuario();
            usuario.setId(this.idUsuario);
            usuario.buscar();
            usuario.update(this.titulo);
        }
        return"";
    }
    
}
