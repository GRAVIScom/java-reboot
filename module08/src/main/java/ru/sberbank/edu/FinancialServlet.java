package ru.sberbank.edu;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Hello world!
 *
 */
public class FinancialServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        try {
            double sum = Double.parseDouble(request.getParameter("sum"));
            double percentage = Double.parseDouble(request.getParameter("percentage"));
            int years = Integer.parseInt(request.getParameter("years"));
            if (sum < 0 || years < 0 || percentage < 0) {
                out.println("<html><body>");
                out.println("<h3>Неверный формат данных</h3>");
                out.println("</body></html>");
            } else if (sum < 50000) {
                out.println("<html><body>");
                out.println("<h3>Минимальная сумма на момент открытия вклада 50 000 рублей</h3>");
                out.println("</body></html>");
            } else {
                double finalAmount = (double) Math.round((sum * Math.pow(1 + (percentage / 100), years)) * 100) / 100;
                out.println("<html><body>");
                out.println("<h1>Результат</h1>");
                out.println("<p>Итоговая сумма " + finalAmount + "</p>");
                out.println("</body></html>");
            }
        } catch (NumberFormatException e) {
            out.println("<html><body>");
            out.println("<h3>Неверный формат данных. Скорректируйте значения</h3>");
            out.println("</body></html>");
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.write("<!DOCTYPE html>");
        out.write("<html lang=\"ru\" >");
        out.write("<head>");
        out.write("<meta charset=\"UTF-8\">");
        out.write("</head>");
        out.write("<body>");
        out.write("<h1>Deposit Profitability Calculator</h1>");
        out.write("<form method=\"POST\" action=\"\">" );
        out.write("Amount at the time of opening: <input name=\"sum\"><br><br>");
        out.write("The interest rate: <input name=\"percentage\"><br><br>");
        out.write("Number of years: <input name=\"years\"><br><br>");
        out.write("<input type=\"submit\" value=\"Calculate\">");
        out.write("</from>");
        out.write("</body>");
        out.write("</html>");
    }
}
