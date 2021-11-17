package business.services;

import business.entities.CartItem;
import business.entities.Order;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.OrderMapper;
import business.persistence.StatusMapper;

import java.util.List;

public class OrderFacade {
    OrderMapper orderMapper;
    StatusMapper statusMapper;

    public OrderFacade(Database database) {
        orderMapper = new OrderMapper(database);
        statusMapper = new StatusMapper(database);
    }

    public List<Order> getAllOrders(int id) throws UserException {
        return orderMapper.getAllOrders(id);
    }

    public void createOrder(int user, List<CartItem> cartItemList) throws UserException {
        orderMapper.createOrder(user, cartItemList);
    }

    public String getStatus(int orderId) throws UserException {
        return statusMapper.getStatus(orderId);
    }
}
