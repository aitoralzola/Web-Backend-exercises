package controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginController", urlPatterns = "/login")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String action = Optional.ofNullable(request.getParameter("action")).orElse("logut");
        switch (action) {
        case "login":
            login(session, request);
            break;
        case "logout":
        default:
            logout(session);
        }
        response.sendRedirect("/index.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void login(HttpSession session, HttpServletRequest request) {
        String username = Optional.ofNullable(request.getParameter("username")).orElse("");
        String password = Optional.ofNullable(request.getParameter("password")).orElse("");
        if (!username.isBlank() && username.equals(password)) {
        session.setAttribute("message", "message.login");
        session.setAttribute("username", username);
        } else {
        session.setAttribute("error", "error.login");
        session.removeAttribute("username");
        }
    }

    private void logout(HttpSession session) {
        session.setAttribute("message", "message.logout");
        session.removeAttribute("username");
    }

}
