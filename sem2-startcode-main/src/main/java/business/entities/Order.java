package business.entities;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private int order_id;
    private int user_id;
    private Date created;
    private String status;
    private List<CartItem> orderLines;

    public Order(int order_id, int user_id, Date created, List<CartItem> orderLines) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.created = created;
        this.orderLines = orderLines;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<CartItem> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<CartItem> orderLines) {
        this.orderLines = orderLines;
    }
}
