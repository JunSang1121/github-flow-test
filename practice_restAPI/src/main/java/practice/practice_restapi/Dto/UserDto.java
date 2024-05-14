package practice.practice_restapi.Dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import practice.practice_restapi.Entity.UserEntity;


@Getter
@NoArgsConstructor
public class UserDto {
    private String userName;


    public UserEntity toEntity(){
        UserEntity user = UserEntity.builder()
                .userName(userName)
                .build();
        return user;
    }

    @Builder
    public UserDto(Long userId, String userName){
        this.userName = userName;
    }
}
