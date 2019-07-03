/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import banco.Conexao;
import dailylog.Atividade;
import dailylog.ParticipacaoAtividade;
import dailylog.Perfil;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author 20151BSI0100
 */
public class ParticipacaoAtividadeBD {
    public  ResultSet rs;
    public ParticipacaoAtividade salvar(ParticipacaoAtividade participacaoAtividade){
        String sql = "";
        //Caso o usuário já exista ele possuí ID
        if(participacaoAtividade.getId() > 0 ){
            //atualiza o usuario
            //sql = "UPDATE `daylog`.`tbl_usuario` SET `id_perfil` = '"+user.getPerfil().getId()+"', `senha` = '"+user.getSenha()+"',`flag_ativo` = '"+user.getFlagAtivo()+"',`nome` = '"+user.getNome()+"' WHERE (`id_usuario` = '"+user.getId()+"');";
            sql = "UPDATE daylog.tbl_participacaoatividade \n" +
                "SET titulo = '"+participacaoAtividade.getTitulo()+"', descricao='"+participacaoAtividade.getDescricao()+"',\n" +
                "horarioInicial='"+participacaoAtividade.getHorarioInicial()+"',horarioFinal='"+participacaoAtividade.getHorarioFinal()+"',\n" +
                "dataInicial='"+participacaoAtividade.getDataInicial()+"',dataFinal='"+participacaoAtividade.getDataFinal()+"',\n" +
                "id_usuario='"+participacaoAtividade.getIdUsuario()+"'\n" +
                "where id_participacaoAtividade='"+participacaoAtividade.getId()+"'";
        }
        else{
            //caso não seja atualização ele cria o usuário
            //Preparando váriaveis e Sql
            sql = "INSERT INTO `daylog`.`tbl_participacaoatividade` "
                    + "(`titulo`, `descricao`, `horarioInicial`, `horarioFinal`, `dataInicial`, `id_atividade`,`dataFinal`,`id_usuario`) "
                    + "VALUES ('"+participacaoAtividade.getTitulo()+"', '"+participacaoAtividade.getDescricao()+"', "
                    + "'"+participacaoAtividade.getHorarioInicial()+"', '"+participacaoAtividade.getHorarioFinal()+"', "
                    + "'"+participacaoAtividade.getDataInicial()+"', '"+participacaoAtividade.getIdAtividade()+"', "
                    + "'"+participacaoAtividade.getDataFinal()+"','"+participacaoAtividade.getIdUsuario()+"');";
           
        }
        try {
           //verifica se está conectado, caso não esteja conecta
           //if(Conexao.conectar().isClosed()){
              // Conexao.conectar(true);
           //}
           Conexao.conectar();
           participacaoAtividade.setId(Conexao.executeUpdateSql(sql));
        }
        catch(ClassNotFoundException e) {
            System.out.println(e);
        }
        return participacaoAtividade;   
    }
   
   public void deletar(int idParticipacaoAtividade){
        String sql = "";
        sql = "delete from tbl_participacaoatividade where id_ParticipacaoAtividade = "+idParticipacaoAtividade;
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
   public void deletar(int idAtividade,boolean atividade){
        String sql = "";
        sql = "delete from tbl_participacaoatividade where id_atividade = "+idAtividade;
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
    public ArrayList<ParticipacaoAtividade> listar(int idAtividade){
     ArrayList<ParticipacaoAtividade> listaRetorno = new ArrayList<>();
        //Preparando váriaveis e Sql
        ParticipacaoAtividade participacaoAtividade = new ParticipacaoAtividade();
        String sql = "select * from tbl_participacaoatividade where id_atividade  = "+idAtividade;
        try {
           //verifica se está conectado, caso não esteja conecta
           Conexao.conectar();
           ResultSet rs = Conexao.executeQuerySql(sql);
           while(rs.next()){
                participacaoAtividade = new ParticipacaoAtividade();
                //Recupera valor referente ao nome
                participacaoAtividade.setId(rs.getInt("id_participacaoAtividade"));
                participacaoAtividade.setIdAtividade(rs.getInt("id_atividade"));
                participacaoAtividade.setIdUsuario(rs.getInt("id_usuario"));
                participacaoAtividade.setDescricao(rs.getString("descricao"));
                
                participacaoAtividade.setDataFinal(rs.getString("dataFinal"));
                participacaoAtividade.setDataInicial(rs.getString("dataInicial"));
                participacaoAtividade.setHorarioInicial(rs.getString("horarioInicial"));
                participacaoAtividade.setHorarioFinal(rs.getString("horarioFinal"));
                
                participacaoAtividade.setTitulo(rs.getString("titulo"));
                
                 listaRetorno.add(participacaoAtividade);
            }
           return listaRetorno;
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    
        public ParticipacaoAtividade buscar(int idParticipacaoAtividade){
        //Preparando váriaveis e Sql
        ParticipacaoAtividade participacaoAtividade = new ParticipacaoAtividade();
        String sql = "select * from daylog.tbl_participacaoatividade where id_participacaoAtividade = "+idParticipacaoAtividade;
        
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
                participacaoAtividade.setId(rs.getInt("id_participacaoAtividade"));
                participacaoAtividade.setIdAtividade(rs.getInt("id_atividade"));
                participacaoAtividade.setIdUsuario(rs.getInt("id_usuario"));
                participacaoAtividade.setDescricao(rs.getString("descricao"));
                
                participacaoAtividade.setDataFinal(rs.getString("dataFinal"));
                participacaoAtividade.setDataInicial(rs.getString("dataInicial"));
                participacaoAtividade.setHorarioInicial(rs.getString("horarioInicial"));
                participacaoAtividade.setHorarioFinal(rs.getString("horarioFinal"));
                
                participacaoAtividade.setTitulo(rs.getString("titulo"));
                 
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return participacaoAtividade;
        
    }
   
}
