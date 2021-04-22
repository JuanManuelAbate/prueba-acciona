package juan.manuel.abate.pruebaacciona.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import juan.manuel.abate.pruebaacciona.controller.request.UpdateRequest;
import juan.manuel.abate.pruebaacciona.model.entity.Tweet;
import juan.manuel.abate.pruebaacciona.repository.TweetRepository;
import juan.manuel.abate.pruebaacciona.service.TweetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import twitter4j.Status;

@Service
@RequiredArgsConstructor
@Slf4j
public class TweetServiceImpl implements TweetService {

	private final TweetRepository tweetRepository;
	
	@Override
	public Optional<Tweet> create(Status status) {
		try {
			Tweet newTweet = new Tweet();
			newTweet.setUser(status.getUser().getScreenName());
			newTweet.setText(status.getText());
			newTweet.setLocalization(status.getUser().getLocation());
			newTweet.setValidated(Boolean.FALSE);
			return Optional.of(tweetRepository.save(newTweet));
		} catch (Exception e) {
			log.error(e.getMessage()); //TODO METER ID DEL TWEETER
			return Optional.empty();
		}
	}

	@Override
	public List<Tweet> getAll() {
		return tweetRepository.findAll();
	}
	
	@Override
	public Tweet update(Long tweetId, UpdateRequest updateRequest) {
		Tweet tweetToUpdate = tweetRepository.findById(tweetId)
				.orElseThrow(() -> new NoSuchElementException("There is no Tweet with id: " + tweetId));
		tweetToUpdate.setValidated(updateRequest.isValidated());
		return tweetRepository.save(tweetToUpdate);
	}
	
	@Override
	public List<Tweet> getByUserAndValidated(String user, boolean validated) {
		return tweetRepository.findByUserAndValidated(user, validated);
	}
}
