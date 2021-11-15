package business.persistence;

import business.entities.Order;
import business.entities.OrderLine;
import business.exceptions.UserException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderMapper {

    private Database database;

    public OrderMapper(Database database) {
        this.database = database;
    }


    public List<Order> getAllOrders(int id) throws UserException {
        List<Order> orderList = null;

        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM orders WHERE user_id=?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    if (orderList == null) {
                        orderList = new ArrayList<>();
                    }
                    int order_id = rs.getInt("order_id");
                    int user_id = rs.getInt("user_id");
                    Date created = rs.getDate("created");

                    Order order = new Order(order_id, user_id, created);


                    orderList.add(order);
                }

            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
        return orderList;
    }
}

