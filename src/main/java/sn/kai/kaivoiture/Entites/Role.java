package sn.kai.kaivoiture.Entites;



import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity


public class Role {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String libelerole;
    private String description;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY ,mappedBy = "role")
    private Set<UserRole>userRoles=new HashSet<>();

    public Role() {
    }

    public Role(int id, String libelerole, String description, Set<UserRole> userRoles) {
        this.id = id;
        this.libelerole = libelerole;
        this.description = description;
        this.userRoles = userRoles;
    }

    public int getId() {
        return id;
    }

    public String getLibelerole() {
        return libelerole;
    }

    public String getDescription() {
        return description;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLibelerole(String libelerole) {
        this.libelerole = libelerole;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}
