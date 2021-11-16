package web.commands;

import business.exceptions.UserException;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserListCommand extends CommandUnprotectedPage {
    private UserFacade userFacade;

    public UserListCommand(String pageToShow) {
        super(pageToShow);
        userFacade = new UserFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        request.getServletContext().setAttribute("userList", userFacade.getAllUsers());
        return "userList";
    }
}
