package project.soomgo.entity.post.repository.impl;

import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import project.soomgo.entity.post.repository.PostRepositoryCustom;
import project.soomgo.entity.post.Posts;

import java.util.Optional;

import static project.soomgo.entity.post.QPosts.posts;

public class PostRepositoryCustomImpl extends QuerydslRepositorySupport implements PostRepositoryCustom {

    private JpaRepositoryFactory factory;

    public PostRepositoryCustomImpl() {
        super(Posts.class);
    }

    @Override
    public Optional<Posts> findByIdWith(Long postId) {
        return Optional.ofNullable(from(posts)
                .where(posts.id.eq(postId))
                .fetchOne()
        );
    }
}