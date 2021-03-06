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
import modelo.generos;
import persistencia.GenerosDAO;
import utilidades.PersonalizarMsgErro;

/**
 *
 * @author sala308b
 */
@WebServlet(name = "GenerosServlets", urlPatterns = {"/GenerosServlets"})
public class GenerosServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=ISO-8859-1");        
         String nome = request.getParameter("nome");
         String descricao = request.getParameter("descricao");        
         if(!nome.equals("")){
           
            generos genero = new generos();          
            genero.setNome(nome);
            genero.setDescricao(descricao);

            try {
                GenerosDAO.inserir(genero);
                request.setAttribute("msgsucess", "genero inserido com sucesso!");
                
            } catch (Exception ex) {
                //Setando um atributo no request com a mensagem de erro;
                request.setAttribute("msgErro", 
                    "Ocorreu um erro ao salvar o genero: " + 
                    PersonalizarMsgErro.getMensagem(ex.getMessage()));               
                request.setAttribute("generos", genero);               
            }             
            
             RequestDispatcher rd = request.getRequestDispatcher("generos.jsp");
             rd.forward(request, response);
            
            return;  
        }else{
  
           request.setAttribute("msgvazio", "Complete todos os campos!");
           RequestDispatcher rd1 = request.getRequestDispatcher("generos.jsp");
           rd1.forward(request, response);
        }
         
         
         
         
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GenerosServlets</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GenerosServlets at " + request.getContextPath() + "</h1>");
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
