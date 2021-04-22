package juan.manuel.abate.pruebaacciona.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HashTag {

	private String name;
	private Integer occurrences;
	
	public Integer addOccurrence() {
		occurrences = occurrences + 1;
		return occurrences;
	}
}
