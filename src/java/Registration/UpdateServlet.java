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
@WebServlet(name = "UpdateServlet", urlPatterns = {"/UpdateServlet"})
public class UpdateServlet extends HttpServlet {

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
        String pemail=request.getParameter("pemail");
        String fname=request.getParameter("f_name");
        String lname=request.getParameter("l_name");
        String branch=request.getParameter("comp_branch");
        String phoneno=request.getParameter("phone_no");
        String email=request.getParameter("email");
        String techlist=request.getParameter("tech_list");
        String gender=request.getParameter("gen");
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
                
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/registrationjspm","root","");
                //query
                
                String q="update register set fname='"+fname+"',lname='"+lname+"',branch='"+branch+"',phoneno='"+phoneno+"',email='"+email+"',techlist='"+techlist+"',gender='"+gender+"' where email='"+pemail+"'";
                
               PreparedStatement pstmt=con.prepareStatement(q);
//               pstmt.setString(1,fname);
//               pstmt.setString(2,lname);
//               pstmt.setString(3,branch);
//               pstmt.setString(4,phoneno);
//               pstmt.setString(5,email);
//               pstmt.setString(6,techlist);
//               pstmt.setString(7,gender);
               
               int x = pstmt.executeUpdate();
            
            if(x == 1)
            {
                //pw.println("Data Submitted Sucessfully.........");
                response.sendRedirect("Dashboard.html");
            }
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.println(e);
        }
    }
       
    }

    