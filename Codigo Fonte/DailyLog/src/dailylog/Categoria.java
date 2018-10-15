/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailylog;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carol Cebin
 */
public class Categoria {
    private final int id;
    private String nome;
    private List<SubCategoria> subCategorias = new ArrayList();

    public Categoria(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }


    public void adicionarSubcategoria(String nomeSubCategoria, int idSubCategoria){
        SubCategoria subCategoria = new SubCategoria(idSubCategoria, nomeSubCategoria);
        this.subCategorias.add(subCategoria);
    }

    public void listarSubCategorias(){
        System.out.println("Categoria " + this. nome);
        for(SubCategoria subcategoria: subCategorias){
            System.out.println("    " + this.id + "." + subcategoria.getId() + " - " + subcategoria.getNome());
        }
    }


    
    
}
