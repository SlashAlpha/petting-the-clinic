package slash.process.pettingtheclinic.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {

    @Builder
    public Pet(Long id, String name, LocalDate birthDate, Owner owner, PetType petType, Set<Visit> visits) {
        super.setId(id);
        this.name = name;
        this.birthDate = birthDate;
        this.owner = owner;
        this.petType = petType;

        if (visits == null || visits.size() > 0) {
            this.visits = visits;
        }
        ;
    }

    //pharmacy, sickness, medication
    @Column(name = "name")
    private String name;
    @Column(name = "birth_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType petType;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();


}
