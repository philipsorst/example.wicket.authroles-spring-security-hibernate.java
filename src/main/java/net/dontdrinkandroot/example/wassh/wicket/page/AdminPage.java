package net.dontdrinkandroot.example.wassh.wicket.page;

import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;


@AuthorizeInstantiation(value = Roles.ADMIN)
public class AdminPage extends DecoratorPage<Void>
{

}
