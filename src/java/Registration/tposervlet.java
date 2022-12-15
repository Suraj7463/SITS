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
@WebServlet(name = "tposervlet", urlPatterns = {"/tposervlet"})
public class tposervlet extends HttpServlet {

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
        
        String register_date=request.getParameter("showdate");
        String cname=request.getParameter("cname");
        String hr_name=request.getParameter("hname");
        String hr_phone=request.getParameter("phoneno");
        String hr_email=request.getParameter("email");
        String comp_add=request.getParameter("cadd");
        String campus_date=request.getParameter("cdate");
        String register_by=request.getParameter("register_by");
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
                
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/registrationjspm","root","");
                //query
                
                String q="insert into tpo_register(register_date,cname,hr_name,hr_phone,hr_email,comp_add,campus_date,register_by) values(?,?,?,?,?,?,?,?);";
                
               PreparedStatement pstmt=con.prepareStatement(q);
               pstmt.setString(1,register_date);
               pstmt.setString(2,cname);
               pstmt.setString(3,hr_name);
               pstmt.setString(4,hr_phone);
               pstmt.setString(5,hr_email);
               pstmt.setString(6,comp_add);
               pstmt.setString(7,campus_date);
               pstmt.setString(8,register_by);
               
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

    
    
        
    
        
