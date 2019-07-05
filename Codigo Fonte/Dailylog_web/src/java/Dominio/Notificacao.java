/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import static java.lang.System.out;

/**
 *
 * @author jardielma
 */
public abstract class Notificacao {
    public void notificar(String mensagem, int id_usuario){
    out.println(mensagem);
    }
    
}
