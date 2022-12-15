
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author suraj dudhabhate
 */
@WebServlet(urlPatterns = {"/ServletLogin"})
public class ServletLogin extends HttpServlet {

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        PrintWriter out=response.getWriter();
        response.setContentType("text/html");
        
        String pname=request.getParameter("uname");
        String pass=request.getParameter("password");
        
        if(pname.equals("admin") && pass.equals("admin123"))
        {
//            
            response.sendRedirect("Dashboard.html");
        }
        else
        {
            out.print("<br><h2> Invalid User </h2>");
        }
                
                
        
    }



}
