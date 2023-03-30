package project.soomgo.api.post.service.impl;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import project.soomgo.api.post.service.PostService;
import project.soomgo.entity.post.dto.PostDTO;
import project.soomgo.entity.post.enums.CommunityType;
import project.soomgo.entity.post.repository.PostRepository;
import project.soomgo.entity.post.request.PostCreateRequest;
import project.soomgo.entity.subject.Subject;
import project.soomgo.entity.subject.repository.SubjectRepository;
import project.soomgo.entity.user.Users;
import project.soomgo.entity.user.dto.UserCreateRequest;
import project.soomgo.entity.user.repository.UsersRepository;

@SpringBootTest
class PostServiceImplTest {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PostService postService;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Test
    @DisplayName("post 생성")
    public void 포스트생성() {

        // given
        PostCreateRequest postCreateRequest = PostCreateRequest.of("포스팅 제목", "포스팅 내용", 1L, 1L, CommunityType.ALL);
        createUserAndSubject();

        // when
        PostDTO post = postService.createPost(postCreateRequest);

        // then
        Assertions.assertEquals(post.getTitle(), postCreateRequest.getTitle());
        Assertions.assertEquals(post.getId(), 1L);
    }

    @Test
    @DisplayName("post 단건 조회")
    public void 포스트단건조회() {

        //given
        createPost();

        //when
        PostDTO post = postService.getPost(1L);

        //then
        Assertions.assertEquals(post.getTitle(), "포스팅 제목");


    }

//    -----------------------------------------

    public void createUserAndSubject() {
        UserCreateRequest userCreateRequest = UserCreateRequest.of("이메일", "비밀번호", "이름", false);
        usersRepository.save(Users.of(userCreateRequest, passwordEncoder));
        subjectRepository.save(Subject.of("서비스 이름", null));
    }

    public void createPost() {
        PostCreateRequest postCreateRequest = PostCreateRequest.of("포스팅 제목", "포스팅 내용", 1L, 1L, CommunityType.ALL);
        createUserAndSubject();
        PostDTO post = postService.createPost(postCreateRequest);
    }
}