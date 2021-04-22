package juan.manuel.abate.pruebaacciona.service.filter;

import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import twitter4j.Status;

@Component(StatusComposedFilter.COMPONENT_NAME)
@RequiredArgsConstructor
public class StatusComposedFilter implements Predicate<Status> {

	public static final String COMPONENT_NAME = "StatusComposedFilter";
	
	@Qualifier(StatusNumberOfFollowersFilter.COMPONENT_NAME)
	private final Predicate<Status> numberOfFollowersFilter;
	@Qualifier(StatusLanguageFilter.COMPONENT_NAME)
	private final Predicate<Status> languageFilter;
	
	@Override
	public boolean test(Status status) {
		return numberOfFollowersFilter.and(languageFilter).test(status);
	}
}
