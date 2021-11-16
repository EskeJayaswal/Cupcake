package business.services;

import business.entities.Order;
import business.entities.User;
import business.persistence.Database;
import business.persistence.UserMapper;
import business.exceptions.UserException;

import java.util.List;

public class UserFacade
{
    UserMapper userMapper;

    public UserFacade(Database database)
    {
        userMapper = new UserMapper(database);
    }

    public User login(String email, String password) throws UserException
    {
        return userMapper.login(email, password);
    }

    public User createUser(String email, String password, String fname, String lname, float balance) throws UserException
    {
        User user = new User(email, password, fname, lname, balance, "customer");
        userMapper.createUser(user);
        return user;
    }

    public List<User> getAllUsers() throws UserException {
        return userMapper.getAllUsers();
    }
}
