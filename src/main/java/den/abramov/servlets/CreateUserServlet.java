package den.abramov.servlets;

import den.abramov.model.User;
import den.abramov.store.UserCache;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class CreateUserServlet extends HttpServlet {

    private UserCache userCache = UserCache.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        String number = req.getParameter("number");

        if(name.length() > 0 && number.length() > 0)
        {
            User user = userCache.getName(name);
            if(user == null)
            {
                User user1 = userCache.getNumber(number);
                        if(user1 == null)
                        {
                            userCache.add(new User(name, number));
                            resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/user/view"));
                        }
                        else
                        {
                            req.setAttribute("error", "Абонент с номером " + user1.getNumber() + " уже есть в справочнике");
                            req.setAttribute("users", userCache.watchOne(user1));
                            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/user/UserView.jsp");
                            dispatcher.forward(req, resp);
                        }
            }
            else
            {
                req.setAttribute("error", "Абонент с именем " + user.getName() + " уже есть в справочнике");
                req.setAttribute("users", userCache.watchOne(user));
                RequestDispatcher dispatcher = req.getRequestDispatcher("/views/user/UserView.jsp");
                dispatcher.forward(req, resp);
            }


        }
        else
        {
            req.setAttribute("error", "Вы не заполнили одно из полей");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/user/UserView.jsp");
            dispatcher.forward(req, resp);
        }

    }
}
