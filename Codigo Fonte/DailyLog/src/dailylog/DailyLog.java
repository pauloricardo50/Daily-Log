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

public class DailyLog {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        System.out.println("Teste Criando usuario");
        Usuario user = new Usuario("12:00", "17:00","Ana", "Jujuba", 12, false, 24);
        System.out.println("Bom Dia, " + user.getNome());

        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Teste Criando e Listando Categorias: ");

        Categoria reuniao = new Categoria(0, "Reuniao");
        reuniao.adicionarSubcategoria("Demandas", 01);
        reuniao.adicionarSubcategoria("Presidencia", 02);
        Categoria evento = new Categoria(1, "Evento");
        evento.adicionarSubcategoria("Aniversariantes do Mes", 3);

        reuniao.listarSubCategorias();
        evento.listarSubCategorias();
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Teste Criando Atividades: ");
        user.adicionarAtividade("24/03/1996", 0, "Reuniao com alguem ai", "Reuinao no 15 andar com o pessoal da NExa", "12:00", "14:30", 01, 04);
        user.adicionarAtividade("24/03/1996", 1, "Reuniao com alguem ai", "Reuinao no 15 andar com o pessoal da NExa", "11:00", "14:00", 01, 04);
        user.adicionarAtividade("24/03/1996", 2, "Aniversario do mes de marco", "Sala do 16 andar com o bone", "10:00", "11:00", 01, 04);

        System.out.println("-------------------------------------------------------------------------");
        user.listarAtividadesCompleta("24/03/1996");
        System.out.println("-------------------------------------------------------------------------");
        user.listarAtividadesSimplificada("24/03/1996");

    }
    
}
