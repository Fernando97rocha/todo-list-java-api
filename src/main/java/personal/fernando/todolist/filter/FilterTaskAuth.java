package personal.fernando.todolist.filter;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import personal.fernando.todolist.user.UserRepository;


@Component
public class FilterTaskAuth extends OncePerRequestFilter {

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        var servletPath = request.getServletPath();
        
        if (servletPath.equals("/tasks/")) {
            // PEGA A AUTORIZAÇÃO (USUARIO E SENHA)
            var authorization = request.getHeader("Authorization");
            var authEncoded = authorization.substring("Basic".length()).trim();
            
            byte[] authDecode = Base64.getDecoder().decode(authEncoded); // Base64 cria um array de bytes
            var authString = new String(authDecode);
    
            var credentials = authString.split(":") ;
            var username = credentials[0];
            var password = credentials[1];
    
            System.out.println("Autorização");
            System.out.println(username);
            System.out.println(password);
    
            //VALIDAR USUARIO
            var user = this.userRepository.findByUsername(username);
            if (user == null) {
                response.sendError(401);
            } else {
                //VALIDAR SENHA
                var passwordVerify = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
                if (passwordVerify.verified) {
                    request.setAttribute("userId", user.getId());
                    filterChain.doFilter(request, response);
                } else {
                    response.sendError(401);
                }
            }
        } else {
            filterChain.doFilter(request, response);
        }
        
    }

}
