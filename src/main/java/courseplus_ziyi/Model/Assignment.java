package courseplus_ziyi.Model;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Assignment {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String description;
//	@Column(insertable = false, updatable = false, columnDefinition = " date default CURRENT_TIMESTAMP")
	private Date uploadDate;
	private java.sql.Date dueDate;
	private String filePath;
	@Transient
	private int courseid;
	@ManyToOne
	private Course course;


}
