/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailylog;

import javax.print.DocFlavor;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *  @author Ana Carolina Cebin Pereira
 *  @author Jardielma Queiroz de Lima
 *  @author Paulo Ricardo Viana Ferreira
 *
 */

public class Expediente {
    private LocalDate data;
    private LocalTime horarioInicial;
    private LocalTime horarioFinal;
    private List<Atividade> atividadesDoDia = new ArrayList();

    public Expediente(String data, LocalTime horarioInicial, LocalTime horarioFinal) {
        this.data = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.horarioInicial = horarioInicial;
        this.horarioFinal = horarioFinal;
    }

    /**
     * Pega o data do expediente
     * @return A data do expediente
     */
    public LocalDate getData() {

        return this.data;
    }

    public String getDataString(){
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataString = this.data.format(formatoData);
        return dataString;
    }
    
    /**Percorre as atividades do dia e verifica se um intervalo horario não disponivel para inserir uma nova atividade
     *
     * @param horario1   Horario inicial da nova atividade
     * @param horario2   Horario final da nova atividade
     *
     * @return Verdadeiro se o horario nao estiver disponivel e Falso se estiver disponivel
     * */
    public boolean vericaConflitoHorario(String horario1, String horario2){
        /**Converte duas Strings pra LocalTime*/
        LocalTime horarioInicial = LocalTime.parse(horario1 + ":00", DateTimeFormatter.ofPattern("HH:mm:ss"));
        LocalTime horarioFinal = LocalTime.parse(horario2 + ":00", DateTimeFormatter.ofPattern("HH:mm:ss"));

        /**Percorre as atividades do dia*/
        for(Atividade atividade: atividadesDoDia){
            /**Explicações das verificações:
             * 1 Caso: Verifica se horario Inicial esta no meio de uma atividade
             * 2 Caso: Verifica se o horario Final esta no meio de uma atividade
             * 3 Caso: Verifica se existe uma atividade entre o horario Inicial e o horario final
             * Caso algum desses casos ocorra, existe um conflito de atividades(Return TRUE).
             */
            if((horarioInicial.isAfter(atividade.getHorarioInicial()) && horarioInicial.isBefore(atividade.getHorarioFinal()) )
                    || (horarioFinal.isAfter(atividade.getHorarioInicial()) && horarioFinal.isBefore(atividade.getHorarioFinal()))
                    || (horarioInicial.isBefore(atividade.getHorarioInicial()) && horarioFinal.isAfter(atividade.getHorarioFinal()))){

                return true;
            }
        }
        return false;
    }


    /**
     *  Exibir todas as atividades do dia com as seguintes informações: Titulo, descricao, categoria, subcategoria, horaio inicial, horario final
     */
    public void listarAtividadesCompleta(){
        for(Atividade atividade: atividadesDoDia){
            atividade.exibirAtividade();
        }
    }

    /**
     *  Exibir todas as atividades do dia com as seguinte informações: Hoario de inicio, Hoario final e Titulo
     */
    public void listarAtividadesSimplificada(){
        for(Atividade atividade: atividadesDoDia){
            atividade.exibirAtividadeSimplificada();
        }
    }

    /**Verifica se existe ja existe alguma atividade no dia
     *
     * @return Verdadeiro se existe atividade casdastrada no Expediente e false se não existe atividade cadastrada no Expediente
     *
     */
    public boolean existeAtividadesCadastradas(){
        if (this.atividadesDoDia.isEmpty()){
            return false;
        }
        return true;
    }

    /**Adiciona a atividade na lista de atividades do expediente
     *
     * @param atividade  Nova atividade
     *
     */
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
