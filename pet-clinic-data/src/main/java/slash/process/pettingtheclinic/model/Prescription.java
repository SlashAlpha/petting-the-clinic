package slash.process.pettingtheclinic.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "prescriptions")
public class Prescription extends BaseEntity {

    public String description;
    public boolean renewal;
    public double validityPeriod;
    public double numberOfItem;


}
