package controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "DbController", urlPatterns = "/db")
public class DbController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DbController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String username = Optional.ofNullable((String) session.getAttribute("username")).orElse("");

        if (!username.isBlank()) {
            dispatchToPage(request, response);
        } else {
            session.setAttribute("error", "error.forbidden");
            response.sendRedirect("/index.jsp");
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private void dispatchToPage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dispatchPage;
        List<String> options = Arrays.asList("db", "dbz", "dbgt");
        String page = request.getParameter("page");

        if (options.contains(page))
            dispatchPage = page.concat(".jsp");
        else
            dispatchPage = "db.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/".concat(dispatchPage));
        dispatcher.forward(request, response);
    }

}
