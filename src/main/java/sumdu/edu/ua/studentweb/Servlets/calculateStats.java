/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package sumdu.edu.ua.studentweb.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sumdu.edu.ua.studentweb.CustomExceptions.EmailException;
import sumdu.edu.ua.studentweb.Support.StatsCalculator;
import sumdu.edu.ua.studentweb.Support.Student;
import sumdu.edu.ua.studentweb.Support.Utils;

/**
 *
 * @author Erlkonig
 */
public class calculateStats extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Student> students = (List<Student>)session.getAttribute("students");
        
        StatsCalculator stat=StatsCalculator.getInstance();
        stat.setMeanAge(Utils.calculateMeanAge((LinkedList<Student>) students));
        stat.setMinAge(Utils.calculateYoungestStudent((LinkedList<Student>) students));
        stat.setMaxAge(Utils.calculateOldestStudent((LinkedList<Student>) students));
        try {
            stat.setSumduMails(Utils.calculateSumduDomain((LinkedList<Student>) students));
        } catch (EmailException ex) {
            Logger.getLogger(calculateStats.class.getName()).log(Level.SEVERE, null, ex);
        }
        stat.setNumberDifferentGroups(Utils.calculateDifferentGroups((LinkedList<Student>) students));
        stat.setNumberStudentsFromDifferentFaculties(Utils.calculateNumberStudentsFromDifferentFaculties((LinkedList<Student>) students));

        try {
            stat.setPopularMail( Utils.calculatePopularDomain((LinkedList<Student>) students));
        } catch (EmailException ex) {
      //Або реалізуйте відлов виняткових ситуацій інакше, блок автогенерується до вставки коли існує обробка виключення
            Logger.getLogger(calculateStats.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Додайте свій код решти обробок даних
        
        
        
        session.setAttribute("stat", stat);
        response.sendRedirect("statistics.jsp");
    
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
