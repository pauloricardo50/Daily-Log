/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;
import banco.Conexao;
import dailylog.Categoria;
import dailylog.SubCategoria;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author jardielma
 */
public class SubCategoriaBD {
    
    public  SubCategoria subcategoria;
    public  ResultSet rs;
    
    //Classe utilizada para buscar 1 usuário
    public SubCategoria buscar(int idSubCategoria){
        //Preparando váriaveis e Sql
        subcategoria = new SubCategoria();
        Categoria categoria = new Categoria();
        String sql = "select descricao,id_categoria from tbl_subcategoria where id_subcategoria = "+idSubCategoria;
        
        try {
           //verifica se está conectado, caso não esteja conecta
           if(Conexao.getConexao().isClosed()){
               Conexao.conectar(true);
           }
           rs = Conexao.executeQuerySql(sql);
           while(rs.next()){
                //Recupera valor referente ao nome
                 subcategoria.setDescricao(rs.getString("descricao"));
                 categoria = new Categoria();                         
                 categoria.setId(rs.getInt("id_categoria"));
                 categoria.buscar();
                 subcategoria.setCategoria(categoria);
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return subcategoria;
    }
    
    //Classe utilizada para salva 1 usuário
    public SubCategoria salvar(SubCategoria subcategoria){
        String sql;
        //Caso o usuário já exista ele possuí ID
        if(subcategoria.getId() > 0 ){
            //atualiza o usuario
            sql = "UPDATE `daylog`.`tbl_subcategoria` SET `id_categoria` = '"+subcategoria.getCategoria().getId()+"',"
                    + " `descricao` = '"+subcategoria.getDescricao()+"' "
                    + "WHERE (`id_subcategoria` = '"+subcategoria.getId()+"')";
        }else{
            //caso não seja atualização ele cria o usuário
            //Preparando váriaveis e Sql
            sql = "INSERT INTO `daylog`.`tbl_subcategoria` (`id_categoria`, `descricao`) VALUES ('"+subcategoria.getCategoria().getId()+"', '"+subcategoria.getDescricao()+"')";
        }
        try {
           //verifica se está conectado, caso não esteja conecta
           if(Conexao.getConexao().isClosed()){
               Conexao.conectar(true);
           }
           
           if(subcategoria.getId()==0){
            subcategoria.setId(Conexao.executeUpdateSql(sql));
           }else{
               Conexao.executeUpdateSql(sql);
           }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return subcategoria;
    }
    
    //Classe utilizada para buscar 1 usuário
    public ArrayList<SubCategoria> listar(){
        ArrayList<SubCategoria> listaRetorno = new ArrayList<>();
        //Preparando váriaveis e Sql
        subcategoria = new SubCategoria();
        Categoria categoria = new Categoria();
        String sql = "select id_categoria,descricao,id_subcategoria from tbl_subcategoria order by id_categoria";
        try {
           //verifica se está conectado, caso não esteja conecta
           if(Conexao.getConexao().isClosed()){
               Conexao.conectar(true);
           }
           
           rs = Conexao.executeQuerySql(sql);
           while(rs.next()){
               subcategoria = new SubCategoria();
                //Recupera valor referente ao nome
                subcategoria.setId(rs.getInt("id_subcategoria"));
                 subcategoria.setDescricao(rs.getString("descricao"));
                 categoria = new Categoria();
                 categoria.setId(rs.getInt("id_categoria"));
                 categoria.buscar();
                 subcategoria.setCategoria(categoria);
                 listaRetorno.add(subcategoria);
            }
           return listaRetorno;
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
}
