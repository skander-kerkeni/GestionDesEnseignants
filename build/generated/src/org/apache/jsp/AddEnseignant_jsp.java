package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import iit.enseignants.entites.Enseignants;
import java.util.List;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;

public final class AddEnseignant_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"bootstrap/css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"row\">\n");
      out.write("         <div class=\"col-sm-4\">\n");
      out.write("        <form method=\"post\" action=\"./EnseignantsController2\">\n");
      out.write("            <input type=\"hidden\" name=\"action\" value=\"ajouter\"/>\n");
      out.write("            <div alight=\"left\">\n");
      out.write("                <label class=\"form-label\">CIN</label>\n");
      out.write("                <input type=\"text\" class=\"form-control\" placeholder=\"cin\" name=\"cin\" id=\"cin\" required >\n");
      out.write("            </div>\n");
      out.write("            <div alight=\"left\">\n");
      out.write("                <label class=\"form-label\">Nom</label>\n");
      out.write("                <input type=\"text\" class=\"form-control\" placeholder=\"nom\" name=\"nom\" id=\"nom\" required >\n");
      out.write("            </div>\n");
      out.write("            <div alight=\"left\">\n");
      out.write("                <label class=\"form-label\">Prenom</label>\n");
      out.write("                <input type=\"text\" class=\"form-control\" placeholder=\"prenom\" name=\"prenom\" id=\"prenom\" required >\n");
      out.write("            </div>\n");
      out.write("            <div alight=\"left\">\n");
      out.write("                <label class=\"form-label\">Adress</label>\n");
      out.write("                <input type=\"text\" class=\"form-control\" placeholder=\"adress\" name=\"adress\" id=\"adress\" required >\n");
      out.write("            </div>\n");
      out.write("         </div>\n");
      out.write("            <div class=\"col-sm-2\"></div>\n");
      out.write("            <div class=\"col-sm-4\">\n");
      out.write("            <div alight=\"left\">\n");
      out.write("                <label class=\"form-label\">Email</label>\n");
      out.write("                <input type=\"text\" class=\"form-control\" placeholder=\"email\" name=\"email\" id=\"email\" required >\n");
      out.write("            </div>\n");
      out.write("            <div alight=\"left\">\n");
      out.write("                <label class=\"form-label\">Phone</label>\n");
      out.write("                <input type=\"text\" class=\"form-control\" placeholder=\"phone\" name=\"phone\" id=\"phone\" required >\n");
      out.write("            </div>\n");
      out.write("            <div alight=\"left\">\n");
      out.write("                <label class=\"form-label\">Login</label>\n");
      out.write("                <input type=\"text\" class=\"form-control\" placeholder=\"login\" name=\"login\" id=\"login\" required >\n");
      out.write("            </div>\n");
      out.write("            <div alight=\"left\">\n");
      out.write("                <label class=\"form-label\">Password</label>\n");
      out.write("                <input type=\"password\" class=\"form-control\" placeholder=\"password\" name=\"password\" id=\"password\" required >\n");
      out.write("            </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("                \n");
      out.write("    \n");
      out.write("            \n");
      out.write("            <input type=\"submit\" name=\"OK\" value=\"OK\" class=\"btn btn-info\"/>\n");
      out.write("            \n");
      out.write("        </form>\n");
      out.write("         </div>\n");
      out.write("        \n");
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
