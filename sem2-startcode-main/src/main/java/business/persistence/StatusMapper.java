package business.persistence;

import business.exceptions.UserException;

import java.sql.*;

public class StatusMapper {

    private Database database;

    public StatusMapper(Database database) {
        this.database = database;
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
