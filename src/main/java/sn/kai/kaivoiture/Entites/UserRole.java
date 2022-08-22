package sn.kai.kaivoiture.Entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
public class UserRole {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
   @ManyToOne(fetch = FetchType.EAGER)
   private User user;
    @ManyToOne()
    private Role role;

    public UserRole(int id, User user, Role role) {
        this.id = id;
        this.user = user;
        this.role = role;
    }

    public UserRole() {
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }
}
