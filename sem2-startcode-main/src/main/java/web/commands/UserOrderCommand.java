package web.commands;

import business.entities.CartItem;
import business.entities.Order;
import business.exceptions.UserException;
import business.persistence.OrderMapper;
import business.services.LogicFacade;
import business.services.OrderFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class UserOrderCommand extends CommandUnprotectedPage {
    private OrderFacade orderFacade;

    public UserOrderCommand(String pageToShow) {
        super(pageToShow);
        orderFacade = new OrderFacade(database);

    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        HttpSession session = request.getSession();
        int chosenUser = Integer.parseInt(request.getParameter("userIdAdmin"));
        session.setAttribute("orderListAdmin", orderFacade.getAllOrders(chosenUser));


        return "userOrders";
    }
}
