package juan.manuel.abate.pruebaacciona.exception;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ApiError {

	private String error;
}
