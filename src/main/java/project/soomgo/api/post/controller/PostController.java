package project.soomgo.api.post.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.soomgo.entity.post.dto.PostDTO;
import project.soomgo.api.post.service.PostService;
import project.soomgo.entity.post.request.PostCreateRequest;

@RestController
@RequestMapping("/v1/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("{postId}")
    @ApiOperation(value = "포스트 단건 조회")
    public ResponseEntity<PostDTO> getPost(
            @ApiParam(value = "조회할 포스트 id", required = true, example = "1") @PathVariable Long postId
    ) {
        return ResponseEntity.ok(postService.getPost(postId));
    }

    @PostMapping
    @ApiOperation(value = "포스트 생성")
    public ResponseEntity<PostDTO> createPost(
            @ApiParam(value = "포스트 생성 데이터") @RequestBody PostCreateRequest request
    ) {
        return ResponseEntity.ok(postService.createPost(request));
    }
}
