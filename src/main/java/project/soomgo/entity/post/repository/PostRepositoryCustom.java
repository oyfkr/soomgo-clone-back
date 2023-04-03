package project.soomgo.entity.post.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import project.soomgo.entity.post.Posts;

import java.util.Optional;
import project.soomgo.entity.post.enums.PostType;

public interface PostRepositoryCustom {

    Optional<Posts> findByIdWith(Long postId);

    Page<Posts> findAllByPostTypeAndPageRequest(PageRequest request, PostType type);

}
