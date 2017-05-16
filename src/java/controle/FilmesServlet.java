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
import modelo.filmes;
import modelo.generos;
import persistencia.FilmesDAO;
import persistencia.GenerosDAO;
import utilidades.PersonalizarMsgErro;

/**
 *
 * @author sala308b
 */
@WebServlet(name = "FilmesServlet", urlPatterns = {"/FilmesServlet"})
public class FilmesServlet extends HttpServlet {

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
        
         String titulo = request.getParameter("titulo");
         String genero = request.getParameter("genero");
         int generos = Integer.parseInt(genero);
         
         String sinopse = request.getParameter("sinopse");
         String diretor = request.getParameter("diretor");
         String ano = request.getParameter("ano");
         int ano1 = Integer.parseInt(ano);
         
         String status = request.getParameter("status");
       
         
         
         
         if(!titulo.equals("") && !genero.equals("") && !sinopse.equals("") && !diretor.equals("")
                 && !ano.equals("") && !status.equals("")){
           
            filmes filme = new filmes();  
            
            filme.setTitulo(titulo);
            filme.setCod_genero(generos);
            filme.setSinopse(sinopse);
            filme.setDiretor(diretor);
            filme.setAno_lancamento(ano1);
            filme.setStatus(status);
           

            try {
                FilmesDAO.inserir(filme);
                request.setAttribute("msgsucess", "Filme inserido com sucesso!");
                
            } catch (Exception ex) {
                //Setando um atributo no request com a mensagem de erro;
                request.setAttribute("msgErro", 
                    "Ocorreu um erro ao salvar o Filme: " + 
                    PersonalizarMsgErro.getMensagem(ex.getMessage()));               
                request.setAttribute("generos", genero);               
            }             
            
             RequestDispatcher rd = request.getRequestDispatcher("filmes.jsp");
             rd.forward(request, response);
            
            return;  
        }else{
         request.setAttribute("msgvazio", "Complete todos os campos!");
           RequestDispatcher rd1 = request.getRequestDispatcher("filmes.jsp");
           rd1.forward(request, response);
        } 

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FilmesServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FilmesServlet at " + request.getContextPath() + "</h1>");
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
