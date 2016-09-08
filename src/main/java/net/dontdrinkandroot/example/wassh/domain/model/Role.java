package net.dontdrinkandroot.example.wassh.domain.model;

import java.util.HashSet;
import java.util.Set;


public enum Role
{
    USER(null),
    ADMIN(Role.USER);

    private Role childRole;

    private Role(Role childRole)
    {
        this.childRole = childRole;
    }

    public Set<Role> getRolesRecursively()
    {
        Set<Role> roles = new HashSet<Role>();
        roles.add(this);
        if (null != this.childRole) {
            roles.addAll(this.childRole.getRolesRecursively());
        }

        return roles;
    }
}
