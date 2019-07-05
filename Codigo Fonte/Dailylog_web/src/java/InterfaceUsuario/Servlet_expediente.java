/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceUsuario;

import Dominio.Atividade;
import Dominio.Aviso;
import Dominio.Expediente;
import Dominio.Perfil;
import Dominio.Permissao;
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
public class Servlet_expediente extends HttpServlet {

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
            Usuario usuario = new Usuario();
            usuario.setId(Integer.parseInt(id_usuario_logado));
            usuario.buscar();
            String tabela_aviso = verificarAvisos(usuario);
            
            
            
            
            String id = "";
            String id_expediente = "";
            id_expediente = request.getParameter("id_expediente");
            String nome="";
            String matricula="";
            String horaInicio="";
            String horaFim="";
            String data="";
            Expediente expediente = new Expediente();
            
            String senha="";
            int perfil = 0;
            Usuario user;
            user = new Usuario();
            id =  Integer.toString(usuario.getId());
                nome = usuario.getNome();
                senha = usuario.getSenha();
                perfil = usuario.getPerfil().getId();
                matricula = usuario.getMatricula();
            if(id_expediente!=null){
                expediente.setId(Integer.parseInt(id_expediente));
                expediente.buscar();
                
                horaInicio = expediente.getHorarioInicial();
                horaFim = expediente.getHorarioFinal();
                data = expediente.getData().toString();
            }else{
                id_expediente = "0";
            }
            
            String html="";
            Atividade atividade = new Atividade();
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
                    "                                    <h2>Registrar Expediente</h2>\n" +
                    "                                    <div class=\"clearfix\"></div>\n" +
                    "                                </div>\n" +
                    "                                <div class=\"x_content\">\n" +
                    tabela_aviso;
        html +=
                "            <form action=\"servlet_expediente\" method=\"POST\">\n" +
                "                <div class=\"row\">\n" +
                                    "                    <div class=\"col-xs-2\">\n" +
                "                        <label>ID do Usuário</label>\n" +
                "                        <input type=\"text\" class=\"form-control form-control-sm\" name=\"id_usuario\"  placeholder=\"nome\" value=\""+usuario.getId()+"\"readonly>                        \n" +
                "                    </div>\n" +
                                "            <form action=\"servlet_expediente\" method=\"POST\">\n" +
                "                <div class=\"row\">\n" +
                                    "                    <div class=\"col-xs-2\">\n" +
                                "                        <label>ID do Expediente</label>\n" +
                "                        <input type=\"text\" class=\"form-control form-control-sm\" name=\"id_expediente\"  placeholder=\"nome\" value=\""+id_expediente+"\"readonly>                        \n" +
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
                "                        <label>Senha</label>\n" +
                "                        <input type=\"password\" class=\"form-control form-control-sm\" name=\"senha\" placeholder=\"senha\" value=\""+senha+"\" readonly>\n" +
                "                    </div>\n" +
                "                    <div class=\"col-xs-2\">\n" +
                "                        <label>Senha</label>\n" +
                "                        <input type=\"password\" class=\"form-control form-control-sm\" name=\"senha_verificacao\" placeholder=\"senha_verificacao\" value=\""+senha+"\" readonly>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                                "                <div class=\"row\">\n" +
                "                    <div class=\"col-xs-2\">\n" +
                "                        <label>Data - AAAA-MM-DD</label>\n" +
                "                        <input type=\"text\" class=\"form-control form-control-sm\" name=\"data\" placeholder=\"data\" value=\""+data+"\">\n" +
                "                    </div>\n" +
                "                   <div class=\"col-xs-2\">\n" +
                "                        <label>Inicio - HH:MM:SS</label>\n" +
                "                        <input type=\"text\" class=\"form-control form-control-sm\" name=\"inicio\" placeholder=\"inicio\" value=\""+horaInicio+"\">\n" +
                "                    </div>\n" +
                "                           <div class=\"col-xs-2\">\n" +
                "                        <label>Fim - HH:MM:SS</label>\n" +
                "                        <input type=\"text\" class=\"form-control form-control-sm\" name=\"fim\" placeholder=\"fim\" value=\""+horaFim+"\">\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "                <div class=\"row\">\n" +
                "                    <div style=\"margin-top: 2%; margin-left: 42.7%\">\n" +
                "                        <button type=\"submit\" class=\"btn btn-primary\">Registrar</button>\n" +
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
        Expediente expediente = new Expediente();
                
        Usuario usuario = new Usuario();
        String id_usuario;
        
        
        id_usuario = request.getParameter("id_usuario");    
        //carrega a informações no objeto
        if(id_usuario!=null){
            //Update
            usuario.setId(Integer.parseInt(id_usuario));
        }else{
            //Create
            usuario.setId(0);
        }
        
        usuario.buscar();
        String id_expediente =  request.getParameter("id_expediente");   
        expediente.setId(Integer.parseInt(id_expediente));
        expediente.setFlagAtivo("A");
        expediente.setHorarioFinal(request.getParameter("fim"));
        expediente.setHorarioInicial(request.getParameter("inicio"));
        expediente.setData(request.getParameter("data"));
        expediente.setUsuario(usuario);
        
        expediente.salvar(expediente.getId());
        //redireciona
        response.sendRedirect("./servlet_listaUsuarios");
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

    
        public boolean verificarPermissao(Usuario usuario){
        //Método que verifica se o usuário tem permissão nessa página
        //Lista Usuarios é permitido para PERFIL: Cadastro e Administrador Geral
        ArrayList<Permissao> lista;
        lista = usuario.getPerfil().getPemissoes();
        for(Permissao linha:lista){
            if(linha.getDescricao().equals("Total")){
                return true;
            }
            if(linha.getDescricao().equals("Registro de Usuarios")){
                
                return true;
            }
        }        
        return false;
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
