/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceUsuario;

import Dominio.Atividade;
import Dominio.Permissao;
import Dominio.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
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
public class Servlet_login extends HttpServlet {

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
        //verifica sessao
            HttpSession session = request.getSession(false);
            if(session!=null){
                response.sendRedirect("./servlet_listaUsuarios");
            }
                    //busca informações do form
        String mensagem;
            mensagem = request.getParameter("mensagem");
            if(mensagem==null){
                mensagem = "";
            }

            out.println(preparaHtmlLogin());
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

        String matricula;
        String senha;
        matricula = request.getParameter("matricula");
        senha = request.getParameter("senha");
        //carrega a informações no objeto
        Usuario usuario = new Usuario();
        usuario.setMatricula(matricula);
        usuario.setSenha(senha);
        //tenta fazer o login
        String resultado = usuario.login();
        //out.println(usuario.getId());
        if(resultado.length()>0){
            response.sendRedirect("./servlet_login?mensagem="+resultado+"");
        }else{
            //cria sessão
            boolean create = true;         
            HttpSession session = request.getSession(create);
            session.setAttribute ("sessao_id_usuario", usuario.getId());
            session.setAttribute ("sessao_nome_usuario", usuario.getNome());
            response.sendRedirect("./servlet_menuPrincipal");
//            usuario.buscar();
//            int opcao = 1;
//            opcao = RedirecionarPorPermissao(usuario);
//            if(opcao==1)
//                response.sendRedirect("./servlet_listaUsuarios");
//            if(opcao==3)
//                response.sendRedirect("./servlet_listaAtividade");
//            if(opcao==2)
//                response.sendRedirect("./servlet_listaCategorias");
//            response.sendRedirect("./servlet_listaAtividades");
        }
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
    
    public String preparaHtmlLogin(String mensagem){
            
        
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
                    
                    "                                    <span style=\"float:center;\"><h2>Fazer Login</h2>\n</span>"
                        + "<div class=\"clearfix\"></div>\n" +
                    "                                </div>\n" +
                    "                                <div class=\"x_content\">\n" ;
                retorno +=
                "            <form action=\"servlet_login\" method=\"POST\">\n" +
                "                <div class=\"row\">\n" +
                "                    <div class=\"col-xs-2\">\n" +
                "                        <label>Matricula</label>\n" +
                "                        <input type=\"text\" class=\"form-control form-control-sm\" name=\"matricula\" placeholder=\"matricula\" value=\"\" >\n" +
                "                    </div>\n" +
                "                    <div class=\"col-xs-2\">\n" +
                "                        <label>Senha</label>\n" +
                "                        <input type=\"password\" class=\"form-control form-control-sm\" name=\"senha\" placeholder=\"senha\" value=\"\" >\n" +
                "                    </div>\n" +
                "                </div>\n" ;
                if(mensagem.length()>0){
                retorno +="                <div class=\"row\">\n" +
                "                    <div class=\"col-xs-6\">\n" +

                "<label>Mensagem</label>\n" +
                "                        <span style=\"float:center;\"><h2>"+mensagem+"</h2>\n</span>" +
                "                    </div>\n" +
                "                </div>\n" ;
                }
                retorno +=
                "                <div class=\"row\">\n" +
                "                    <div style=\"margin-top: 2%; margin-left: 42.7%\">\n" +
                "                        <button type=\"submit\" class=\"btn btn-primary\">Login</button>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </form>\n" ;
                
                retorno += "                                </div>\n" +
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
    
    public String preparaHtmlLogin(){
            
        
        String retorno = "";

                retorno = "<!DOCTYPE html>\n" +
        "<html lang=\"pt\"><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
        "    \n" +
        "    <!-- Meta, title, CSS, favicons, etc. -->\n" +
        "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
        "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
        "\n" +
        "    <title>Login</title>\n" +
        "\n" +
        "    <!-- Bootstrap -->\n" +
        "    <link href=\"./css/bootstrap.min.css\" rel=\"stylesheet\">\n" +
        "    <!-- Font Awesome -->\n" +
        "    <link href=\"./fonts/font-awesome.min.css\" rel=\"stylesheet\">\n" +
        "    <!-- NProgress -->\n" +
        "    <link href=\"./css/nprogress.css\" rel=\"stylesheet\">\n" +
        "    <!-- Animate.css -->\n" +
        "    <link href=\"./css/animate.min.css\" rel=\"stylesheet\">\n" +
        "\n" +
        "    <!-- Custom Theme Style -->\n" +
        "    <link href=\"./css/custom.min.css\" rel=\"stylesheet\">\n" +
        "  </head>\n" +
        "\n" +
        "	<body class=\"login\">\n" +
        "		<div>\n" +
        "			<a class=\"hiddenanchor\" id=\"signup\"></a>\n" +
        "			<a class=\"hiddenanchor\" id=\"signin\"></a>\n" +
        "\n" +
        "			<div class=\"login_wrapper\">\n" +
        "				<div class=\"animate form login_form\">\n" +
        "					<section class=\"login_content\">\n" +
        "						<form action=\"servlet_login\" method=\"POST\">\n" +
        "							<h1>Página de Login</h1>\n" +
        "								<div>\n" +
        "									<input type=\"text\" class=\"form-control\" name=\"matricula\"  placeholder=\"Nome Usuário\" required=\"\">\n" +
        "								</div>\n" +
        "								<div>\n" +
        "									<input type=\"password\" class=\"form-control\" name=\"senha\" placeholder=\"Senha\" required=\"\">\n" +
        "								</div>\n" +
        "								<div>\n" +
        "									"
                        + "                                                     <button type=\"submit\" class=\"btn btn-default\">Login</button>" +
        "								</div>\n" +
        "						</form>\n" +
        "					</section>\n" +
        "				</div>\n" +
        "			</div>\n" +
        "		</div>\n" +
        "  \n" +
        "\n" +
        "	</body>\n" +
        "</html>";
    return retorno;
    }
    
        public int RedirecionarPorPermissao(Usuario usuario){
        //Método que verifica se o usuário tem permissão nessa página
        //Lista Usuarios é permitido para PERFIL: Cadastro e Administrador Geral
        
        ArrayList<Permissao> lista;
        lista = usuario.getPerfil().getPemissoes();
        for(Permissao linha:lista){
            if(linha.getDescricao().equals("Total")){
                return 1;
            }
            if(linha.getDescricao().equals("Registro de Usuarios")){
                return 1;
            }
            if(linha.getDescricao().equals("Registro de Atividade")){
                return 2;
            }
            if(linha.getDescricao().equals("Registro de Participacao de Atividade")){
                return 3;
            }
            if(linha.getDescricao().equals("Registro de Categorias")){
                return 4;
            }
        }
        return 1;
    }

}
