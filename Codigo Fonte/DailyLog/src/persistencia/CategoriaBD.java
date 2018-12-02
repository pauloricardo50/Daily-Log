/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import banco.Conexao;
import dailylog.Categoria;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author 20151BSI0100
 */
public class CategoriaBD {
    public  Categoria categoria ;
    public  ResultSet rs;
    
    //Classe utilizada para buscar 1 usuário
    public Categoria buscar(int idcategoria){
        //Preparando váriaveis e Sql
        categoria = new Categoria();
        String sql = "select descricao from tbl_categoria where id_categoria = "+idcategoria;
        
        try {
           //verifica se está conectado, caso não esteja conecta
           if(Conexao.getConexao().isClosed()){
               Conexao.conectar(true);
           }
           rs = Conexao.executeQuerySql(sql);
//           if(rs.first()== false){
//            //Caso a categoria não existe retorna null
//            return null;
//           }
           while(rs.next()){
                //Recupera valor referente ao nome
                 categoria.setDescricao(rs.getString("descricao"));
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return categoria;
        
    }
    
    //Classe utilizada para salva 1 usuário
    public Categoria salvar(Categoria categoria){
        String sql;
        //Caso o usuário já exista ele possuí ID
        if(categoria.getId() > 0 ){
            //atualiza o usuario
            sql = "UPDATE `daylog`.`tbl_categoria` SET `descricao` = '"+categoria.getDescricao()+" 32' WHERE (`id_categoria` = '"+categoria.getId()+"')";
        }else{
            //caso não seja atualização ele cria o usuário
            //Preparando váriaveis e Sql
            sql = "INSERT INTO `daylog`.`tbl_categoria` (`descricao`) VALUES ('"+categoria.getDescricao()+"')";
        }
        try {
           //verifica se está conectado, caso não esteja conecta
           if(Conexao.getConexao().isClosed()){
               Conexao.conectar(true);
           }
           categoria.setId(Conexao.executeUpdateSql(sql));
           System.out.println(categoria.getId());
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return categoria;   
    }
    
    //Classe utilizada para buscar 1 usuário
    public ArrayList<Categoria> listar(){
        ArrayList<Categoria> listaRetorno = new ArrayList<>();
        //Preparando váriaveis e Sql
        categoria = new Categoria();
        String sql = "select id_categoria,descricao from tbl_categoria";
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
               categoria = new Categoria();
                //Recupera valor referente ao nome
                categoria.setId(rs.getInt("id_categoria"));
                 categoria.setDescricao(rs.getString("descricao"));
                 listaRetorno.add(categoria);
            }
           return listaRetorno;
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
}
