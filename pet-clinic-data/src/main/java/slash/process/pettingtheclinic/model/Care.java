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
    private double administrativCost;

    @Column(name = "specification")
    private String specification;
    @Column(name = "totalcost")
    private double totalCost;


    public double getTotalCost() {
        this.totalCost = productCost + administrativCost + Math.round((time / 60) * hourCost);
        return totalCost;
    }





}
