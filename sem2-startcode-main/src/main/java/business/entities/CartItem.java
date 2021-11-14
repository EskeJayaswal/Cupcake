package business.entities;

public class CartItem {
    private Bottom bottom;
    private Topping topping;
    private int quantity;
    private float price;

    public CartItem(Bottom bottom, Topping topping, int quantity, float price) {
        this.bottom = bottom;
        this.topping = topping;
        this.quantity = quantity;
        this.price = price;
    }

    public Bottom getBottom() {
        return bottom;
    }

    public void setBottom(Bottom bottom) {
        this.bottom = bottom;
    }

    public Topping getTopping() {
        return topping;
    }

    public void setTopping(Topping topping) {
        this.topping = topping;
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
