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
import persistencia.AtividadeBD;

/**
 *
 * @author Jardielma e Paulo Ricardo
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
    private int idExpediente;
    private int idUsuario;
    private String data;
    private AtividadeBD persistencia;

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

    public void setHorarioFinal(String horarioFinal){
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
    
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
     public int getIdExpediente() {
        return idExpediente;
    }

    public void setIdExpediente(int idExpediente) {
        this.idExpediente = idExpediente;
    }
    
     public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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
    
    public String salvar(Usuario user, Expediente expediente, SubCategoria subcategoria){
         persistencia = new AtividadeBD();
        Atividade retorno;
        try{
            retorno = persistencia.salvar(this,user.getId(),expediente.getId(),subcategoria.getId());
            //Atualiza o id do usuario, tendo em vista que o usuario criado não tinha
            this.id = retorno.getId();
        }
        catch(Exception e ){
            System.out.println(e);
        }
        return "Atividade Salvo com sucesso";
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
    public ArrayList<Atividade> listar(Usuario user){
        ArrayList<Atividade> lista = null;
        persistencia = new AtividadeBD();
        try{
            //busca o Usuario
            lista = persistencia.listar(user.getId());
            return lista;
        }catch(Exception e ){
            System.out.println(e);
        }
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
