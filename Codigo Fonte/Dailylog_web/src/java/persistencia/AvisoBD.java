/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import banco.Conexao;
import Dominio.Aviso;
import static java.lang.System.out;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author jardielma
 */
public class AvisoBD {
    public  ResultSet rs;
    
    public Aviso buscar(int id_aviso){
        //Preparando váriaveis e Sql
        Aviso aviso = new Aviso();
        String sql = "select * from tbl_aviso where flag_ativo = 'A' and id_aviso = "+id_aviso;
        
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
                 aviso.setMensagem(rs.getString("mensagem"));
                 aviso.setFlag_ativo(rs.getString("flag_ativo"));
                 aviso.setId_User(rs.getInt("id_usuario"));
                 aviso.setId(id_aviso);
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return aviso;
        
    }
    
    public Aviso salvar(Aviso aviso){
        
        String sql;
        
        if(aviso.getId() > 0 ){
            //atualiza o usuario
            sql = "UPDATE `daylog`.`tbl_aviso` SET `id_usuario` = '"+aviso.getId_User()+"', `mensagem` = '"+aviso.getMensagem()+"', `flag_ativo` = '"+aviso.getFlag_ativo()+"' WHERE (`id_aviso` = '"+aviso.getId()+"')";
        }else{
            //caso não seja atualização ele cria o usuário
            //Preparando váriaveis e Sql
            sql = "INSERT INTO `daylog`.`tbl_aviso` (`id_usuario`,`mensagem`,`flag_ativo`) VALUES ('"+aviso.getId_User()+"','"+aviso.getMensagem()+"','"+aviso.getFlag_ativo()+"')";
        }
        
        try {
           //verifica se está conectado, caso não esteja conecta
           Conexao.conectar();
           
           if(aviso.getId()==0){
            aviso.setId(Conexao.executeUpdateSql(sql));
           }else{
               Conexao.executeUpdateSql(sql);
           }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return aviso;   
    }
    public ArrayList<Aviso> listar(int id_usuario){
        ArrayList<Aviso>listaRetorno = new ArrayList<Aviso>();
        //Preparando váriaveis e Sql
        Aviso aviso = new Aviso();
        String sql = "select * from tbl_aviso where flag_ativo = \"A\" and id_usuario  = "+id_usuario;
        try {
           //verifica se está conectado, caso não esteja conecta
           Conexao.conectar();
           ResultSet rs = Conexao.executeQuerySql(sql);
           while(rs.next()){
                aviso = new Aviso();
                aviso.setMensagem(rs.getString("mensagem"));
                aviso.setFlag_ativo(rs.getString("flag_ativo"));
                aviso.setId_User(id_usuario);
                aviso.setId(rs.getInt("id_aviso"));
                
                 listaRetorno.add(aviso);
            }
           //out.println(sql);
           return listaRetorno;
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
