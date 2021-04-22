package juan.manuel.abate.pruebaacciona.service.filter;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import twitter4j.Status;

@ExtendWith(MockitoExtension.class)
public class StatusLanguageFilterTest {

	@Mock
	private Status statusMock;
	
	private StatusLanguageFilter statusLanguageFilterToBeTested = 
			new StatusLanguageFilter();

	@Test
	public void given_AStatusWithLanguageEs_WhenCheckIfHaveLanguageEs_TheResultShouldBeTrue() {
		when(statusMock.getLang()).thenReturn("es");
		ReflectionTestUtils.setField(statusLanguageFilterToBeTested, "languagesAccepted", new HashSet<>(Arrays.asList("es", "fr", "it")));
		
		assertTrue(statusLanguageFilterToBeTested.test(statusMock));
	}
}
