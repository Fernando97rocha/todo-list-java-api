package personal.fernando.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import personal.fernando.todolist.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/")
    public UserModel create(@RequestBody UserModel userModel) {
        return service.create(userModel);
    }


    @DeleteMapping("/{userId}")
    public HttpStatus delete(@PathVariable Long userId){
        service.delete(userId);
        return HttpStatus.ACCEPTED;
    }
}
