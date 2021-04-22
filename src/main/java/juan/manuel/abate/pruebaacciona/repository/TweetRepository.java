package juan.manuel.abate.pruebaacciona.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import juan.manuel.abate.pruebaacciona.model.entity.Tweet;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {

	List<Tweet> findByUserAndValidated(String user, boolean validated);
}
