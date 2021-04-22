package juan.manuel.abate.pruebaacciona.service;

import java.util.List;
import java.util.Optional;

import juan.manuel.abate.pruebaacciona.controller.request.UpdateRequest;
import juan.manuel.abate.pruebaacciona.model.entity.Tweet;
import twitter4j.Status;

public interface TweetService {

	Optional<Tweet> create(Status status);
	List<Tweet> getAll();
	Tweet update(Long tweetId, UpdateRequest updateRequest);
	List<Tweet> getByUserAndValidated(String user, boolean validated);
}