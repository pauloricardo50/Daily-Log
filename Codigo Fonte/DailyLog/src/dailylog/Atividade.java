/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailylog;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


/**
 *  @author Ana Carolina Cebin Pereira
 *  @author Jardielma Queiroz de Lima
 *  @author Paulo Ricardo Viana Ferreira
 *
 */



public class Atividade {
    private final int id;
    private String titulo;
    private String descricao;
    private LocalTime horarioInicial;
    private LocalTime horarioFinal;
    private int idCategoria;
    private int idSubCategoria;

    public Atividade(int id, String titulo, String descricao, String horarioInicial, String horarioFinal, int idCategoria, int idSubCategoria) {

        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.horarioInicial = LocalTime.parse(horarioInicial + ":00", DateTimeFormatter.ofPattern("HH:mm:ss"));
        this.horarioFinal = LocalTime.parse(horarioFinal + ":00", DateTimeFormatter.ofPattern("HH:mm:ss"));
        this.idCategoria = idCategoria;
        this.idSubCategoria = idSubCategoria;

    }

    /**
    *   Exibe uma atividade com todos seus campos
    */
    public void exibirAtividade(){
        System.out.println("Numero: " + this.id);
        System.out.println("    1. Titulo: " + this.titulo);
        System.out.println("    2. Decricao: " + this.descricao);
        System.out.println("    3. Horario de Inicio: " + getHorarioString(this.horarioInicial));
        System.out.println("    4. Horario de Termino: " + getHorarioString(this.horarioFinal));
        System.out.println("    5. Categoria: " + this.idCategoria);
        System.out.println("    6. Subcategoria: " + this.idSubCategoria);
    }

    /*
     *   Exibe uma atividade com horario inicial, horario final e o titulo.
     */
    public void exibirAtividadeSimplificada(){
        System.out.println("Numero: " + this.id);
        System.out.println("    1. Horario de Inicio: " + getHorarioString(this.horarioInicial));
        System.out.println("    2. Horario de Termino: " + getHorarioString(this.horarioFinal));
        System.out.println("    3. Titulo: " + this.titulo);
    }

    //Funcoes de SET

    /**
     * Altera seu titulo
     * @param titulo  Novo titulo da atividade
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Altera sua descricao
     * @param descricao  Nova descrição da atividade
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Altera seu horario inicial
     * @param horarioInicial Novo horario inicial da atividade
     */
    public void setHorarioInicial(String horarioInicial) {
        this.horarioInicial = LocalTime.parse(horarioInicial + ":00", DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    /**
     * Altera seu horario final
     * @param horarioFinal Novo horario final da atividade
     */
    public void setHorarioFinal(String horarioFinal) {
        this.horarioFinal = LocalTime.parse(horarioInicial + ":00", DateTimeFormatter.ofPattern("HH:mm:ss"));
    }



    //Funcoes de GET

    /**
     * Pega o valor do horario Incial
     * @return O horario inicial da atividade
     */
    public LocalTime getHorarioInicial() {
        return this.horarioInicial;
    }

    /**
     * Pega o valor do horario Final
     * @return O horario Final da atividade
     */
    public LocalTime getHorarioFinal() {
        return this.horarioFinal;
    }

    /**
     * Pega o valor do horario no formato String - Padrão HH:MM
     * @param horario horario no formato LocalTime que sera convertido para String no formato desejado
     * @return String com o horario no formato HH:MM
     */
    public String getHorarioString(LocalTime horario){
        DateTimeFormatter formatoHorario = DateTimeFormatter.ofPattern("HH:mm");
        String format = horario.format(formatoHorario);
        return format;
    }

    /**
     * Calcula sua duracao em Minutos
     * @return Retorna a duracao da atividade em minutos
     */
    public long calculaDuracaoMinutos(){
        long diferencaMinutos = ChronoUnit.MINUTES.between(this.horarioInicial, this.horarioFinal);
        return diferencaMinutos;
    }
    
    
}
