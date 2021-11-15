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

public class MyOrdersCommand extends CommandUnprotectedPage {
    private OrderFacade orderFacade;
    private List<Order> orderList;

    public MyOrdersCommand(String pageToShow) {
        super(pageToShow);
        orderFacade = new OrderFacade(database);
        orderList = new ArrayList<>();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        HttpSession session = request.getSession();
        int currentUser = (int) session.getAttribute("userId");
//        session.setAttribute("orderList", orderFacade.getAllOrders(1));
        request.getServletContext().setAttribute("orderList", orderFacade.getAllOrders(currentUser));

        return "myOrders";
    }
}
