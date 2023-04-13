package project.soomgo.api.subject;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.soomgo.entity.subject.Subject;
import project.soomgo.entity.subject.dto.SubjectDTO;
import project.soomgo.entity.subject.repository.SubjectRepository;
import project.soomgo.entity.subject.request.SubjectCreateRequest;
import project.soomgo.exception.BaseException;
import project.soomgo.exception.ErrorCode;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectDTO createSubject(SubjectCreateRequest request) {

        Long parentSubjectId = request.getParentSubjectId();
        // 부모 subject가 존재할 경우 조회한 뒤 넣어줘야함
        if(parentSubjectId != null) {
            Subject parentSubject = subjectRepository.findById(request.getParentSubjectId())
                    .orElseThrow(() -> BaseException.of(
                            ErrorCode.SUBJECT_NOT_FOUND));

            return SubjectDTO.of(subjectRepository.save(Subject.of(request.getName(), parentSubject)));
        } else {
            return SubjectDTO.of(subjectRepository.save(Subject.of(request.getName(), null)));
        }

    }
}
