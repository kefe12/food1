/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class LoginServlet extends HttpServlet {

   

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     response.setContentType("text/html");
     PrintWriter out=response.getWriter();
     String username=request.getParameter("username");
      String password=request.getParameter("password");
      try{
          Class.forName("com.mysql.jdbc.Driver");
          Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cci?useSSL=false","root","");
      Statement stmt=con.createStatement();
      ResultSet rs=stmt.executeQuery("select *from food where username='"+username+"' and password='"+password+"'");
      if(rs.next()){
      response.sendRedirect("Home.html");
      
      }else{
      out.println("wrong username and password");
      }
      con.close();
      }catch(Exception e){
      System.out.println(e.getMessage());
      }
    }

    
    // </editor-fold>

}
