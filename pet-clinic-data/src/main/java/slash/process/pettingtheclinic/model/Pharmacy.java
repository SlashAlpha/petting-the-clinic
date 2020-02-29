package slash.process.pettingtheclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pharmacy")
public class Pharmacy extends BaseEntity {


    int numberOfMedicaments;

    double amount;

    @OneToMany
    @JoinColumn
    @JoinTable(joinColumns = @JoinColumn(name = "pharmacy_id"), inverseJoinColumns = @JoinColumn(name = "medicament_id"))
    Set<Medicament> medicaments;


}
