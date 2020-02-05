package slash.process.pettingtheclinic.model;

import java.time.LocalDate;
import java.util.Set;

public class Visit extends BaseEntity {
    private LocalDate date;
    private String description;
    private Set<Care> cares;
    private Pet pet;
    private Vet vet;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Care> getCares() {
        return cares;
    }

    public void setCares(Set<Care> cares) {
        this.cares = cares;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }
}
