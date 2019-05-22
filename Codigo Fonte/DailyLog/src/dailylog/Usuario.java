/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailylog;

import java.util.ArrayList;
import persistencia.UsuarioBD;


/**
 *
 * @author Jardielma e Paulo Ricardo
 */
public class Usuario implements Observador{
    /* atributos */
    
    private int id;
    private int idade;
    private String flagAtivo;
    protected String nome;
    protected String senha;
    private Perfil perfil;
    private UsuarioBD persistencia;
    
    
    /* Getters e Setters */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getFlagAtivo() {
        return flagAtivo;
    }

    public void setFlagAtivo(String flag_ativo) {
        this.flagAtivo = flag_ativo;
    }
    
    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }


    /**
     * Busca o usuario pelo id do objeto
     * Caso encontre, retorna o usuário encontrado e seta as váriaveis do objeto no objeto atual
     * Caso não encontre, retorna null.
     * @return
     */
    public Usuario buscar(){
        Usuario retorno;
        persistencia = new UsuarioBD();
        try{
            //busca o Usuario
            retorno = persistencia.buscar(this.id);
            //verifica se encontrou registro
            if(retorno == null){
                //retorna objeto como null caso não encontra
                return null;
            }
            this.nome = retorno.nome;
            this.perfil= retorno.perfil;
        }catch(Exception e ){
            System.out.println(e);
        }
        return this;
    }
    
    /**
     * Salva o usuario
     * Método utilizado para salvar e atualizar
     * Atualiza o id(0) do objeto atual com o id gerado pelo banco
     * @return
     */
    public String salvar(){
        persistencia = new UsuarioBD();
        Usuario retorno;
        
        try{
            if(this.getNome().length() == 0){
                return "Usuario sem nome";
            }
            if(this.getSenha().length() < 3){
                return "Usuario sem senha ou com senha muito curta";
            }
            if(this.getPerfil() == null){
                return "Usuario sem Perfil";
            }
            System.out.println("perfil id - "+this.getPerfil().getId());
            //salva o usuario
            retorno = persistencia.salvar(this);
            //Atualiza o id do usuario, tendo em vista que o usuario criado não tinha
            this.id = retorno.getId();
        }
        catch(Exception e ){
            System.out.println(e);
        }
        return "Usuário Salvo com sucesso";
    }
    
    public String deletar(){
        persistencia = new UsuarioBD();
        this.setFlagAtivo("D");
        try{
            //busca o Usuario
            persistencia.salvar(this);
        }catch(Exception e ){
            System.out.println(e);
        }
            return "Usuário excluido com sucesso";
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Usuario> listar(){
        try{
            persistencia = new UsuarioBD();
            //busca o Usuario
            return persistencia.listar();
        }catch(Exception e ){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public void update(String mensagem) {
        //Deverar chegar por email - a ser implementado futuramente
        //Mensagem tela
        System.out.println("Um novo usuário solicitou participação na atividade "+mensagem);
    }
   
}
