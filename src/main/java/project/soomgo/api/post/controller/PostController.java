package project.soomgo.api.post.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.soomgo.entity.post.dto.PostDTO;
import project.soomgo.api.post.service.PostService;
import project.soomgo.entity.post.enums.PostType;
import project.soomgo.entity.post.request.PostCreateRequest;
import project.soomgo.support.PageResponse;

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

    @GetMapping()
    @ApiOperation(value = "포스트 페이징 조회")
    public ResponseEntity<PageResponse<List<PostDTO>>> getPosts(
            @ApiParam(value = "포스트 타입", required = true, example = "ENABLE") @RequestParam PostType postType,
            @ApiParam(value = "원하는 페이징당 개수", example = "5")@RequestParam(required = false, defaultValue = "5") int size,
            @ApiParam(value = "원하는 페이지 수", example = "1")@RequestParam(required = false, defaultValue = "1") int page
    ) {

        PageResponse<List<PostDTO>> pageResponse = postService.getPosts(PageRequest.of(page-1, size), postType);
        return ResponseEntity.ok(pageResponse);
    }
}
