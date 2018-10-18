/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailylog;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *  @author Ana Carolina Cebin Pereira
 *  @author Jardielma Queiroz de Lima
 *  @author Paulo Ricardo Viana Ferreira
 */

public class Usuario{
    private LocalTime horarioPadraoInicial;
    private LocalTime horarioPadraoFinal;
    protected String nome;
    protected String senha;
    protected int tamanhoFonte;
    protected boolean autoContraste;
    protected int id;
    public List<Expediente> expedientes = new ArrayList();


    public Usuario(String horarioPadraoInicial, String horarioPadraoFinal, String nome, String senha, int tamanhoFonte, boolean autoContraste, int id) {
        this.horarioPadraoInicial = LocalTime.parse(horarioPadraoInicial + ":00", DateTimeFormatter.ofPattern("HH:mm:ss"));
        this.horarioPadraoFinal = LocalTime.parse(horarioPadraoFinal + ":00", DateTimeFormatter.ofPattern("HH:mm:ss"));
        this.nome = nome;
        this.senha = senha;
        this.tamanhoFonte = tamanhoFonte;
        this.autoContraste = autoContraste;
        this.id = id;
        
    }


    public String getNome() {

        return this.nome;
    }

    /**
     * Adiciona uma atividade verificando se vai existir um conflito com alguma outra atividade  registrada no dia
     *
     * @param data              data da atividade
     * @param id                id da atividade
     * @param titulo            titulo da atividade
     * @param descricao         descricao da atividade
     * @param horarioInicio     horario de inicio da atividade
     * @param horarioFim        horario de termino da atividade
     * @param idCategoria       id da categoria da ativiade
     * @param idSubCategoria    id da SubCategoria da atividade
     */
    public void adicionarAtividade(String data, int id, String titulo, String descricao, String horarioInicio, String horarioFim, int idCategoria, int idSubCategoria){
        if(!existeExpediente(data)){
            adicionarExpediente(data);
        }
        for (Expediente expediente: expedientes) {
            if(data.equals(expediente.getDataString())){
                if ((!expediente.existeAtividadesCadastradas()) || (!expediente.vericaConflitoHorario(horarioInicio, horarioFim)) ){
                    Atividade atividade = new Atividade(id , titulo, descricao, horarioInicio, horarioFim, idCategoria, idSubCategoria);
                    expediente.adicionaAtividade(atividade);
                } else{
                    System.out.println("Atividade nao pode ser adicionada devido a conflitos");
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

    /**
     * Lista as atividade de um determinado dia com as informacoes completas da atividade
     * @param data data referente as atividades que devem ser listadas
     */
    public void listarAtividadesCompleta(String data){
        for( Expediente expediente : expedientes) {
            if (data.equals(expediente.getDataString())) {
                expediente.listarAtividadesCompleta();
            }
        }
    }


    /**
     * Lista as atividade de um determinado dia com as informacoes simplificadas(Horario de comeco e termino, e titulo) da atividade
     * @param data data referente as atividades que devem ser listadas
     */
    public void listarAtividadesSimplificada(String data){
        for( Expediente expediente : expedientes) {
            if (data.equals(expediente.getDataString())) {
                expediente.listarAtividadesSimplificada();
            }
        }
    }
    
    public void consultarRelatorio(){
        
   
    }


    /**
     * Cria um novo expediente e adiona na lista de expedientes do usuario
     * @param dataString data do expediente que sera criado
     */
    private void adicionarExpediente(String dataString){
        LocalDate localDate = LocalDate.parse("2018/07/22", DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        Expediente novoExpediente = new Expediente(dataString, this.horarioPadraoInicial, this.horarioPadraoFinal);
        this.expedientes.add(novoExpediente);
        
    }

    /**Verifica se o Expediente ja esta cadastrado
     * @param dataString String com a informação da data que sera verificado se existe o expediente
     */
    private boolean existeExpediente(String dataString){

        for( Expediente expediente : expedientes){
            if(dataString.equals(expediente.getDataString())){
                return true;
            } 
        }
        return false;
    }


}


    
