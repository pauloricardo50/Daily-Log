/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import banco.Conexao;
import dailylog.Perfil;
import dailylog.Usuario;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Jardielma e Paulo Ricardo
 */
public class UsuarioBD {
    
    public  Usuario user ;
    public  ResultSet rs;
    
    //Classe utilizada para buscar 1 usuário
    public Usuario buscar(int iduser){
        //Preparando váriaveis e Sql
        user = new Usuario();
        String sql = "select id_perfil,nome from tbl_usuario where flag_ativo = 'A' and id_usuario = "+iduser;
        Perfil perfil = new Perfil();
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
                 user.setNome(rs.getString("nome"));
                 //Recupera valor referente ao idperfil
                 perfil.setId(rs.getInt("id_perfil"));
                 //busca o perfil
                 user.setPerfil(perfil.buscar());
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return user;
        
    }
    
    //Classe utilizada para salva 1 usuário
    public Usuario salvar(Usuario user){
        String sql;
        //Caso o usuário já exista ele possuí ID
        if(user.getId() > 0 ){
            //atualiza o usuario
            sql = "UPDATE `daylog`.`tbl_usuario` SET `id_perfil` = '"+user.getPerfil().getId()+"', `senha` = '"+user.getSenha()+"',`flag_ativo` = '"+user.getFlag_ativo()+"',`nome` = '"+user.getNome()+"' WHERE (`id_usuario` = '"+user.getId()+"');";
        }else{
            //caso não seja atualização ele cria o usuário
            //Preparando váriaveis e Sql
            sql = "INSERT INTO `daylog`.`tbl_usuario` (`id_perfil`, `senha`, `nome`, `flag_ativo`) VALUES ('"+user.getPerfil().getId()+"', '"+user.getSenha()+"', '"+user.getNome()+"','A');";
        }
        try {
           //verifica se está conectado, caso não esteja conecta
           if(Conexao.getConexao().isClosed()){
               Conexao.conectar(true);
           }
           user.setId(Conexao.executeUpdateSql(sql));
           System.out.println(user.getId());
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return user;   
    }
    
    //Classe utilizada para buscar 1 usuário
    public ArrayList<Usuario> listar(){
        ArrayList<Usuario> listaRetorno = new ArrayList<>();
        //Preparando váriaveis e Sql
        user = new Usuario();
        String sql = "select id_usuario,id_perfil,nome,senha from tbl_usuario where flag_ativo='A'";
        Perfil perfil = new Perfil();
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
               user = new Usuario();
                //Recupera valor referente ao nome
                user.setId(rs.getInt("id_usuario"));
                 user.setNome(rs.getString("nome"));
                 user.setSenha(rs.getString("senha"));
                 //Recupera valor referente ao idperfil
                 perfil.setId(rs.getInt("id_perfil"));
                 //busca o perfil
                 user.setPerfil(perfil.buscar());
                 listaRetorno.add(user);
            }
           return listaRetorno;
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
}
