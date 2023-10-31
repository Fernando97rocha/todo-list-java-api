package personal.fernando.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserRepository repository;

    @PostMapping("/")
    public UserModel create(@RequestBody UserModel userModel) {

        var passwordHashed = BCrypt.withDefaults()
                .hashToString(12, userModel
                .getPassword().toCharArray());

        userModel.setPassword(passwordHashed);
        var userCreated = this.repository.save(userModel);
        return userCreated;
    }

}
