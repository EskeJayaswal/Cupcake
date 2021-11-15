package web.commands;

import business.entities.Bottom;
import business.entities.CartItem;
import business.entities.Topping;
import business.exceptions.UserException;
import business.services.LogicFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class RemoveFromBasketCommand extends CommandUnprotectedPage {
    private List<CartItem> cartList;
    private LogicFacade logicFacade;

    public RemoveFromBasketCommand(String pageToShow) {
        super(pageToShow);
        logicFacade = new LogicFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        int id = Integer.parseInt(request.getParameter("fjernknap"));
        cartList = (List<CartItem>) request.getServletContext().getAttribute("cartList");

        cartList.remove(id-1);

        HttpSession session = request.getSession();

        session.setAttribute("sumQuantity",sumQuantity(cartList));
        session.setAttribute("sumPrice",sumPrice(cartList));
        rearrangeList(cartList);

        return "checkout";
    }

    public List<CartItem> rearrangeList(List<CartItem>  list) {
        int newId = 1;
        for (CartItem cartItem : list) {
            cartItem.setId(newId);
            newId++;
        }
        return list;
    }
}
