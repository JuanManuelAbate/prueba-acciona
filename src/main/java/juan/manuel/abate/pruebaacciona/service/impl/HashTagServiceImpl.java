package juan.manuel.abate.pruebaacciona.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import juan.manuel.abate.pruebaacciona.model.HashTag;
import juan.manuel.abate.pruebaacciona.service.HashTagService;

@Service
public class HashTagServiceImpl implements HashTagService {

	@Value("${hashtag.top.n:10}")
	private int hashtagsTopN;
	
	private Map<String, Integer> hashTagOcurrences = new HashMap<>();
	
	@Override
	public void store(String hashTagName) {
		if (hashTagOcurrences.containsKey(hashTagName)) {
			hashTagOcurrences.put(hashTagName, hashTagOcurrences.get(hashTagName) + 1);
		} else {
			hashTagOcurrences.put(hashTagName, 1);
		}
	}

	@Override
	public List<HashTag> getTopN(Integer topNLimit) {
		List<HashTag> hashTags = generateHashTags();
		hashTags.sort((htA, htB) -> htB.getOccurrences().compareTo(htA.getOccurrences()));
		return hashTags.stream()
				.limit(determineHashTagsTopNLimit(topNLimit))
				.collect(Collectors.toList());
	}
	
	private int determineHashTagsTopNLimit(Integer topNLimit) {
		return topNLimit != null
				? topNLimit
				: hashtagsTopN;
	}
	
	private List<HashTag> generateHashTags() {
		return hashTagOcurrences.keySet().stream()
					.map(htk -> HashTag.builder()
							.name(htk)
							.occurrences(hashTagOcurrences.get(htk))
							.build())
					.collect(Collectors.toList());
	}
}
