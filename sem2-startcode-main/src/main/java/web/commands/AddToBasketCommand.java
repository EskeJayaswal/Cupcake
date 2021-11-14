package web.commands;

import business.entities.Bottom;
import business.entities.CartItem;
import business.entities.Topping;
import business.entities.User;
import business.persistence.Database;
import business.services.UserFacade;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class AddToBasketCommand extends CommandUnprotectedPage {
    private List<CartItem> cartList;

    public AddToBasketCommand(String pageToShow) {
        super(pageToShow);

    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        int bottom = Integer.parseInt(request.getParameter("bottomSelection"));
        int topping = Integer.parseInt(request.getParameter("toppingSelection"));
        int quantity = Integer.parseInt(request.getParameter("quantitySelection"));


        Bottom b = Bottom.getBottom(bottom);



        CartItem cartItem = new CartItem(bottom, new Topping(1, "Walnut", 5), 10, 100);


        cartList = (List<CartItem>) request.getServletContext().getAttribute("cartList");

        cartList.add(cartItem);


        return "index";
    }

}
