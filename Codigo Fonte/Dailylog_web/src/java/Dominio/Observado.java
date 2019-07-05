/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.ArrayList;

/**
 *
 * @author jardielma
 */
public class Observado {
    
    private ArrayList<Observador> listaObservadores;
    
    public void setListaObservadores(ArrayList<Observador> listaObservadores){
        this.listaObservadores =  listaObservadores;
    }
    
    public ArrayList<Observador> getListaObservadores(){
        return this.listaObservadores;
    }
    
    public void adicionarObservador(Observador observador){
        this.listaObservadores.add(observador);
    }
    
    public void retirarObservador(Observador observador){
        this.listaObservadores.remove(observador);
    }
    
    public void notificaObservador(String mensagem){
        for(Observador observador: listaObservadores){
            observador.update(mensagem,0);
        }
    }
}
