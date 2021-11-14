package web.commands;

import business.entities.Bottom;
import business.entities.CartItem;
import business.entities.Topping;
import business.entities.User;
import business.persistence.Database;
import business.services.LogicFacade;
import business.services.UserFacade;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.util.List;

public class AddToBasketCommand extends CommandUnprotectedPage {
    private List<CartItem> cartList;
    private LogicFacade logicFacade;

    public AddToBasketCommand(String pageToShow) {
        super(pageToShow);
        logicFacade = new LogicFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        cartList = (List<CartItem>) request.getServletContext().getAttribute("cartList");
        int bottom = Integer.parseInt(request.getParameter("bottomSelection"));
        int topping = Integer.parseInt(request.getParameter("toppingSelection"));
        int quantity = Integer.parseInt(request.getParameter("quantitySelection"));
        int id = cartList.size();
        Bottom b = logicFacade.getBottomFromId(bottom);
        Topping t = logicFacade.getToppingFromId(topping);
        float price = (b.getPrice() + t.getPrice())*quantity;

        CartItem cartItem = new CartItem(id+1, b, t, quantity, price);

        cartList.add(cartItem);

        return "index";
    }
}
