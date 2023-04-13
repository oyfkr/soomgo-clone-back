package project.soomgo.entity.subject.request;

import lombok.Getter;

@Getter
public class SubjectCreateRequest {

    private String name;

    private Long parentSubjectId;

    public static SubjectCreateRequest of(String name, Long parentSubjectId) {
        SubjectCreateRequest instance = new SubjectCreateRequest();

        instance.name = name;
        instance.parentSubjectId = parentSubjectId;

        return instance;
    }
}
