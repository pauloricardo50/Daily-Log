/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceUsuario;

import Dominio.Atividade;
import Dominio.Aviso;
import Dominio.ParticipacaoAtividade;
import Dominio.Usuario;
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
public class Servlet_excluirParticipacaoAtividade extends HttpServlet {

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
            String id_atividade = "";
            id_atividade = request.getParameter("id_atividade");
            if(id_atividade==null){
                response.sendRedirect("./servlet_errorAtividade");
            }
            //Verificamos se é página de criação ou edição ou exclusão
            String id_participacaoAtividade = "";
            id_participacaoAtividade = request.getParameter("id_participacaoAtividade");
            
            //Criação das variáveis locais
            String titulo="";
            String descricao="";
            String horaInicio="";
            String horaFim="";
            String dataInicial="";
            String dataFinal="";
            String html_atividade ="";
            String usuario = "";
            String matricula ="";
            
            Usuario user;
            Atividade atividade;
            user = new Usuario();
            user.setId(Integer.parseInt(id_user));
            user.buscar();
            matricula = user.getMatricula();
            atividade = new Atividade();
            atividade.setId(Integer.parseInt(id_atividade));
            atividade.buscar(Integer.parseInt(id_atividade));
            
            //usuario = listarUsuarios(Integer.parseInt(id_user));
            ParticipacaoAtividade participacaoAtividade = new ParticipacaoAtividade();
            if(id_participacaoAtividade!=null){
                
                participacaoAtividade.setId(Integer.parseInt(id_participacaoAtividade));
                participacaoAtividade.buscar(Integer.parseInt(id_participacaoAtividade));
                
                titulo=participacaoAtividade.getTitulo();
                descricao = participacaoAtividade.getDescricao();
                horaInicio = participacaoAtividade.getHorarioInicial();
                horaFim = participacaoAtividade.getHorarioFinal();
                dataInicial = participacaoAtividade.getDataInicial().toString();
                dataFinal = participacaoAtividade.getDataFinal().toString();
                usuario = listarUsuarios(participacaoAtividade.getIdUsuario());
                
            }else{
                id_participacaoAtividade= "0";
                usuario = listarUsuarios(Integer.parseInt(id_user));
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
                    "                                    <h2>Participação na Atividade</h2>\n" +
                    "                                    <div class=\"clearfix\"></div>\n" +
                    "                                </div>\n" +
                    "                                <div class=\"x_content\">\n" +
                        tabela_avisos;
                
            html += "            <form action=\"servlet_excluirParticipacaoAtividade\" method=\"POST\">\n" +
                "                <div class=\"row\">\n" +
                                    "                    <div class=\"col-xs-4\">\n" +
                "                        <label>ID do Usuário</label>\n" +
                "                        <input type=\"text\" class=\"form-control form-control-sm\" name=\"id_user\"  placeholder=\"id_user\" value=\""+user.getId()+"\" readonly>                        \n" +
                "                    </div>\n" +
                "                    <div class=\"col-xs-4\">\n" +
                "                        <label>Nome do Usuário</label>\n" +
                "                        <input type=\"text\" class=\"form-control form-control-sm\" name=\"nome\"  placeholder=\"nome\" value=\""+user.getNome()+"\" readonly>                        \n" +
                "                    </div>\n" +
                "                    <div class=\"col-xs-2\">\n" +
                "                        <label>Matricula</label>\n" +
                "                        <input type=\"text\" class=\"form-control form-control-sm\" name=\"matricula\" placeholder=\"matricula\" value=\""+matricula+"\" readonly>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "    <div class=\"row\">\n" +
                "                    <div class=\"col-xs-4\">\n" +
                "                        <label>Atividade</label>\n" +
                "                        <input type=\"text\" class=\"form-control form-control-sm\" name=\"idAtividade\"   value=\""+atividade.getId()+"\" readonly>                        \n" +
                "                    </div>\n" +
                "                    <div class=\"col-xs-4\">\n" +
                "                        <label>Titulo</label>\n" +
                "                        <input type=\"textbox\" class=\"form-control form-control-sm\" name=\"atividade\" placeholder=\"atividade\" value=\""+atividade.getTitulo()+"\" readonly>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "                <div class=\"row\">\n" +
                "                    <div class=\"col-xs-2\">\n" +
                "                        <label>IdParticipacaoAtividade</label>\n" +
                "                        <input type=\"text\" class=\"form-control form-control-sm\" name=\"idParticipacaoAtividade\" placeholder=\"idParticipacaoAtividade\" value=\""+id_participacaoAtividade+"\" readonly>\n" +
                "                    </div>\n" +
                "                    <div class=\"col-xs-4\">\n" +
                "                        <label>Título</label>\n" +
                "                        <input type=\"text\" class=\"form-control form-control-sm\" name=\"titulo\" placeholder=\"titulo\" value=\""+titulo+"\" readonly>\n" +
                "                    </div>\n" +

                "                </div>\n" +
                "                <div class=\"row\">\n" +
                "                    <div class=\"col-xs-4\">\n" +
                "                        <label>Data Inicio - AAAA-MM-DD</label>\n" +
                "                        <input type=\"text\" class=\"form-control form-control-sm\" name=\"dataInicial\" placeholder=\"dataInicial\" value=\""+dataInicial+"\" readonly>\n" +
                "                    </div>\n" +
                "                    <div class=\"col-xs-4\">\n" +
                "                        <label>Data Final - AAAA-MM-DD</label>\n" +
                "                        <input type=\"text\" class=\"form-control form-control-sm\" name=\"dataFinal\" placeholder=\"dataFinal\" value=\""+dataFinal+"\" readonly>\n" +
                "                    </div>\n" +

                "                </div>\n" +
                "                <div class=\"row\">\n" +
                "                   <div class=\"col-xs-4\">\n" +
                "                        <label>Inicio - HH:MM:SS</label>\n" +
                "                        <input type=\"text\" class=\"form-control form-control-sm\" name=\"inicio\" placeholder=\"inicio\" value=\""+horaInicio+"\" readonly>\n" +
                "                    </div>\n" +
                "                           <div class=\"col-xs-4\">\n" +
                "                        <label>Fim - HH:MM:SS</label>\n" +
                "                        <input type=\"text\" class=\"form-control form-control-sm\" name=\"fim\" placeholder=\"fim\" value=\""+horaFim+"\" readonly>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "                <div class=\"row\">\n" +
                "                    <div class=\"col-xs-4\">\n" +
                "                        <label>Descricao</label>\n" +
                "                        <input type=\"text\" class=\"form-control form-control-sm\" name=\"descricao\" placeholder=\"descricao\" value=\""+descricao+"\" readonly>\n" +                  
                "                          </div>\n" +
                "                </div>\n" +
                "                <div class=\"row\">\n" +
                "                    <div class=\"col-xs-4\">\n" +
                "                        <label>Usuario</label>\n" +                       
                                            usuario +
                "                          </div>\n" +
                "                </div>\n" +
                                    "                <div class=\"row\">\n" +
                "                    <div class=\"col-xs-4\">\n" +
                "                        <label>Deseja Excluir a Participação na Atividade?</label>\n" +
                
                "                          </div>\n" +
                "                </div>\n" +
                                    
                "                <div class=\"row\">\n" +
                "                    <div style=\"margin-top: 2%; margin-left: 42.7%\">\n" +
                "                        <button type=\"submit\" class=\"btn btn-primary\">DELETAR</button>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </form>\n" +
                "        </div>\n" +
                "    </div>\n";
 html +="                            </div>\n" +
                    "                        </div>\n" +
                    "                   </div>\n" +
                    "                </div>\n" +
                    "</div>\n" +
               
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
         String id_participacaoAtividade = request.getParameter("idParticipacaoAtividade");
         ParticipacaoAtividade participacaoAtividade = new ParticipacaoAtividade();
        //carrega a informações no objeto
        if(id_participacaoAtividade!=null){
            //Update
            participacaoAtividade.setId(Integer.parseInt(id_participacaoAtividade));
        }else{
            //Create
            participacaoAtividade.setId(0);
        }
        participacaoAtividade.deletarParticipacaoAtividade();
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

    
    
        public String listarUsuarios(int id_usuario){
        String retorno = "<select name=\"id_usuarioParticipante\" class=\"form-control form-control-sm\" readonly>\n";
        Usuario usuario = new Usuario();
        ArrayList<Usuario> lista;
        lista = usuario.listar();
        
        if(lista.isEmpty()){
            return retorno + "</select>\n";
        }else{
            for(Usuario linha : lista){
                if(id_usuario==linha.getId()){
                    retorno +=  "<option selected value=\""+linha.getId()+"\">"+linha.getNome()+"</option>\n";
                }
                else{
                    retorno +=  "<option value=\""+linha.getId()+"\">"+linha.getNome()+"</option>\n";
                }
            }
        }
        return retorno + "</select>\n";
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
