package project.soomgo.entity.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.soomgo.entity.post.Posts;

public interface PostRepository extends JpaRepository<Posts, Long>, PostRepositoryCustom {
}
