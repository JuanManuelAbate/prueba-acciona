package juan.manuel.abate.pruebaacciona.service.filter;

import java.util.Set;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import twitter4j.Status;

@Component(StatusLanguageFilter.COMPONENT_NAME)
public class StatusLanguageFilter implements Predicate<Status> {

	public static final String COMPONENT_NAME = "StatusLanguageFilter";
	
	@Value("${tweet.languages.accepted:es,fr,it}")
	private Set<String> languagesAccepted;

	@Override
	public boolean test(Status status) {
		return languagesAccepted.contains(status.getLang());
	}
}
