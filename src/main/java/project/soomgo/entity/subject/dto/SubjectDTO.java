package project.soomgo.entity.subject.dto;

import lombok.Getter;
import project.soomgo.entity.subject.Subject;

@Getter
public class SubjectDTO {

    private Long id;
    private String name;

    public static SubjectDTO of(Subject subject) {
        SubjectDTO instance = new SubjectDTO();

        instance.id = subject.getId();
        instance.name = subject.getName();

        return instance;
    }
}
