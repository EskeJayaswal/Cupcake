package web.commands;

import business.entities.CartItem;
import business.entities.User;
import business.services.UserFacade;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class LoginCommand extends CommandUnprotectedPage {
    private UserFacade userFacade;
    private List<CartItem> cartList;

    public LoginCommand(String pageToShow) {
        super(pageToShow);
        userFacade = new UserFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        cartList = (List<CartItem>) request.getServletContext().getAttribute("cartList");

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            User user = userFacade.login(email, password);

            HttpSession session = request.getSession();

            session.setAttribute("user", user);
            session.setAttribute("role", user.getRole());
            session.setAttribute("email", email);
            session.setAttribute("fname", user.getFname());
            session.setAttribute("lname", user.getLname());
            session.setAttribute("balance", user.getBalance());
            String pageToShow = "";

            // If we already have put item in our cart then we want the loginpage to redirect checkout, instead of customerpage.
            if (cartList.size()!=0) {
                pageToShow = "checkout";
            } else {
                pageToShow = user.getRole() + "page";
            }

            return REDIRECT_INDICATOR + pageToShow;
        } catch (UserException ex) {
            request.setAttribute("error", "Wrong username or password!");
            return "loginpage";
        }
    }

}
