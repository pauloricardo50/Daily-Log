/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author PAULOR RICARDO GAMEPLAYS E JARDIELMA QUEIROZ DE LIMA
 */
public class DeleteNasTables 
{
    private Conexao conexaoSQLite;
    public DeleteNasTables(Conexao pConexaoSQLite) 
    {
        this.conexaoSQLite = pConexaoSQLite;
    }

    public DeleteNasTables() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //EXCLUIR USUARIO POR ID
    public void excluirUsuario(int idDeletado)
    {
        Conexao conexaoSQLite = new Conexao(); // criando conexao
        conexaoSQLite.conectar(); //conectando 
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        
        String sqlDelete = "DELETE FROM tbl_usuario"
                +" WHERE id = ?;";
        
        try
        {
            preparedStatement = conexaoSQLite.criarPreparedStatement(sqlDelete);
            preparedStatement.setInt(1,idDeletado);
            int totalLinhasDeletadas = preparedStatement.executeUpdate();
            System.out.println("FORAM DELETADOS: " + totalLinhasDeletadas + " REGISTROS" );
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                preparedStatement.close();
                conexaoSQLite.desconectar();
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }
                
    }
    
    // EXCLUIR ATIVIDADE POR ID 
    public void excluirAtividade (int idDeletado)
    {
        Conexao conexaoSQLite = new Conexao(); // criando conexao
        conexaoSQLite.conectar(); //conectando 
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        
        String sqlDelete = "DELETE FROM tbl_atividade"
                +" WHERE id = ?;";
        
        try
        {
            preparedStatement = conexaoSQLite.criarPreparedStatement(sqlDelete);
            preparedStatement.setInt(1,idDeletado);
            int totalLinhasDeletadas = preparedStatement.executeUpdate();
            System.out.println("FORAM DELETADOS: " + totalLinhasDeletadas + " REGISTROS" );
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                preparedStatement.close();
                conexaoSQLite.desconectar();
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }
    }
    
    // EXCLUIR EXPEDIENTE POR ID 
    public void excluirExpediente (int idDeletado)
    {
        Conexao conexaoSQLite = new Conexao(); // criando conexao
        conexaoSQLite.conectar(); //conectando 
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        
        String sqlDelete = "DELETE FROM tbl_expediente"
                +"WHERE id = ?;";
        
        try
        {
            preparedStatement = conexaoSQLite.criarPreparedStatement(sqlDelete);
            preparedStatement.setInt(0,idDeletado);
            int totalLinhasDeletadas;
            totalLinhasDeletadas = preparedStatement.executeUpdate();
            System.out.println("FORAM DELETADOS: " + totalLinhasDeletadas + " REGISTROS" );
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                preparedStatement.close();
                conexaoSQLite.desconectar();
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }
    
    }
    // EXCLUIR CATEGORIA POR ID 
    public void excluirCategoria (int idDeletado)
    {
        Conexao conexaoSQLite = new Conexao(); // criando conexao
        conexaoSQLite.conectar(); //conectando 
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        
        String sqlDelete = "DELETE FROM tbl_categoria"
                +"WHERE id = ?;";
        try
        {
            preparedStatement = conexaoSQLite.criarPreparedStatement(sqlDelete);
            preparedStatement.setInt(0,idDeletado);
            int totalLinhasDeletadas;
            totalLinhasDeletadas = preparedStatement.executeUpdate();
            System.out.println("FORAM DELETADOS: " + totalLinhasDeletadas + " REGISTROS" );
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                preparedStatement.close();
                conexaoSQLite.desconectar();
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }  
    }
}
