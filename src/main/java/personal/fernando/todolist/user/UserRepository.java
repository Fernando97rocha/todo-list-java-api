package personal.fernando.todolist.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository< UserModel, Long >{
    
    UserModel findByUsername(String username); //METODO PERSONALIZADO
}
