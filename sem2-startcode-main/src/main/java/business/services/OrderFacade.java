package business.services;

import business.entities.Order;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.OrderMapper;

import java.util.List;

public class OrderFacade {
    OrderMapper orderMapper;

    public OrderFacade(Database database) {
        orderMapper = new OrderMapper(database);
    }

    public List<Order> getAllOrders(int id) throws UserException {
        System.out.println(id);
        return orderMapper.getAllOrders(id);
    }
}
