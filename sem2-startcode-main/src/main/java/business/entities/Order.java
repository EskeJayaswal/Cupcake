package business.entities;

public class Order {
    private int order_lines_id;
    private int order_id;
    private int bottom_id;
    private int topping_id;
    private int quantity;
    private float price;

    public Order(int order_lines_id, int order_id, int bottom_id, int topping_id, int quantity, float price) {
        this.order_lines_id = order_lines_id;
        this.order_id = order_id;
        this.bottom_id = bottom_id;
        this.topping_id = topping_id;
        this.quantity = quantity;
        this.price = price;
    }

    public int getOrder_lines_id() {
        return order_lines_id;
    }

    public void setOrder_lines_id(int order_lines_id) {
        this.order_lines_id = order_lines_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getBottom_id() {
        return bottom_id;
    }

    public void setBottom_id(int bottom_id) {
        this.bottom_id = bottom_id;
    }

    public int getTopping_id() {
        return topping_id;
    }

    public void setTopping_id(int topping_id) {
        this.topping_id = topping_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
