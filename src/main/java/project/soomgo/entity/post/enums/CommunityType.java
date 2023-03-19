package project.soomgo.entity.post.enums;

import org.springframework.http.HttpStatus;

public enum CommunityType {

    ALL("전체"),
    QUESTION("궁금해요"),
    HOW_MUCH("얼마에요");

    private String desc;

    CommunityType(String desc){
        this.desc = desc;
    }
}
