package practice.practice_restapi.test;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.annotation.Rollback;
import practice.practice_restapi.Dto.UserDto;
import practice.practice_restapi.Entity.UserEntity;
import practice.practice_restapi.Repository.UserRepository;
import practice.practice_restapi.Service.UserService;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class test {


    private UserService userService;
    private UserRepository userRepository;



    @Test
    @Rollback(value = false)
    public void save(){

        Long id = 1L;
        String name = "test1";

        UserDto userDto = UserDto.builder()
                .userId(id)
                .userName(name)
                .build();




        /*List<UserEntity> all_list = userRepository.findAll();
        assertThat(all_list.get(0).getUserId()).isEqualTo(id);
        assertThat(all_list.get(0).getUserName()).isEqualTo(name);*/


    }
}
