package net.dontdrinkandroot.example.wassh.domain.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Entity
public class User implements UserDetails
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column
    private String password;

    @Column
    @Enumerated(EnumType.STRING)
    private Role role;

    protected User()
    {
        /* Reflection instantiation */
    }

    public User(String username, String password, Role role)
    {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername()
    {
        return this.username;
    }

    public String getPassword()
    {
        return this.password;
    }

    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        if (null == this.role) {
            return null;
        }

        Set<Role> roles = this.role.getRolesRecursively();
        Set<SimpleGrantedAuthority> authories = new HashSet<SimpleGrantedAuthority>();
        for (Role role : roles) {
            authories.add(new SimpleGrantedAuthority(role.name()));
        }

        return authories;
    }

    public boolean isAccountNonExpired()
    {
        return true;
    }

    public boolean isAccountNonLocked()
    {
        return true;
    }

    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    public boolean isEnabled()
    {
        return true;
    }
}
