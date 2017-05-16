package org.apache.jsp.JSP;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class usuarios_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Cadastro de Usuarios</h1>\n");
      out.write("        <hr>\n");
      out.write("        <form action=\"../CadastrarUsuario\">\n");
      out.write("        Login:<br>\n");
      out.write("         <input type=\"text\" name=\"login\" value=\"\" /><br><br>\n");
      out.write("         Nome:<br>\n");
      out.write("         <input type=\"text\" name=\"nome\" value=\"\" /><br><br>\n");
      out.write("         Senha:<br>\n");
      out.write("         <input type=\"password\" name=\"senha\" value=\"\" /><br><br>\n");
      out.write("         Perfil:<br>\n");
      out.write("         <select name=\"perfil\">\n");
      out.write("             <option>Funcionarios</option>\n");
      out.write("             <option>Administrador</option>\n");
      out.write("         </select><br><br>\n");
      out.write("         Status:<br>\n");
      out.write("         <select name=\"status\">\n");
      out.write("             <option>Ativo</option>\n");
      out.write("             <option>Inativo</option>\n");
      out.write("          </select><br><br>\n");
      out.write("          <input type=\"submit\" value=\"Cadastrar\" name=\"cadastrar\" />\n");
      out.write("          <a href=\"javascript:history.back()\"><input type=\"button\" value=\"Voltar\" name=\"voltar\" /></a><br><br>\n");
      out.write("         \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
