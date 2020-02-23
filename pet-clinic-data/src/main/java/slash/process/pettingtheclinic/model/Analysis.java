package slash.process.pettingtheclinic.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Entity
@Builder
@Table(name = "analysis")
public class Analysis extends BaseEntity {

    @Column(name = "documentation")
    Byte[] documentation;
    @Column(name = "date")
    private Date date;
    @Column(name = "type")
    private String type;
    @Column(name = "description")
    private String description;
    @Column(name = "conclusions")
    private String conclusions;

}
