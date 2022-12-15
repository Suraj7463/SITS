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
@WebServlet(name = "admissionservlet", urlPatterns = {"/admissionservlet"})
public class admissionservlet extends HttpServlet {

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
        String branch=request.getParameter("branch");
        String cast=request.getParameter("c");
        String fees=request.getParameter("fees");
        String phoneno=request.getParameter("phoneno");
        String email=request.getParameter("email");
        String address=request.getParameter("add");
       
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
                
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/registrationjspm","root","");
                //query
                
                String q="insert into newadmission(first_name,last_name,branch,cast,fees,phoneno,email,address) values(?,?,?,?,?,?,?,?);";
                
               PreparedStatement pstmt=con.prepareStatement(q);
               pstmt.setString(1,first_name);
               pstmt.setString(2,last_name);
               pstmt.setString(3,branch);
               pstmt.setString(4,cast);
               pstmt.setString(5,fees);
               pstmt.setString(6,phoneno);
               pstmt.setString(7,email);
               pstmt.setString(8,address);
            
               
               int x = pstmt.executeUpdate();
            
            if(x == 1)
            {
                //pw.println("Data Submitted Sucessfully.........");
                response.sendRedirect("success.html");
            }
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.println(e);
        }
    }
    }
        
    
        
    