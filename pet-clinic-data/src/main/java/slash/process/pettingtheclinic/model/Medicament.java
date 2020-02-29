package slash.process.pettingtheclinic.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "medicament")
public class Medicament extends BaseEntity {


    Date expirationDate;
    String name;
    String description;
    int Number;
    double price;

    @ManyToOne
    @JoinColumn(name = "pharmacy_id")
    Pharmacy pharmacy;


}
