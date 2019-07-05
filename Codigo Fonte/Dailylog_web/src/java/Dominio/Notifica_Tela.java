/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author jardielma
 */
public class Notifica_Tela extends Notificacao{
    @Override
    public void notificar(String mensagem,int id_usuario){
        Aviso aviso= new Aviso();
        aviso.setMensagem(mensagem);
        aviso.setId_User(id_usuario);
        aviso.setFlag_ativo("A");
        aviso.salvar();
    }
    }