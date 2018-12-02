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
public class Usuario 
{
    /* atributos */
    
    private int id;
    private int idade;
    private String flag_ativo;
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
    
    public String getFlag_ativo() {
        return flag_ativo;
    }

    public void setFlag_ativo(String flag_ativo) {
        this.flag_ativo = flag_ativo;
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
        this.setFlag_ativo("D");
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
   /* 
    
    public void adicionarAtiviade(String data, int id, String titulo, String descricao, String horarioInicio, String horarioFim, int idCategoria, int idSubCategoria){
        if(!existeExpediente(data)){
            adicionarExpediente(data);
        }
        for (Expediente expediente: expedientes) {
            if(data.equals(expediente.getData())){
                if (!expediente.existeAtiviadesCadastradas()){
                    Atividade atividade = new Atividade(id , titulo, descricao, horarioInicio, horarioFim, 01, 03);
                    expediente.adicionaAtividade(atividade);
                }else{
                    if(!expediente.vericaConflitoHorario(horarioInicio, horarioFim)) {
                        Atividade atividade = new Atividade(id, titulo, descricao, horarioInicio, horarioFim, 01, 03);
                        expediente.adicionaAtividade(atividade);
                    } else{
                        System.out.println("Atividade nao pode ser adicionada devido a conflitos");
                    }
                }
            }
        }
    }
    
    public void excluirAtividade(){
        //Pergunta a data
        //Procura o expediente
        //Lista as ativiades
        //Seleciona a atividade
        //Retira do array de ativiades dentro do expediente
        
    }
    
    public void editarAtividade(){
        //Pergunta a data
        //procura o expedinte
        //Lista as ativiades
        //Pegunta qual a ativiade vai ser alterada
        //Pergunta a informação que vai ser alterada
        //E altera a infomação
        
    }
    
    public void listarAtiviade(String data){
        for( Expediente expediente : expedientes) {
            if (data.equals(expediente.getData())) {
                expediente.listarAtividades();
            }
        }
    }
    
    public void consultarRelatorio(){
        
   
    }

    private void adicionarExpediente(String data){
        Expediente novoExpediente = new Expediente(data, this.horarioPadraoInicial, this.horarioPadraoFinal);
        this.expedientes.add(novoExpediente);
        
    }

    //Verifica se o Expediente ja esta cadastrado//
    private boolean existeExpediente(String data){
        for( Expediente expediente : expedientes){
            if(data.equals(expediente.getData())){
                return true;
            } 
        }
        return false;
    }
    
    
    */
    
    
    
}
