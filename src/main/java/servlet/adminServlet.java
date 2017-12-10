///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package servlet;
//
//import com.google.gson.*;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Date;
//import java.sql.SQLException;
//import java.text.DateFormat;
//import java.util.ArrayList;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Collections;
//import java.util.List;
//import java.util.Locale;
//import java.util.Properties;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import model.DAO;
//import model.DataSourceFactory;
//import model.Revenue;
//
///**
// *
// * @author max
// */
//public class adminServlet extends HttpServlet {
//
//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException, SQLException, ParseException {
//
//        DAO dao = new DAO(DataSourceFactory.getDataSource());
//
//        String date_debut = request.getParameter("dateDebut");
//        String date_fin = request.getParameter("dateFin");
//        List<Revenue> list = null;
//        try {
//            //si on appelle la servlet avec des paramètres de dates
//            if (date_debut != null && date_fin != null) {
//                //list = dao.chiffreAffaireByProductCategory(date_debut, date_fin);
//            }
//        } catch (SQLException ex) {
//            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//        }
//        try (PrintWriter out = response.getWriter()) {
//            Gson gson = new Gson();
//            String gsonData = gson.toJson(list);
//            //on affiche la collection dans la console pour vérifier
//            System.out.println(gsonData);
//            out.println(gsonData);
//
//        }
//    }
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        try {
//            processRequest(request, response);
//        } catch (SQLException ex) {
//            Logger.getLogger(adminServlet.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ParseException ex) {
//            Logger.getLogger(adminServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        try {
//            processRequest(request, response);
//        } catch (SQLException ex) {
//            Logger.getLogger(adminServlet.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ParseException ex) {
//            Logger.getLogger(adminServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}
