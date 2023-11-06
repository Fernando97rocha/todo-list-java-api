package personal.fernando.todolist.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import personal.fernando.todolist.user.UserRepository;
import personal.fernando.todolist.user.service.AuthService;

public class AuthServiceImpl implements AuthService{

    @Autowired
    UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username);
    }

}
