/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailylog;

import java.time.OffsetTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carol Cebin
 */
public class Usuario{
    private OffsetTime horarioPadraoInicial;
    private OffsetTime horarioPadraoFinal;
    private String nome;
    private String senha;
    private int tamanhoFonte;
    private boolean autoContraste;
    private int id;
    private List<Expediente> expedientes = new ArrayList();

    public Usuario(String horarioPadraoInicial, String horarioPadraoFinal, String nome, String senha, int tamanhoFonte, boolean autoContraste, int id) {
        this.horarioPadraoInicial = OffsetTime.parse(horarioPadraoInicial+":00+00:00");
        this.horarioPadraoFinal = OffsetTime.parse(horarioPadraoFinal+":00+00:00");
        this.nome = nome;
        this.senha = senha;
        this.tamanhoFonte = tamanhoFonte;
        this.autoContraste = autoContraste;
        this.id = id;
        
    }


    public String getNome() {
        return this.nome;
    }
    
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

    /**Verifica se o Expediente ja esta cadastrado*/
    private boolean existeExpediente(String data){
        for( Expediente expediente : expedientes){
            if(data.equals(expediente.getData())){
                return true;
            } 
        }
        return false;
    }


}


    
