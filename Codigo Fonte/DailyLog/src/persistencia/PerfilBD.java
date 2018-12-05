/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import banco.Conexao;
import dailylog.Perfil;
import dailylog.Permissao;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Jardielma e Paulo Ricardo
 */
public class PerfilBD {
    public Perfil perfil ;
    public ResultSet rs;
    
    //Classe utilizada para buscar 1 usuário
    public Perfil buscar(int idperfil)
    {
        //Preparando váriaveis e Sql
        this.perfil = new Perfil();
        String sql = "select descricao,\n" +
                            "horarioPadraoInicial,\n" +
                            "horarioPadraoFinal,\n" +
                            "tamanhoFonte,\n" +
                            "autoContraste " +
                            "from tbl_perfil where id_perfil = "+idperfil;
        try {
           //verifica se está conectado, caso não esteja conecta
           if(Conexao.getConexao().isClosed()){
               Conexao.conectar(true);
           }
           rs = Conexao.executeQuerySql(sql);
           while(rs.next()){
                //Recupera valores
                perfil.setId(idperfil);
                perfil.setDescricao(rs.getString("descricao"));
                perfil.setHorarioPadraoInicial(rs.getString("horarioPadraoInicial"));
                perfil.setHorarioPadraoFinal(rs.getString("horarioPadraoFinal"));
                perfil.setTamanhoFonte(rs.getInt("tamanhoFonte"));
                perfil.setAutoContraste(rs.getBoolean("autoContraste"));
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return perfil;
        
    }
    
    //Classe utilizada para salva 1 usuário
    public Perfil salvar(Perfil perfil){
        String sql;
        int autocontraste;
        if(perfil.getAutoContraste()==true){
            autocontraste = 1;
        }else{
            autocontraste = 0;
        }
        
        //Caso o perfil já exista ele possuí ID
        if(perfil.getId() > 0 ){
            //atualiza o perfil
            sql = "UPDATE `daylog`.`tbl_perfil` SET `descricao` = '"+perfil.getDescricao()+"',"
                    + " `horarioPadraoInicial` = '"+perfil.getHorarioPadraoInicial()+"',"
                    + " `horarioPadraoFinal` = '"+perfil.getHorarioPadraoFinal()+"',"
                    + " `tamanhoFonte` = '"+perfil.getTamanhoFonte()+"',"
                    + " `autoContraste` = '"+autocontraste+"'"
                    + " WHERE (`id_perfil` = '"+perfil.getId()+"');";
        }else{
            //caso não seja atualização ele cria o perfil
            //Preparando váriaveis e Sql
            sql = "INSERT INTO `daylog`.`tbl_perfil` (`descricao`, `horarioPadraoInicial`,"
                    + " `horarioPadraoFinal`,"
                    + " `tamanhoFonte`, `autoContraste`)"
                    + " VALUES ('"+perfil.getDescricao()+"','"+perfil.getHorarioPadraoInicial()+"',"
                    + "'"+perfil.getHorarioPadraoFinal()+"','"+perfil.getTamanhoFonte()+"','"+autocontraste+"')";
        }
        try {
           //verifica se está conectado, caso não esteja conecta
           if(Conexao.getConexao().isClosed()){
               Conexao.conectar(true);
           }
           if(perfil.getId()==0){
            perfil.setId(Conexao.executeUpdateSql(sql));
           }else{
               Conexao.executeUpdateSql(sql);
           }
           salvarPermissoes(perfil);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return perfil;
        
    }
    
    
     //Classe utilizada para buscar 1 usuário
    public ArrayList<Perfil> listar(){
        ArrayList<Perfil> listaRetorno = new ArrayList<>();
        //Preparando váriaveis e Sql
        perfil = new Perfil();
        String sql = "select id_perfil,descricao,"
                + "horarioPadraoInicial,"
                + "horarioPadraoFinal,tamanhoFonte,"
                + "autoContraste "
                + "from tbl_perfil";
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
                perfil = new Perfil();
                //Recupera valor referente ao nome
                perfil.setId(rs.getInt("id_perfil"));
                perfil.setDescricao(rs.getString("descricao"));
                perfil.setHorarioPadraoInicial(rs.getString("horarioPadraoInicial"));
                perfil.setHorarioPadraoFinal(rs.getString("horarioPadraoFinal"));
                perfil.setTamanhoFonte(rs.getInt("tamanhoFonte"));
                perfil.setAutoContraste(rs.getBoolean("autoContraste"));
                 listaRetorno.add(perfil);
            }
           return listaRetorno;
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    public void salvarPermissoes(Perfil perfil){
        String sql;
        try{
            sql="";
            //sql deletar
            sql="DELETE FROM `daylog`.`tbl_permisaoperfil` WHERE (`id_perfil` = '"+perfil.getId()+"');";
            Conexao.executeUpdateSql(sql);
            
        for(Permissao permissao : perfil.getPemissoes()) {
            
            //sql de adicionar
            sql="";
            sql = "INSERT INTO `daylog`.`tbl_permisaoperfil` (`id_permisao`, `id_perfil`) VALUES ('"+permissao.getId()+"', '"+perfil.getId()+"')";
            Conexao.executeUpdateSql(sql);
        }
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}
