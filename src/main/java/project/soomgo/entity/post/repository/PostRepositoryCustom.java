package project.soomgo.entity.post.repository;

import project.soomgo.entity.post.Posts;

import java.util.Optional;

public interface PostRepositoryCustom {

    Optional<Posts> findByIdWith(Long postId);
}
