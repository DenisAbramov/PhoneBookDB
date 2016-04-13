package den.abramov.servlets;

import den.abramov.model.User;
import den.abramov.store.UserCache;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;


public class SearchUserServlet extends HttpServlet {

    private UserCache userCache = UserCache.getInstance();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        if(req.getParameter("name") != null && req.getParameter("name").length() > 0) {

            Collection<User> users = userCache.search(req.getParameter("name"));
            if(users.size() > 0)
            {
                req.setAttribute("users", users);
            }
            else
            {
                req.setAttribute("error", "Такого абонента(ов) в списке нет!");
            }
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/user/UserView.jsp");
            dispatcher.forward(req, resp);
        }
        else
        {
            req.setAttribute("error", "Вы не заполнили поле для поиска");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/user/UserView.jsp");
            dispatcher.forward(req, resp);
        }

    }
}
