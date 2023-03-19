package project.soomgo.api.post.service;

import project.soomgo.entity.post.dto.PostDTO;
import project.soomgo.entity.post.request.PostCreateRequest;

public interface PostService {

    PostDTO getPost(Long id);

    PostDTO createPost(PostCreateRequest request);
}
