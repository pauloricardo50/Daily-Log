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
           Conexao.conectar();
           if(permissao.getId()==0){
            permissao.setId(Conexao.executeUpdateSql(sql));
           }else{
               Conexao.executeUpdateSql(sql);
           }
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
          Conexao.conectar();
           rs = Conexao.executeQuerySql(sql);
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
           Conexao.conectar();
           rs = Conexao.executeQuerySql(sql);
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
    
    //Lista as permissões de acordo com o perfil informado
    public ArrayList<Permissao> listar(int idPerfil){
     ArrayList<Permissao> listaRetorno = new ArrayList<>();
        //Preparando váriaveis e Sql
        permissao = new Permissao();
        String sql = "select perm.id_permisao, perm.descricao "
                + "from tbl_permissao as perm left join tbl_permisaoperfil as permPerfil "
                + "on perm.id_permisao = permPerfil.id_permisao "
                + "where permPerfil.id_perfil = "+idPerfil;
        try {
           //verifica se está conectado, caso não esteja conecta
           Conexao.conectar();
           rs = Conexao.executeQuerySql(sql);
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
