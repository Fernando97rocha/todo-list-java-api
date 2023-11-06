
package personal.fernando.todolist.user.service;

import personal.fernando.todolist.user.UserModel;

public interface UserService {
    
    public UserModel create(UserModel userModel);
    public UserModel delete(Long userId);
}
