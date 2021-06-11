package pl.coderslab.user;

import pl.coderslab.DAO_project.User;
import pl.coderslab.entity.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserAdd", value = "/user/add")
public class UserAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/users/userAdd.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName= request.getParameter("userName");
        String email= request.getParameter("email");
        String password= request.getParameter("password");

        if (userName != null && !userName.isBlank() && email != null && !email.isBlank() && password != null && !password.isBlank()) {
            UserDao userDao = new UserDao();
            userDao.create(new User(email, userName, password));
        }
        response.sendRedirect(request.getContextPath() + "/user/list");
    }
}
