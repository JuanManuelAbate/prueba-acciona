package juan.manuel.abate.pruebaacciona.service.impl;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import juan.manuel.abate.pruebaacciona.model.HashTag;

public class HashTagServiceImplTest {

	private HashTagServiceImpl hashTagServiceImplToBeTested =
			new HashTagServiceImpl();
	
	@Test
	public void asd() {
		hashTagServiceImplToBeTested.store("a");
		hashTagServiceImplToBeTested.store("a");
		hashTagServiceImplToBeTested.store("a");
		hashTagServiceImplToBeTested.store("b");
		hashTagServiceImplToBeTested.store("b");
		hashTagServiceImplToBeTested.store("a");
		hashTagServiceImplToBeTested.store("a");
		hashTagServiceImplToBeTested.store("c");
		hashTagServiceImplToBeTested.store("e");
		hashTagServiceImplToBeTested.store("c");
		hashTagServiceImplToBeTested.store("c");
		hashTagServiceImplToBeTested.store("a");

		List<HashTag> expectedResult = Arrays.asList(
				HashTag.builder().name("a").occurrences(6).build(),
				HashTag.builder().name("c").occurrences(3).build());
		
		List<HashTag> result = hashTagServiceImplToBeTested.getTopN(2);
		
		assertEquals(expectedResult, result);
	}
}
