package project.soomgo.entity.subject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class Subject {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long parentId;

    public static Subject of(String name, Long parentId) {
        Subject instance = new Subject();

        instance.name = name;
        instance.parentId = parentId;

        return instance;
    }

}
