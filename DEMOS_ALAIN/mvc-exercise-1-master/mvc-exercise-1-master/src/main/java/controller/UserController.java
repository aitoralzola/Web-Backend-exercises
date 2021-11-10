package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.user.dao.UserFacade;
import domain.user.model.User;

@WebServlet(name = "UserController", urlPatterns = { "/user" })
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UserController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = Optional.ofNullable(request.getParameter("action")).orElse("list");

        switch (action) {
            case "delete":
                deleteUser(request, response);
                break;
            case "create":
            case "edit":
                showUserForm(request, response);
                break;
            case "view":
                showUser(request, response);
                break;
            case "list":
            default:
                listUsers(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = Optional.ofNullable(request.getParameter("action")).orElse("list");
        switch (action) {
            case "create":
                createUser(request, response);
                break;
            case "edit":
                editUser(request, response);
                break;
            default:
                listUsers(request, response);
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        int userId = getUserId(request);
        UserFacade uf = new UserFacade();
        if (uf.deleteUser(userId)) {
            session.setAttribute("message", "message.deleteUser");
        } else {
            session.setAttribute("error", "error.deleteUser");
        }
        response.sendRedirect("user?action=list");
    }

    private void editUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        int userId = getUserId(request);
        UserFacade uf = new UserFacade();
        User user = uf.loadUser(userId);
        System.out.println("Show User Form: " + userId);
        if (user != null) {
            user.setEmail(request.getParameter("email"));
            user.setFirstName(request.getParameter("firstName"));
            user.setPassword(request.getParameter("password"));
            user.setSecondName(request.getParameter("secondName"));
            user.setUsername(request.getParameter("username"));
            uf.saveUser(user);
            if (user.getUserId() != 0) {
                session.setAttribute("message", "message.editUser");
                response.sendRedirect("user?action=view&userId=" + userId);
            } else {
                session.setAttribute("error", "error.editUser");
                response.sendRedirect("user?action=edit&userId=" + userId);
            }
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        User user = new User();
        user.setEmail(request.getParameter("email"));
        user.setFirstName(request.getParameter("firstName"));
        user.setPassword(request.getParameter("password"));
        user.setSecondName(request.getParameter("secondName"));
        user.setUsername(request.getParameter("username"));

        UserFacade uf = new UserFacade();
        uf.saveUser(user);

        if (user.getUserId() != 0) {
            request.setAttribute("user", user);
            session.setAttribute("message", "message.createUser");
            response.sendRedirect("user?action=view&userId=" + user.getUserId());
        } else {
            session.setAttribute("error", "error.createUser");
            response.sendRedirect("user?action=list");
        }

    }

    private void showUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = getUserId(request);
        System.out.println("Show User: " + userId);
        UserFacade uf = new UserFacade();
        User user = uf.loadUser(userId);

        if (user != null && user.getUserId() != 0) {
            request.setAttribute("user", user);

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/user/user.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "User Not Found: " + userId);
        }

    }

    private void showUserForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = getUserId(request);
        System.out.println("Show User Form: " + userId);
        if (userId > 0) {
            // Edit user
            UserFacade userFacade = new UserFacade();
            User user = userFacade.loadUser(userId);
            if (user == null) {
                // Return 404
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "User Not Found: " + userId);
                return;
            }
            request.setAttribute("user", user);
        } // Else, Create user (nothing has to be loaded)

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/user/user_form.jsp");
        dispatcher.forward(request, response);
    }

    private void listUsers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("List Users");
        UserFacade userFacade = new UserFacade();
        ArrayList<User> users = userFacade.loadUsers();
        request.setAttribute("userList", users);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/user/user_list.jsp");
        dispatcher.forward(request, response);
    }

    private int getUserId(HttpServletRequest request) {
        int userId;
        String userIdStr = Optional.ofNullable(request.getParameter("userId")).orElse("-1");

        try {
            userId = Integer.parseInt(userIdStr);
        } catch (NumberFormatException e) {
            userId = -1;
            System.out.println("userId is not a number");
        }

        return userId;
    }

}
