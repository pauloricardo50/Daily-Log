/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dailylog.Atividade;
import dailylog.Aviso;
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
public class Servlet_listaAtividades extends HttpServlet {

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
                //verifico se sessão está criada
                id_usuario_logado = session.getAttribute("sessao_id_usuario").toString();
                nome_usuario_logado = session.getAttribute("sessao_nome_usuario").toString();
            }
            else{
                request.getRequestDispatcher("./servlet_login").include(request, response);  
            }
            
            
            String id = "";
            id = request.getParameter("id_user");
            if(id!=null){
                //response.sendRedirect("./servlet_login");
            }else{
                //response.sendRedirect("./servlet_login");
                id = id_usuario_logado;
            }
            Usuario usuario = new Usuario();
            usuario.setId(Integer.parseInt(id_usuario_logado));
            usuario.buscar();
            String tabela_avisos = verificarAvisos(usuario);
            String tabela = listaAtividades(Integer.parseInt(id), true,tabela_avisos);
            String html ="";
            Atividade atividade = new Atividade();
            atividade.carregarHtmlTop(nome_usuario_logado);
            atividade.carregarHtmlFooter();
            html = atividade.getHtmlTop();
            html += tabela;
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
        processRequest(request, response);
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

    
        public String listaAtividades(int id_user,String mensagem){
        
            String retorno = mensagem;
            retorno += "<table style=\"width:100%\">\n"
                + "<tr>\n" +
                "    <th>ID</th>\n" +
                "    <th>TÍTULO</th>\n" +
                "    <th>INICIO</th>\n" +
                "    <th>FIM</th>\n" +
                "    <th>Opção</th>\n" +
                "    <th>Opção</th>\n" +
                "  </tr>";
        Usuario user = new Usuario();
        user.setId(id_user);
        Atividade atividade = new Atividade();
        ArrayList<Atividade> lista;
        lista = atividade.listar(user);
        for(Atividade linha:lista){
            retorno+="<tr>\n"
                    + "<td>"+linha.getId()+"</td>\n"
                    + "<td>"+linha.getTitulo()+"</td>\n"
                    + "<td>"+linha.getHorarioInicial().toString()+"</td>\n"
                    + "<td>"+linha.getHorarioFinal().toString()+"</td>\n"
                    + "<td><a href=\"./servlet_atividade?id_atividade="+linha.getId()+ "&id_user="+user.getId()+"\" class=\"button\">Editar</a></td>\n"
                    + "<td><a href=\"./servlet_atividade?id_atividade="+linha.getId()+ "&id_user="+user.getId()+"\" class=\"button\">Excluir</a></td>\n"
                    + "</tr>";
        }
        retorno+="<tr>\n"
                    + "<td><a href=\"./servlet_atividade?id_user="+user.getId()+"\" class=\"button\">Criar nova Atividade</a></td>\n"
                    + "</tr>";
        return retorno+"</table>";
    }
        
public String listaAtividades(int id_user,boolean template,String mensagem){
            Usuario user = new Usuario();
        user.setId(id_user);
        String retorno = "";

                retorno = "<div class=\"right_col\" role=\"main\" style=\"min-height: 1775px;\">\n" +
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
                    "                                    <h2>Atividades</h2>\n" +
                    "                                    <span style=\"float:right;\"><h2><a href=\"./servlet_atividade?id_user="+id_user+"\" >Criar nova Atividade</a></h2>\n</span>"
                        + "<div class=\"clearfix\"></div>\n" +
                    "                                </div>\n" +
                    "                                <div class=\"x_content\">\n" +
                    mensagem+
                    "                                    <table class=\"table table-hover\">\n" +
                    "                                        <thead>\n" +
                    "                                            <tr>\n" +
                    "                                                <th>ID</th>\n" +
                    "                                                <th>TÍTULO</th>\n" +
                    "                                                <th>INICIO</th>\n" +
                    "                                                <th>FIM</th>\n" +
                    "                                                <th>OPÇÃO</th>\n" +
                    "                                                <th>OPÇÃO</th>\n" +
                    "                                            </tr>\n" +
                    "                                        </thead>\n" +
                    "                                        <tbody>\n";

        Atividade atividade = new Atividade();
        ArrayList<Atividade> lista;
        lista = atividade.listar(user);
        for(Atividade linha:lista){
            retorno+="<tr>\n"
                    + "<td>"+linha.getId()+"</td>\n"
                    + "<td>"+linha.getTitulo()+"</td>\n"
                    + "<td>"+linha.getHorarioInicial().toString()+"</td>\n"
                    + "<td>"+linha.getHorarioFinal().toString()+"</td>\n"
                    + "<td><a href=\"./servlet_atividade?id_atividade="+linha.getId()+ "&id_user="+user.getId()+"\" >Editar</a></td>\n"
                    + "<td><a href=\"./servlet_excluirAtividade?id_atividade="+linha.getId()+ "&id_user="+user.getId()+"\" >Excluir</a></td>\n"
                    + "</tr>";
        }
        retorno += "                                        </tbody>\n" +
                    "                                    </table>\n" +
                    "\n" +
                    "                                </div>\n" +
                    "                            </div>\n" +
                    "                        </div>\n" +
                    "                    </div>\n" +
                    "                </div>\n" +
                    "                <br>\n" +
                    "            </div>"
                + "        </div>\n" +
"    </div>";
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
