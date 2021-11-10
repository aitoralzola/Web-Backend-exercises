package controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.user.dao.UserFacade;
import domain.user.model.User;

@WebServlet(name = "LoginController", urlPatterns = { "/login" })
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get parameters from the request
        String action = Optional.ofNullable(request.getParameter("action")).orElse("logout");
        String username = Optional.ofNullable(request.getParameter("username")).orElse("");
        String password = Optional.ofNullable(request.getParameter("password")).orElse("");
        HttpSession session = request.getSession(true);

        System.out.println("Username: " + username);
        System.out.println("Password: " + password
                + " (This should never be done in real projects! Printing passwords in logs is a bad practice.)");

        switch (action) {
            case "login":
                login(session, username, password);
                break;
            case "logout":
            default:
                logout(session);
        }
        response.sendRedirect("/index.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private void login(HttpSession session, String username, String password) {
        User user = null;

        // Check if the user exists in the database/properties file
        UserFacade uf = new UserFacade();
        user = uf.loadUser(username, password);

        // Save login result in session
        if (user != null) {
            session.setAttribute("user", user);
            session.setAttribute("message", "message.login");
        } else {
            session.removeAttribute("user");
            session.setAttribute("username", username);
            session.setAttribute("error", "error.login");
        }
    }

    private void logout(HttpSession session) {
        session.removeAttribute("user");
        session.setAttribute("message", "message.logout");
    }

}
