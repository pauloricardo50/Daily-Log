/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import banco.Conexao;
import dailylog.Permissao;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author 20151BSI0100
 */
public class PermissaoBD {
    public Permissao permissao;
    public ResultSet rs;
   
        //Classe utilizada para salva 1 usuário
    public Permissao salvar(Permissao permissao){
        String sql;
        
        //Caso o perfil já exista ele possuí ID
        if(permissao.getId() > 0 ){
            //atualiza o perfil
            sql = "UPDATE `daylog`.`tbl_permissao` SET `descricao` = '"+permissao.getDescricao()+"' WHERE (`id_permisao` = '"+permissao.getId()+"')";
        }else{
            //caso não seja atualização ele cria o perfil
            //Preparando váriaveis e Sql
            sql = "INSERT INTO `daylog`.`tbl_permissao` (`descricao`) VALUES ('"+permissao.getDescricao()+"')";
        }
        try {
           //verifica se está conectado, caso não esteja conecta
           if(Conexao.getConexao().isClosed()){
               Conexao.conectar(true);
           }
           permissao.setId(Conexao.executeUpdateSql(sql));
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return permissao;
        
    }
    
    public Permissao buscar(int idPermissao){
        //Preparando váriaveis e Sql
        permissao = new Permissao();
        String sql = "select id_permisao,descricao from tbl_permissao where id_permisao = "+idPermissao;
        
        try {
           //verifica se está conectado, caso não esteja conecta
           if(Conexao.getConexao().isClosed()){
               Conexao.conectar(true);
           }
           rs = Conexao.executeQuerySql(sql);
//           if(rs.first()== false){
//            //Caso o usuário não existe retorna null
//            return null;
//           }
           while(rs.next()){
                //Recupera valor referente ao nome
                 permissao.setDescricao(rs.getString("descricao"));
                 //Recupera valor referente ao idperfil
                 permissao.setId(rs.getInt("id_permisao"));
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return permissao;
        
    }
    
    
    public ArrayList<Permissao> listar(){
     ArrayList<Permissao> listaRetorno = new ArrayList<>();
        //Preparando váriaveis e Sql
        permissao = new Permissao();
        String sql = "select id_permisao,descricao"
                + " from daylog.tbl_permissao";
        try {
           //verifica se está conectado, caso não esteja conecta
           if(Conexao.getConexao().isClosed()){
               Conexao.conectar(true);
           }
           rs = Conexao.executeQuerySql(sql);
//           if(rs.equals(sql.)){
//            //Caso o usuário não existe retorna null
//            return null;
//           }
           while(rs.next()){
                permissao = new Permissao();
                //Recupera valor referente ao nome
                permissao.setId(rs.getInt("id_permisao"));
                permissao.setDescricao(rs.getString("descricao"));
                 listaRetorno.add(permissao);
            }
           return listaRetorno;
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
}
