package sn.kai.kaivoiture.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.kai.kaivoiture.Entites.User;
import sn.kai.kaivoiture.Entites.UserRole;
import sn.kai.kaivoiture.Exception.UsernameAlreadyExistException;
import sn.kai.kaivoiture.Repository.RoleRepository;
import sn.kai.kaivoiture.Repository.UserRepository;

import java.util.Set;
@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class UserServiceImplement implements UserService {
 private UserRepository userRepository;
 private RoleRepository roleRepository;
    @Override
    public User creeruser(User user, Set<UserRole> userRoles) throws UsernameAlreadyExistException {
       User local= this.userRepository.findByUsername(user.getUsername());
       if(local!=null){
                throw new UsernameAlreadyExistException("username already exist");
            }else {
               for (UserRole userRole : userRoles) {
                   roleRepository.save(userRole.getRole());
               }
                user.getUserRoles().addAll(userRoles);
                local= this.userRepository.save(user);
            }
        return local;
    }

    @Override
    public User getUser(String username) {

        return this.userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(int id) {
        this.userRepository.deleteById(id);
    }
}

