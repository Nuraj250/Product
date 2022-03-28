package dto;

public class ProductDTO {

    int Product_id;
    String Product_name;
    String Product_Qty;
    String Product_price;

    public ProductDTO() {
    }
    public ProductDTO(int Product_id, String Product_name, String Product_Qty, String Product_price) {
        this.Product_id = Product_id;
        this.Product_name = Product_name;
        this.Product_Qty = Product_Qty;
        this.Product_price = Product_price;

    }

    public int getProduct_id() {
        return Product_id;
    }

    public void setProduct_id(int product_id) {
        Product_id = product_id;
    }

    public String getProduct_name() {
        return Product_name;
    }

    public void setProduct_name(String product_name) {
        Product_name = product_name;
    }

    public String getProduct_Qty() {
        return Product_Qty;
    }

    public void setProduct_Qty(String product_Qty) {
        Product_Qty = product_Qty;
    }

    public String getProduct_price() {
        return Product_price;
    }

    public void setProduct_price(String product_price) {
        Product_price = product_price;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "Product_id='" + Product_id + '\'' +
                ", Product_name='" + Product_name + '\'' +
                ", Product_Qty='" + Product_Qty + '\'' +
                ", Product_price='" + Product_price + '\'' +
                '}';
    }
}
