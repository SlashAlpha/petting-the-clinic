package slash.process.pettingtheclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "cares")
public class Care extends BaseEntity {

    @Column(name = "type")
    private String type;
    @Column(name = "time")
    private double time;
    @Column(name = "products")
    private String products;
    @Column(name = "product_cost")
    private double productCost;
    @Column(name = "hour_cost")
    private double hourCost;
    @Column(name = "admin_cost")
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
