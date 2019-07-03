/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import banco.Conexao;
import dailylog.Atividade;
import dailylog.ParticipacaoAtividade;
import static java.lang.System.out;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jardielma e Paulo Ricardo
 */
public class AtividadeBD 
{
    public  ResultSet rs;
    
     //Classe utilizada para buscar 1 usuário
    public Atividade buscar(int idAtividade){
        //Preparando váriaveis e Sql
        Atividade atividade = new Atividade();
        String sql = "select data,descricao,horarioFim,horarioInicio,id_expediente,id_subcategoria,id_usuario,titulo from tbl_atividade where flag_ativo = 'A' and id_atividade = "+idAtividade;
        
        try {
           //verifica se está conectado, caso não esteja conecta
           Conexao.conectar();
           rs = Conexao.executeQuerySql(sql);
//           if(rs.first()== false){
//            //Caso o usuário não existe retorna null
//            return null;
//           }
           while(rs.next()){
                //Recupera valor referente ao nome
                 atividade.setTitulo(rs.getString("titulo"));
                 atividade.setDescricao(rs.getString("descricao"));
                 atividade.setHorarioInicial(rs.getTime("horarioInicio").toString());
                 atividade.setHorarioFinal(rs.getTime("horarioFim").toString());
                 atividade.setData(rs.getDate("data").toString());
                 atividade.setIdUsuario(rs.getInt("id_usuario"));
                 atividade.setIdExpediente(rs.getInt("id_expediente"));
                 atividade.setIdSubCategoria(rs.getInt("id_subcategoria"));
                 atividade.setId(idAtividade);
                 
            }
           ParticipacaoAtividadeBD participacaoAtividadeBD = new ParticipacaoAtividadeBD();
           atividade.setlistaParticipacaoAtividade(participacaoAtividadeBD.listar(idAtividade));
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return atividade;
        
    }
    
   public Atividade salvar(Atividade atividade,int idUsuario, int idExpediente, int idSubCategoria){
        String sql = "";
        //Caso o usuário já exista ele possuí ID
        if(atividade.getId() > 0 ){
            //atualiza o usuario
            sql = "UPDATE daylog.tbl_atividade \n" +
                "SET titulo = '"+atividade.getTitulo()+"', descricao='"+atividade.getDescricao()+"',\n" +
                "horarioInicio='"+atividade.getHorarioInicial()+"',horarioFim='"+atividade.getHorarioFinal()+"',\n" +
                "data='"+atividade.getData()+"',\n" +
                "id_usuario='"+atividade.getIdUsuario()+"',\n" +
                    "id_expediente='"+atividade.getIdUsuario()+"',\n" +
                    "id_subcategoria='"+atividade.getIdUsuario()+"'\n" +
                "where id_atividade='"+atividade.getId()+"'";
        }
        else{
            //caso não seja atualização ele cria o usuário
            //Preparando váriaveis e Sql
            sql = "INSERT INTO `daylog`.`tbl_atividade` "
                    + "(`titulo`, `descricao`, `horarioInicio`, `horarioFim`, `data`, `id_usuario`, `id_expediente`, `id_subcategoria`, flag_ativo) "
                    + "VALUES ('"+atividade.getTitulo()+"', '"+atividade.getDescricao()+"', "
                    + "'"+atividade.getHorarioInicial()+"', '"+atividade.getHorarioFinal()+"', "
                    + "'"+atividade.getData()+"', '"+idUsuario+"', "
                    + "'"+idExpediente+"', '"+idSubCategoria+"', 'A');";
           
        }
        try {
           //verifica se está conectado, caso não esteja conecta
           //if(Conexao.conectar().isClosed()){
              // Conexao.conectar(true);
           //}
           Conexao.conectar();
           atividade.setId(Conexao.executeUpdateSql(sql));
        }
        catch(ClassNotFoundException e) {
            System.out.println(e);
        }
        return atividade;   
    }
   
   public void deletar(int idAtividade){
        String sql = "";
        sql = "delete from tbl_atividade where id_atividade = "+idAtividade;
        try {
           //verifica se está conectado, caso não esteja conecta
           //if(Conexao.getConexao().isClosed()){
               //Conexao.conectar(true);
           //}
           Conexao.conectar();
           Conexao.executeUpdateSql(sql);
        }
        catch(ClassNotFoundException e) {
            System.out.println(e);
        }  
    }
   
   //Lista as permissões de acordo com o perfil informado
    public ArrayList<Atividade> listar(int idUsuario){
     ArrayList<Atividade> listaRetorno = new ArrayList<>();
        //Preparando váriaveis e Sql
        Atividade atividade = new Atividade();
        String sql = "select * from tbl_atividade where id_usuario  = "+idUsuario;
        try {
           //verifica se está conectado, caso não esteja conecta
           Conexao.conectar();
           ResultSet rs = Conexao.executeQuerySql(sql);
           while(rs.next()){
                atividade = new Atividade();
                //Recupera valor referente ao nome
                atividade.setId(rs.getInt("id_atividade"));
                atividade.setDescricao(rs.getString("descricao"));
                
                atividade.setData(rs.getString("data"));
                atividade.setHorarioInicial(rs.getString("horarioInicio"));
                atividade.setHorarioFinal(rs.getString("horarioFim"));
                
                atividade.setTitulo(rs.getString("titulo"));
                atividade.setIdSubCategoria(rs.getInt("id_subcategoria"));
                atividade.setIdExpediente(rs.getInt("id_Expediente"));
                atividade.setIdUsuario(rs.getInt("id_Usuario"));
                
                 listaRetorno.add(atividade);
            }
           return listaRetorno;
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
}
