/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PRFERREIRA e JQLIMA
 */
public class Conexao 
{
    
    private static Connection conexao;

    /**
     * Conecta a um banco de dados (cria o banco se ele não existir)
     *
     * @return
     */
    public boolean conectar() 
    {

        try {

            String url = "jdbc:sqlite:banco_de_dados/banco_sqlite.db";

            this.conexao = DriverManager.getConnection(url);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }

        System.out.println("conectou!!!");

        return true;
    }
    
    
    

    public boolean desconectar() {

        try {
            if (this.conexao.isClosed()) {
                this.conexao.close();
            }

        } catch (SQLException e) {

            System.err.println(e.getMessage());
            return false;
        }
        System.out.println("desconectou!!!");
        return true;
    }

    /**
     * Criar os statements para nossos sqls serem executados
     *
     * @return
     */
    public Statement criarStatement() {
        try {
            return this.conexao.createStatement();
        } catch (SQLException e) {
            return null;
        }
    }
    
    /**
     * Criar os statements para nossos sqls serem executados
     *
     * @param sql
     * @return
     */
    public PreparedStatement criarPreparedStatement(String sql) {
        try {
            return this.conexao.prepareStatement(sql);
        } catch (SQLException e) {
            System.out.println("" + e);
            return null;
        }
    }
    
    

    public static Connection getConexao() {
        return Conexao.conexao;
    }
    
    
    
    
    //Classe utilizada para conectar ao banco de dados mysql - Testada OK
    public static void conectar(boolean mysql) throws ClassNotFoundException 
    {
        //Conectando ao banco
        try {
            Class.forName("com.mysql.jdbc.Driver");
           Conexao.conexao =  DriverManager.getConnection("jdbc:mysql://127.0.0.1:3388/daylog","root","");
           //Conectado.
        }
        catch(SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
        
    }
    
    //Classe utilizada para desconectar ao banco de dados mysql - Testada OK
    public static boolean desconectar(boolean mysql) {
        //Preparando para desconectar!
        try {
            if (Conexao.conexao.isClosed()) {
                Conexao.conexao.close();
            }

        } catch (SQLException e) {

            System.err.println(e.getMessage());
            return false;
        }
        //desconectou!
        return true;
    }

    //Classe utilizada para conectar ao banco de dados mysql - Testada OK
    public static ResultSet executeQuerySql(String sql) 
    {
        //preparando para executar sql
        try {
            PreparedStatement ps = Conexao.conexao.prepareStatement(sql);
            //Executa a instrução
            ResultSet rs = ps.executeQuery(sql);
            //sql executado
            return rs;
        }
        catch(SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
        
    }
    
    //Classe utilizada para conectar ao banco de dados mysql - Testada OK
    public static int executeUpdateSql(String sql) 
    {
        //preparando para executar sql
        try {
            PreparedStatement ps = Conexao.conexao.prepareStatement(sql);
            //Executa a instrução
            int resultado = ps.executeUpdate(sql);
            //sql executado
            return resultado;
        }
        catch(SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
        
    }
}
