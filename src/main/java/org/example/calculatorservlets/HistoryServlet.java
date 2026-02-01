package org.example.calculatorservlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/history")
public class HistoryServlet extends HttpServlet {
    InMemoryCalculatorRepository history = InMemoryCalculatorRepository.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> all = history.findAll();

        req.setAttribute("history", all);

        req.getRequestDispatcher("/pages/history.jsp").forward(req, resp);
    }
}
