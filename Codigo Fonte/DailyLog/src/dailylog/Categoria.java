/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailylog;

import BancoDeDados.ConexaoSQLite;
import BancoDeDados.DeleteNasTables;
import BancoDeDados.InsertNasTables;
import BancoDeDados.SelectNasTables;

/**
 *
 * @author PAULOR RICARDO GAMEPLAYS E JARDIELMA QUEIROZ DE LIMA
 */
public class Categoria 
{
    private int id;
    private String nome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Categoria() {
        this.id = id;
        this.nome = nome;
    }

    public boolean adicionarCategoria(Categoria categoria){
        boolean result = false;
        ConexaoSQLite conexaoSQLite = new ConexaoSQLite(); // criando conexao
        conexaoSQLite.conectar(); //conectando
        
        InsertNasTables tabelaCategoria = new InsertNasTables(conexaoSQLite);
        
        if(tabelaCategoria.InserirnaTabelaCategoria(categoria)){
            System.out.println("Adicionar Categoria:");
        }
        return(tabelaCategoria.InserirnaTabelaCategoria(categoria));
    }
    
    public void bucarCategoria(){
        ConexaoSQLite conexaoSQLite = new ConexaoSQLite(); // criando conexao
        conexaoSQLite.conectar(); //conectando
        
        SelectNasTables consulta = new SelectNasTables(conexaoSQLite);
        consulta.exibirCategorias();
    }
    
    public void deletarCategoria(int idCategoria){
        ConexaoSQLite conexaoSQLite = new ConexaoSQLite(); // criando conexao
        conexaoSQLite.conectar(); //conectando
        
        DeleteNasTables deletandoporid = new DeleteNasTables(conexaoSQLite);
        deletandoporid.excluirCategoria(idCategoria); // ira excluir o usuario pelo id de numero 2
        
    }
    
/*
    public void adicionarSubcategoria(String nomeSubCategoria, int idSubCategoria){
        SubCategoria subCategoria = new SubCategoria(idSubCategoria, nomeSubCategoria);
        this.subCategorias.add(subCategoria);
    }

    public void listarSubCategorias(){
        System.out.println("Categoria " + this. nome);
        for(SubCategoria subcategoria: subCategorias){
            System.out.println("    " + this.id + "." + subcategoria.getId() + " - " + subcategoria.getNome());
        }
    }
    
    
    
    
    */
    
    
}
