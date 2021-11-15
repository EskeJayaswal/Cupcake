package web.commands;

import business.entities.CartItem;
import business.exceptions.UserException;
import business.services.LogicFacade;
import business.services.OrderFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class ConfirmationCommand extends CommandUnprotectedPage {
    private OrderFacade orderFacade;
    private List<CartItem> cartList;


    public ConfirmationCommand(String pageToShow) {
        super(pageToShow);
        orderFacade = new OrderFacade(database);
        cartList = new ArrayList<>();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        cartList = (List<CartItem>) request.getServletContext().getAttribute("cartList");
        HttpSession session = request.getSession();
        int currentUser = (int) session.getAttribute("userId");

        orderFacade.createOrder(currentUser, cartList);
        cartList.clear();

        return pageToShow;

    }
}