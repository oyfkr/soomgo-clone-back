package project.soomgo.entity.post.repository.impl;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import project.soomgo.entity.post.dto.PostDTO;
import project.soomgo.entity.post.enums.PostType;
import project.soomgo.entity.post.repository.PostRepositoryCustom;
import project.soomgo.entity.post.Posts;

import java.util.Optional;
import project.soomgo.support.PageResponse;

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

    @Override
    public Page<Posts> findAllByPostTypeAndPageRequest(PageRequest request,
            PostType type) {

        List<Posts> postList = from(posts)
                .where(posts.postType.eq(type))
                .offset(request.getOffset())
                .limit(request.getPageSize())
                .fetch();

        long total = from(posts)
                .where(posts.postType.eq(type))
                .fetchCount();

        return new PageImpl<>(postList, request, total);
    }
}