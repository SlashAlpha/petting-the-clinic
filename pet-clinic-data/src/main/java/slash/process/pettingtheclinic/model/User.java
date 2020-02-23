package slash.process.pettingtheclinic.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@Table(name = "auth_user")
public class User extends Person {

    @Column(name = "username")
    private String userName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "mobile")
    private String mobile;
    @Column(name = "status")
    private String status;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "auth_user_role", joinColumns = @JoinColumn(name = "auth_user_id")
            , inverseJoinColumns = @JoinColumn(name = "auth_role_id"))
    private Set<Role> roles;

    private String passwordConfirm;

    @Transient
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

}
