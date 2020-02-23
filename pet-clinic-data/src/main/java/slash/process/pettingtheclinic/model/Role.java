package slash.process.pettingtheclinic.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Builder
@Entity
@Table(name = "auth_role_id")
public class Role extends BaseEntity {


    @Column(name = "role_name")
    private String role;

    @Column(name = "role_desc")
    private String description;

}
