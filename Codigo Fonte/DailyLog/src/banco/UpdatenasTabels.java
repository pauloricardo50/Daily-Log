/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import dailylog.Main;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author paulo
 */
public class UpdatenasTabels {
    
    private final Conexao conexaoSQLite;
    
    /**
     *
     * @param pConexaoSQLite
     */
    public UpdatenasTabels(Conexao pConexaoSQLite) {
        this.conexaoSQLite = pConexaoSQLite;
    }
    
    public void atualizandoUsuporID(int idDesejado) 
    {
        Conexao conexaoSQLite = new Conexao(); // criando conexao
        conexaoSQLite.conectar(); //conectando 
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        
        //estamos assumindo que a tabela usuario ja esta criada.
        //InsertNasTables inserindo = new InsertNasTables(conexaoSQLite); // criando conexao
               
        String sqlInsert;
        sqlInsert = "UPDATE tbl_usuario"
                + " SET "
                + " idade = ?,"
                + " horarioPadraoInicial = ?,"
                + " horarioPadraoFinal = ?,"
                + " nome = ?,"
                + " tamanhoFonte = ?,"
                + " autoContraste = ?"
                + " WHERE id = ? ";
        
        preparedStatement = conexaoSQLite.criarPreparedStatement(sqlInsert);
        try
        {
            preparedStatement.setInt(1,58);
            preparedStatement.setString(2,"7:30");
            preparedStatement.setString(3,"11:30");
            preparedStatement.setString(4,"Maria do Bairro");
            preparedStatement.setInt(5,14);
            preparedStatement.setBoolean(6,false);
            preparedStatement.setInt(7, idDesejado); // pegando o id e atualizando
            
            preparedStatement.executeUpdate();
            System.out.println("Pessoa Atualizada =D");

        }
        catch (SQLException e)
        {
            System.out.println("" + e);
            System.out.println("Pessoa não atualizada! =[");
        }
        finally
        {
            if(preparedStatement != null)
            {
                try 
                {
                    preparedStatement.close();
                } 
                catch (SQLException ex) 
                {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                conexaoSQLite.desconectar();
            }
        }
        
    }
    
    public void updateTabelaAtividade(int idDesejado) 
    {
        Conexao conexaoSQLite = new Conexao(); // criando conexao
        conexaoSQLite.conectar(); //conectando 
        PreparedStatement preparedStatement = null;
        
        //estamos assumindo que a tabela usuario ja esta criada.
        //InsertNasTables inserindo = new InsertNasTables(conexaoSQLite); // criando conexao
               
        String sqlInsert;
        sqlInsert = "UPDATE tbl_atividade"
                + " SET "
                + " titulo = ?," 
                + " descricao = ?,"
                + " horarioInicial = ?,"
                + " horarioFinal = ?"
                + " WHERE id = ? ";
        
        preparedStatement = conexaoSQLite.criarPreparedStatement(sqlInsert);
        try
        {
            preparedStatement.setString(1,"Comelança");
            preparedStatement.setString(2,"Aniversariantes do Mes");
            preparedStatement.setString(3,"11:30");
            preparedStatement.setString(4,"17:00");
            preparedStatement.setInt(5, idDesejado); // pegando o id e atualizando
            
            
            preparedStatement.executeUpdate();
            System.out.println("Atividade Atualizada =D");

            
        }
        catch (SQLException e)
        {
            System.out.println("" + e);
            System.out.println("Atividade não atualizada! =[");
        }
        finally
        {
            if(preparedStatement != null)
            {
                try 
                {
                    preparedStatement.close();
                } 
                catch (SQLException ex) 
                {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                conexaoSQLite.desconectar();
            }
        }
        
    }
    
    public void updateTabelaCategoria(int idDesejado) 
    {
        Conexao conexaoSQLite = new Conexao(); // criando conexao
        conexaoSQLite.conectar(); //conectando 
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        
        //estamos assumindo que a tabela usuario ja esta criada.
        //InsertNasTables inserindo = new InsertNasTables(conexaoSQLite); // criando conexao
               
        String sqlInsert;
        sqlInsert = "UPDATE tbl_categoria"
                + " SET "
                + " nome = ? " 
                + " WHERE id = ? ";
        
        preparedStatement = conexaoSQLite.criarPreparedStatement(sqlInsert);
        try
        {
            preparedStatement.setString(1,"Joao");
            preparedStatement.setInt(2, idDesejado); // pegando o id e atualizando
            
            
            preparedStatement.executeUpdate();
            System.out.println("Categoria Atualizada =D");  
        }
        catch (SQLException e)
        {
            System.out.println("" + e);
            System.out.println("Categoria Nao Atualizada =[");
        }
        finally
        {
            if(preparedStatement != null)
            {
                try 
                {
                    preparedStatement.close();
                } 
                catch (SQLException ex) 
                {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                conexaoSQLite.desconectar();
            }
        }
    }
    
    public void updateTabelaExpediente(int idDesejado) 
    {
        Conexao conexaoSQLite = new Conexao(); // criando conexao
        conexaoSQLite.conectar(); //conectando 
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        
        //estamos assumindo que a tabela usuario ja esta criada.
        //InsertNasTables inserindo = new InsertNasTables(conexaoSQLite); // criando conexao
               
        String sqlInsert;
        sqlInsert = "UPDATE tbl_expediente"
                + " SET "
                + " data = ?," 
                + " horarioInicial = ?,"
                + " horarioFinal = ?"
                + " WHERE id = ? ";
        
        preparedStatement = conexaoSQLite.criarPreparedStatement(sqlInsert);
        try
        {
            preparedStatement.setString(1,"13/13/13");
            preparedStatement.setString(2,"12:80");
            preparedStatement.setString(3,"12:90");
            preparedStatement.setInt(4, idDesejado); // pegando o id e atualizando
            
            
            preparedStatement.executeUpdate();
            System.out.println("Expediente Atualizado =D");

            
        }
        catch (SQLException e)
        {
            System.out.println("" + e);
            System.out.println("Expediente não atualizado! =[");
        }
        finally
        {
            if(preparedStatement != null)
            {
                try 
                {
                    preparedStatement.close();
                } 
                catch (SQLException ex) 
                {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                conexaoSQLite.desconectar();
            }
        }
    }
}
