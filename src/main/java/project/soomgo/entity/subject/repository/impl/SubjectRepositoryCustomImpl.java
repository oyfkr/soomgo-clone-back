package project.soomgo.entity.subject.repository.impl;


import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import project.soomgo.entity.subject.repository.SubjectRepositoryCustom;
import project.soomgo.entity.user.Users;

public class SubjectRepositoryCustomImpl extends QuerydslRepositorySupport implements
        SubjectRepositoryCustom {

    public SubjectRepositoryCustomImpl() {
        super(Users.class);
    }

}
