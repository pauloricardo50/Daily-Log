/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoDeDados;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author PAULOR RICARDO GAMEPLAYS E JARDIELMA QUEIROZ DE LIMA
 */
public class SelectNasTables {
    private final ConexaoSQLite conexaoSQLite;
    public SelectNasTables(ConexaoSQLite pConexaoSQLite){
        this.conexaoSQLite = pConexaoSQLite;
    }
    
    //exibir dados dos usuario
    public void exibirUsuario(){
        ConexaoSQLite conexaoSQLite = new ConexaoSQLite(); // criando conexao
        conexaoSQLite.conectar(); //conectando 
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        
        String sqlselect = "SELECT * FROM tbl_usuario";
        Statement statement;
        statement = conexaoSQLite.criarStatement();
        
        try{
            resultSet = statement.executeQuery(sqlselect);
            while(resultSet.next()){
                System.out.println("Dados dos Usuarios do Sistema: ");
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("NOME COMPLETO:  " + resultSet.getString("nome"));
                System.out.println("IDADE:  " + resultSet.getInt("idade"));
                System.out.println("-----------------------------");
                
            }
        }
        catch (SQLException e){
            System.out.println(""+e);
            System.out.println("Erro Misterioso");
        }
        finally{
            try{
                resultSet.close();
                statement.close();
                conexaoSQLite.desconectar();
            }
            catch (SQLException ex){
                System.out.println("Erro Misterioso");
            }
        }
        
     }
    
    public void exibirCategorias(){
        ConexaoSQLite conexaoSQLite = new ConexaoSQLite(); // criando conexao
        conexaoSQLite.conectar(); //conectando 
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        
        String sqlselect = "SELECT * FROM tbl_categoria";
        Statement statement;
        statement = conexaoSQLite.criarStatement();
        
        try{
            resultSet = statement.executeQuery(sqlselect);
            while(resultSet.next()){
                System.out.println("Categorias: ");
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("NOME DA CATEGORIA: " + resultSet.getString("nome"));
                System.out.println("-----------------------------");
                
            }
        }
        catch (SQLException e){
            System.out.println("Erro Misterioso");
        }
        finally{
            try{
                resultSet.close();
                statement.close();
                conexaoSQLite.desconectar();
            }
            catch (SQLException ex){
                System.out.println("Erro Misterioso");
            }
        }
        
     }
        
    public void exibirAtividades(){
        ConexaoSQLite conexaoSQLite = new ConexaoSQLite(); // criando conexao
        conexaoSQLite.conectar(); //conectando 
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        
        String sqlselect = "SELECT * FROM tbl_atividade";
        Statement statement;
        statement = conexaoSQLite.criarStatement();
        
        try{
            resultSet = statement.executeQuery(sqlselect);
            while(resultSet.next()){
                System.out.println("Atividade: ");
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("titulo"));
                System.out.println(resultSet.getString("descricao"));
                System.out.println(resultSet.getString("horarioInicial"));
                System.out.println(resultSet.getString("horarioFinal"));
                System.out.println("-----------------------------");
                
            }
        }
        catch (SQLException e){
            System.out.println("Erro Misterioso");
        }
        finally{
            try{
                resultSet.close();
                statement.close();
                conexaoSQLite.desconectar();
            }
            catch (SQLException ex){
                System.out.println("Erro Misterioso");
            }
        }
        
    }
    public void exibirExpediente(){
        ConexaoSQLite conexaoSQLite = new ConexaoSQLite(); // criando conexao
        conexaoSQLite.conectar(); //conectando 
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        
        String sqlselect = "SELECT * FROM tbl_expediente";
        Statement statement;
        statement = conexaoSQLite.criarStatement();
        
        try{
            resultSet = statement.executeQuery(sqlselect);
            while(resultSet.next()){
                System.out.println("Expediente: ");
                System.out.println(resultSet.getInt("id"));
                System.out.println(resultSet.getString("data"));
                System.out.println(resultSet.getString("horarioInicial"));
                System.out.println(resultSet.getString("horarioFinal"));
                System.out.println("-----------------------------");
                
            }
        }
        catch (SQLException e){
            System.out.println("Erro Misterioso");
        }
        finally{
            try{
                resultSet.close();
                statement.close();
                conexaoSQLite.desconectar();
            }
            catch (SQLException ex){
                System.out.println("Erro Misterioso");
            }
        }
    }
}
