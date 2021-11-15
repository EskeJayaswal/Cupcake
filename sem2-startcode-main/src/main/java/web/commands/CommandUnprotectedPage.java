package web.commands;

import business.entities.CartItem;
import business.exceptions.UserException;
import business.persistence.Database;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CommandUnprotectedPage extends Command
{
    public String pageToShow;

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
            System.out.println(sum);
        }
        return String.valueOf(sum);
    }

    public String sumPrice(List<CartItem> list) {
        int sum = 0;
        for (CartItem cartItem : list) {
            sum += cartItem.getPrice();
            System.out.println(sum);
        }
        return String.valueOf(sum);
    }
}


