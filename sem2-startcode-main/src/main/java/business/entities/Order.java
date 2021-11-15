package business.entities;

import java.util.Date;

public class Order {
    private int order_id;
    private int user_id;
    private Date created;

    public Order(int order_id, int user_id, Date created) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.created = created;
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
}
