import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.lang.String;
import java.io.PrintWriter;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;

@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet implements javax.servlet.Servlet {
    private static final long serialVersionUID = 1L;

    private Affine Affine;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Affine = new Affine();

        String encrypt = request.getParameter("encryptText").trim();
        String result = Affine.encrypt(encrypt);

        response.setContentType("text/plain");
        response.getWriter().write(result);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
}