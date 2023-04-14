package project.soomgo.api.subject;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import project.soomgo.entity.subject.Subject;
import project.soomgo.entity.subject.dto.SubjectDTO;
import project.soomgo.entity.subject.repository.SubjectRepository;
import project.soomgo.entity.subject.request.SubjectCreateRequest;

@SpringBootTest
class SubjectServiceTest {
    
    @Autowired
    private SubjectService subjectService;

    @Autowired
    private SubjectRepository subjectRepository;
    
    @Test
    public void 생성테스트() {
        SubjectCreateRequest request1 = SubjectCreateRequest.of("서브젝트테스트", null);

        SubjectDTO subjectDTO1 = subjectService.createSubject(request1);

        Subject subject1 = subjectRepository.findById(1L).orElseThrow(RuntimeException::new);

        Assertions.assertEquals(subject1.getId(), subjectDTO1.getId());
        Assertions.assertNull(subject1.getParentSubject());

        /////////////////////////////////////////////////////////
        SubjectDTO firstSubject = createFirstSubject();
        SubjectCreateRequest request2 = SubjectCreateRequest.of("부모가있는테스트", firstSubject.getId());

        SubjectDTO subjectDTO2 = subjectService.createSubject(request2);
        Subject subject2 = subjectRepository.findById(subjectDTO2.getId())
                .orElseThrow(RuntimeException::new);

        Assertions.assertEquals(subjectDTO2.getId(), subject2.getId());
        Assertions.assertNotNull(subject2.getParentSubject());

    }

    public SubjectDTO createFirstSubject(){
        SubjectCreateRequest request = SubjectCreateRequest.of("최상위", null);
        return subjectService.createSubject(request);
    }
}