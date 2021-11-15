package web.commands;

import business.entities.CartItem;
import business.exceptions.UserException;
import business.services.LogicFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class IndexCommand extends CommandUnprotectedPage {
    private LogicFacade logicFacade;
    private List<CartItem> cartList;


    public IndexCommand(String pageToShow) {
        super(pageToShow);
        logicFacade = new LogicFacade(database);
        cartList = new ArrayList<>();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        try {

            if (request.getServletContext().getAttribute("bottomList") == null) {
                request.getServletContext().setAttribute("bottomList", logicFacade.getAllBottoms());
            }
            if (request.getServletContext().getAttribute("toppingList") == null) {
                request.getServletContext().setAttribute("toppingList", logicFacade.getAllToppings());
            }


            request.getServletContext().setAttribute("cartList", cartList);



            return pageToShow;
        } catch (UserException ex) {
            request.setAttribute("error", "No data!");
            return "index";
        }
    }
}
