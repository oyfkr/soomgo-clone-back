package project.soomgo.api.post.service;

import java.util.List;
import org.springframework.data.domain.PageRequest;
import project.soomgo.entity.post.Posts;
import project.soomgo.entity.post.dto.PostDTO;
import project.soomgo.entity.post.enums.PostType;
import project.soomgo.entity.post.request.PostCreateRequest;
import project.soomgo.support.PageResponse;

public interface PostService {

    PostDTO getPost(Long id);

    PostDTO createPost(PostCreateRequest request);

    PageResponse<List<PostDTO>> getPosts(PageRequest request, PostType type);
}
