package project.soomgo.entity.post.enums;

public enum PostType {

    ENABLE("활성화"),
    DISABLE("비활성화");

    private final String desc;

    PostType(String desc){
        this.desc = desc;
    }
}
