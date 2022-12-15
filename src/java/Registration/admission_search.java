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
@WebServlet(name = "admission_search", urlPatterns = {"/admission_search"})
public class admission_search extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        
         String email=request.getParameter("cityname");         
         String tab=request.getParameter("action");
        
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
                
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/registrationjspm","root","");
                //query
                if(email!=null)
                {
         
                    PreparedStatement ps=con.prepareStatement("select * from newadmission where email='"+email+"'");
                    
                
                
          
                
                out.print("<center><table width=100% border=1 cellpadding=5>");
                out.print("<caption><h1> New Employee Details </h1></caption>");
                
                ResultSet rs=ps.executeQuery();
                
                ResultSetMetaData rsmd=rs.getMetaData();
                int total = rsmd.getColumnCount();
                
                out.println("<tr bgcolor='gold'>");
                
 //               for(int i=1;i<=total;i++)
//                {
//                    out.print("<th>"+rsmd.getCatalogName(i)+"</th>");
//                }
                out.print("</tr>");
                
                out.print("<th>First Name</th>");
                out.print("<th>Last Name</th>");
                out.print("<th>Branch</th>");
                out.print("<th>Cast</th>");
                out.print("<th>Fees</th>");
                out.print("<th>Phoene_No</th>");
                out.print("<th>Email</th>");
                out.print("<th>Address</th>");
                
                 
                
                
                while(rs.next())
                {
                    out.print("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td></tr>");
                }
                out.print("</table></center>");
                }
                
                }
        
        
        catch(Exception e)
            
            {
                System.out.println(e);
            }
            finally
            {
                out.close();
            }
       
        }

    
    }
    
    
        
    