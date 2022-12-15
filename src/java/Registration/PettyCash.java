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
@WebServlet(name = "PettyCash", urlPatterns = {"/PettyCash"})
public class PettyCash extends HttpServlet {

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
        String day=request.getParameter("day");
        String product=request.getParameter("product");
        String rate=request.getParameter("rate");
        String quantity=request.getParameter("qty");
        String amount=request.getParameter("amount");
        String purch_from=request.getParameter("purchase");
        String purch_by=request.getParameter("purch_by");
        String purpose=request.getParameter("purpose");
        String approval=request.getParameter("aprove");
       
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
                
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/registrationjspm","root","");
                //query
                
                String q="insert into pettycash(date,day,product,rate,quantity,amount,purch_from,purch_by,purpose,approval) values(?,?,?,?,?,?,?,?,?,?);";
                
               PreparedStatement pstmt=con.prepareStatement(q);
               pstmt.setString(1,date);
               pstmt.setString(2,day);
               pstmt.setString(3,product);
               pstmt.setString(4,rate);
               pstmt.setString(5,quantity);
               pstmt.setString(6,amount);
               pstmt.setString(7,purch_from);
               pstmt.setString(8,purch_by);
               pstmt.setString(9,purpose);
               pstmt.setString(10,approval);
                      
            
               
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
        
 
        
   
        

   