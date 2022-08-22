package sn.kai.kaivoiture.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.kai.kaivoiture.Entites.User;

public interface UserRepository extends JpaRepository<User, Integer> {


    public User findByUsername(String username);
}
