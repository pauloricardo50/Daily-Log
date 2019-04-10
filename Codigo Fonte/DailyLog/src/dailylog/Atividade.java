/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailylog;

import java.util.ArrayList;
import persistencia.AtividadeBD;

/**
 *
 * @author Jardielma e Paulo Ricardo
 */
public class Atividade 
{
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


    // GETTERS E SETTERS PARA O BD
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
