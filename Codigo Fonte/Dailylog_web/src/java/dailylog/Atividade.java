/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dailylog;

import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Calendar;
import persistencia.AtividadeBD;

/**
 *
 * @author Jardielma e Paulo Ricardo
 */
public class Atividade extends Observado{
    private int id;
    private String titulo;
    private String descricao;
    private String horarioInicial;
    private String horarioFinal;
    private int idCategoria;
    private int idSubCategoria;
    private int idExpediente;
    private int idUsuario;
    private String data;
    private AtividadeBD persistencia;
    private ArrayList<ParticipacaoAtividade> listaParticipacaoAtividade ;
    private String htmlTop;
    private String htmlFooter;
    
    public int getId() {
        return id;
        
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public ArrayList<ParticipacaoAtividade> getlistaParticipacaoAtividade() {
        return listaParticipacaoAtividade;
        
    }

    public void setlistaParticipacaoAtividade(ArrayList<ParticipacaoAtividade> listaParticipacaoAtividade) {
        this.listaParticipacaoAtividade = listaParticipacaoAtividade;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getHorarioInicial() {
        return horarioInicial;
    }

    public void setHorarioInicial(String horarioInicial) {
        this.horarioInicial = horarioInicial;
    }

    public String getHorarioFinal() {
        return horarioFinal;
    }

    public void setHorarioFinal(String horarioFinal){
        this.horarioFinal = horarioFinal;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdSubCategoria() {
        return idSubCategoria;
    }

    public void setIdSubCategoria(int idSubCategoria) {
        this.idSubCategoria = idSubCategoria;
    }
    
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
     public int getIdExpediente() {
        return idExpediente;
    }

    public void setIdExpediente(int idExpediente) {
        this.idExpediente = idExpediente;
    }
    
     public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public String getHtmlTop() {
        return htmlTop;
    }

    public void setHtmlTop(String htmlTop) {
        this.htmlTop = htmlTop;
    }
    public String getHtmlFooter() {
        return htmlFooter;
    }

    public void setHtmlFooter(String htmlFooter) {
        this.htmlFooter = htmlFooter;
    }
    
    
    
    public String salvar(Usuario user, Expediente expediente, SubCategoria subcategoria){
        persistencia = new AtividadeBD();
        Atividade retorno;
        try{
            retorno = persistencia.salvar(this,user.getId(),expediente.getId(),subcategoria.getId());
            
            //Atualiza o id do usuario, tendo em vista que o usuario criado não tinha
            this.id = retorno.getId();
        }
        catch(Exception e ){
            System.out.println(e);
        }
        return "Atividade Salvo com sucesso";
    }
    
        public String salvar(){
        persistencia = new AtividadeBD();
        Atividade retorno;
        try{
            retorno = persistencia.salvar(this,this.getIdUsuario(),this.getIdExpediente(),this.getIdSubCategoria());
            
            //Atualiza o id do usuario, tendo em vista que o usuario criado não tinha
            this.id = retorno.getId();
        }
        catch(Exception e ){
            System.out.println(e);
        }
        return "Atividade Salvo com sucesso";
    }
    
    public void deletar(){
        persistencia = new AtividadeBD();
        try{
            //deleto as dependencias
            ParticipacaoAtividade participacao = new ParticipacaoAtividade();
            participacao.setIdAtividade(this.getId());
            participacao.deletarParticipacaoAtividade(true);
            //busca o Usuario
            persistencia.deletar(this.getId());
        }catch(Exception e ){
            System.out.println(e);
        }
    }
    
    public void adicionarParticipacao(ParticipacaoAtividade novaParticipacao){
        this.listaParticipacaoAtividade.add(novaParticipacao);
    }
    
    /**
     *
     * @param user
     * @return
     */
    public ArrayList<Atividade>listar(Usuario user){
        ArrayList<Atividade> lista = null;
        persistencia = new AtividadeBD();
        try{
            //busca o Usuario
            lista = persistencia.listar(user.getId());
            return lista;
        }catch(Exception e ){
            System.out.println(e);
        }
        return null;
    }
    
    
    /**
     * Busca o usuario pelo id do objeto
     * Caso encontre, retorna o usuário encontrado e seta as váriaveis do objeto no objeto atual
     * Caso não encontre, retorna null.
     * @return
     */
    public Atividade buscar(int idAtividade){
        Atividade retorno;
        persistencia = new AtividadeBD();
        try{
            //busca o Usuario
            retorno = persistencia.buscar(idAtividade);
            //verifica se encontrou registro
            if(retorno == null){
                //retorna objeto como null caso não encontra
                return null;
            }
            this.titulo = retorno.titulo;
            this.descricao = retorno.descricao;
            this.horarioFinal = retorno.horarioFinal;
            this.horarioInicial = retorno.horarioInicial;
            this.data = retorno.data;
            this.idCategoria = retorno.idCategoria;
            this.idExpediente = retorno.idExpediente;
            this.idSubCategoria = retorno.idSubCategoria;
            this.idUsuario = retorno.idUsuario;
            this.listaParticipacaoAtividade = retorno.listaParticipacaoAtividade;
        }catch(Exception e ){
            System.out.println(e);
        }
        return this;
    }
    
    public String identificarUsuarioDiferente(ParticipacaoAtividade participacaoAtividade){
        out.println(participacaoAtividade.getIdUsuario());
        out.println(this.idUsuario);
        if(participacaoAtividade.getIdUsuario()== this.idUsuario){
            //não é usuario diferente
            return "";
        }else{
        //retorna o texto
            return "Voce foi registrado como Participante na Atividade: "+this.id+"-"+this.getTitulo()+" horaInicial: "+participacaoAtividade.getHorarioInicial()+ "Hora Final: "+participacaoAtividade.getHorarioFinal();
        }
        
    }
    
    
    
        public void carregarHtmlTop(String nome){
            String logout="";
            if(nome==""){
                logout="";
            }else
                logout="LOGOUT";
    this.htmlTop = "<!DOCTYPE html>\n" +
"<html lang=\"PT\">\n" +
"\n" +
"<head>\n" +
"    <meta charset=\"utf-8\">\n" +
"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
"\n" +
"    <title>DailyLog</title>\n" +
"	\n" +
"    <!-- Bootstrap -->\n" +
"    <link href=\"./css/bootstrap.min.css\" rel=\"stylesheet\">\n" +
"    <!-- Font Awesome -->\n" +
"    <link href=\"./css/font-awesome.min.css\" rel=\"stylesheet\">\n" +
"    <!-- NProgress -->\n" +
"    <link href=\"./css/nprogress.css\" rel=\"stylesheet\">\n" +
"    <!-- iCheck -->\n" +
"    <link href=\"./css/green.css\" rel=\"stylesheet\">\n" +
"    <!-- bootstrap-daterangepicker -->\n" +
"    <link href=\"./css/daterangepicker.css\" rel=\"stylesheet\">\n" +
"    <!-- Custom Theme Style -->\n" +
"    <link href=\"./css/custom.min.css\" rel=\"stylesheet\">\n" +
"</head>\n" +
"\n" +
"<body class=\"nav-md\">\n" +
"    <div class=\"container body\">\n" +
"\n" +
"        <div class=\"main_container\">\n" +
"            <div class=\"col-md-3 left_col\" style=\"position: fixed;\">\n" +
"                <div class=\"left_col scroll-view\">\n" +
"\n" +
"\n" +
"                    <!-- Menu Lateral -->\n" +
"                    <div class=\"navbar nav_title\" style=\"border: 10;\">\n" +
"                        <a href=\"\" class=\"site_title\"><i class=\"fa fa-calendar\"></i><span>  DailyLog</span></a>\n" +
"                    </div>\n" +
"\n" +
"                    <div id=\"sidebar-menu\" class=\"main_menu_side hidden-print main_menu\">\n" +
"                        <div class=\"menu_section\">\n" +
"                            <ul class=\"nav side-menu\"></ul>\n" +
"                            <ul class=\"nav side-menu\">\n" +
"                                <li><a><i class=\"fa fa-home\"></i> Home <span class=\"fa fa-chevron-down\"></span></a>\n" +
"                                    <ul class=\"nav child_menu\">\n" +
"                                        <li><a href=\"./servlet_menuPrincipal\">Home</a></li>\n" +
"                                    </ul>\n" +
"                                </li>\n" +
"                                <li><a><i class=\"fa fa-plus-circle\"></i> Atividade <span class=\"fa fa-chevron-down\"></span></a>\n" +
"                                    <ul class=\"nav child_menu\">\n" +
"                                        <li><a href=\"./servlet_listaAtividades\">Criar Atividade</a></li>\n" +
"                                        <li><a href=\"./servlet_listaAtividades\">Criar Participacao Atividade</a></li>\n" +
"                                    </ul>\n" +
"                                </li>\n" +
"                                <li><a><i class=\"fa fa-plus-circle\"></i> Expediente <span class=\"fa fa-chevron-down\"></span></a>\n" +
"                                    <ul class=\"nav child_menu\">\n" +
"                                        <li><a href=\"./servlet_expediente\">Registrar Expediente</a></li>\n" +
"                                    </ul>\n" +
"                                </li>\n" +
"                                <li><a><i class=\"fa fa-plus-circle\"></i> Perfil <span class=\"fa fa-chevron-down\"></span></a>\n" +
"                                    <ul class=\"nav child_menu\">\n" +
"                                        <li><a href=\"./servlet_perfil\">Criar Perfil</a></li>\n" +
"                                        <li><a href=\"./servlet_listaPerfils\">Listar Perfil</a></li>\n" +
"                                    </ul>\n" +
"                                </li>\n" +
"                                <li><a><i class=\"fa fa-plus-circle\"></i> Usuarios <span class=\"fa fa-chevron-down\"></span></a>\n" +
"                                    <ul class=\"nav child_menu\">\n" +

"                                        <li><a href=\"./servlet_listaUsuarios\">Listar Usuarios</a></li>\n" +
"                                    </ul>\n" +
"                                </li>\n" +
"                                <li><a><i class=\"fa fa-bar-chart\"></i> Relatórios <span class=\"fa fa-chevron-down\"></span></a>\n" +
"                                    <ul class=\"nav child_menu\">\n" +


"                                    </ul>\n" +
"                                </li>\n" +
"                                <li><a><i class=\"fa fa-tasks\"></i> Categoria <span class=\"fa fa-chevron-down\"></span></a>\n" +
"                                    <ul class=\"nav child_menu\">\n" +


"                                    </ul>\n" +
"                                </li>\n" ;
    if(nome==""){
            this.htmlTop += 
"                                <li><a><i class=\"fa fa-gear\"></i>LOGIN<span class=\"fa fa-chevron-down\"></span></a>\n" +
"                                    <ul class=\"nav child_menu\">\n" +
"                                        <li><a href=\"./servlet_login\">LOGIN</a></li>\n" +
"                                    </ul>\n" +
"                                </li>\n" ;
    }
    else{
        this.htmlTop += 
"                                <li><a><i class=\"fa fa-gear\"></i>"+nome+"<span class=\"fa fa-chevron-down\"></span></a>\n" +
"                                    <ul class=\"nav child_menu\">\n" +
"                                        <li><a href=\"./servlet_logout\">"+logout+"</a></li>\n" +
"                                    </ul>\n" +
"                                </li>\n" ;
        }
    this.htmlTop+=
"                                <li><a><i class=\"fa fa-gear\"></i> Configurações </a>\n" +
"                            </ul>\n" +
"                        </div>\n" +
"                    </div>\n" +
"                    <!-- /Menu Lateral -->\n" +
"                </div>\n" +
"            </div>\n" +
"\n" +
"            <!-- Barra Superior -->\n" +
"            <div class=\"top_nav\">\n" +
"                <div class=\"nav_menu\">\n" +
"                    <nav>\n" +
"                        <div class=\"nav toggle\">\n" +
"                            <a id=\"menu_toggle\"><i class=\"fa fa-bars\"></i></a>\n" +
"                        </div>\n" +
"\n" +
"                        <ul class=\"nav navbar-nav navbar-right\">\n" +
"                            <li class=\"\">\n" +
"                                <a href=\"javascript:;\" class=\"user-profile dropdown-toggle\" data-toggle=\"dropdown\" aria-expanded=\"false\">\n" +
"                    <i class=\"fa fa-user\"></i>  "+nome+"\n" +
"                    <span class=\" fa fa-angle-down\"></span>\n" +
"                  </a>\n" +
"                                <ul class=\"dropdown-menu dropdown-usermenu pull-right\">\n" +
"                                    <li><a href=\"javascript:;\">Ajuda</a></li>\n" +
"                                    <li><a href=\"servlet_logout\"><i class=\"fa fa-sign-out pull-right\"></i> Sair</a></li>\n" +
"                                </ul>\n" +
"                            </li>\n" +
"                        </ul>\n" +
"                    </nav>\n" +
"                </div>\n" +
"            </div>\n" +
"            <!-- /Barra superior -->\n";
    }
    
    public void carregarHtmlFooter(){
    this.htmlFooter = " </div>\n" +
"    </div>\n" +
"	\n" +
"    <!-- footer content -->\n" +
"    <footer>\n" +
"        <!--------- RODAPÉ -------->\n" +
"        <div class=\"pull-right\">\n" +
"            Bootstrap Admin Template by <a href=\"https://colorlib.com/\">Colorlib</a>\n" +
"        </div>\n" +
"    </footer>\n" +
"    <!-- /footer content -->\n" +
"    </div>\n" +
"\n" +
"    <!-- jQuery -->\n" +
"    <script src=\"./js/jquery.min.js\"></script>\n" +
"    <!-- Bootstrap -->\n" +
"    <script src=\"./js/bootstrap.min.js\"></script>\n" +
"    <!-- bootstrap-daterangepicker -->\n" +
"    <script src=\"./js/moment.min.js\"></script>\n" +
"    <script src=\"./js/daterangepicker.js\"></script>\n" +
"    <!-- Custom Theme Scripts -->\n" +
"    <script src=\"./js/custom.min.js\"></script>\n" +
"	<script src=\"./js/w3-include-HTML.js\"></script>\n" +
"\n" +
"\n" +
"	<!-- Filtro -->\n" +
"    <div class=\"jqvmap-label\" style=\"display: none;\"></div>\n" +
"    <div class=\"daterangepicker dropdown-menu ltr opensleft\">\n" +
"        <div class=\"calendar left\">\n" +
"            <div class=\"daterangepicker_input\"><input class=\"input-mini form-control\" type=\"text\" name=\"daterangepicker_start\" value=\"\"><i class=\"fa fa-calendar glyphicon glyphicon-calendar\"></i>\n" +
"                <div class=\"calendar-time\" style=\"display: none;\">\n" +
"                    <div></div><i class=\"fa fa-clock-o glyphicon glyphicon-time\"></i></div>\n" +
"            </div>\n" +
"            <div class=\"calendar-table\"></div>\n" +
"        </div>\n" +
"        <div class=\"calendar right\">\n" +
"            <div class=\"daterangepicker_input\"><input class=\"input-mini form-control\" type=\"text\" name=\"daterangepicker_end\" value=\"\"><i class=\"fa fa-calendar glyphicon glyphicon-calendar\"></i>\n" +
"                <div class=\"calendar-time\" style=\"display: none;\">\n" +
"                    <div></div><i class=\"fa fa-clock-o glyphicon glyphicon-time\"></i></div>\n" +
"            </div>\n" +
"            <div class=\"calendar-table\"></div>\n" +
"        </div>\n" +
"        <div class=\"ranges\">\n" +
"            <ul>\n" +
"                <li data-range-key=\"Today\">Today</li>\n" +
"                <li data-range-key=\"Yesterday\">Yesterday</li>\n" +
"                <li data-range-key=\"Last 7 Days\">Last 7 Days</li>\n" +
"                <li data-range-key=\"Last 30 Days\">Last 30 Days</li>\n" +
"                <li data-range-key=\"This Month\">This Month</li>\n" +
"                <li data-range-key=\"Last Month\">Last Month</li>\n" +
"                <li data-range-key=\"Custom\">Custom</li>\n" +
"            </ul>\n" +
"            <div class=\"range_inputs\"><button class=\"applyBtn btn btn-default btn-small btn-primary\" disabled=\"disabled\" type=\"button\">Submit</button> <button class=\"cancelBtn btn btn-default btn-small\" type=\"button\">Clear</button></div>\n" +
"        </div>\n" +
"    </div>\n" +
"	<!-- /Filtro -->\n" +
"</body>\n" +
"</html>";
    }
   
}
