/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 728918
 */
public class operations extends HttpServlet {

    
   

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          getServletContext().getRequestDispatcher("/WEB-INF/calculator.jsp").forward(request, response);
    }   

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
     String firstStr = request.getParameter("first");
        String secondStr = request.getParameter("second");
        String operation = request.getParameter("operation");
    
    int result=0;
    boolean calcPerformed=false;
    
    if (operation!=null)
    {
        if (firstStr!=null && secondStr!=null && !firstStr.equals("") && !secondStr.equals(""))
        {
            int first = Integer.parseInt(firstStr);
            int second = Integer.parseInt(secondStr);
            
            char operationType = operation.charAt(0);
            
            switch (operationType)
            {
                case '+': result = first + second;
                    break;
                case '-': result = first - second;
                    break;
                case '*': result = first * second;
                    break;
                case '%': result = first % second;
                    break;
            }
            
            calcPerformed = true;
        }
    }
        if(calcPerformed == false){
            request.setAttribute("answer", "Please have a valid entry for both variables in order to perform operations.");
        }
        else request.setAttribute("answer", result);
        getServletContext().getRequestDispatcher("/WEB-INF/calculator.jsp").forward(request, response);
    }

}
