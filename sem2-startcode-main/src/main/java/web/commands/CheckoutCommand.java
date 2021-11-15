package web.commands;


import business.entities.CartItem;
import business.services.LogicFacade;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.util.List;

public class CheckoutCommand extends CommandUnprotectedPage {
    private List<CartItem> cartList;
    private LogicFacade logicFacade;

    public CheckoutCommand(String pageToShow) {
        super(pageToShow);

    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();
        // Makes sure we are logged in when view the checkout page.
        if(session.getAttribute("user")==null){
            return "loginpage";
        }else{
            return "checkout";
        }
    }
}
