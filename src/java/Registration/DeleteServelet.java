/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Registration;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author suraj dudhabhate
 */
@WebServlet(name = "DeleteServelet", urlPatterns = {"/DeleteServelet"})
public class DeleteServelet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        
         String email=request.getParameter("cityname");
        
        
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
                
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/registrationjspm","root","");
                //query
                
             
         
                    PreparedStatement ps=con.prepareStatement("delete from register where email='"+email+"'");
                    
                     int x = ps.executeUpdate();
            
            if(x >= 1)
            {
                //pw.println("Data Submitted Sucessfully.........");
                response.sendRedirect("remove_success.html");
            }
            else{
                response.sendRedirect("wrong.html");
            }
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.println(e);
        }
    }

    
}
