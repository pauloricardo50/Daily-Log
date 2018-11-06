/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailylog;

import bancoDeDados.ConexaoSQLite;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import bancoDeDados.CriarBancoSQLiteeTales;
import bancoDeDados.DeleteNasTables;
import bancoDeDados.InsertNasTables;
import bancoDeDados.SelectNasTables;
import bancoDeDados.UpdatenasTabels;
import dailylog.Usuario;
import dailylog.Atividade;
import dailylog.Expediente;
import dailylog.Categoria;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author PAULOR RICARDO GAMEPLAYS E JARDIELMA QUEIROZ DE LIMA
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ConexaoSQLite conexaoSQLite = new ConexaoSQLite(); // criando conexao
        conexaoSQLite.conectar(); //conectando 
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        
        // criando o banco
        CriarBancoSQLiteeTales criarBancoSQLite = new CriarBancoSQLiteeTales(conexaoSQLite);
        
        // criando tabelas essenciais 
        // NÃO VAI CRIAR AS TABELAS PQ ELAS JA FORAM CRIADAS NA PRIMEIRA VEZ QUE RODEI O PROGRAMA, ASSIM COMO NOS OUTROS=D
        criarBancoSQLite.criarTabelaUsuario();
        criarBancoSQLite.criarTabelaAtividade();
        criarBancoSQLite.criarTabelaCategoria();
        criarBancoSQLite.criarTabelaExpediente();
        
        //invocando usuarios
        Usuario pessoa1 = new Usuario();
        pessoa1.setId(3);
        pessoa1.setIdade(28);
        pessoa1.setHorarioPadraoInicial("13:00");
        pessoa1.setHorarioPadraoFinal("19:00");
        pessoa1.setNome("Carlos");
        pessoa1.setSenha("123");
        pessoa1.setTamanhoFonte(12);
        pessoa1.setAutoContraste(true);
         
        Usuario pessoa2 = new Usuario();
        pessoa2.setId(4);
        pessoa2.setIdade(20);
        pessoa2.setHorarioPadraoInicial("12:00");
        pessoa2.setHorarioPadraoFinal("16:00");
        pessoa2.setNome("Paulo");
        pessoa2.setSenha("123");
        pessoa2.setTamanhoFonte(12);
        pessoa2.setAutoContraste(true);
        
        Usuario pessoa3 = new Usuario();
        pessoa3.setId(4);
        pessoa3.setIdade(21);
        pessoa3.setHorarioPadraoInicial("12:00");
        pessoa3.setHorarioPadraoFinal("16:00");
        pessoa3.setNome("Jardielma");
        pessoa3.setSenha("123");
        pessoa3.setTamanhoFonte(12);
        pessoa3.setAutoContraste(true);
        
        // objetos criados, hora de inserir
        conexaoSQLite.conectar();
        InsertNasTables tabelaUsuario = new InsertNasTables(conexaoSQLite);
        tabelaUsuario.InserirnaTabelaUsuario(pessoa1);
        tabelaUsuario.InserirnaTabelaUsuario(pessoa2);
        tabelaUsuario.InserirnaTabelaUsuario(pessoa3);
        
        
        //INVOCADO ATIVIDADES
        
        Atividade atividade1 = new Atividade();
        atividade1.setId(1);
        atividade1.setTitulo("Reunião com o PJE");
        atividade1.setDescricao("Reuniao para homologação da versão 2.0");
        atividade1.setHorarioInicial("13:30");
        atividade1.setHorarioFinal("14:30");
        atividade1.setIdCategoria(1);
        atividade1.setIdSubCategoria(1);
        
        Atividade atividade2 = new Atividade();
        atividade2.setId(2);
        atividade2.setTitulo("Reunião com o PROJUDI");
        atividade2.setDescricao("Reuniao para homologação da versão 1.0");
        atividade2.setHorarioInicial("14:40");
        atividade2.setHorarioFinal("18:30");
        atividade2.setIdCategoria(2);
        atividade2.setIdSubCategoria(2);
        
        // INSERINDO ATIVIDADES
        
        conexaoSQLite.conectar();
        InsertNasTables tabelaAtividade = new InsertNasTables(conexaoSQLite);
        tabelaAtividade.InserirnaTabelaAtividade(atividade1);
        tabelaAtividade.InserirnaTabelaAtividade(atividade2);
        
        //invocando expedientes
        Expediente expediente1 = new Expediente();
        expediente1.setId(1);
        expediente1.setData("11/09/2001");
        expediente1.setHorarioInicial("12:00");
        expediente1.setHorarioFinal("19:30");
        
        Expediente expediente2 = new Expediente();
        expediente2.setId(2);
        expediente2.setData("11/11/2011");
        expediente2.setHorarioInicial("12:00");
        expediente2.setHorarioFinal("19:30");
        
        // INSERIDNDO EXPEDIENTES
        InsertNasTables tabelaexpediente = new InsertNasTables(conexaoSQLite);
        tabelaexpediente.InserirnaTabelaExpediente(expediente1);
        tabelaexpediente.InserirnaTabelaExpediente(expediente2);
        
        
        //invocando categorias
        Categoria categoria1 = new Categoria();
        categoria1.setId(50);
        categoria1.setNome("Reuniao");
        
        Categoria categoria2 = new Categoria();
        categoria2.setId(51);
        categoria2.setNome("Treinamento");
        
        Categoria categoria3 = new Categoria();
        categoria3.setId(52);
        categoria3.setNome("Evento");
        
        Categoria categoria4 = new Categoria();
        categoria4.setId(53);
        categoria4.setNome("Comunicação");
        
        Categoria categoria5 = new Categoria();
        categoria5.setId(54);
        categoria5.setNome("Contrato");
        
        Categoria categoria6 = new Categoria();
        categoria5.setId(55);
        categoria5.setNome("Outro");
       
        // INSERINDO CATEGORIAS
        InsertNasTables tabelaCategoria = new InsertNasTables(conexaoSQLite);
        tabelaCategoria.InserirnaTabelaCategoria(categoria1);
        tabelaCategoria.InserirnaTabelaCategoria(categoria2);
        tabelaCategoria.InserirnaTabelaCategoria(categoria3);
        tabelaCategoria.InserirnaTabelaCategoria(categoria4);
        tabelaCategoria.InserirnaTabelaCategoria(categoria5);
        tabelaCategoria.InserirnaTabelaCategoria(categoria6);
       
        // vamos consulta-los - Ira exibir todos os usuarios,atividades e categorias
        categoria1.bucarCategoria();
        pessoa1.bucarUsuario();
        expediente1.bucarExpediente();
        
        SelectNasTables consulta = new SelectNasTables(conexaoSQLite);
        //consulta.exibirUsuario();
        consulta.exibirAtividades();
        consulta.exibirExpediente();
        //consulta.exibirCategorias();
        
        // vamos agora deletalos por id
        DeleteNasTables deletandoporid = new DeleteNasTables(conexaoSQLite);
        deletandoporid.excluirUsuario(2); // ira excluir o usuario pelo id de numero 2
        
        deletandoporid.excluirAtividade(1); // ira excluir a categoria pelo id de numero 1*/
        
        UpdatenasTabels atualizadotabelasid = new UpdatenasTabels(conexaoSQLite);
        atualizadotabelasid.UpdateTabelaAtividade(2);
        atualizadotabelasid.atualizandoUsuporID(3);
        atualizadotabelasid.updateTabelaCategoria(51);
        atualizadotabelasid.updateTabelaExpediente(2);
        
    }
}

    

