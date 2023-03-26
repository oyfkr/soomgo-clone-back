package project.soomgo.entity.post.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import project.soomgo.entity.post.Posts;

@Getter
public class PostDTO {

    @ApiModelProperty(value = "포스트 id", example = "1")
    private Long id;

    @ApiModelProperty(value = "포스트 제목", example = "인테리어 장인!")
    private String title;

    @ApiModelProperty(value = "포스트 내용", example = "인테리어 장인입니다!")
    private String content;

    public static PostDTO of(Posts posts) {
        PostDTO instance = new PostDTO();

        instance.id = posts.getId();
        instance.title = posts.getTitle();
        instance.content = posts.getContent();

        return instance;
    }
}
