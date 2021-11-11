package business.persistence;

import business.entities.Topping;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ToppingMapper {

    private Database database;

    public ToppingMapper(Database database) {
        this.database = database;
    }


    public List<Topping> getAllToppings() throws UserException {
        List<Topping> toppingList = null;

        try (Connection connection = database.connect()) {
            String sql = "SELECT * FROM toppings";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    if (toppingList == null) {
                        toppingList = new ArrayList<>();
                    }
                    int bottom_id = rs.getInt("bottom_id");
                    String name = rs.getString("name");
                    float price = rs.getFloat("price");


                    Topping topping = new Topping(bottom_id, name, price);
                    toppingList.add(topping);
                }

            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
        return toppingList;
    }
}