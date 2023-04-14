package project.soomgo.entity.subject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Getter;

@Getter
@Entity
public class Subject {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Subject parentSubject;

    public static Subject of(String name, Subject parentSubject) {
        Subject instance = new Subject();

        instance.name = name;
        instance.parentSubject = parentSubject;

        return instance;
    }

}
