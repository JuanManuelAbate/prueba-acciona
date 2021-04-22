package juan.manuel.abate.pruebaacciona.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import juan.manuel.abate.pruebaacciona.controller.request.UpdateRequest;
import juan.manuel.abate.pruebaacciona.model.entity.Tweet;
import juan.manuel.abate.pruebaacciona.service.TweetService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class TweetController {

	private final TweetService tweetService;
	
	@ApiOperation(value = "List all tweets")
	@GetMapping("/tweets")
	public ResponseEntity<List<Tweet>> getAll() {
		return ResponseEntity.ok(tweetService.getAll());
	}
	
	@ApiOperation(value = "Modify the validated state of a tweet")
	@PatchMapping("/tweets/{id}")
	public ResponseEntity<Tweet> update(@PathVariable Long id, @RequestBody UpdateRequest updateRequest) {
		return ResponseEntity.ok(tweetService.update(id, updateRequest));
	}
}
