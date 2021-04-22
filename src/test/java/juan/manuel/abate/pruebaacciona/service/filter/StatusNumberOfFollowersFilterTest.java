package juan.manuel.abate.pruebaacciona.service.filter;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import twitter4j.Status;
import twitter4j.User;

@ExtendWith(MockitoExtension.class)
public class StatusNumberOfFollowersFilterTest {

	@Mock
	private Status statusMock;
	
	@Mock
	private User userMock;
	
	private StatusNumberOfFollowersFilter statusNumberOfFollowersFilterToBeTested = 
			new StatusNumberOfFollowersFilter();

	@Test
	public void given_AStatusWithMoreThan1500Followers_WhenCheckIfHaveMoreThan1500Followers_TheResultShouldBeTrue() {
		when(statusMock.getUser()).thenReturn(userMock);
		when(userMock.getFollowersCount()).thenReturn(1501);
		ReflectionTestUtils.setField(statusNumberOfFollowersFilterToBeTested, "numberOfFollowersAcepted", 1500);
		
		assertTrue(statusNumberOfFollowersFilterToBeTested.test(statusMock));
	}
}
