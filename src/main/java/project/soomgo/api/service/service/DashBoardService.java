package project.soomgo.api.service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.soomgo.api.service.controller.response.DashBoardResponse;
import project.soomgo.entity.user.Users;

@Service
@RequiredArgsConstructor
public class DashBoardService {

    public DashBoardResponse getDashBoard(Users users) {
        return null;
    }
}
