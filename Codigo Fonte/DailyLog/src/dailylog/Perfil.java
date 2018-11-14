/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailylog;

/**
 *
 * @author PAULOR RICARDO GAMEPLAYS E JARDIELMA QUEIROZ DE LIMA
 */
public class Perfil {
    private int id;
    private String tipo;
    private String horarioPadraoInicial;
    private String horarioPadraoFinal;
    protected int tamanhoFonte;
    protected boolean autoContraste;
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getHorarioPadraoInicial() {
        return horarioPadraoInicial;
    }

    public void setHorarioPadraoInicial(String horarioPadraoInicial) {
        this.horarioPadraoInicial = horarioPadraoInicial;
    }

    public String getHorarioPadraoFinal() {
        return horarioPadraoFinal;
    }

    public void setHorarioPadraoFinal(String horarioPadraoFinal) {
        this.horarioPadraoFinal = horarioPadraoFinal;
    }

    public int getTamanhoFonte() {
        return tamanhoFonte;
    }

    public void setTamanhoFonte(int tamanhoFonte) {
        this.tamanhoFonte = tamanhoFonte;
    }

    public boolean isAutoContraste() {
        return autoContraste;
    }

    public void setAutoContraste(boolean autoContraste) {
        this.autoContraste = autoContraste;
    }
   
}
