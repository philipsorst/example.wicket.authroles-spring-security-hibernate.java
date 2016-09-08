package net.dontdrinkandroot.example.wassh.domain.service;

import net.dontdrinkandroot.example.wassh.domain.model.Role;
import net.dontdrinkandroot.example.wassh.domain.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public interface UserService extends UserDetailsService
{
    User findUserByUsername(String username);

    User create(String username, String password, Role role);
}
