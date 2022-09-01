package sn.kai.kaivoiture.Web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import sn.kai.kaivoiture.Entites.Role;
import sn.kai.kaivoiture.Entites.User;
import sn.kai.kaivoiture.Entites.UserRole;
import sn.kai.kaivoiture.Exception.UsernameAlreadyExistException;
import sn.kai.kaivoiture.service.UserServiceImplement;

import java.util.HashSet;
import java.util.Set;

@RestController

@CrossOrigin("*")
public class UserController {
@Autowired
private UserServiceImplement userServiceImplement;

    @PostMapping("/saveuser")
    public User saveUser(@RequestBody User user) throws UsernameAlreadyExistException {

        Set<UserRole> roles = new HashSet<>();
        Role role = new Role();
        role.setId(15);
        role.setLibelerole("ROLE_ADMIN");
        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        roles.add(userRole);

        return this.userServiceImplement.creeruser(user, roles);

    }
    @GetMapping("/{username}")
    public User getUsers(@PathVariable("username") String username) {
        return this.userServiceImplement.getUser(username);
    }
    @DeleteMapping("/deleteuser/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        this.userServiceImplement.deleteUser(id);
    }
}
