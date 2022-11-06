package project.soomgo.chat;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Getter;
import project.soomgo.user.Users;

@Entity
@Getter
public class ChatRooms {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private Users sender;

    @OneToOne(fetch = FetchType.LAZY)
    private Users receiver;

    @OneToMany(mappedBy = "chatRoom", fetch = FetchType.LAZY)
    private Set<ChatMessages> chatMessages;
}
