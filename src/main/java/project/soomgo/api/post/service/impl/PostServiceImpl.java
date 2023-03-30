package project.soomgo.api.post.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.soomgo.entity.post.Posts;
import project.soomgo.entity.post.dto.PostDTO;
import project.soomgo.api.post.service.PostService;
import project.soomgo.entity.post.repository.PostRepository;
import project.soomgo.entity.post.request.PostCreateRequest;
import project.soomgo.entity.subject.Subject;
import project.soomgo.entity.subject.repository.SubjectRepository;
import project.soomgo.entity.user.Users;
import project.soomgo.entity.user.repository.UsersRepository;
import project.soomgo.exception.BaseException;
import project.soomgo.exception.ErrorCode;

import java.util.Objects;

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
}
