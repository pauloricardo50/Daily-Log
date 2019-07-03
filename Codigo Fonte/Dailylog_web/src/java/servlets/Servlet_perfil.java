/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dailylog.Atividade;
import dailylog.Aviso;
import dailylog.Perfil;
import dailylog.Permissao;
import dailylog.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sun.security.util.Pem;

/**
 *
 * @author jardielma
 */
public class Servlet_perfil extends HttpServlet {

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
            if(session==null){
                response.sendRedirect("./servlet_login");
            }else{
                //verifico se tem permissão de acesso
                id_usuario_logado = session.getAttribute("sessao_id_usuario").toString();
                nome_usuario_logado = session.getAttribute("sessao_nome_usuario").toString();

            }
            
            Usuario usuario = new Usuario();
            usuario.setId(Integer.parseInt(id_usuario_logado));
            usuario.buscar();
            String tabela_avisos = verificarAvisos(usuario);
            //Verifico a permissão do usuário para essa página
            if(verificarPermissao(usuario)==false){
                response.sendRedirect("./servlet_errorPermissao");
            }
            
            
            
            String id = "";
            id = request.getParameter("id_perfil");
            String descricao = "";
            String horarioPadraoInicial= "";
            String horarioPadraoFinal= "";
            String tamanhoFonte= "";
            String autoContraste= "";
            Perfil perfil = new Perfil();
            String permissao = "";
            //pagina para atualização
            if(id!=null){
                perfil.setId(Integer.parseInt(id));
                perfil.buscar();
                descricao = perfil.getDescricao();
                horarioPadraoFinal = perfil.getHorarioPadraoFinal();
                horarioPadraoInicial = perfil.getHorarioPadraoInicial();
                tamanhoFonte = Integer.toString(perfil.getTamanhoFonte());
                autoContraste = perfil.getAutoContraste();
                permissao = listarPermissao(perfil.getPemissoes().get(0).getId());
            }else{
                id = "0";
                perfil.setId(0);
                permissao = listarPermissao(0);
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
                    "                                    <h2>Perfil</h2>\n" +
                    "                                    <div class=\"clearfix\"></div>\n" +
                    "                                </div>\n" +
                    "                                <div class=\"x_content\">\n" +
                    tabela_avisos;
        html +=
                "            <form action=\"servlet_perfil\" method=\"POST\">\n" +
                "                <div class=\"row\">\n" +
                                    "                    <div class=\"col-xs-2\">\n" +
                "                        <label>ID do Perfil</label>\n" +
                "                        <input type=\"text\" class=\"form-control form-control-sm\" name=\"id_perfil\"  placeholder=\"id_perfil\" value=\""+id+"\"readonly>                        \n" +
                "                    </div>\n" +
                "                    <div class=\"col-xs-4\">\n" +
                "                        <label>Descricao</label>\n" +
                "                        <input type=\"text\" class=\"form-control form-control-sm\" name=\"descricao\"  placeholder=\"descricao\" value=\""+descricao+"\">                        \n" +
                "                    </div>\n" +
                "                    <div class=\"col-xs-2\">\n" +
                "                        <label>Tamanho da Fonte</label>\n" +
                "                        <input type=\"text\" class=\"form-control form-control-sm\" name=\"tamanhoFonte\" placeholder=\"tamanhoFonte\" value=\""+tamanhoFonte+"\">\n" +
                "                    </div>\n" +
                "                    <div class=\"col-xs-2\">\n" +
                "                        <label>Auto Contraste</label>\n" +
                "                        <input type=\"text\" class=\"form-control form-control-sm\" name=\"autoContraste\" placeholder=\"autoContraste\" value=\""+autoContraste+"\">\n" +
                "                    </div>\n" +

                "                </div>\n" +
                "                <div class=\"row\">\n" +
                "                   <div class=\"col-xs-2\">\n" +
                "                        <label>Inicio Padrão - HH:MM:SS</label>\n" +
                "                        <input type=\"text\" class=\"form-control form-control-sm\" name=\"inicio\" placeholder=\"inicio\" value=\""+horarioPadraoInicial+"\">\n" +
                "                    </div>\n" +
                "                           <div class=\"col-xs-2\">\n" +
                "                        <label>Fim Padrão - HH:MM:SS</label>\n" +
                "                        <input type=\"text\" class=\"form-control form-control-sm\" name=\"fim\" placeholder=\"fim\" value=\""+horarioPadraoFinal+"\">\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "                <div class=\"row\">\n" +
                "                    <div class=\"col-xs-4\">\n" +
                "                        <label>Selecione a Permissao</label>\n" +                       
                                            permissao +
                "                          </div>\n" +
                "                </div>\n" +
                "                <div class=\"row\">\n" +
                "                    <div style=\"margin-top: 2%; margin-left: 42.7%\">\n" +
                "                        <button type=\"submit\" class=\"btn btn-primary\">Enviar</button>\n" +
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
        
        Perfil perfil = new Perfil();
        
        
        perfil.setId(Integer.parseInt(request.getParameter("id_perfil")));
        perfil.setAutoContraste(request.getParameter("autoContraste"));
        perfil.setDescricao(request.getParameter("descricao"));
        perfil.setHorarioPadraoFinal(request.getParameter("fim"));
        perfil.setHorarioPadraoInicial(request.getParameter("inicio"));
        perfil.setTamanhoFonte(Integer.parseInt(request.getParameter("tamanhoFonte")));
        Permissao permissao = new Permissao();
        permissao.setId(Integer.parseInt(request.getParameter("perfil")));
        permissao.buscar();
        ArrayList<Permissao>lista =  new ArrayList<Permissao>();
        lista.add(permissao);
        perfil.setPermissoes(lista);
        

        //salva
        perfil.salvar();
        //redireciona
        response.sendRedirect("./servlet_listaPerfis");
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

    
    
        public String listarPermissao(int id_permissao){
        String retorno = "<select name=\"perfil\" class=\"form-control form-control-sm\" >\n";
        Permissao permissao = new Permissao();
        
        ArrayList<dailylog.Permissao> lista ;
        lista = permissao.listar();
        if(lista.isEmpty()){
            return retorno + "</select>\n";
        }else{
            for(Permissao perf : lista){
                if(id_permissao==perf.getId()){
                    retorno +=  "<option selected value=\""+perf.getId()+"\">"+perf.getDescricao()+"</option>\n";
                }
                else{
                    retorno +=  "<option value=\""+perf.getId()+"\">"+perf.getDescricao()+"</option>\n";
                }
            }
        }
        return retorno + "</select>\n";
    }
    
        public boolean verificarPermissao(Usuario usuario){
        //Método que verifica se o usuário tem permissão nessa página
        //Lista Usuarios é permitido para PERFIL: Cadastro e Administrador Geral
        
        ArrayList<Permissao> lista;
        lista = usuario.getPerfil().getPemissoes();
        for(Permissao linha:lista){
            if(linha.getDescricao().equals("Total"))
                return true;
            if(linha.getDescricao().equals("Registro de Categorias"))
                return true;
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
