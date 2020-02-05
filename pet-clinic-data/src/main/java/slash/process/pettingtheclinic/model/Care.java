package slash.process.pettingtheclinic.model;

public class Care extends BaseEntity {
    private String type;
    private double time;
    private String products;
    private double productCost;
    private double hourCost;
    private double administrationCost;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public double getProductCost() {
        return productCost;
    }

    public void setProductCost(double productCost) {
        this.productCost = productCost;
    }

    public double getHourCost() {
        return hourCost;
    }

    public void setHourCost(double hourCost) {
        this.hourCost = hourCost;
    }

    public double getAdministrationCost() {
        return administrationCost;
    }

    public void setAdministrationCost(double administrationCost) {
        this.administrationCost = administrationCost;
    }
}
