package slash.process.pettingtheclinic.model;

public class Care extends BaseEntity {
    private String type;
    private int time;
    private String products;
    private int productCost;
    private int hourCost;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public int getProductCost() {
        return productCost;
    }

    public void setProductCost(int productCost) {
        this.productCost = productCost;
    }

    public int getHourCost() {
        return hourCost;
    }

    public void setHourCost(int hourCost) {
        this.hourCost = hourCost;
    }
}
