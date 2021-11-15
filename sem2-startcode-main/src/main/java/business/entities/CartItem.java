package business.entities;

public class CartItem {
    private int id;
    private Bottom bottom;
    private Topping topping;
    private int quantity;
    private float price;


    public CartItem(int id, Bottom bottom, Topping topping, int quantity, float price) {
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", topping=" + topping +
                ", quantity=" + quantity +
                ", price=" + price +
                ", bottom=" + bottom +
                '}';
    }
}
