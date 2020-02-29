package slash.process.pettingtheclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "analysis")
public class Analysis extends BaseEntity {

    @Lob
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
