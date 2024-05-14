package practice.practice_restapi.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import practice.practice_restapi.Dto.UserDto;
import practice.practice_restapi.Entity.UserEntity;
import practice.practice_restapi.Service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/crud")
public class MainController {

    private final UserService userService;


    @GetMapping("/findAll")
    public List<UserDto> list_main(){
        return userService.getList();
    }

    @PostMapping("/save")
    public Long save(@RequestBody UserDto dto){
       return userService.save(dto);
    }

    @GetMapping("/find/{id}")
    public UserDto findId(@PathVariable Long id){
        return userService.findId(id);

    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        userService.del_user(id);
    }
}
