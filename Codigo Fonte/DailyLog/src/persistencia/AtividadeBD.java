/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import dailylog.Atividade;
import java.util.ArrayList;

/**
 *
 * @author 20151BSI0100
 */
public class AtividadeBD 
{
    ArrayList<Atividade> lista = new ArrayList<Atividade>();
    void inserir(Atividade novaAtividade)
    {
        lista.add(novaAtividade);
    }
    
    void alterar()
    {
        
    }
    
    void excluir(int id)
    {
        for (int i=0; i < lista.size();i++)
        {
            Atividade cadaAtividade = lista.get(i);
            if(cadaAtividade.getId() == id) // usar o termo igual
            {
                lista.remove(i);
            }
               
        }
               
    }
    
    ArrayList<Atividade> listar()
    {
        return null;
        
    }
}
