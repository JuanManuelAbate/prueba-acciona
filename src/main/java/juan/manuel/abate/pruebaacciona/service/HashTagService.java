package juan.manuel.abate.pruebaacciona.service;

import java.util.List;

import juan.manuel.abate.pruebaacciona.model.HashTag;

public interface HashTagService {

	void store(String hashTagName);

	List<HashTag> getTopN(Integer topNLimit);
}
