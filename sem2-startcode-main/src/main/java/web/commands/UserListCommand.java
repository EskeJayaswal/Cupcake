package web.commands;

import business.entities.CartItem;
import business.entities.User;
import business.exceptions.UserException;
import business.persistence.OrderMapper;
import business.services.OrderFacade;
import business.services.UserFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class UserListCommand extends CommandUnprotectedPage {
    private UserFacade userFacade;
    OrderFacade orderFacade;


    public UserListCommand(String pageToShow) {
        super(pageToShow);
        userFacade = new UserFacade(database);
        orderFacade = new OrderFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        List<User> userList = userFacade.getAllUsers();

        for (User u : userList) {
            u.setOrderCount(userFacade.getOrderCount(u.getId()));
        }

        request.getSession().setAttribute("userList",userList);

        return "userList";
    }

}
