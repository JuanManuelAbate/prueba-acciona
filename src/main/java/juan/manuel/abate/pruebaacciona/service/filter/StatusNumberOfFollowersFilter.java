package juan.manuel.abate.pruebaacciona.service.filter;

import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import twitter4j.Status;

@Component(StatusNumberOfFollowersFilter.COMPONENT_NAME)
public class StatusNumberOfFollowersFilter implements Predicate<Status> {

	public static final String COMPONENT_NAME = "StatusNumberOfFollowersFilter";
	
	@Value("${tweet.minimum.number.of.followers:1500}")
	private int numberOfFollowersAcepted;
	
	@Override
	public boolean test(Status status) {
		return status.getUser().getFollowersCount() > numberOfFollowersAcepted;
	}
}
