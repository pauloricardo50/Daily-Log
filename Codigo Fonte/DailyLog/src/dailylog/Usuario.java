/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailylog;

import bancoDeDados.ConexaoSQLite;
import bancoDeDados.SelectNasTables;


/**
 *
 * @author PAULOR RICARDO GAMEPLAYS E JARDIELMA QUEIROZ DE LIMA
 */
public class Usuario 
{
    /* atributos */
    
    private int id;
    private int idade;
    private String horarioPadraoInicial;
    private String horarioPadraoFinal;
    protected String nome;
    protected String senha;
    protected int tamanhoFonte;
    protected boolean autoContraste;
    
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

    public int getTamanhoFonte() {
        return tamanhoFonte;
    }

    public void setTamanhoFonte(int tamanhoFonte) {
        this.tamanhoFonte = tamanhoFonte;
    }

    public boolean isAutoContraste() {
        return autoContraste;
    }

    public void setAutoContraste(boolean autoContraste) {
        this.autoContraste = autoContraste;
    }

    
    public void bucarUsuario(){
        ConexaoSQLite conexaoSQLite = new ConexaoSQLite(); // criando conexao
        conexaoSQLite.conectar(); //conectando
        
        SelectNasTables consulta = new SelectNasTables(conexaoSQLite);
        consulta.exibirUsuario();
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
