package project.soomgo.api.post.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import project.soomgo.entity.post.Posts;
import project.soomgo.entity.post.dto.PostDTO;
import project.soomgo.api.post.service.PostService;
import project.soomgo.entity.post.enums.PostType;
import project.soomgo.entity.post.repository.PostRepository;
import project.soomgo.entity.post.request.PostCreateRequest;
import project.soomgo.entity.subject.Subject;
import project.soomgo.entity.subject.repository.SubjectRepository;
import project.soomgo.entity.user.Users;
import project.soomgo.entity.user.repository.UsersRepository;
import project.soomgo.exception.BaseException;
import project.soomgo.exception.ErrorCode;

import java.util.Objects;
import project.soomgo.support.PageResponse;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final SubjectRepository subjectRepository;
    private final UsersRepository usersRepository;


    @Override
    public PostDTO getPost(Long id) {
        return PostDTO.of(Objects.requireNonNull(postRepository.findByIdWith(id).orElse(null)));
    }

    @Override
    public PostDTO createPost(PostCreateRequest request) {
        Posts post = Posts.of(request);

        Subject subject = subjectRepository.findById(request.getServiceId())
                .orElseThrow(() -> BaseException.of(ErrorCode.SUBJECT_NOT_FOUND));

        Users users = usersRepository.findById(request.getUserId())
                .orElseThrow(() -> BaseException.of(ErrorCode.USER_NOT_FOUND));

        post.changeUserAndSubjectFotCreate(subject, users);

        Posts savedPost = postRepository.save(post);

        return PostDTO.of(savedPost);
    }

    @Override
    public PageResponse<List<PostDTO>> getPosts(PageRequest request, PostType type) {

        Page<Posts> pagingPosts = postRepository.findAllByPostTypeAndPageRequest(
                request, type);

        List<PostDTO> content = pagingPosts.stream().map(pagingPost -> PostDTO.of(pagingPost))
                .collect(Collectors.toList());

        return PageResponse.of(request, pagingPosts.getTotalElements(), content);
    }
}
