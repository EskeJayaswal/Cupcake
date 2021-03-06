package web.commands;

import business.entities.User;
import business.persistence.Database;
import business.services.UserFacade;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegisterCommand extends CommandUnprotectedPage
{
    private UserFacade userFacade;

    public RegisterCommand(String pageToShow)
    {
        super(pageToShow);
        userFacade = new UserFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException
    {
        String email = request.getParameter("email");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        float balance = 0;

        if (password1.equals(password2))
        {
            User user = userFacade.createUser(email, password1, fname, lname, balance);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("userId",user.getId());
            session.setAttribute("email", email);
            session.setAttribute("fname", user.getFname());
            session.setAttribute("lname", user.getLname());
            session.setAttribute("balance", user.getBalance());
            return user.getRole() + "page";
        }
        else
        {
            request.setAttribute("error", "the two passwords did not match");
            return "registerpage";
        }
    }

}
