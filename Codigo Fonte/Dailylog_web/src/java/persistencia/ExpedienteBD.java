/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import banco.Conexao;
import dailylog.Expediente;
import dailylog.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author 20151BSI0100
 */
public class ExpedienteBD {
    
    public  Expediente expediente ;
    public  ResultSet rs;
    
    //Classe utilizada para buscar 1 usuário
    public Expediente buscar(int idExpediente){
        //Preparando váriaveis e Sql
        expediente = new Expediente();
        Usuario user;
        String sql = "select data,id_usuario,horarioInicio,horarioFim,flag_ativo "
                + "from tbl_expediente "
                + "where flag_ativo = 'A' and id_expediente = "+idExpediente;
        try {
           //verifica se está conectado, caso não esteja conecta
          Conexao.conectar();
           rs = Conexao.executeQuerySql(sql);
           while(rs.next()){
                //Recupera valor referente ao nome
                 expediente = new Expediente();
                   expediente.setData(rs.getDate("data").toString());
                   expediente.setHorarioFinal(rs.getString("horarioFim"));
                   expediente.setHorarioInicial(rs.getString("horarioInicio"));
                   expediente.setFlagAtivo(rs.getString("flag_ativo"));
                   user = new Usuario();
                   user.setId(rs.getInt("id_usuario"));
                   user.buscar();
                   expediente.setUsuario(user);
                 
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return expediente;
        
    }
    
    //Classe utilizada para salva 1 usuário
    public Expediente salvar(Expediente expediente){
        String sql;
        //Caso o usuário já exista ele possuí ID
        if(expediente.getId() > 0 ){
            //atualiza o usuario
            //sql = "UPDATE `daylog`.`tbl_expediente` SET `id_usuario` = '"+expediente.getUsuario().getId()+"', `horarioInicio` = '"+expediente.getHorarioInicial()+"', `horarioFim` = '"+expediente.getHorarioFinal()+"', `data` = '"+expediente.getData()+"', `flag_ativo` = '"+expediente.getFlagAtivo()+"' WHERE (`id_expediente` = '"+expediente.getId()+"');";
            sql = "UPDATE `daylog`.`tbl_expediente` SET `id_usuario`"
                    + " = '"+expediente.getUsuario().getId()+"', `horarioInicio`"
                    + " = '"+expediente.getHorarioInicial()+"', `horarioFim` = "
                    + "'"+expediente.getHorarioFinal()+"', `flag_ativo` = "
                    + "'"+expediente.getFlagAtivo()+"', `data` = '"+expediente.getData()+"'"
                    + " WHERE (`id_expediente` = '"+expediente.getId()+"')";
        }else{
            //caso não seja atualização ele cria o usuário
            //Preparando váriaveis e Sql
            sql = "INSERT INTO `daylog`.`tbl_expediente` "
                    + "(`id_usuario`, `horarioInicio`, `horarioFim`,"
                    + " `data`, `flag_ativo`) VALUES ('"+expediente.getUsuario().getId()+"',"
                    + " '"+expediente.getHorarioInicial()+"', '"+expediente.getHorarioFinal()+"', "
                    + "'"+expediente.getData()+"', 'A')";
        }
        try {
           //verifica se está conectado, caso não esteja conecta
           Conexao.conectar();
           if(expediente.getId()==0){
            expediente.setId(Conexao.executeUpdateSql(sql));
           }else{
               Conexao.executeUpdateSql(sql);
           }
        }
        catch(ClassNotFoundException e) {
            System.out.println(e);
        }
        return expediente;   
    }
    
    //Classe utilizada para buscar 1 usuário
    public ArrayList<Expediente> listar(){
        ArrayList<Expediente> listaRetorno = new ArrayList<>();
        //Preparando váriaveis e Sql
        expediente = new Expediente();
        Usuario user = new Usuario();
        String sql = "select id_usuario,horarioInicio,horarioFim,data,"
                + "flag_ativo,id_expediente from tbl_expediente where "
                + "flag_ativo='A' order by id_usuario";
        Expediente expediente = new Expediente();
        try {
           //verifica se está conectado, caso não esteja conecta
           Conexao.conectar();
           
           rs = Conexao.executeQuerySql(sql);
           while(rs.next()){
               expediente = new Expediente();
               expediente.setData(rs.getDate("data").toString());
               expediente.setHorarioFinal(rs.getString("horarioFim"));
               expediente.setHorarioInicial(rs.getString("horarioInicio"));
               expediente.setId(rs.getInt("id_expediente"));
               expediente.setFlagAtivo(rs.getString("flag_ativo"));
               user = new Usuario();
               user.setId(rs.getInt("id_usuario"));
               user.buscar();
               expediente.setUsuario(user);
               listaRetorno.add(expediente);
            }
           return listaRetorno;
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    //Classe utilizada para buscar 1 usuário
    public ArrayList<Expediente> listar(int idUsuario){
        ArrayList<Expediente> listaRetorno = new ArrayList<>();
        //Preparando váriaveis e Sql
        expediente = new Expediente();
        Usuario user = new Usuario();
        String sql = "select id_usuario,horarioInicio,horarioFim,data,flag_ativo,"
                + "id_expediente from tbl_expediente where flag_ativo='A' "
                + "and id_usuario = '"+idUsuario+"' order by id_usuario";
        
        Expediente expediente = new Expediente();
        try {
           //verifica se está conectado, caso não esteja conecta
           Conexao.conectar();
           
           rs = Conexao.executeQuerySql(sql);
           while(rs.next()){
               expediente = new Expediente();
               expediente.setData(rs.getDate("data").toString());
               expediente.setHorarioFinal(rs.getString("horarioFim"));
               expediente.setHorarioInicial(rs.getString("horarioInicio"));
               expediente.setId(rs.getInt("id_expediente"));
               expediente.setFlagAtivo(rs.getString("flag_ativo"));
               user = new Usuario();
               user.setId(rs.getInt("id_usuario"));
               user.buscar();
               expediente.setUsuario(user);
               listaRetorno.add(expediente);
            }
           return listaRetorno;
        }
        catch(ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
