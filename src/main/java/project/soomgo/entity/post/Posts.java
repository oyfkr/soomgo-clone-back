package project.soomgo.entity.post;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.Getter;
import project.soomgo.entity.post.enums.CommunityType;
import project.soomgo.entity.post.enums.PostType;
import project.soomgo.entity.post.request.PostCreateRequest;
import project.soomgo.entity.subject.Subject;
import project.soomgo.entity.user.Users;

@Entity
@Getter
public class Posts {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private Users users;


    @Enumerated(EnumType.STRING)
    private CommunityType communityType;

    @ManyToOne(fetch = FetchType.LAZY)
    private Subject subject;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    @Enumerated(EnumType.STRING)
    private PostType postType;

    public static Posts of(PostCreateRequest request) {
        Posts instance = new Posts();

        instance.title = request.getTitle();
        instance.content = request.getContent();
        instance.communityType = request.getCommunityType();
        instance.postType = PostType.ENABLE;

        return instance;
    }

    public void changeUserAndSubjectFotCreate(Subject subject, Users users) {

        this.subject = subject;
        this.users = users;
    }
}
