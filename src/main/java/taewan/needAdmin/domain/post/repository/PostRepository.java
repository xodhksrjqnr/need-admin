package taewan.needAdmin.domain.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import taewan.needAdmin.domain.post.entity.Post;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

    Optional<Post> findById(Long postId);
}
