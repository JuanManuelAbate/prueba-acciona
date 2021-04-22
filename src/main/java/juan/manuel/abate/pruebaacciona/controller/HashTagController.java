package juan.manuel.abate.pruebaacciona.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import juan.manuel.abate.pruebaacciona.model.HashTag;
import juan.manuel.abate.pruebaacciona.service.HashTagService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class HashTagController {

	private final HashTagService hashTagService;
	
	@ApiOperation(value = "List top used hashtags", notes = "Use the request parameter topNLimit to limit the number of hashtags")
	@GetMapping("/hashtags")
	public ResponseEntity<List<HashTag>>  getTopN(@RequestParam(required = false) Integer topNLimit) {
		return ResponseEntity.ok(hashTagService.getTopN(topNLimit));
	}
}
