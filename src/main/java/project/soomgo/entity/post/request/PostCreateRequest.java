package project.soomgo.entity.post.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import project.soomgo.entity.post.enums.CommunityType;

@Getter
public class PostCreateRequest {

    @ApiModelProperty(value = "포스트 제목", example = "포스트 제목!")
    private String title;
    @ApiModelProperty(value = "포스트 내용", example = "포스트 내용")
    private String content;
    @ApiModelProperty(value = "포스트를 생성한 유저 id", example = "1")
    private Long userId;
    @ApiModelProperty(value = "포스트의 서비스 id", example = "1")
    private Long serviceId;
    @ApiModelProperty(value = "포스트이 커뮤니티 type", example = "QUESTION")
    private CommunityType communityType;
}
