/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailylog;

/**
 *  @author Ana Carolina Cebin Pereira
 *  @author Jardielma Queiroz de Lima
 *  @author Paulo Ricardo Viana Ferreira
 */

public class SubCategoria {
    private final int id;
    private String nome;

    public SubCategoria(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    /**
     * Pega a valor do id da SubCategoria
     * @return Retorna o Id da SubCategoria
     *
     */
    public int getId() {

        return id;
    }

    /**
     * Pega o nome da categoria
     * @return O nome da Subcategoria no formato de String
     *
     */
    public String getNome() {

        return nome;
    }
}
