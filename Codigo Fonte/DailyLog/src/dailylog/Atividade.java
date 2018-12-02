/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailylog;

import banco.Conexao;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Jardielma e Paulo Ricardo
 */
public class Atividade 
{
    private int id;
    private String titulo;
    private String descricao;
    private Time horarioInicial;
    private Time horarioFinal;
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

    public Time getHorarioInicial() {
        return horarioInicial;
    }

    public void setHorarioInicial(String horarioInicial) throws ParseException {
        SimpleDateFormat formatador = new SimpleDateFormat("HH:mm");
        Date data = (Date) formatador.parse(horarioInicial);
        Time time = new Time(data.getTime());
        this.horarioInicial = time;
    }

    public Time getHorarioFinal() {
        return horarioFinal;
    }

    public void setHorarioFinal(String horarioFinal) throws ParseException {
        SimpleDateFormat formatador = new SimpleDateFormat("HH:mm");
        Date data = (Date) formatador.parse(horarioFinal);
        Time time = new Time(data.getTime());
        this.horarioFinal = time;
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
    
    
    
    public Atividade buscarAtividade(){
//        Usuario retorno;
//        try{
//            //busca o Usuario
//            retorno = UsuarioBD.buscar(this.id);
//            this.nome = retorno.nome;
//            this.perfil= retorno.perfil;
//        }catch(Exception e ){
//            System.out.println(e);
//        }
//        return this;
        return null;
    }
    
    public void salvarAtividade(){
//        Usuario retorno;
//        try{
//            //busca o Usuario
//            retorno = UsuarioBD.buscar(this.id);
//            this.nome = retorno.nome;
//            this.perfil= retorno.perfil;
//        }catch(Exception e ){
//            System.out.println(e);
//        }
    }
    
    public void deletarAtividade(){
//        Usuario retorno;
//        try{
//            //busca o Usuario
//            retorno = UsuarioBD.buscar(this.id);
//            this.nome = retorno.nome;
//            this.perfil= retorno.perfil;
//        }catch(Exception e ){
//            System.out.println(e);
//        }
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Atividade> listaAtividade(){
//        Permissao retorno;
//        ArrayList<Permissao> lista = null;
//        try{
//            //busca o Usuario
//            retorno = UsuarioBD.buscar(this.id);
//            return lista;
//        }catch(Exception e ){
//            System.out.println(e);
//        }
        return null;
    }
    
    
    
    
    // METODOS
//    
//    public boolean adicionarAtividade(Atividade atividade){
//        Conexao conexaoSQLite = new Conexao(); // criando conexao
//        conexaoSQLite.conectar(); //conectando
//        
//        InsertNasTables tabelaAtividade = new InsertNasTables(conexaoSQLite);
//        return(tabelaAtividade.InserirnaTabelaAtividade(atividade));
//    }
//    
//    public void bucarAtividade(){
//        Conexao conexaoSQLite = new Conexao(); // criando conexao
//        conexaoSQLite.conectar(); //conectando
//        
//        SelectNasTables consulta = new SelectNasTables(conexaoSQLite);
//        consulta.exibirAtividades();
//    }
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
