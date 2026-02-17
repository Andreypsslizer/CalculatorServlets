package org.example.calculatorservlets.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.calculatorservlets.storage.JDBCStorage;

import java.io.IOException;
import java.util.List;

@WebServlet("/history")
public class HistoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JDBCStorage instance = JDBCStorage.getINSTANCE();
        List<String> all = instance.findAll();

        req.setAttribute("history", all);

        req.getRequestDispatcher("/pages/history.jsp").forward(req, resp);
    }
}
