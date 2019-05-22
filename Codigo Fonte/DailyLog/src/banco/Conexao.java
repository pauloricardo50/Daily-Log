/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Jardielma e Paulo Ricardo
 */


/**
 * Classe para conectar ao banco de dados mysql
*/  
public class Conexao 
{
    //Estancia o objeto
    private static Connection conexao;

    /**
     * Metodo utilizado para retornar a conexão com o banco de dados mysql
     * @return 
     */  
    // função que retorna sempre a mesma instância do objeto
    
    public static synchronized Connection conectar() throws ClassNotFoundException 
    {
         //Conectando ao banco
        try {
           if (conexao == null){
                Class.forName("com.mysql.jdbc.Driver");
                conexao =  DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/daylog","root","");
                //Conectado.
           }
           else{
               return conexao;
           }
        }
        catch(SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }    
        return conexao;
    }
       
    /**
     * Metodo utilizada para desconectar ao banco de dados mysql
     * @param mysql
     * @return 
     */   
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
    
    /**
     * Metodo utilizada para executar as consultas no banco de dados mysql
     * @param sql
     * @return 
     */   
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
    
    /**
     * Metodo utilizada para executar as comandos que não retornam dados
     * @param sql
     * @return 
     */   
    public static int executeUpdateSql(String sql) 
    {
        //preparando para executar sql
        try {
            PreparedStatement ps = Conexao.conexao.prepareStatement(sql);
            //Executa a instrução
            ps.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            //sql executado
            ResultSet rs = ps.getGeneratedKeys();
            int resultado = 0;
            if(rs.next()){
                resultado = rs.getInt(1);
            }
            return resultado;
        }
        catch(SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }
}
