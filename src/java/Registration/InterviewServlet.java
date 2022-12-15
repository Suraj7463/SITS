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
@WebServlet(name = "InterviewServlet", urlPatterns = {"/InterviewServlet"})
public class InterviewServlet extends HttpServlet {

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
        
        String date=request.getParameter("showdate");
        String first_name=request.getParameter("fname");
        String last_name=request.getParameter("lname");
        String branch=request.getParameter("branch");
        String tech_round=request.getParameter("tech_round");
        String apty_round=request.getParameter("apty_round");
        String hr_round=request.getParameter("hr_round");
        String total_mark=request.getParameter("total_mark");
        String result=request.getParameter("result");
        
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
                
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/registrationjspm","root","");
                //query
                
                String q="insert into interview(date,first_name,last_name,branch,tech_round,apty_round,hr_round,total_mark,result) values(?,?,?,?,?,?,?,?,?);";
                
               PreparedStatement pstmt=con.prepareStatement(q);
               pstmt.setString(1,date);
               pstmt.setString(2,first_name);
               pstmt.setString(3,last_name);
               pstmt.setString(4,branch);
               pstmt.setString(5,tech_round);
               pstmt.setString(6,apty_round);
               pstmt.setString(7,hr_round);
               pstmt.setString(8,total_mark);
               pstmt.setString(9,result);
               
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

  


