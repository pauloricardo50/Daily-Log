/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import banco.Conexao;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Jardielma e Paulo Ricardo
 */


public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        //Tenta se conectar com o BD
        try{
            Conexao.conectar(); //conectando 
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
            System.out.println("7 - Sub-categoria");
            
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
                    menuCategoria();
                    break;
                case 5:
                    menuExpediente();
                    break;
                case 6:
                    menuPermissao();
                    break;
                case 7:
                    menuSubCategoria();
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
        Atividade atividade;
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
            System.out.println("5 - Listar Expedientes");
            System.out.println("6 - Adicionar Atividade");
            System.out.println("7 - Listar Atividade");
            System.out.println("8 - Excluir Atividade");
            System.out.println("9 - Registrar Execução de Atividade");
            System.out.println("10 - Listar Execução de Atividade");
            //System.out.println("11 - Excluir Execução de Atividade");
            
            System.out.println("12 - Sair");
            
            //Pega os dados passado pelo usuário (nextInt) porque espera um int;
            dados = new Scanner(System.in);
            controleSwitch = dados.nextInt();
            
            //Prepara o switch para tratar os dados passado e executa a operação requisitada;
            switch (controleSwitch){
                case 1:
                    menuCriarUsuario(0);
                    
                    break;
                case 2:
                    //Busca o usuário pelo id:
                    
                    menuBuscarUsuario("Informe id do usuário a ser buscado:");
                    
                    break;
                case 3:
                    //Lista todos usuários cadastrados no banco
                    menuImprimeListaUsuario();
                    
                    break;
                case 4:
                    menuExcluirUsuario();
                    
                    break;
                case 5:
                    menuImprimeListaUsuario();
                    System.out.println("Informe o id do usuario");
                    user = new Usuario();
                    dados = new Scanner(System.in);
                    user.setId(dados.nextInt());
                    user.buscar();
                    
                    Expediente expediente = new Expediente();
                    //Verificar se o usuário tem expediente
                    imprimeListaExpediente( expediente.listar(user));
                    
                    break;
                case 6:
                    menuCriarAtividade(0);
                    
                    break;
                case 7:
                    user = menuBuscarUsuario("Informe o ID do Usuario:");     
                    menuImprimeListaAtividade(user);
                    break;
                case 8:
                    user = menuBuscarUsuario("Informe o ID do Usuario:"); 
                    menuImprimeListaAtividade(user);
                    menuExcluirAtividade();
                    break;
                case 9:
                    //Registrar Execução de Atividade
                    user = menuBuscarUsuario("Informe o ID do Usuario:"); 
                    atividade = menuBuscarAtividade(user,"Informe o Id da Atividade");
                    menuCriarParticipacaoAtividade(atividade.getId());
                    //menuImprimeListaAtividade(user);
                    break;
                case 10:
                    //Listar Execução de Atividade
                    user = menuBuscarUsuario("Informe o ID do Usuario:"); 
                    atividade = menuBuscarAtividade(user,"Informe o Id da Atividade");
                    menuImprimeListaParticipacaoAtividade(atividade.getId());
                    break;
                case 11:
                    //Excluir Execução de Atividade
//                    user = menuBuscarUsuario("Informe o ID do Usuario:"); 
//                    menuImprimeListaAtividade(user);
//                    menuExcluirAtividade();
                    break;
                case 12:
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
            System.out.println("4 - Alterar Perfil");
            System.out.println("9 - Sair");
            
            dados = new Scanner(System.in);
            controleSwitch = dados.nextInt();
            String autoContraste;
            
            //Prepara o switch para tratar os dados passado e executa a operação requisitada;
            switch (controleSwitch){
                case 1:
                    menuCriarPerfil(0);
                    
                    break;
                case 2:
                    menuBuscarPerfil();
                    
                    break;
                case 3:
                    //Lista todos os perfils cadastrados no BD
                    menuImprimeListaPerfil();
                    
                    break;
                case 4:
                    menuImprimeListaPerfil();
                            
                    perfil = menuBuscarPerfil();
                    
                    menuCriarPerfil(perfil.getId());
                    
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
     * Metodo responsável por tratar as operações referentes as permissões de usuário;
     */
    public static void menuCategoria() {
        //Declaração de variáveis:
        Categoria categoria;
        ArrayList<Categoria> lista;
        Scanner dados;
        int controleSwitch = 0;
        
        /**
         * Loop para fazer aparecer o munu do permissao;
         */
        while(controleSwitch >=0){
            //Imprime o nenu de categoria:
            System.out.println("\n Menu Categoria:\n ");
            System.out.println("Informe a opção desejada:");
            System.out.println("1 - Criar");
            System.out.println("2 - Buscar Pelo ID");
            System.out.println("3 - Listar");
            System.out.println("4 - Alterar");
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
                    menuCriarCategoria(0);
                    break;
                case 2:
                    menuBuscarCategoria("Informe id da categoria a ser buscado:");
                    break;
                case 3:
                    menuImprimeListaCategoria();
                    break;
                case 4:
                    menuImprimeListaCategoria();
                    categoria = menuBuscarCategoria("Informe id da categoria a ser alterado:");
                    menuCriarCategoria(categoria.getId());
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
     * Metodo responsável por tratar as operações referentes as permissões de usuário;
     */
    public static void menuSubCategoria() {
        //Declaração de variáveis:
        SubCategoria subCategoria;
        ArrayList<SubCategoria> lista;
        Scanner dados;
        int controleSwitch = 0;
        
        /**
         * Loop para fazer aparecer o munu do permissao;
         */
        while(controleSwitch >=0){
            //Imprime o nenu de categoria:
            System.out.println("\n Menu Sub-Categoria:\n ");
            System.out.println("Informe a opção desejada:");
            System.out.println("1 - Criar");
            System.out.println("2 - Buscar Pelo ID");
            System.out.println("3 - Listar");
            System.out.println("4 - Alterar");
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
                    menuCriarSubCategoria(0);
                    break;
                case 2:
                    menuBuscarSubCategoria("Informe id da subcategoria a ser buscado:");
                    break;
                case 3:
                    menuImprimeListaSubCategoria();
                    break;
                case 4:
                    menuImprimeListaSubCategoria();
                    subCategoria = new SubCategoria();
                    subCategoria = menuBuscarSubCategoria("Informe id da Subcategoria a ser alterado:");
                    menuCriarSubCategoria(subCategoria.getId());
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
     * Metodo responsável por tratar as operações referentes as permissões de usuário;
     */
    public static void menuExpediente() {
        //Declaração de variáveis:
        Expediente expediente;
        ArrayList<Expediente> lista;
        Scanner dados;
        int controleSwitch = 0;
        
        /**
         * Loop para fazer aparecer o munu do permissao;
         */
        while(controleSwitch >=0){
            //Imprime o nenu de categoria:
            System.out.println("\n Menu Expediente:\n ");
            System.out.println("Informe a opção desejada:");
            System.out.println("1 - Criar");
            System.out.println("2 - Buscar Pelo ID");
            System.out.println("3 - Listar");
            System.out.println("4 - Alterar");
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
                    menuCriarExpediente(0);
                    break;
                case 2:
                    menuBuscarExpediente("Informe id do Expediente a ser buscado:");
                    break;
                case 3:
                    menuImprimeListaExpediente();
                    break;
                case 4:
                    menuImprimeListaExpediente();
                    expediente = new Expediente();
                    expediente = menuBuscarExpediente("Informe id do Expediente a ser alterado:");
                    expediente.setFlagAtivo("A");
                    menuCriarExpediente(expediente.getId());
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
     * Metodo responsável por imprimir lista de perfil;
     * @param lista
     */
    public static void imprimeListaUsuario(ArrayList<Usuario> lista){
        lista.forEach((usuario) -> {
            System.out.println(usuario.getId()+" - " +usuario.getNome());
        });
    }
    
    public static void imprimeUsuario(Usuario usuario){
            System.out.println("\nUsuario: "+usuario.getId()+" - " +usuario.getNome());
    }
    
    /**
     * Metodo responsável por imprimir lista de perfil com todos os atributos;
     * @param lista
     */
    public static void imprimeListaPerfilDetalhada(ArrayList<Perfil> lista){
        lista.forEach((perfil) -> {
            System.out.println(perfil.getId()+" - " +perfil.getDescricao()+
                    " - Horário Ini.: "+perfil.getHorarioPadraoInicial()+" - Horário Fin.: "+perfil.getHorarioPadraoFinal()+
                    " - Tam. fonte: "+perfil.getTamanhoFonte()+" - Auto Contrastre: "+perfil.getAutoContraste());
        });
    }
    
    /**
     * Metodo responsável por imprimir lista de perfil com todos os atributos;
     * @param lista
     */
    public static void imprimeListaAtividade(ArrayList<Atividade> lista){
        if(lista.isEmpty()){
            System.out.println("Nenhuma Execução cadastrada nesta atividade");
        }
        Expediente expediente = new Expediente();
        SubCategoria subcategoria = new SubCategoria();
        for(Atividade atividade: lista){
            expediente = new Expediente();
            expediente.setId(atividade.getIdExpediente());
            expediente.buscar();
            subcategoria = new SubCategoria();
            subcategoria.setId(atividade.getIdSubCategoria());
            subcategoria.buscar();
            System.out.println("id: "+atividade.getId()+" - Titulo: "+ atividade.getTitulo()+
                    " - Des.: "+ atividade.getDescricao() + " - Horario Ini.: " +atividade.getHorarioInicial()+
                            " - Horario Final: "+ atividade.getHorarioFinal() + " - data: " + atividade.getData()+
                    " - subcategoria: "+ subcategoria.getDescricao()+" - categoria: "+subcategoria.getCategoria().getDescricao());
        }
    }
    
    public static void imprimeListaParticipacaoAtividade(ArrayList<ParticipacaoAtividade> lista){
        if(lista.isEmpty()){
            System.out.println("Nenhuma Execução cadastrada nesta atividade");
        }
        Usuario usuario = new Usuario();
        System.out.println("\n");
        for(ParticipacaoAtividade participacaoAtividade: lista){
            usuario = new Usuario();
            usuario.setId(participacaoAtividade.getIdUsuario());
            usuario.buscar();
            
            System.out.println("Execução: id_Atividade: "+participacaoAtividade.getId()+" -- Usuario: "+usuario.getNome()+ " - Titulo: "+ participacaoAtividade.getTitulo()+
                    " - Des.: "+ participacaoAtividade.getDescricao() + " - Horario Ini.: " +participacaoAtividade.getHorarioInicial()+
                            " - Horario Final: "+ participacaoAtividade.getHorarioFinal() + " - data Inicial: " + participacaoAtividade.getDataInicial()+
                    " - data Final: " + participacaoAtividade.getDataFinal());
        }
    }
    
        /**
     * Metodo responsável por imprimir Atividade;
     */
    public static void imprimeAtividade(Atividade atividade){
        SubCategoria subcategoria = new SubCategoria();
            subcategoria.setId(atividade.getIdSubCategoria());
            subcategoria.buscar();
            System.out.println("\n Atividade: id: "+atividade.getId()+" - Titulo: "+ atividade.getTitulo()+
                    " - Des.: "+ atividade.getDescricao() + " - Horario Ini.: " +atividade.getHorarioInicial()+
                            " - Horario Final: "+ atividade.getHorarioFinal() + " - data: " + atividade.getData()+
                    " - subcategoria: "+ subcategoria.getDescricao()+" - categoria: "+subcategoria.getCategoria().getDescricao());
        
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
     * Metodo responsável por imprimir lista de categoria;
     * @param lista
     */
    public static void imprimeListaCategoria(ArrayList<Categoria> lista){
        lista.forEach((categoria) -> {
            System.out.println(categoria.getId()+" - " +categoria.getDescricao());
        });
    }
    /**
     * Metodo responsável por imprimir lista de categoria;
     * @param lista
     */
    public static void imprimeListaSubCategoria(ArrayList<SubCategoria> lista){
        lista.forEach((subcategoria) -> {
            System.out.println("categoria: "+ subcategoria.getCategoria().getDescricao()+" - ID: "+subcategoria.getId()+" - Desc.:" +subcategoria.getDescricao());
        });
    }
    
    public static void imprimeListaExpediente(ArrayList<Expediente> lista){
        lista.forEach((expediente) -> {
            System.out.println("Usuario: "+ expediente.getUsuario().getNome()+" - ID: "+expediente.getId()+" - "
                    + "Hora Ini.:" +expediente.getHorarioInicial()+" - Hora Fin.:"+
                    expediente.getHorarioFinal()+" - Data: "+ expediente.getData());
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
    
     /**
     * Metodo responsável por imprimir o perfil detalhado de usuário; 
     */
    public static void menuImprimeListaPerfil(){
        Perfil perfil = new Perfil();
                    
        imprimeListaPerfilDetalhada(perfil.listar());
    }
    
     /**
     * Metodo responsável por buscar as permissões que o perfil do usuário possui;
     * @return 
     */
    public static Perfil menuBuscarPerfil(){
        //Busca permissão pelo perfil:
        System.out.println("Informe o ID a ser buscado:");
        Scanner dados = new Scanner(System.in);
                    
        Perfil perfil = new Perfil();
        perfil.setId(dados.nextInt());
                    
        perfil.buscar();
                    
        System.out.println(perfil.getId()+" - " +perfil.getDescricao()+
        " - Horário Ini.: "+perfil.getHorarioPadraoFinal()+" - Horário Fin.: "+perfil.getHorarioPadraoFinal()+
        " - Tam. fonte: "+perfil.getTamanhoFonte()+" - Auto Contrastre: "+perfil.getAutoContraste());

        //Verifica se deseja imprimir lista de permissões do perfil
        System.out.println("Deseja imprimir as permissões desse perfil: SIM ou NAO");
        dados = new Scanner(System.in);
        if(dados.next().equals("SIM")){
            imprimeListaPermissao(perfil.getPemissoes());
        }
        return perfil;
    }
    
    public static void menuCriarPerfil(int id){
        //Criar perfil
        Perfil perfil = new Perfil();
        
        /** Verifica se o id é maior que zero pois se for
         * identificamos que o usuário quer modificar o perfil
         * já existente.
         */
        
        if(id>0){
            perfil.setId(id);
        }

        //captura as informações do perfil:
        System.out.println("Informe descricao:");
        Scanner dados = new Scanner(System.in);
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
        
//        //Faz o tratamento do que o usuário responde
//        String autoContraste = dados.next();
//        if(autoContraste.equals("SIM")){
//            perfil.setAutoContraste(true);
//        }else{
//            perfil.setAutoContraste(false);
//        }

        /**
         * Leva para o submenu de permissões para ele selecionar as opções
         * e retorna o array list de permissões
         */
        Permissao permissao = new Permissao();
        perfil.setPermissoes(menuSelecionarPermissoes());

        //Imprime as permissões atribuidas para o perfil
        imprimeListaPermissao(perfil.getPemissoes());       
        
        perfil.salvar();
    }
    
    
    
    public static void menuCriarUsuario(int id){
       //Caso desejar criar um novo usuário, o sistema pede todas informações do usuário;
                    Usuario user = new Usuario();
                    System.out.println("Informe o nome do novo usuário:");
                    Scanner dados = new Scanner(System.in);
                    user.setNome(dados.next());
                    System.out.println("Informe a senha do novo usuário:");
                    dados = new Scanner(System.in);
                    user.setSenha(dados.next());
                    
                    //Imprime os perfils cadastrado no sistema para que o usuário escolha um:
                    Perfil perfil = new Perfil();
                    ArrayList<Perfil> lista = perfil.listar();
                    imprimeListaPerfil(lista);
                    
                    System.out.println("Informe o perfil do novo usuário:");
                    dados = new Scanner(System.in);
                    perfil.setId(dados.nextInt());
                    perfil.buscar();
                    
                    //Salva usuário:
                    user.setPerfil(perfil);
                    user.salvar();
    }
    
    public static void menuExcluirUsuario(){
       /**
                     * Exclui o usuário pelo ID, porem ele não exclui o registro do BD,
                     * apenas faz uma autualização no registro e atribui ao usuário uma flag
                     * que ele está desativado, para que então possamos ter o histórico;
                     */
                    Usuario user = new Usuario();
                    ArrayList<Usuario>listaUser = user.listar();
                    
                    imprimeListaUsuarios(listaUser);
                    
                    System.out.println("Informe id do usuário a ser excluído:");
                    Scanner dados = new Scanner(System.in);
                    user.setId(dados.nextInt());
                    
                    //Busca o usuário e "deleta"
                    user.buscar();
                    user.deletar();
                    
                    System.out.println("Usuário Deletado com sucesso!");
    }
    
     /**
     * Metodo responsável por imprimir a lista de Gategorias; 
     */
     public static void menuImprimeListaCategoria(){
        Categoria categoria = new Categoria();
                    
        imprimeListaCategoria(categoria.listar());
    }
     
     /**
     * Metodo responsável imprimir a lista de usuário; 
     */
    public static void menuImprimeListaUsuario(){
        Usuario user = new Usuario();
                    
        imprimeListaUsuario(user.listar());
    }
    
     /**
     * Metodo responsável por buscar as Categorias; 
     * @param id
     * @return 
     */
    public static Categoria menuBuscarCategoria(String id){
        //Busca uma permissão pelo id:
        System.out.println(id);
        Scanner dados = new Scanner(System.in);

        Categoria categoria = new Categoria();
        categoria.setId(dados.nextInt());

        categoria.buscar();

        System.out.println(categoria.getId()+" - " +categoria.getDescricao());
        return categoria;
    }
    
     /**
     * Metodo responsável por criar uma nova categoria; 
     * @param id
     */
    public static void menuCriarCategoria(int id){
        //Cria uma nova categoria
        Categoria categoria = new Categoria();
        
        /**
        * condicional utilizada para verificar se vai ser atualizada uma categoria
        * ou se vai ser adicionada uma nova categoria
        */
        if(id >0){
            categoria.setId(id);
        }
        
        //Coleta os dados da categoria:
        System.out.println("Informe o nome da nova Categoria:");
        Scanner dados = new Scanner(System.in);
        categoria.setDescricao(dados.next());

        //Salva a categoria
        categoria.salvar();
        System.out.println("Categoria Salva com sucesso!");
    }
    
    /**
     * Metodo responsável por imprimir as categoria cadastradas; 
     */
    public static void menuImprimeListaSubCategoria(){
        SubCategoria subcategoria = new SubCategoria();
                    
        imprimeListaSubCategoria(subcategoria.listar());
    }
    
    /**
     * Metodo responsável por imprimir a lista de expediente do usuário; 
     */
    public static void menuImprimeListaExpediente(){
        Expediente expediente = new Expediente();
                    
        imprimeListaExpediente(expediente.listar());
    }
    public static void menuImprimeListaExpediente(Usuario user){
        Expediente expediente = new Expediente();
        
        imprimeListaExpediente(expediente.listar(user));
    }
    
    /**
     * Metodo responsável por criar uma nova categoria; 
     * @param id
     * @return 
     */
    public static SubCategoria menuBuscarSubCategoria(String id){
        //Busca uma Subcategoria pelo id:
        System.out.println(id);
        Scanner dados = new Scanner(System.in);

        SubCategoria subcategoria = new SubCategoria();
        subcategoria.setId(dados.nextInt());

        subcategoria.buscar();

        System.out.println("categoria: "+ subcategoria.getCategoria().getDescricao()+" - ID: "+subcategoria.getId()+" - Desc.:" +subcategoria.getDescricao());
        return subcategoria;
    }
    
    /**
     * Metodo responsável por criar uma nova Subcategoria; 
     * @param id
     */
    public static void menuCriarSubCategoria(int id){
        //Cria uma nova subcategoria
        SubCategoria subcategoria = new SubCategoria();
        
        /**
        * condicional utilizada para verificar se a categoria já existe
        * e caso exista ela será atualizada e caso não ela será criada 
        */
        if(id >0){
            subcategoria.setId(id);
        }
        
        //Captura os dado da subcategoria
        System.out.println("Informe o nome da nova Sub-Categoria:");
        Scanner dados = new Scanner(System.in);
        subcategoria.setDescricao(dados.next());
        menuImprimeListaCategoria();
        
        /** Como um subcategoria pertence a uma categoria
         *  listamos todas as categorias cadastradas no sistema 
         *  para que o usuário escolha a categoria para qual está cadastrando
         *  uma nova subcategoria.
         */
        System.out.println("Informe Categoria pai da sub-categoria:");
        dados = new Scanner(System.in);
        subcategoria.setCategoria(new Categoria());
        subcategoria.getCategoria().setId(dados.nextInt());
        subcategoria.getCategoria().buscar();
        
        subcategoria.salvar();
        System.out.println("Categoria Salva com sucesso!");
    }
    
    /**
     * Metodo responsável por buscar uma novo dia de expediente; 
     * @param mensagem
     * @return 
     */
    public static Expediente menuBuscarExpediente(String mensagem){
        //Busca uma permissão pelo id:
        System.out.println(mensagem);
        Scanner dados = new Scanner(System.in);

        Expediente expediente = new Expediente();
        expediente.setId(dados.nextInt());
            expediente.buscar();
        
        System.out.println("Usuario: "+ expediente.getUsuario().getNome()+" - ID: "+expediente.getId()+" - "
                    + "Hora Ini.:" +expediente.getHorarioInicial()+" - Hora Fin.:"+
                    expediente.getHorarioFinal()+" - Data: "+ expediente.getData());
        
        return expediente;
    }
    
    /**
     * Metodo responsável por criar uma novo dia de expediente; 
     * @param id 
     */
    public static void menuCriarExpediente(int id){
        //Cria uma novo expediente
        Expediente expediente = new Expediente();
        
        //Verifica se o expediente já existe
        if(id >0){
            expediente.setId(id);
        }
        
        System.out.println("Informe a data do novo Expediente: AAAA/MM/DD");
        Scanner dados = new Scanner(System.in);
        expediente.setData(dados.next());
        
        //Lista todos os usuário para que o expediente seja atribuido a ele
        Usuario user = new Usuario();
        menuImprimeListaUsuario();
        System.out.println("Informe Usuario:");
        dados = new Scanner(System.in);
        
        user.setId(dados.nextInt());
        user.buscar();
        
        expediente.setUsuario(user);
        
        System.out.println("Informe o Horario INicio do novo Expediente: HH:MM:SS");
        dados = new Scanner(System.in);
        expediente.setHorarioInicial(dados.next());
        
        System.out.println("Informe o Horario Final do novo Expediente: HH:MM:SS");
        dados = new Scanner(System.in);
        expediente.setHorarioFinal(dados.next());
        
        expediente.salvar(0);
        
        System.out.println("Expediente Salvo com sucesso!");
    }
    
    /**
     * Metodo responsável por buscar uma novo dia de expediente; 
     * @param mensagem
     * @return 
     */
    public static Usuario menuBuscarUsuario(String mensagem){
       
        System.out.println(mensagem);
        Scanner dados = new Scanner(System.in);

        Usuario user = new Usuario();
        user.setId(dados.nextInt());

        user.buscar();

        System.out.println(user.getId()+" - "+user.getNome());
        return user;
    }
    
    
    public static void menuCriarAtividade(int id){
       //Caso desejar criar um novo usuário, o sistema pede todas informações do usuário;
        Usuario user = menuBuscarUsuario("Informe o ID do Usuario:");
        String texto;
        SubCategoria subcategoria = new SubCategoria();
        menuImprimeListaSubCategoria();
        subcategoria = menuBuscarSubCategoria("Informe o ID da subCategoria");
        menuImprimeListaExpediente(user);
        Expediente expediente = menuBuscarExpediente("Informe o ID do expediente");
        Atividade atividade = new Atividade();
        System.out.println("Informe o titulo da atividade:");
        Scanner dados = new Scanner(System.in);
        atividade.setTitulo(dados.next());
        System.out.println("Informe a descricao da atividade:");
        dados = new Scanner(System.in);
        atividade.setDescricao(dados.next());
            System.out.println("Informe a Hora inicio da atividade: HH:MM:SS");
            dados = new Scanner(System.in);
            atividade.setHorarioInicial(dados.next());
            System.out.println("Informe a Hora final da atividade: HH:MM:SS");
            dados = new Scanner(System.in);
            atividade.setHorarioFinal(dados.next());
        
        System.out.println("Informe a data da atividade: AAAA/MM/DD");
        dados = new Scanner(System.in);
        atividade.setData(dados.next());
        atividade.salvar(user,expediente,subcategoria);
    }
    
    public static void menuImprimeListaAtividade(Usuario user){
        Atividade atividade = new Atividade();
        
        imprimeListaAtividade(atividade.listar(user));
    }
    
    /**
     * Metodo responsável por buscar uma novo dia de expediente; 
     * @param mensagem
     * @return 
     */
    public static void menuExcluirAtividade(){
       
        System.out.println("Informe ID da atividade para excluir: -1 para cancelar");
        Scanner dados = new Scanner(System.in);
        int idAtividade= dados.nextInt();
        if(idAtividade == -1)
        {
            return;
        }
        Atividade atividade = new Atividade();
        atividade.setId(idAtividade);

        atividade.deletar();

        System.out.println("Atividade deletada com sucesso!");
    }
    
    
    public static Atividade menuBuscarAtividade(Usuario user, String mensagem){
        menuImprimeListaAtividade(user);
        
        System.out.println(mensagem);
        Scanner dados = new Scanner(System.in);
        
        Atividade atividade = new Atividade();
        atividade.setId(dados.nextInt());
        atividade.buscar(atividade.getId());


        System.out.println(atividade.getId()+" - "+atividade.getTitulo());
        return atividade;
    }
    
    
    public static void menuCriarParticipacaoAtividade(int idAtividade){
       //Caso desejar criar um novo usuário, o sistema pede todas informações do usuário;
            
        String texto;
        ParticipacaoAtividade participacaoAtividade = new ParticipacaoAtividade();
        System.out.println("Informe o titulo da Execucao da atividade:");
        Scanner dados = new Scanner(System.in);
        participacaoAtividade.setTitulo(dados.next());
        
        System.out.println("Informe a descricao da atividade:");
        dados = new Scanner(System.in);
        participacaoAtividade.setDescricao(dados.next());
        
        System.out.println("Informe a Hora inicio da atividade: HH:MM:SS");
        dados = new Scanner(System.in);
        participacaoAtividade.setHorarioInicial(dados.next());
        
        System.out.println("Informe a Hora final da atividade: HH:MM:SS");
        dados = new Scanner(System.in);
        participacaoAtividade.setHorarioFinal(dados.next());
        
        System.out.println("Informe a data Inicial da atividade: AAAA/MM/DD");
        dados = new Scanner(System.in);
        participacaoAtividade.setDataInicial(dados.next());
        
        System.out.println("Informe a data Final da atividade: AAAA/MM/DD");
        dados = new Scanner(System.in);
        participacaoAtividade.setDataFinal(dados.next());
        
        System.out.println("Informe o Usuario que executou essa atividade:");
        dados = new Scanner(System.in);
        participacaoAtividade.setIdUsuario(dados.nextInt());
        
        participacaoAtividade.setIdAtividade(idAtividade);
        
        Atividade atividade = new Atividade();
        atividade.setId(idAtividade);
        atividade.buscar(idAtividade);
        atividade.identificarUsuarioDiferente(participacaoAtividade);
        
        participacaoAtividade.salvar();
        
    }
    
    
    public static void menuImprimeListaParticipacaoAtividade(int idAtividade){
        Atividade atividade = new Atividade();
        atividade.buscar(idAtividade);
        //Imprime usuário
        Usuario usuario = new Usuario();
        usuario.setId(atividade.getIdUsuario());
        usuario.buscar();
        
        imprimeUsuario(usuario);
        //imprime atividade
        imprimeAtividade(atividade);
        //imprime paticipacaoatividade
        imprimeListaParticipacaoAtividade(atividade.getlistaParticipacaoAtividade());
    }
    
}

    

