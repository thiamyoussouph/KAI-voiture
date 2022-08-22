package sn.kai.kaivoiture.service;

import org.springframework.stereotype.Service;
import sn.kai.kaivoiture.Entites.User;
import sn.kai.kaivoiture.Entites.UserRole;
import sn.kai.kaivoiture.Exception.UsernameAlreadyExistException;

import java.util.Set;
@Service
public interface UserService {
    public User creeruser(User user, Set<UserRole> userRoles) throws UsernameAlreadyExistException;


    User getUser(String username);

    void deleteUser(int id);
}
