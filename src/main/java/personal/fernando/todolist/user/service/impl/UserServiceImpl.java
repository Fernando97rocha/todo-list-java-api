package personal.fernando.todolist.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import personal.fernando.todolist.user.UserModel;
import personal.fernando.todolist.user.UserRepository;
import personal.fernando.todolist.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repository;
    
    @Override
    public UserModel create(UserModel userModel) {
        var passwordHashed = BCrypt.withDefaults()
                .hashToString(12, userModel
                .getPassword().toCharArray());

        userModel.setPassword(passwordHashed);
        var userCreated = this.repository.save(userModel);
        return userCreated;
    }

    @Override
    public UserModel delete(Long userId) {
        repository.deleteById(userId);
        return null;
    }
}
