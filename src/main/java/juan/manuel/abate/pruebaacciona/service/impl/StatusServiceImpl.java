package juan.manuel.abate.pruebaacciona.service.impl;

import java.util.Arrays;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import juan.manuel.abate.pruebaacciona.service.HashTagService;
import juan.manuel.abate.pruebaacciona.service.StatusService;
import juan.manuel.abate.pruebaacciona.service.TweetService;
import juan.manuel.abate.pruebaacciona.service.filter.StatusComposedFilter;
import lombok.RequiredArgsConstructor;
import twitter4j.Status;

@Service
@RequiredArgsConstructor
public class StatusServiceImpl implements StatusService {

	@Qualifier(StatusComposedFilter.COMPONENT_NAME)
	private final Predicate<Status> statusComposedFilter;
	private final TweetService tweetService;
	private final HashTagService hashTagService;
	
	@Override
	public void consume(Status status) {
		if (statusComposedFilter.test(status)) {
			tweetService.create(status);
			Arrays.stream(status.getHashtagEntities()).forEach(he -> hashTagService.store(he.getText()));
		}
	}
}
