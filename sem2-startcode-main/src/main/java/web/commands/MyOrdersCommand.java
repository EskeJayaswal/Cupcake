package web.commands;

import business.entities.CartItem;
import business.exceptions.UserException;
import business.services.LogicFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class MyOrdersCommand extends CommandUnprotectedPage {
    private LogicFacade logicFacade;
    private List<CartItem> cartList;

    public MyOrdersCommand(String pageToShow) {
        super(pageToShow);
        logicFacade = new LogicFacade(database);
        cartList = new ArrayList<>();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        return "myOrders";
    }
}
