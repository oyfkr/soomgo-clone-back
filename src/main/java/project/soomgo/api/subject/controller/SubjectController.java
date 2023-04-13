package project.soomgo.api.subject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.soomgo.api.subject.SubjectService;
import project.soomgo.entity.subject.dto.SubjectDTO;
import project.soomgo.entity.subject.request.SubjectCreateRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    @PostMapping()
    public ResponseEntity<SubjectDTO> createPost(
            @RequestBody SubjectCreateRequest request
    ) {

        SubjectDTO subjectDTO = subjectService.createSubject(request);

        return ResponseEntity.ok(subjectDTO);
    }
}
