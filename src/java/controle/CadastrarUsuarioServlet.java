/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.usuarios;
import org.apache.commons.codec.digest.DigestUtils;
import persistencia.UsuariosDAO;
import utilidades.PersonalizarMsgErro;

/**
 *
 * @author sala304b
 */
@WebServlet(name = "CadastrarUsuarioServlet", urlPatterns = {"/CadastrarUsuario"})
public class CadastrarUsuarioServlet extends HttpServlet {

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
        
        String login = request.getParameter("login");
        String nome = request.getParameter("nome");
        String senha = request.getParameter("senha");
        String perfil = request.getParameter("perfil");
        String status = request.getParameter("status");
        
        
        if(nome != null && senha !=null){
            //Criptografando a senha do usuário
            String senhaCriptografada = DigestUtils.sha512Hex(senha);

            usuarios usuario = new usuarios();
            usuario.setLogin(login);
            usuario.setNome(nome);
            usuario.setStatus(status);
            usuario.setPerfil(perfil);
            usuario.setSenha(senhaCriptografada);

            try {
                UsuariosDAO.inserir(usuario);
            } catch (Exception ex) {
                //Setando um atributo no request com a mensagem de erro;
                request.setAttribute("msgErro", 
                    "Ocorreu um erro ao salvar o usuário: " + 
                    PersonalizarMsgErro.getMensagem(ex.getMessage()));
                
                request.setAttribute("usuarios", usuario);
                
                //encaminhando a requisição para a página CadastroUsuario.jsp
                RequestDispatcher rd = request.getRequestDispatcher("CadastroUsuario.jsp");
                rd.forward(request, response);
                //throw new ServletException(ex);
            } 
            // Informo ao servidor qual usuario autenticado
            HttpSession session = request.getSession(true);
            session.setAttribute("usuarioAutenticado", nome);

            // Redireciona para uma pagina logada
            response.sendRedirect("PainelUsuario.jsp");

            return;
                
            
            
        }
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AutenticarServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Autenticação</h1>");
            out.println("<hr>");
            out.println("<a href=\"javascript:history.back()\">Voltar</a><br>");
            out.println("<h3>Login ou Senha Incorretos!</h3>");
            out.println("</body>");
            out.println("</html>");
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

}
