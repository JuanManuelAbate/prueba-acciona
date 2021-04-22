package juan.manuel.abate.pruebaacciona.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import juan.manuel.abate.pruebaacciona.model.entity.Tweet;
import juan.manuel.abate.pruebaacciona.service.TweetService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

	private final TweetService tweetService;
	
	@ApiOperation(value = "List tweets for the user", notes = "Use the request parameter validated to filter tweets based on validated state")
	@GetMapping("/users/{user}/tweets")
	public ResponseEntity<List<Tweet>> getAll(@PathVariable String user, @RequestParam(required = true) boolean validated) {
		return ResponseEntity.ok(tweetService.getByUserAndValidated(user, validated)) ;
	}
}
