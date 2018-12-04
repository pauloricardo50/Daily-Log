/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailylog;

import banco.Conexao;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Jardielma e Paulo Ricardo
 */


public class Main 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        //Tenta se conectar com o BD
        try{
            Conexao.conectar(true); //conectando 
        }
        catch(ClassNotFoundException e){
            System.out.println(e);
        }
        
        //Declaração de Variáveis:
        Scanner dados;
        int controleSwitch = 0;
        
        /**
         * Loop para fazer aparecer o munu do sistema;
         */
        while(controleSwitch >=0){
            //Imprime as opções do munu:
            System.out.println("\n Menu Principal: \n");
            System.out.println("Informe a opção desejada:");
            System.out.println("1 - Usuário");
            System.out.println("2 - Perfil");
            System.out.println("3 - Atividade");
            System.out.println("4 - Categoria");
            System.out.println("5 - Expediente");
            System.out.println("6 - Permissao");
            System.out.println("9 - Sair");
            
            //Pega os dados passado pelo usuário (nextInt) porque espera um int;
            dados = new Scanner(System.in);
            controleSwitch = dados.nextInt();
            
            //Prepara o switch para tratar os dados passado e vai para o submenu da opção desejada;
            switch (controleSwitch){
                case 1:
                    menuUsuario();
                    break;
                case 2:
                    
                    menuPerfil();
                    break;
                case 3:
                    System.out.println("Opção 1");
                    break;
                case 4:
                    System.out.println("Opção 1");
                    break;
                case 5:
                    System.out.println("Opção 1");
                    break;
                case 6:
                    menuPermissao();
                    break;
                case 9:
                    System.out.println("Saiu");
                    controleSwitch=-1;
                    break;
                default:
                    System.out.println("Opção Inválida");
            }
        }
    }
    
    /**
     * Metodo responsável por tratar as operações referentes ao usuário;
     */
    public static void menuUsuario() {
        //Declarações de variáveis:
        Usuario user;
        ArrayList<Perfil> lista;
        ArrayList<Usuario> listaUser;
        Perfil perfil;
        Scanner dados;
        int controleSwitch = 0;
        
        /**
         * Loop para fazer aparecer o munu do usuário;
         */
        while(controleSwitch >=0){
            //imprime as opções de menu:
            System.out.println("\n Menu Usuário: \n");
            System.out.println("Informe a opção desejada:");
            System.out.println("1 - Criar");
            System.out.println("2 - Buscar Pelo ID");
            System.out.println("3 - Listar");
            System.out.println("4 - Excluir pelo ID");
            System.out.println("9 - Sair");
            
            //Pega os dados passado pelo usuário (nextInt) porque espera um int;
            dados = new Scanner(System.in);
            controleSwitch = dados.nextInt();
            
            //Prepara o switch para tratar os dados passado e executa a operação requisitada;
            switch (controleSwitch){
                case 1:
                    //Caso desejar criar um novo usuário, o sistema pede todas informações do usuário;
                    user = new Usuario();
                    System.out.println("Informe o nome do novo usuário:");
                    dados = new Scanner(System.in);
                    user.setNome(dados.next());
                    System.out.println("Informe a senha do novo usuário:");
                    dados = new Scanner(System.in);
                    user.setSenha(dados.next());
                    
                    //Imprime os perfils cadastrado no sistema para que o usuário escolha um:
                    perfil = new Perfil();
                    lista = perfil.listar();
                    imprimeListaPerfil(lista);
                    
                    System.out.println("Informe o perfil do novo usuário:");
                    dados = new Scanner(System.in);
                    perfil.setId(dados.nextInt());
                    perfil.buscar();
                    
                    //Salva usuário:
                    user.setPerfil(perfil);
                    user.salvar();
                    
                    break;
                case 2:
                    //Busca o usuário pelo id:
                    user = new Usuario();
                    System.out.println("Informe id do usuário a ser buscado:");
                    dados = new Scanner(System.in);
                    user.setId(dados.nextInt());
                    
                    //Busca usuário:
                    user.buscar();
                    System.out.println(user.getId()+" - " +user.getNome());
                    
                    break;
                case 3:
                    //Lista todos usuários cadastrados no banco
                    user = new Usuario();
                    listaUser = user.listar();
                    
                    imprimeListaUsuarios(listaUser);
                    
                    break;
                case 4:
                    /**
                     * Exclui o usuário pelo ID, porem ele não exclui o registro do BD,
                     * apenas faz uma autualização no registro e atribui ao usuário uma flag
                     * que ele está desativado, para que então possamos ter o histórico;
                     */
                    user = new Usuario();
                    listaUser = user.listar();
                    
                    imprimeListaUsuarios(listaUser);
                    
                    System.out.println("Informe id do usuário a ser excluído:");
                    dados = new Scanner(System.in);
                    user.setId(dados.nextInt());
                    
                    //Busca o usuário e "deleta"
                    user.buscar();
                    user.deletar();
                    
                    System.out.println("Usuário Deletado com sucesso!");
                    
                    break;
                case 9:
                    //Caso ele não queira fazer mais nada no SI ele sai.
                    System.out.println("Saiu");
                    controleSwitch=-1;
                    
                    break;
                default:
                    /**
                     * Caso não escolha uma opção válida ele imprime uma msg de falha e imprime o submenu novamente
                    */
                    System.out.println("Opção Inválida");
            }
        }
    }
    
    /**
     * Metodo responsável por tratar as operações referentes as permissões de usuário;
     */
    public static void menuPermissao() {
        //Declaração de variáveis:
        Permissao permissao;
        ArrayList<Permissao> lista;
        Scanner dados;
        int controleSwitch = 0;
        
        /**
         * Loop para fazer aparecer o munu do permissao;
         */
        while(controleSwitch >=0){
            //Imprime o nenu de permisão:
            System.out.println("\n Menu Permissao:\n ");
            System.out.println("Informe a opção desejada:");
            System.out.println("1 - Criar");
            System.out.println("2 - Buscar Pelo ID");
            System.out.println("3 - Listar");
            
            //System.out.println("4 - Excluir pelo ID");
            
            /**Função não disponivel porque é uma regra
            *de negócio do sistema não deletar as permissões 
            * Porem está implementada;
            */
            
            System.out.println("9 - Sair");
            
            dados = new Scanner(System.in);
            controleSwitch = dados.nextInt();
            
            //Prepara o switch para tratar os dados passado e executa a operação requisitada;
            switch (controleSwitch){
                case 1:
                    //Cria uma nova permissão
                    permissao = new Permissao();
                    
                    System.out.println("Informe o nome da nova Permissao:");
                    dados = new Scanner(System.in);
                    permissao.setDescricao(dados.next());
                    
                    permissao.salvar();
                    
                    break;
                case 2:
                    //Busca uma permissão pelo id:
                    System.out.println("Informe id do usuário a ser buscado:");
                    dados = new Scanner(System.in);
                    
                    permissao = new Permissao();
                    permissao.setId(dados.nextInt());
                    
                    permissao.buscar();
                    
                    System.out.println(permissao.getId()+" - " +permissao.getDescricao());
                    
                    break;
                case 3:
                    //Imprime todas as permissões cadastradas no banco:
                    permissao = new Permissao();
                    
                    lista = permissao.listar();
                    
                    imprimeListaPermissao(lista);
                    
                    break;
                case 4:
                    permissao = new Permissao();
                    lista = permissao.listar();
                    
                    imprimeListaPermissao(lista);
                    
                    System.out.println("Informe id da permissão a ser excluída:");
                    dados = new Scanner(System.in);
                    permissao.setId(dados.nextInt());
                    
                    permissao.buscar();
                    permissao.deletar();
                    
                    System.out.println("Permissão Deletado com sucesso");
                    
                    break;
                case 9:
                    System.out.println("Saiu");
                    controleSwitch=-1;
                    break;
                default:
                    System.out.println("Opção Inválida");
            }
        }
    }
    
    
    /**
     * Metodo responsável por tratar as operações referentes ao perfil de usuário;
     */
    public static void menuPerfil() {
        //Declaração de variáveis:
        Perfil perfil;
        Permissao permissao;
        Scanner dados;
        int controleSwitch = 0;
        
        /**
         * Loop para fazer aparecer o munu do permissao;
         */
        while(controleSwitch >=0){
           //Impime o menu de perfil de usuário:
            System.out.println("\n Menu Perfil: \n");
            System.out.println("Informe a opção desejada:");
            System.out.println("1 - Criar Perfil");
            System.out.println("2 - Buscar Pelo ID");
            System.out.println("3 - Listar");
            System.out.println("4 - Excluir pelo ID");
            System.out.println("9 - Sair");
            
            dados = new Scanner(System.in);
            controleSwitch = dados.nextInt();
            String autoContraste;
            
            //Prepara o switch para tratar os dados passado e executa a operação requisitada;
            switch (controleSwitch){
                case 1:
                    //Criar perfil
                    perfil = new Perfil();
                    
                    //captura as informações do perfil:
                    System.out.println("Informe descricao:");
                    dados = new Scanner(System.in);
                    perfil.setDescricao(dados.next());
                    System.out.println("Informe Horario Padrao Inicial: HH:MM:SS");
                    dados = new Scanner(System.in);
                    perfil.setHorarioPadraoInicial(dados.next());
                    System.out.println("Informe Horario Padrao Final: HH:MM:SS");
                    dados = new Scanner(System.in);
                    perfil.setHorarioPadraoFinal(dados.next());
                    System.out.println("Informe Tamanho Fonte:");
                    dados = new Scanner(System.in);
                    perfil.setTamanhoFonte(dados.nextInt());
                    System.out.println("Informe SIM para ativar autoContraste:");
                    dados = new Scanner(System.in);
                    
                    autoContraste = dados.next();
                    if(autoContraste.equals("SIM")){
                        perfil.setAutoContraste(true);
                    }else{
                        perfil.setAutoContraste(false);
                    }
                    
                    /**
                     * Leva para o submenu de permissões para ele selecionar as opções
                     * e retorna o array list de permissões
                     */
                    permissao = new Permissao();
                    perfil.setPermissoes(menuSelecionarPermissoes());
                    
                    //Imprime as permissões atribuidas para o perfil
                    //imprimeListaPermissao(perfil.getPemissoes());
                    
                    perfil.salvar();
                    
                    break;
                case 2:
                    //Busca permissão pelo perfil:
                    System.out.println("Informe o ID a ser buscado:");
                    dados = new Scanner(System.in);
                    
                    perfil = new Perfil();
                    perfil.setId(dados.nextInt());
                    
                    perfil.buscar();
                    
                    System.out.println(perfil.getId()+" - " +perfil.getDescricao()+
                    " - Horário Ini.: "+perfil.getHorarioPadraoFinal()+" - Horário Fin.: "+perfil.getHorarioPadraoFinal()+
                    " - Tam. fonte: "+perfil.getTamanhoFonte()+" - Auto Contrastre: "+perfil.getAutoContraste());
                    
                    break;
                case 3:
                    //Lista todos os perfils cadastrados no BD
                    perfil = new Perfil();
                    
                    imprimeListaPerfilDetalhada(perfil.listar());
                    
                    break;
                case 4:
                    //Não implementada pq não vai ser permitido excluir o perfil
                    break;
                case 9:
                    System.out.println("Saiu");
                    controleSwitch=-1;
                    
                    break;
                default:
                    System.out.println("Opção Inválida");
            }
        }
    }
    
    /**
     * Metodo responsável por imprimir lista de perfil;
     * @param lista
     */
    public static void imprimeListaPerfil(ArrayList<Perfil> lista){
        lista.forEach((perfil) -> {
            System.out.println(perfil.getId()+" - " +perfil.getDescricao());
        });
    }
    
    /**
     * Metodo responsável por imprimir lista de perfil com todos os atributos;
     * @param lista
     */
    public static void imprimeListaPerfilDetalhada(ArrayList<Perfil> lista){
        lista.forEach((perfil) -> {
            System.out.println(perfil.getId()+" - " +perfil.getDescricao()+
                    " - Horário Ini.: "+perfil.getHorarioPadraoFinal()+" - Horário Fin.: "+perfil.getHorarioPadraoFinal()+
                    " - Tam. fonte: "+perfil.getTamanhoFonte()+" - Auto Contrastre: "+perfil.getAutoContraste());
        });
    }
    
    /**
     * Metodo responsável por imprimir lista de usuário;
     * @param lista
     */
    public static void imprimeListaUsuarios(ArrayList<Usuario> lista){
        lista.forEach((user) -> {
            System.out.println(user.getId()+" - "+user.getNome());
        });
    }
    
    /**
     * Metodo responsável por imprimir lista de permisão;
     * @param lista
     */
    public static void imprimeListaPermissao(ArrayList<Permissao> lista){
        lista.forEach((permissao) -> {
            System.out.println(permissao.getId()+" - " +permissao.getDescricao());
        });
    }
    
    /**
     * Metodo responsável por criar o array de permissões atribuidas para um perfil;
     * @return 
     */
    public static ArrayList<Permissao> menuSelecionarPermissoes(){
        Permissao permissao = new Permissao();
        imprimeListaPermissao(permissao.listar());
       
        ArrayList<Permissao> listaRetorno = new ArrayList<>();
        Scanner dados;
        int id;
        int controleWhile = 0;
        
        while(controleWhile >=0){
            System.out.println("Informe o id da Permissão desejada - informe -1 para terminar");
            dados = new Scanner(System.in);
            id = dados.nextInt();
            
            if(id==-1){
                //Verfica se a lista ta vazia:
                if(listaRetorno.isEmpty()){
                    System.out.println("Nenhuma permissão informada, favor informar 1 permissão");
                }
                else{
                    controleWhile = -1;
                    break;
                }
            }
            
            permissao = new Permissao();
            permissao.setId(id);
            permissao.buscar();
            listaRetorno.add(permissao);
        }
        return listaRetorno;
    }
}

    

