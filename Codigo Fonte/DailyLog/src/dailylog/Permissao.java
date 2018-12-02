/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailylog;

import java.util.ArrayList;

/**
 *
 * @author Jardielma e Paulo Ricardo
 */
public class Permissao {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
    public Permissao buscarPermissao(){
//        Usuario retorno;
//        try{
//            //busca o Usuario
//            retorno = UsuarioBD.buscar(this.id);
//            this.nome = retorno.nome;
//            this.perfil= retorno.perfil;
//        }catch(Exception e ){
//            System.out.println(e);
//        }
//        return this;
        return null;
    }
    
    public void salvarPermissao(){
//        Usuario retorno;
//        try{
//            //busca o Usuario
//            retorno = UsuarioBD.buscar(this.id);
//            this.nome = retorno.nome;
//            this.perfil= retorno.perfil;
//        }catch(Exception e ){
//            System.out.println(e);
//        }
    }
    
    public void deletarPermissao(){
//        Usuario retorno;
//        try{
//            //busca o Usuario
//            retorno = UsuarioBD.buscar(this.id);
//            this.nome = retorno.nome;
//            this.perfil= retorno.perfil;
//        }catch(Exception e ){
//            System.out.println(e);
//        }
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Permissao> listaPermissao(){
//        Permissao retorno;
//        ArrayList<Permissao> lista = null;
//        try{
//            //busca o Usuario
//            retorno = UsuarioBD.buscar(this.id);
//            return lista;
//        }catch(Exception e ){
//            System.out.println(e);
//        }
        return null;
    }
    
    
    
}
