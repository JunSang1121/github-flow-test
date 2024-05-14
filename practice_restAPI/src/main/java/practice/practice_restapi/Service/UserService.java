package practice.practice_restapi.Service;


import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practice.practice_restapi.Dto.UserDto;
import practice.practice_restapi.Entity.UserEntity;
import practice.practice_restapi.Repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Transactional
    public  Long save(UserDto dto){

        return userRepository.save(dto.toEntity()).getUserId();
    } //C

    public List<UserDto> getList(){
        List<UserEntity> userEntityList = userRepository.findAll();
        List<UserDto> dtoList = new ArrayList<>();

        for(UserEntity user: userEntityList){
            UserDto userDto = UserDto.builder()
                    .userId(user.getUserId() )
                    .userName(user.getUserName())
                    .build();
            dtoList.add(userDto);
        }
        return  dtoList;
    } // R


    public UserDto findId(Long id){
        Optional<UserEntity> userId = userRepository.findById(id);  //R
            UserEntity user = userId.get();

            UserDto userDto = UserDto.builder()
                    .userName(user.getUserName())
                    .build();

            return userDto;

    }

    public void del_user(Long id){
        userRepository.deleteById(id);  //D
    }

}
