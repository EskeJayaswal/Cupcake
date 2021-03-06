package web.commands;

import business.entities.CartItem;
import business.entities.User;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.UserMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CommandUnprotectedPage extends Command
{
    public String pageToShow;
    UserMapper userMapper;
    User user;

    public CommandUnprotectedPage(String pageToShow)
    {
        this.pageToShow = pageToShow;
    }

    public String execute(
            HttpServletRequest request,
            HttpServletResponse response) throws UserException
    {
        return pageToShow;
    }

    public String sumQuantity(List<CartItem> list) {
        int sum = 0;
        for (CartItem cartItem : list) {
            sum += cartItem.getQuantity();
        }
        return String.valueOf(sum);
    }

    public String sumPrice(List<CartItem> list) {
        int sum = 0;
        for (CartItem cartItem : list) {
            sum += cartItem.getPrice();
        }
        return String.valueOf(sum);
    }

}


