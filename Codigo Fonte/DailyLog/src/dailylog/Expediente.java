/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailylog;

import bancoDeDados.ConexaoSQLite;
import bancoDeDados.SelectNasTables;
import java.util.ArrayList;

/**
 *
 * @author PAULOR RICARDO GAMEPLAYS E JARDIELMA QUEIROZ DE LIMA
 */
public class Expediente 
{
    private int id;
    private String data;
    private String horarioInicial;
    private String horarioFinal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
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

    public void bucarExpediente(){
        ConexaoSQLite conexaoSQLite = new ConexaoSQLite(); // criando conexao
        conexaoSQLite.conectar(); //conectando
        
        SelectNasTables consulta = new SelectNasTables(conexaoSQLite);
        consulta.exibirExpediente();
    }
    
    /*
    
    public Expediente(String data, OffsetTime horarioInicial, OffsetTime horarioFinal) {
        this.data = data;
        this.horarioInicial = horarioInicial;
        this.horarioFinal = horarioFinal;
    }

    public String getData() {
        return this.data;
    }
    /*
    /**Percorre as ativiades do dia, e verifica se o intervalo de tempo inserido(HorarioInicial e horarioFIna) NÃO esta sem disponivel(True). */
    /*public boolean vericaConflitoHorario(String horario1, String horario2){
        //Converte As duas Strings pra OffSetTime//
        OffsetTime horarioInicial = OffsetTime.parse(horario1 + ":00+00:00");
        OffsetTime horarioFinal = OffsetTime.parse(horario2 + ":00+00:00");
        ///Percorre as atividades//
        for(Atividade atividade: atividadesDoDia){
            //Explicacoes das verificacoes:
             * 1 Caso: Verifica se horario Inicial esta no meio de uma atividade
             * 2 Caso: Verifica se o horario Final esta no meio de uma atividade
             * 3 Caso: Verifica se existe uma atividade entre o horario Inicial e o horario final
             * Caso algum desses casos ocorra, existira um conflito de atividades(Return true).
             //
            if((horarioInicial.isAfter(atividade.getHorarioInicial()) && horarioInicial.isBefore(atividade.getHorarioFinal()) ) || (horarioFinal.isAfter(atividade.getHorarioInicial()) && horarioFinal.isBefore(atividade.getHorarioFinal())) || (horarioInicial.isBefore(atividade.getHorarioInicial()) && horarioFinal.isAfter(atividade.getHorarioFinal()))){
                return true;
            }

        }

        return false;
    }
    
    /**Pecorre as atividades do dia exibindo elas*/
    /*
    public void listarAtividades(){
        for(Atividade atividade: atividadesDoDia){
            atividade.exibirAtividade();
        }
    }

    /**Verifica se existe ja existe alguma atividade no dia*/
    /*
    public boolean existeAtiviadesCadastradas(){
        if (this.atividadesDoDia.isEmpty()){
            return false;
        }
        return true;
    }

    public void adicionaAtividade(Atividade atividade){
        this.atividadesDoDia.add(atividade);
    }

    /*
    public void alteraInicioExpediente(String novoHorario){
        OffsetTime horario = OffsetTime.parse(horario2 + ":00+00:00");
        for (Atividade atividade: atividadesDoDia ) {
            if(atividade.getHorarioInicial().isAfter(horario)){
                System.out.println("Não é possivel alterar o horario, pois ja existe atividades nesse horario");
                break;
            }
        }
    }*/
    
    
    
    
}
