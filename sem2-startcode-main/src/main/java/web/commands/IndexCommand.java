package web.commands;


import business.exceptions.UserException;
import business.services.LogicFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexCommand extends CommandUnprotectedPage {
    private LogicFacade logicFacade;


    public IndexCommand(String pageToShow) {
        super(pageToShow);
        logicFacade = new LogicFacade(database);
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


            return pageToShow;
        } catch (UserException ex) {
            request.setAttribute("error", "No data!");
            return "index";
        }
    }
}
