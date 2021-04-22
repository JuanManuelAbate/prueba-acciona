package juan.manuel.abate.pruebaacciona.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Tweet {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String user;
	@Column(columnDefinition = "TEXT")
	private String text;
	private String localization;
	private boolean validated;
}
