package pl.coderslab.user;

import pl.coderslab.entity.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserShow", value = "/user/show")
public class UserShow extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        if (idParam != null && !idParam.isBlank()) {
            try {
                int id = Integer.parseInt(idParam);
                UserDao userDao = new UserDao();
                request.setAttribute("user", userDao.read(id));
                request.getRequestDispatcher("/users/userShow.jsp").forward(request, response);
            } catch (NumberFormatException ex) {
                response.sendRedirect(request.getContextPath() + "/user/list");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/user/list");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
