package den.abramov.servlets;

import den.abramov.store.UserCache;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class UserViewServlet extends HttpServlet {

    private UserCache userCache = UserCache.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req.setAttribute("users", userCache.value());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/user/UserView.jsp");
        dispatcher.forward(req, resp);
    }
}
