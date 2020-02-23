package slash.process.pettingtheclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {

    @Builder
    public Visit(Long id, LocalDate date, String description, Set<Care> cares, Pet pet, Vet vet, String tag, Prescription prescription, double visitCost, String smallDescription) {
        super.setId(id);
        this.date = date;
        this.description = description;
        this.pet = pet;
        this.vet = vet;
        this.tag = tag;
        this.prescription = prescription;
        this.visitCost = visitCost;
        this.smallDescription = smallDescription;
        if (cares == null || cares.size() > 0) {
            this.cares = cares;
        }
    }

    @Column(name = "date")
    private LocalDate date;
    @Column(name = "description")
    private String description;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name = "visit_id"), inverseJoinColumns = @JoinColumn(name = "care_id"))
    private Set<Care> cares = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;
    @ManyToOne
    @JoinColumn(name = "vet_id")
    private Vet vet;
    @Column(name = "tag")
    private String tag;
    @ManyToOne
    @JoinColumn(name = "prescription_id")
    private Prescription prescription;
    @Column(name = "visit_cost")
    private double visitCost;
    @Column(name = "small_description")
    private String smallDescription;
    @ManyToOne
    @JoinColumn(name = "analysis_id")
    private Analysis analysis;



    public double getVisitCost() {
        cares.forEach(care -> {
            visitCost += care.getTotalCost();
        });
        return visitCost;
    }


}
