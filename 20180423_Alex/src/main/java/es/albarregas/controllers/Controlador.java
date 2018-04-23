/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alex
 */
@WebServlet(name = "Controlador", urlPatterns = {"/controlador"})
public class Controlador extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        
        String url;
        int digitos;
        int muertos = 0;
        int heridos = 0;
  
        
        if (request.getParameter("configurar") != null) {
            digitos = Integer.parseInt(request.getParameter("digitos"));
        
            request.setAttribute("digitos", digitos);

            StringBuilder builder = new StringBuilder();
           
            int numero[] = new int [digitos];
        
            for (int i=0; i<numero.length; i++) {
                numero[i] = (int) Math.floor(Math.random()*10);
                for (int j=0; j<i; j++) {
                    if (numero[i] == numero[j]) {
                        i--;
                    }
                }
            }
            for (int i=0; i<numero.length; i++) {
                builder.append(numero[i]);
            }
           
            String adivina = builder.toString();
            
           request.setAttribute("adivina", adivina);
            
            
            url = "JSP/jugar.jsp";
        
            request.getRequestDispatcher(url).forward(request, response);
        }
        
        if (request.getParameter("enviar") != null) {
            
            HttpSession sesion = request.getSession();
            digitos = (int) sesion.getAttribute("digitos");
            String adivina = (String) sesion.getAttribute("adivina");
            int numeroIntroducido[] = new int [digitos];
            int numero[] = new int[digitos];
            
            //recuperamos el valor de número
            for (int i=0; i<digitos; i++) {
                numero[i] = Integer.parseInt("" + adivina.charAt(i));
            }
            
            //recuperamos el valor del número introducido
            for (int i=0; i<digitos; i++) {
                numeroIntroducido[i] = Integer.parseInt(request.getParameter("num" + i));
            }
            
            //calculamos los muertos
            for (int i=0; i<numeroIntroducido.length; i++) {
                if (numero[i] == numeroIntroducido[i]) {
                    muertos++;
                }
            }
            
            for (int i=0; i<numeroIntroducido.length; i++) {
                for (int j=0; j<numeroIntroducido.length;j++) {
                    if (numero[j] == numeroIntroducido[i]) {
                        heridos++;
                    }
                }
            }
            
            heridos = heridos - muertos;
            
            request.setAttribute("heridos", heridos);
            request.setAttribute("muertos", muertos);
            
            if (muertos == digitos) {
                url = "JSP/finalizar.jsp";
                request.getRequestDispatcher(url).forward(request, response);
            }
            
            url = "JSP/jugar.jsp";
            
            request.getRequestDispatcher(url).include(request, response);
        }
        
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
