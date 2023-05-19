package project.soomgo.api.service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.soomgo.api.auth.CustomDetails;
import project.soomgo.api.service.controller.response.DashBoardResponse;
import project.soomgo.api.service.service.DashBoardService;

@RestController
@RequestMapping("/service/dash-board")
@RequiredArgsConstructor
public class DashBoardServiceController {

    private final DashBoardService dashBoardService;
    public ResponseEntity<DashBoardResponse> getDashBoard(
            @AuthenticationPrincipal CustomDetails customDetails
    ) {
        return ResponseEntity.ok(dashBoardService.getDashBoard(customDetails.getUsers()));
    }
}
