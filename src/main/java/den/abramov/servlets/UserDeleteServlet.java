package den.abramov.servlets;

import den.abramov.store.UserCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class UserDeleteServlet extends HttpServlet {

    private UserCache userCache = UserCache.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userCache.delete(Integer.valueOf(req.getParameter("id")));
        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/user/view"));
    }
}
