/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import banco.Conexao;
import dailylog.Expediente;
import java.sql.ResultSet;
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
        String sql = "select data,id_usuario,horarioInicio,horarioFim "
                + "from tbl_expediente "
                + "where flag_ativo = 'A' and id_expediente = "+idExpediente;
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
                 expediente.setData(rs.getString("data"));
                 expediente.setHorarioInicial(rs.getString("horarioInicial"));
                 expediente.setHorarioFinal(rs.getString("horarioFinal"));
                 
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return expediente;
        
    }
    
    //Classe utilizada para salva 1 usuário
    public Expediente salvar(Expediente expediente,int idusuario){
        String sql;
        //Caso o usuário já exista ele possuí ID
        if(expediente.getId() > 0 ){
            //atualiza o usuario
            sql = "UPDATE `daylog`.`tbl_expediente` SET `id_usuario` = '"+idusuario+"', `horarioInicio` = '"+expediente.getHorarioInicial()+"', `horarioFim` = '"+expediente.getHorarioFinal()+"', `data` = '"+expediente.getData()+"', `flag_ativo` = '"+expediente.getFlag_ativo()+"' WHERE (`id_expediente` = '"+expediente.getId()+"');";
        }else{
            //caso não seja atualização ele cria o usuário
            //Preparando váriaveis e Sql
            sql = "INSERT INTO `daylog`.`tbl_expediente` (`id_usuario`, `horarioInicio`, `horarioFim`, `data`, `flag_ativo`) VALUES ('"+idusuario+"', '"+expediente.getHorarioInicial()+"', '"+expediente.getHorarioFinal()+"', '"+expediente.getData()+"', 'A')";
        }
        try {
           //verifica se está conectado, caso não esteja conecta
           if(Conexao.getConexao().isClosed()){
               Conexao.conectar(true);
           }
           expediente.setId(Conexao.executeUpdateSql(sql));
           System.out.println(expediente.getId());
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return expediente;   
    }
    
    //Classe utilizada para buscar 1 usuário
    public ArrayList<Expediente> listar(){
        ArrayList<Expediente> listaRetorno = new ArrayList<>();
        //Preparando váriaveis e Sql
        expediente = new Expediente();
        String sql = "select id_usuario,id_perfil,nome,senha from tbl_usuario where flag_ativo='A'";
        Expediente expediente = new Expediente();
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
               expediente = new Expediente();
                //Recupera valor referente ao nome
//                user.setId(rs.getInt("id_usuario"));
//                 user.setNome(rs.getString("nome"));
//                 user.setSenha(rs.getString("senha"));
//                 //Recupera valor referente ao idperfil
//                 perfil.setId(rs.getInt("id_perfil"));
//                 //busca o perfil
//                 user.setPerfil(perfil.buscar());
//                 listaRetorno.add(user);
            }
           return listaRetorno;
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
