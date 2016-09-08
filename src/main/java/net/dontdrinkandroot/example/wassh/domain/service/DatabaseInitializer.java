package net.dontdrinkandroot.example.wassh.domain.service;

import net.dontdrinkandroot.example.wassh.domain.model.Role;
import net.dontdrinkandroot.example.wassh.domain.model.User;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.transaction.annotation.Transactional;


public class DatabaseInitializer implements ApplicationListener<ContextRefreshedEvent>
{

    private UserService userService;

    public DatabaseInitializer(UserService userService)
    {
        this.userService = userService;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event)
    {
        User user;

        user = this.userService.findUserByUsername("user");
        if (null == user) {
            this.userService.create("user", "user", Role.USER);
        }

        user = this.userService.findUserByUsername("admin");
        if (null == user) {
            this.userService.create("admin", "admin", Role.ADMIN);
        }
    }
}
