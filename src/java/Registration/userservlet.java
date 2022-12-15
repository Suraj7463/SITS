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
@WebServlet(name = "userservlet", urlPatterns = {"/userservlet"})
public class userservlet extends HttpServlet {

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
        PrintWriter pw;
        response.setContentType("text/html");
        pw=response.getWriter();
        
        String first_name=request.getParameter("fname");
        String last_name=request.getParameter("lname");
        String username=request.getParameter("uname");
        String password=request.getParameter("pass");
        String retypepass=request.getParameter("retype");
        String phoneno=request.getParameter("phone");
        String email=request.getParameter("Email");
      
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
                
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/registrationjspm","root","");
                //query
                
                String q="insert into userregister(first_name,last_name,username,password,retypepass,phoneno,email) values(?,?,?,?,?,?,?);";
                
               PreparedStatement pstmt=con.prepareStatement(q);
               pstmt.setString(1,first_name);
               pstmt.setString(2,last_name);
               pstmt.setString(3,username);
               pstmt.setString(4,password);
               pstmt.setString(5,retypepass);
               pstmt.setString(6,phoneno);
               pstmt.setString(7,email);
               
               int x = pstmt.executeUpdate();
            
            if(x == 1)
            {
                pw.println("Data Submitted Sucessfully.........");
                //response.sendRedirect("success.html");
            }
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.println(e);
        }
    }
    }

    
