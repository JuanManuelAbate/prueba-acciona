package juan.manuel.abate.pruebaacciona.config.tweetsload;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import twitter4j.StatusListener;
import twitter4j.TwitterStreamFactory;

@Component
@RequiredArgsConstructor
public class ApplicationEventListener {

	private final StatusListener statusListener;
	
	@EventListener(ApplicationReadyEvent.class)
    public void startApp() {

        TwitterStreamFactory.getSingleton().addListener(statusListener).sample();
    }
}
