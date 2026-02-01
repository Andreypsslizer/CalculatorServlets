package org.example.calculatorservlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/calculator")
public class CalculatorServlet extends HttpServlet {
    InMemoryCalculatorRepository history = InMemoryCalculatorRepository.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double num1 = Double.parseDouble(req.getParameter("num1"));
        double num2 = Double.parseDouble(req.getParameter("num2"));
        String operation = req.getParameter("operation");

        Calc calc = new Calc(num1, num2, operation);
        double result = calc.result();

        history.add(num1 + operation + num2 + " = " + result);

        req.setAttribute("num1", num1);
        req.setAttribute("num2", num2);
        req.setAttribute("operation", operation);
        req.setAttribute("result", result);

        getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, resp);
    }
}
