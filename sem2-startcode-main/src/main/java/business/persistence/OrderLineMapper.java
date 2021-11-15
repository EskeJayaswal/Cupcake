package business.persistence;

import business.entities.OrderLine;
import business.exceptions.UserException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderLineMapper {

    private Database database;

    public OrderLineMapper(Database database) {
        this.database = database;
    }


    public List<OrderLine> getAllOrders() throws UserException {
        List<OrderLine> orderList = null;

        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM order_lines";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    if (orderList == null) {
                        orderList = new ArrayList<>();
                    }
                    int order_lines_id = rs.getInt("order_lines_id");
                    int order_id = rs.getInt("order_id");
                    int bottom_id = rs.getInt("bottom_id");
                    int topping_id = rs.getInt("topping_id");
                    int quantity = rs.getInt("quantity");
                    float price = rs.getFloat("price");


                    OrderLine orderline = new OrderLine(order_lines_id, order_id, bottom_id, topping_id, quantity, price);
                    orderList.add(orderline);
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
