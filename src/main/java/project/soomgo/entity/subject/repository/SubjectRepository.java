package project.soomgo.entity.subject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.soomgo.entity.subject.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long>, SubjectRepositoryCustom {

}
