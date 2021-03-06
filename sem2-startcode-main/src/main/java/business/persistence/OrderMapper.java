package business.persistence;

import business.entities.*;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderMapper {

    private Database database;
    private BottomMapper bottomMapper;
    private ToppingMapper toppingMapper;

    private List<Bottom> bottoms;
    private List<Topping> toppings;

    public OrderMapper(Database database) {
        this.database = database;
        bottomMapper = new BottomMapper(database);
        toppingMapper = new ToppingMapper(database);

        try {
            bottoms = bottomMapper.getAllBottoms();
            toppings = toppingMapper.getAllToppings();
        } catch (UserException e) {
            e.printStackTrace();
        }
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
                    String status = getStatus(order_id);

                    List<CartItem> orderlines = getAllOrderLines(order_id);

                    Order order = new Order(order_id, user_id, created, orderlines, status);

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

    public List<CartItem> getAllOrderLines(int orderId) throws UserException {
        List<CartItem> orderLineList = null;
        int id = 1;
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM orders_joined WHERE order_id=?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, orderId);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    if (orderLineList == null) {
                        orderLineList = new ArrayList<>();
                    }

                    int bottom_id = rs.getInt("bottom_id");
                    int topping_id = rs.getInt("topping_id");
                    int quantity = rs.getInt("quantity");
                    float price = rs.getFloat("price");

                    Bottom b = bottoms.get(bottom_id-1);
                    Topping t = toppings.get(topping_id-1);


                    CartItem orderline = new CartItem(id, b, t, quantity, price);
                    id++;
                    orderLineList.add(orderline);
                }

            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
        return orderLineList;
    }

    public void createOrder(int user, List<CartItem> cartItemList) throws UserException {

        int generatedId = 0;

        try {
            Connection connection = database.connect();
            String sql = "INSERT INTO orders (user_id) VALUES (?)";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, String.valueOf(user));
            ps.executeUpdate();

            ResultSet ids = ps.getGeneratedKeys();
            if (ids.next()) {
                generatedId = ids.getInt(1);

                createOrderLines(cartItemList, generatedId);
                createStatus(generatedId);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void createOrderLines(List<CartItem> cartItemList, int generatedId) throws UserException {
        try {
            Connection connection = database.connect();
            String sql = "INSERT INTO order_lines(order_id, bottom_id, topping_id, quantity, price) VALUES (?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            for (CartItem cartItem : cartItemList) {
                ps.setInt(1, generatedId);
                ps.setInt(2, cartItem.getBottom().getId());
                ps.setInt(3, cartItem.getTopping().getId());
                ps.setInt(4, cartItem.getQuantity());
                ps.setFloat(5, cartItem.getPrice());
                ps.executeUpdate();

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public int getOrderCount(int id) throws UserException {
        int orderCount = 0;

        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM orders WHERE user_id=?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    orderCount++;
                }

            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
        return orderCount;
    }

    public void createStatus(int id) throws UserException {


        try {
            Connection connection = database.connect();
            String sql = "INSERT INTO orders_status_link (order_id, status_id) VALUES (?,?)";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, id);
            ps.setInt(2, 1); // Default status for new orders.
            ps.executeUpdate();



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public String getStatus(int orderId) throws UserException {
        String status = "";
        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM orders_status WHERE order_id=?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, orderId);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {

                    status = rs.getString("status_text");

                }

            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
        return status;
    }

}





