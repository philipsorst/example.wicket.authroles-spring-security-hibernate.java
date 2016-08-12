package net.dontdrinkandroot.example.wassh.domain.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import net.dontdrinkandroot.example.wassh.domain.model.Role;
import net.dontdrinkandroot.example.wassh.domain.model.User;


public interface UserService extends UserDetailsService
{

	User findUserByUsername(String username);

	User create(String username, String password, Role role);

}
