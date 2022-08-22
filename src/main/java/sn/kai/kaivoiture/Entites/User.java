package sn.kai.kaivoiture.Entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Entity

public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String Nom;
    private String prenom;
    private String username;
    private String email;
    private String profil;
    private String image;
    private String adresse;
    private String password;
    private String telephone;
  private boolean enabled=true;
  @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER ,mappedBy = "user")
  @JsonIgnore
    private Set<UserRole> userRoles = new HashSet<>();

    public User() {
    }

    public User(int id, String nom, String prenom, String username, String email, String profil, String image, String adresse, String password, String telephone, boolean enabled, Set<UserRole> userRoles) {
        this.id = id;
        Nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.email = email;
        this.profil = profil;
        this.image = image;
        this.adresse = adresse;
        this.password = password;
        this.telephone = telephone;
        this.enabled = enabled;
        this.userRoles = userRoles;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return Nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public String getEmail() {
        return email;
    }

    public String getProfil() {
        return profil;
    }

    public String getImage() {
        return image;
    }

    public String getAdresse() {
        return adresse;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Authority> set=new HashSet<>();
        this.userRoles.forEach(userRole->{
            set.add(new Authority(userRole.getRole().getLibelerole()));
         });

        return set;
    }

    public String getPassword() {
        return password;
    }

    public String getTelephone() {
        return telephone;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}
