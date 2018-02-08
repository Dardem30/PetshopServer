package com.petshop.petshop.model.security.model;

import com.petshop.petshop.model.Pet;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.List;

/**
 * Entity that describes the user.
 */
@Entity
@Data
@Table(name = "users")
@SuppressWarnings("PMD.ShortClassName")
public class User implements UserDetails {

    private static final long serialVersionUID = -4031829348949429069L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private List<Authority> authorities;

    @OneToMany
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private List<Pet> pets;

    @Column(name = "account_non_expired")
    private boolean accountNonExpired;

    @Column(name = "account_non_locked")
    private boolean accountNonLocked;

    @Column(name = "credentials_non_expired")
    private boolean credentialsNonExpired;

    @Column(name = "enabled")
    private boolean enabled;
}
