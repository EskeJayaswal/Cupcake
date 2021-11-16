package web.commands;

import business.entities.CartItem;
import business.entities.Order;
import business.exceptions.UserException;
import business.services.LogicFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IndividualOrdersCommand extends CommandUnprotectedPage {
    private LogicFacade logicFacade;
    private List<CartItem> cartList;

    public IndividualOrdersCommand(String pageToShow) {
        super(pageToShow);
        logicFacade = new LogicFacade(database);
        cartList = new ArrayList<>();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        int orderId = Integer.parseInt(request.getParameter("individualOrder"));
        List<Order> orders = (List<Order>) request.getSession().getAttribute("orderList");
        List<CartItem> orderLines = findOrder(orders, orderId);
        request.getSession().setAttribute("currentOrder" , orderLines);
        request.getSession().setAttribute("sumOfCurrentOrder", getSum(orderLines));
        return "individualOrders";
    }

    private List<CartItem> findOrder(List<Order> orders, int id){
        for (Order order : orders) {
            if(order.getOrder_id()==id){
                return order.getOrderLines();
            }
        }
        return null;
    }

    private String getSum(List<CartItem> orderLines){
        int sum = 0;
        for (CartItem orderLine : orderLines) {
            sum += orderLine.getPrice();
        }
        return String.valueOf(sum);
    }

}
