/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dailylog.Atividade;
import dailylog.Aviso;
import dailylog.Expediente;
import dailylog.ParticipacaoAtividade;
import dailylog.SubCategoria;
import dailylog.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jardielma
 */
public class Servlet_excluirAtividade extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
String id_usuario_logado="";
            String nome_usuario_logado="";
            HttpSession session = request.getSession(false);
            if(session!=null){
                //verifico se tem permissão de acesso
                id_usuario_logado = session.getAttribute("sessao_id_usuario").toString();
                nome_usuario_logado = session.getAttribute("sessao_nome_usuario").toString();
            }
            else{
                request.getRequestDispatcher("./servlet_login").include(request, response);  
            }
            
            Usuario logado = new Usuario();
            logado.setId(Integer.parseInt(id_usuario_logado));
            logado.buscar();
            String tabela_avisos = verificarAvisos(logado);
                    
            
            //Verificamos se é passado um usuário como parâmetro
            String id_user = "";
            id_user = request.getParameter("id_user");
            
            if(id_user==null){
                response.sendRedirect("./servlet_errorUsuario");
            }
            //Verificamos se é passado uma atividade como parâmetro
            //Caso seja passado é uma página de edição
            //Caso não seja passado é uma página de criação
            String id_atividade = "";
            id_atividade = request.getParameter("id_atividade");
            
            //Criação das variáveis locais
            String titulo="";
            String descricao="";
            String horaInicio="";
            String horaFim="";
            String data="";
            String expediente="";
            String subcategoria="";
            String participacaoAtividade ="";
            String nome ="";
            String matricula = "";
            Usuario user;
            Atividade atividade;
            user = new Usuario();
                user.setId(Integer.parseInt(id_user));
                user.buscar();
                nome = user.getNome();
                matricula = user.getMatricula();
           atividade = new Atividade();     
            if(id_atividade!=null){
                
                atividade.setId(Integer.parseInt(id_atividade));
                atividade.buscar(Integer.parseInt(id_atividade));
                titulo=atividade.getTitulo();
                descricao = atividade.getDescricao();
                horaInicio = atividade.getHorarioInicial();
                horaFim = atividade.getHorarioFinal();
                data = atividade.getData().toString();
                //expediente = Integer.toString(atividade.getIdExpediente());
                expediente = listarExpediente(user, atividade.getIdExpediente());
                //subcategoria = Integer.toString(atividade.getIdSubCategoria());
                subcategoria = listarSubCategorias(atividade.getIdSubCategoria());
                participacaoAtividade = listarParticipacaoAtividades(atividade,true);
                
            }else{
                id_atividade="0";
                subcategoria = listarSubCategorias(0);
                expediente = listarExpediente(user, 0);
            }
            //String listaPerfil = listarPerfil(perfil);
            String html="";
            
            atividade.carregarHtmlFooter();
            atividade.carregarHtmlTop(nome_usuario_logado);
            
            html = atividade.getHtmlTop();
            html += "<div class=\"right_col\" role=\"main\" style=\"min-height: 1775px;\">\n" +
                    "                <div class=\"row\">\n" +
                    "                    <div class=\"col-md-12 col-sm-12 col-xs-12\">\n" +
                    "                        <!-- Calendário -->\n" +
                    "                        <div class=\"row x_title\">\n" +
                    "                            <div class=\"col-md-6\">\n" +
                    "                                <h2>\n" +
                    "                                    <div id=\"data\"></div>\n" +
                    "                                </h2>\n" +
                    "                            </div>\n" +
                    "                            <div class=\"col-md-6\">\n" +
                    "                                <div id=\"reportrange\" class=\"pull-right\" style=\"background: #fff; cursor: pointer; padding: 5px 10px; border: 1px solid #ccc\">\n" +
                    "                                    <i class=\"glyphicon glyphicon-calendar fa fa-calendar\"></i>\n" +
                    "                                    <span></span> <b class=\"caret\"></b>\n" +
                    "                                </div>\n" +
                    "                            </div>\n" +
                    "                        </div>\n" +
                    "                        <!-- /Calendário-->\n" +
                    "                        <!--conteudo-->\n" +
                    "                        <div class=\"col-md-8 col-sm-8 col-xs-12\">\n" +
                    "                            <div class=\"x_panel\">\n" +
                    "                                <div class=\"x_title\">\n" +
                    "                                    <h2>Atividade</h2>\n" +
                    "                                    <div class=\"clearfix\"></div>\n" +
                    "                                </div>\n" +
                    "                                <div class=\"x_content\">\n" +
                    tabela_avisos;
        html +=
                "            <form action=\"servlet_excluirAtividade\" method=\"POST\">\n" +
                "                <div class=\"row\">\n" +
                "                    <div class=\"col-xs-2\">\n" +
                "                        <label>Id Usuario</label>\n" +
                "                        <input type=\"text\" class=\"form-control form-control-sm\" name=\"id_usuario\" placeholder=\"id_usuario\" value=\""+user.getId()+"\" readonly>\n" +
                "                    </div>\n" +
                "                    <div class=\"col-xs-4\">\n" +
                "                        <label>Nome do Usuário</label>\n" +
                "                        <input type=\"text\" class=\"form-control form-control-sm\" name=\"nome\"  placeholder=\"nome\" value=\""+nome+"\" readonly>                        \n" +
                "                    </div>\n" +
                "                    <div class=\"col-xs-2\">\n" +
                "                        <label>Matricula</label>\n" +
                "                        <input type=\"text\" class=\"form-control form-control-sm\" name=\"matricula\" placeholder=\"matricula\" value=\""+matricula+"\" readonly>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "                <div class=\"row\">\n" +
                                    "                    <div class=\"col-xs-2\">\n" +
                "                        <label>Id Atividade</label>\n" +
                "                        <input type=\"text\" class=\"form-control form-control-sm\" name=\"idatividade\" placeholder=\"id_atividade\" value=\""+id_atividade+"\" readonly>\n" +
                "                    </div>\n" +
                "                    <div class=\"col-xs-2\">\n" +
                "                        <label>Título</label>\n" +
                "                        <input type=\"text\" class=\"form-control form-control-sm\" name=\"titulo\" placeholder=\"titulo\" value=\""+titulo+"\" readonly>\n" +
                "                    </div>\n" +
                "                    <div class=\"col-xs-2\">\n" +
                "                        <label>Data - AAAA-MM-DD</label>\n" +
                "                        <input type=\"text\" class=\"form-control form-control-sm\" name=\"data\" placeholder=\"data\" value=\""+data+"\" readonly>\n" +
                "                    </div>\n" +
                "                   <div class=\"col-xs-2\">\n" +
                "                        <label>Inicio - HH:MM:SS</label>\n" +
                "                        <input type=\"text\" class=\"form-control form-control-sm\" name=\"inicio\" placeholder=\"inicio\" value=\""+horaInicio+"\" readonly>\n" +
                "                    </div>\n" +
                "                           <div class=\"col-xs-2\">\n" +
                "                        <label>Fim - HH:MM:SS</label>\n" +
                "                        <input type=\"text\" class=\"form-control form-control-sm\" name=\"fim\" placeholder=\"fim\" value=\""+horaFim+"\" readonly>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "                <div class=\"row\">\n" +
                "                    <div class=\"col-xs-4\">\n" +
                "                        <label>Sub-Categoria</label>\n" +                       
                                            subcategoria +
                "                          </div>\n" +
                    "                    <div class=\"col-xs-4\">\n" +
                "                        <label>Expediente</label>\n" +                       
                                            expediente +
                "                          </div>\n" +
                "                </div>\n" +
                    
                                    "                <div class=\"row\">\n" +
                "                    <div class=\"col-xs-4\">\n" +
                "                        <label>Descricao</label>\n" +                       
                "                        <input type=\"textbox\" class=\"form-control form-control-sm\" name=\"descricao\" placeholder=\"descricao\" value=\""+descricao+"\" readonly>\n" +                             
                "                          </div>\n" +
                "                </div>\n" +
                    
                                    "                <div class=\"row\">\n" +
                "                    <div class=\"col-xs-4\">\n" +
                                            
                "                          </div>\n" +
                "                </div>\n" +
                "                <div class=\"row\">\n" +
                "                    <div style=\"margin-top: 2%; margin-left: 42.7%\">\n" +
                "                        <button type=\"submit\" class=\"btn btn-primary\">Deletar</button>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </form>\n" ;
                    
       html +="                            </div>\n" +
                    "                        </div>\n" +
                    "                   </div>\n" +
                    "                </div>\n" +
                    "</div>\n" +
               participacaoAtividade +
                    "                            </div>\n" +
                    "                            </div>\n" +
                    "                            </div>\n" ;
       
            
            html += atividade.getHtmlFooter();

            out.println(html);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                 String id_atividade = request.getParameter("idatividade");
         Atividade atividade = new Atividade();
        //carrega a informações no objeto
        if(id_atividade!=null){
            //Update
            atividade.setId(Integer.parseInt(id_atividade));
        }else{
            //Create
            atividade.setId(0);
        }
        atividade.deletar();
        
        response.sendRedirect("./servlet_listaAtividades");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
        
    public String listarExpediente(Usuario user, int id_expediente){
        String retorno = "<select name=\"expediente\" class=\"form-control form-control-sm\" readonly>\n";
        Expediente expediente = new Expediente();
        ArrayList<Expediente> lista;
        expediente.setId(id_expediente);
        expediente.buscar();
        lista = expediente.listar(user);
        
        if(lista.isEmpty()){
            return retorno + "</select>\n";
        }else{
            for(Expediente linha : lista){
                if(id_expediente==linha.getId()){
                    retorno +=  "<option selected value=\""+linha.getId()+"\">"+linha.getData().toString()+"--"+linha.getHorarioInicial()+"--"+linha.getHorarioFinal()+"</option>\n";
                }
                else{
                    retorno +=  "<option value=\""+linha.getId()+"\">"+linha.getData().toString()+"--"+linha.getHorarioInicial()+"--"+linha.getHorarioFinal()+"</option>\n";
                }
            }
        }
        return retorno + "</select>\n";
    }
    
    public String listarSubCategorias(int idSubCategorias){
        String retorno = "<select name=\"subCategoria\" class=\"form-control form-control-sm\" readonly>\n";
        SubCategoria subCategoria = new SubCategoria();
        ArrayList<SubCategoria> lista;
        lista = subCategoria.listar();
        
        if(lista.isEmpty()){
            return retorno + "</select>\n";
        }else{
            for(SubCategoria subcat : lista){
                if(idSubCategorias==subcat.getId()){
                    retorno +=  "<option selected value=\""+subcat.getId()+"\">"+subcat.getDescricao()+"</option>\n";
                }
                else{
                    retorno +=  "<option value=\""+subcat.getId()+"\">"+subcat.getDescricao()+"</option>\n";
                }
            }
        }
        return retorno + "</select>\n";
    }
    public String listarParticipacaoAtividades(Atividade atividade){
        String retorno = "<label>Participações na Atividade</label>\n"
                + "<table style=\"width:100%\" readonly>\n"
                + "<tr>\n" +
                "    <th>ID</th>\n" +
                "    <th>TÍTULO</th>\n" +
                "    <th>INICIO</th>\n" +
                "    <th>FIM</th>\n" +
                "    <th>ID Usuario</th>\n" +
                "    <th>Usuario Participante</th>\n" +
                "  </tr>";
        ArrayList<ParticipacaoAtividade> lista = atividade.getlistaParticipacaoAtividade();
        
        Usuario user = new Usuario();
        user.setId(atividade.getIdUsuario());
        Usuario usuarioParticipacao;
        
        for(ParticipacaoAtividade linha:lista){
            usuarioParticipacao = new Usuario();
            usuarioParticipacao.setId(linha.getIdUsuario());
            usuarioParticipacao.buscar();
            retorno+="<tr>\n"
                    + "<td>"+linha.getId()+"</td>\n"
                    + "<td>"+linha.getTitulo()+"</td>\n"
                    + "<td>"+linha.getHorarioInicial().toString()+"-"+linha.getDataInicial().toString()+"</td>\n"
                    + "<td>"+linha.getHorarioFinal().toString()+"-"+linha.getDataFinal().toString()+"</td>\n"
                    + "<td>"+usuarioParticipacao.getId()+"</td>\n"
                    + "<td>"+usuarioParticipacao.getNome()+"</td>\n"                    
                    
                    + "</tr>";
        }
        retorno+="<tr>\n"
                    + "</tr>"
                    + "</table>";
        return retorno + "<a href=\"./servlet_participacaoAtividade?id_atividade="+atividade.getId()+ "&id_user="+atividade.getIdUsuario()+"\" class=\"button\">Registrar nova Participação na Atividade</a>\n";
    }
    
    
    public String listarParticipacaoAtividades(Atividade atividade,boolean template){
            Usuario user = new Usuario();
        String retorno;
                        retorno = "                        <!--conteudo-->\n" +
                    "                        <div class=\"col-md-8 col-sm-8 col-xs-12\">\n" +
                    "                            <div class=\"x_panel\">\n" +
                    "                                <div class=\"x_title\">\n" +
                    "                                    <h2>Participações na Atividade</h2>\n" +
                                "                        <span style=\"float:right;\"><h2><a href=\"./servlet_participacaoAtividade?id_atividade="+atividade.getId()+ "&id_user="+atividade.getIdUsuario()+"\" >Registrar nova Participação</a></h2></span>\n" +
                    "                                    <div class=\"clearfix\"></div>\n" +
                    "                                </div>\n" +
                    "                                <div class=\"x_content\">\n";

                retorno += 
                    "                                    <table class=\"table table-hover\">\n" +
                    "                                        <thead>\n" +
                                                                "<tr>\n" +
                                                               "    <th>ID</th>\n" +
                                                               "    <th>TÍTULO</th>\n" +
                                                               "    <th>INICIO</th>\n" +
                                                               "    <th>FIM</th>\n" +
                                                               "    <th>ID Usuario</th>\n" +
                                                               "    <th>Usuario Participante</th>\n" +
                                                               "  </tr>\n"+
                    "                                        </thead>\n" +
                    "                                        <tbody>\n";

        ArrayList<ParticipacaoAtividade> lista = atividade.getlistaParticipacaoAtividade();
        
        user.setId(atividade.getIdUsuario());
        Usuario usuarioParticipacao;
        for(ParticipacaoAtividade linha:lista){
            usuarioParticipacao = new Usuario();
            usuarioParticipacao.setId(linha.getIdUsuario());
            usuarioParticipacao.buscar();
            retorno+="<tr>\n"
                    + "<td>"+linha.getId()+"</td>\n"
                    + "<td>"+linha.getTitulo()+"</td>\n"
                    + "<td>"+linha.getHorarioInicial().toString()+"-"+linha.getDataInicial().toString()+"</td>\n"
                    + "<td>"+linha.getHorarioFinal().toString()+"-"+linha.getDataFinal().toString()+"</td>\n"
                    + "<td>"+usuarioParticipacao.getId()+"</td>\n"
                    + "<td>"+usuarioParticipacao.getNome()+"</td>\n"                    
                    
                    + "</tr>";
        }
//                retorno+="<tr>\n"
//                    + "<td><a href=\"./servlet_atividade?id_user="+user.getId()+"\" >Criar nova Atividade</a></td>\n"
//                    + "</tr>";
        retorno += "                                        </tbody>\n" +
                    "                                    </table>\n"  +
                    "\n" +
                    "                                </div>\n" +
                    "                            </div>\n" +
                    "                        </div>\n" +
                    "                    </div>\n";
        
        return retorno;
    }
    
                    public String verificarAvisos(Usuario usuario_logado){
        
        
        String retorno = "<span style=\"float:center;\"><h2>Mensagens de Aviso importantes</h2>\n</span>"
                + "<table class=\"table table-hover\">\n"
                + "<tr>\n" +
                "    <th>ID</th>\n" +
                "    <th>Mensagem de Avisos</th>\n" +
                "  </tr>";
        Aviso aviso = new Aviso();
        aviso.setId_User(usuario_logado.getId());
        ArrayList<Aviso> lista;
        lista = aviso.listar();
        
        if(lista.size()==0){
        return "";
        }
        
        for(Aviso linha:lista){
            retorno+="<tr>\n"
                    + "<td>"+linha.getId()+"</td>\n"
                    + "<td>"+linha.getMensagem()+"</td>\n"
                    + "</tr>";
            linha.setFlag_ativo("H");
            linha.salvar();
        }
        retorno += " </table>\n";
        //out.println(retorno);
        return retorno;
        
    }

}
