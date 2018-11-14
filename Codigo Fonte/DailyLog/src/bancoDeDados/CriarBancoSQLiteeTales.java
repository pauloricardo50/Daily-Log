/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoDeDados;

import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author PAULOR RICARDO GAMEPLAYS E JARDIELMA QUEIROZ DE LIMA
 */
public class CriarBancoSQLiteeTales 
{

    private final ConexaoSQLite conexaoSQLite;

    public CriarBancoSQLiteeTales(ConexaoSQLite pConexaoSQLite) 
    {
        this.conexaoSQLite = pConexaoSQLite;
    }


    public void criarTabelaUsuario() 
    {

        String sql = "CREATE TABLE IF NOT EXISTS tbl_usuario"
                + "("
                + "id integer PRIMARY KEY,"
                + "idade int NOT NULL,"
                + "horarioPadraoInicial text NOT NULL,"
                + "horarioPadraoFinal text NOT NULL,"
                + "nome text NOT NULL,"
                + "senha text NOT NULL,"
                + "tamanhoFonte int NOT NULL,"
                + "autoContraste boolean"
                + ");";

        //executando o sql de criar tabelas
        boolean conectou = false;

        try 
        {
            conectou = this.conexaoSQLite.conectar();
            
            Statement stmt = this.conexaoSQLite.criarStatement();
            
            stmt.execute(sql);
            
            System.out.println("Tabela Usuario criada!");

        } 
        catch (SQLException e) 
        {
            System.out.println("Tabela Usuario not criada fion!");
        } 
        finally 
        {
            if(conectou)
            {
                this.conexaoSQLite.desconectar();
            }
        }

    }
    
    
    public void criarTabelaAtividade() 
    {

        String sql = "CREATE TABLE IF NOT EXISTS tbl_atividade"
                + "("
                + "id integer PRIMARY KEY,"
                + "titulo text NOT NULL,"
                + "descricao text NOT NULL,"
                + "horarioInicial text NOT NULL,"
                + "horarioFinal text NOT NULL,"
                + "idCategoria  int NOT NULL,"
                + "idSubCategoria int NOT NULL"
                + ");";

        //executando o sql de criar tabelas
        boolean conectou = false;

        try 
        {
            conectou = this.conexaoSQLite.conectar();
            
            Statement stmt = this.conexaoSQLite.criarStatement();
            
            stmt.execute(sql);
            
            System.out.println("Tabela Atividade criada!");

        } 
        catch (SQLException e) 
        {
            System.out.println("Tabela Atividade not criada fion!");
        } 
        finally 
        {
            if(conectou)
            {
                this.conexaoSQLite.desconectar();
            }
        }

    }
    
    public void criarTabelaCategoria() 
    {

        String sql = "CREATE TABLE IF NOT EXISTS tbl_categoria"
                + "("
                + "id integer PRIMARY KEY,"
                + "nome text NOT NULL"
                + ");";

        //executando o sql de criar tabelas
        boolean conectou = false;

        try {
            conectou = this.conexaoSQLite.conectar();
            
            Statement stmt = this.conexaoSQLite.criarStatement();
            
            stmt.execute(sql);
            
            System.out.println("Tabela Categoria criada!");

        } catch (SQLException e) {
            System.out.println("Tabela Atividade Nao  criada!");
        } finally {
            if(conectou){
                this.conexaoSQLite.desconectar();
            }
        }

    }
    
    public void criarTabelaExpediente() 
    {
        String sql = "CREATE TABLE IF NOT EXISTS tbl_expediente"
                + "("
                + "id integer PRIMARY KEY,"
                + "data text NOT NULL,"
                + "horarioInicial text NOT NULL,"
                + "horarioFinal text NOT NULL"
                + ");";

        //executando o sql de criar tabelas
        boolean conectou = false;

        try {
            conectou = this.conexaoSQLite.conectar();
            
            Statement stmt = this.conexaoSQLite.criarStatement();
            
            stmt.execute(sql);
            
            System.out.println("Tabela Expediente criada!");

        } catch (SQLException e) {
            System.out.println("Tabela Expediente nao criada!");
        } finally {
            if(conectou){
                this.conexaoSQLite.desconectar();
            }
        }

    }

}
