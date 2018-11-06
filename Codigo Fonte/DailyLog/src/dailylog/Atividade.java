/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailylog;

import bancoDeDados.ConexaoSQLite;
import bancoDeDados.InsertNasTables;
import bancoDeDados.SelectNasTables;

/**
 *
 * @author PAULOR RICARDO GAMEPLAYS E JARDIELMA QUEIROZ DE LIMA
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

    public void setHorarioFinal(String horarioFinal) {
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
    
    // METODOS
    
    public boolean adicionarAtividade(Atividade atividade){
        boolean result = false;
        ConexaoSQLite conexaoSQLite = new ConexaoSQLite(); // criando conexao
        conexaoSQLite.conectar(); //conectando
        
        InsertNasTables tabelaAtividade = new InsertNasTables(conexaoSQLite);
        return(tabelaAtividade.InserirnaTabelaAtividade(atividade));
    }
    
    public void bucarAtividade(){
        ConexaoSQLite conexaoSQLite = new ConexaoSQLite(); // criando conexao
        conexaoSQLite.conectar(); //conectando
        
        SelectNasTables consulta = new SelectNasTables(conexaoSQLite);
        consulta.exibirAtividades();
    }
    /*
    public Atividade(int id, String titulo, String descricao, String horarioInicial, String horarioFinal, int idCategoria, int idSubCategoria) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.horarioInicial = OffsetTime.parse(horarioInicial + ":00+00:00");
        this.horarioFinal = OffsetTime.parse(horarioFinal + ":00+00:00");
        this.idCategoria = idCategoria;
        this.idSubCategoria = idSubCategoria;
    }

    /*Exibe uma atividade com seus campos 
    public void exibirAtividade(){
        System.out.println("Numero: " + this.id);
        System.out.println("    1. Titulo: " + this.titulo);
        System.out.println("    2. Decricao: " + this.descricao);
        System.out.println("    3. Horario de Inicio: " + this.horarioInicial);
        System.out.println("    4. Horario de Termino: " + this.horarioFinal);
        System.out.println("    5. Categoria: " + this.idCategoria);
        System.out.println("    6. Subcategoria: " + this.idSubCategoria);
    }

    /**Altera seu titulo*/
    /*
    public void setTitulo(String titulo) 
    {
        this.titulo = titulo;
    }
    */

    /**Altera sua descricao
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    /**Altera seu horario inicial
    public void setHorarioInicial(String horarioInicial) {
        this.horarioInicial = OffsetTime.parse(horarioInicial + ":00+00:00");
    }*/

    /**Altera seu horario final
    public void setHorarioFinal(String horarioFinal) {
        this.horarioFinal = OffsetTime.parse(horarioFinal + ":00+00:00");
    }*/
    
    /* 
    public OffsetTime getHorarioInicial() {
        return horarioInicial;
    }*/

    /*
    public OffsetTime getHorarioFinal() {
        return horarioFinal;
    }*/

    /**Calcula sua duracao em Minutos
    public long calculaDuracaoMinutos(){
        return this.horarioInicial.until(this.horarioFinal, ChronoUnit.MINUTES);
    }
    */
}
