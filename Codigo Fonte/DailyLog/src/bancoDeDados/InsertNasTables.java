/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoDeDados;
import bancoDeDados.ConexaoSQLite;
import dailylog.Atividade;
import dailylog.Categoria;
import dailylog.Expediente;
import dailylog.Main;
import dailylog.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author PAULOR RICARDO GAMEPLAYS E JARDIELMA QUEIROZ DE LIMA
 */
public class InsertNasTables 
{
    private final ConexaoSQLite conexaoSQLite;
    
    public InsertNasTables(ConexaoSQLite pConexaoSQLite) 
    {
        this.conexaoSQLite = pConexaoSQLite;
    }
    
        
    public void InserirnaTabelaUsuario(Usuario pessoa1) 
    {
        ConexaoSQLite conexaoSQLite = new ConexaoSQLite(); // criando conexao
        conexaoSQLite.conectar(); //conectando 
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        
        //estamos assumindo que a tabela usuario ja esta criada.
        //InsertNasTables inserindo = new InsertNasTables(conexaoSQLite); // criando conexao
               
        String sqlInsert;
        sqlInsert = "INSERT INTO tbl_usuario("
                +"id,"
                +"idade,"
                +"horarioPadraoInicial,"
                +"horarioPadraoFinal,"
                +"nome,"
                +"senha,"
                +"tamanhoFonte,"
                +"autoContraste"
                +") VALUES(?,?,?,?,?,?,?,?)"
                +";";
        preparedStatement = conexaoSQLite.criarPreparedStatement(sqlInsert);
        try
        {
            preparedStatement.setInt(1,pessoa1.getId());
            preparedStatement.setInt(2,pessoa1.getIdade());
            preparedStatement.setString(3,pessoa1.getHorarioPadraoInicial());
            preparedStatement.setString(4,pessoa1.getHorarioPadraoFinal());
            preparedStatement.setString(5, pessoa1.getNome());
            preparedStatement.setString(6, pessoa1.getSenha());
            preparedStatement.setInt(7,pessoa1.getTamanhoFonte());
            preparedStatement.setBoolean(8,pessoa1.isAutoContraste());
            
            int resultado = preparedStatement.executeUpdate();
            if (resultado == 1) 
            {
                System.out.println("Usuario Inserido!");
            } 
            else 
            {
                System.out.println("Usuario não inserido! =[");
            }
            
        }
        catch (SQLException e)
        {
            System.out.println("" + e);
            System.out.println("Pessoa não inserida! =[");
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
    
    public boolean InserirnaTabelaAtividade(Atividade atividade) 
    {
        ConexaoSQLite conexaoSQLite = new ConexaoSQLite(); // criando conexao
        conexaoSQLite.conectar(); //conectando 
        ResultSet resultSet = null;
        boolean result = false;
        PreparedStatement preparedStatement = null;
        
        //estamos assumindo que a tabela usuario ja esta criada.
        //InsertNasTables inserindo = new InsertNasTables(conexaoSQLite); // criando conexao
               
        String sqlInsert = "INSERT INTO tbl_atividade("
                +"id,"
                +"titulo,"
                +"descricao,"
                +"horarioInicial,"
                +"horarioFinal,"
                +"idCategoria,"
                +"idSubCategoria"
                +") VALUES(?,?,?,?,?,?,?)"
                +";";
        preparedStatement = conexaoSQLite.criarPreparedStatement(sqlInsert);
        try
        {
            preparedStatement.setInt(1,atividade.getId());
            preparedStatement.setString(2,atividade.getTitulo());
            preparedStatement.setString(3,atividade.getDescricao());
            preparedStatement.setString(4,atividade.getHorarioInicial());
            preparedStatement.setString(5,atividade.getHorarioFinal());
            preparedStatement.setInt(6,atividade.getIdCategoria());
            preparedStatement.setInt(7,atividade.getIdSubCategoria());
                        
            int resultado = preparedStatement.executeUpdate();
            if (resultado == 1) 
            {
                result = true;
            } 
        }
        catch (SQLException e)
        {
            System.out.println("Atividade não Inserida! =[");
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
       return result; 
    }
    
    public boolean InserirnaTabelaCategoria(Categoria categoria) 
    {
        ConexaoSQLite conexaoSQLite = new ConexaoSQLite(); // criando conexao
        conexaoSQLite.conectar(); //conectando 
        ResultSet resultSet = null;
         boolean result = false;
        PreparedStatement preparedStatement = null;
        
        //estamos assumindo que a tabela usuario ja esta criada.
        //InsertNasTables inserindo = new InsertNasTables(conexaoSQLite); // criando conexao
               
        String sqlInsert = "INSERT INTO tbl_categoria("
                +"id,"
                +"nome"
                + ") VALUES(?,?)"
                +";";
        preparedStatement = conexaoSQLite.criarPreparedStatement(sqlInsert);
        try
        {
            preparedStatement.setInt(1,categoria.getId());
            preparedStatement.setString(2,categoria.getNome());
                        
            int resultado = preparedStatement.executeUpdate();
            if (resultado == 1) 
            {
                result = true;
            } 
        }
        catch (SQLException e)
        {
            System.out.println("Categoria não Inserida! =[");
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
        return result;
    }
    
    public void InserirnaTabelaExpediente(Expediente expediente1) 
    {
        ConexaoSQLite conexaoSQLite = new ConexaoSQLite(); // criando conexao
        conexaoSQLite.conectar(); //conectando 
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        
        //estamos assumindo que a tabela usuario ja esta criada.
        //InsertNasTables inserindo = new InsertNasTables(conexaoSQLite); // criando conexao
               
        String sqlInsert = "INSERT INTO tbl_expediente("
                +"id,"
                +"data,"
                +"horarioInicial,"
                +"horarioFinal"
                + ") VALUES(?,?,?,?)"
                +";";
        preparedStatement = conexaoSQLite.criarPreparedStatement(sqlInsert);
        try
        {
            preparedStatement.setInt(1,expediente1.getId());
            preparedStatement.setString(2,expediente1.getData());
            preparedStatement.setString(3,expediente1.getHorarioInicial());
            preparedStatement.setString(4,expediente1.getHorarioFinal());
                        
            int resultado = preparedStatement.executeUpdate();
            if (resultado == 1) 
            {
                System.out.println("Expediente Inserido!");
            } 
            else 
            {
                System.out.println("Expediente não Inserido! =[");
            }
            
        }
        catch (SQLException e)
        {
            System.out.println("Expediente não Inserido! =[");
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
