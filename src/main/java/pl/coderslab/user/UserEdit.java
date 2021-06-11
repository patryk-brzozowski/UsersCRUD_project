package pl.coderslab.user;

import pl.coderslab.DAO_project.User;
import pl.coderslab.entity.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserEdit", value = "/user/edit")
public class UserEdit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam != null && !idParam.isBlank()) {
            try {
                int id = Integer.parseInt(idParam);
                UserDao userDao = new UserDao();
                request.setAttribute("user", userDao.read(id));
                request.getRequestDispatcher("/users/userEdit.jsp").forward(request, response);
            } catch (NumberFormatException ex) {
                response.sendRedirect(request.getContextPath() + "/user/list");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/user/list");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (userName != null && !userName.isBlank() && email != null && !email.isBlank() && password != null && !password.isBlank()) {
            UserDao userDao = new UserDao();
            User user = new User(email, userName, password);
            user.setId(id);
            userDao.update(user);
        }
        response.sendRedirect("list");
    }
}
