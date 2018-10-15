/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailylog;

import java.time.OffsetTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Carol Cebin
 */
public class Expediente {
    private String data;
    private OffsetTime horarioInicial;
    private OffsetTime horarioFinal;
    private List<Atividade> atividadesDoDia = new ArrayList();

    public Expediente(String data, OffsetTime horarioInicial, OffsetTime horarioFinal) {
        this.data = data;
        this.horarioInicial = horarioInicial;
        this.horarioFinal = horarioFinal;
    }

    public String getData() {
        return this.data;
    }
    
    /**Percorre as ativiades do dia, e verifica se o intervalo de tempo inserido(HorarioInicial e horarioFIna) NÃO esta sem disponivel(True). */
    public boolean vericaConflitoHorario(String horario1, String horario2){
        /**Converte As duas Strings pra OffSetTime*/
        OffsetTime horarioInicial = OffsetTime.parse(horario1 + ":00+00:00");
        OffsetTime horarioFinal = OffsetTime.parse(horario2 + ":00+00:00");
        /**Percorre as atividades*/
        for(Atividade atividade: atividadesDoDia){
            /**Explicacoes das verificacoes:
             * 1 Caso: Verifica se horario Inicial esta no meio de uma atividade
             * 2 Caso: Verifica se o horario Final esta no meio de uma atividade
             * 3 Caso: Verifica se existe uma atividade entre o horario Inicial e o horario final
             * Caso algum desses casos ocorra, existira um conflito de atividades(Return true).
             */
            if((horarioInicial.isAfter(atividade.getHorarioInicial()) && horarioInicial.isBefore(atividade.getHorarioFinal()) ) || (horarioFinal.isAfter(atividade.getHorarioInicial()) && horarioFinal.isBefore(atividade.getHorarioFinal())) || (horarioInicial.isBefore(atividade.getHorarioInicial()) && horarioFinal.isAfter(atividade.getHorarioFinal()))){
                return true;
            }

        }

        return false;
    }

    /**Pecorre as atividades do dia exibindo elas*/
    public void listarAtividades(){
        for(Atividade atividade: atividadesDoDia){
            atividade.exibirAtividade();
        }
    }

    /**Verifica se existe ja existe alguma atividade no dia*/
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
