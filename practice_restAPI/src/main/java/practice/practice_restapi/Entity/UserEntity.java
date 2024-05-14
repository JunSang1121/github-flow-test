package practice.practice_restapi.Entity;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "user")
@NoArgsConstructor
@Getter
public class UserEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "User_Name")
    private String userName;

    @Builder
    public UserEntity(Long userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
}
