package juan.manuel.abate.pruebaacciona.config.tweetsload;

import org.springframework.stereotype.Component;

import juan.manuel.abate.pruebaacciona.service.StatusService;
import lombok.RequiredArgsConstructor;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;

@Component
@RequiredArgsConstructor
public class TwitterListener implements StatusListener{

	private final StatusService statusService;
	
	@Override
	public void onException(Exception ex) {
		// Not used in this exercise.
	}

	@Override
	public void onStatus(Status status) {
		statusService.consume(status);
	}

	@Override
	public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
		// Not used in this exercise.
	}

	@Override
	public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
		// Not used in this exercise.
	}

	@Override
	public void onScrubGeo(long userId, long upToStatusId) {
		// Not used in this exercise.
	}

	@Override
	public void onStallWarning(StallWarning warning) {
		// Not used in this exercise.
	}

}
