package net.dontdrinkandroot.example.wassh.wicket.component;

import net.dontdrinkandroot.example.wassh.wicket.WebApplication;
import org.apache.wicket.authorization.Action;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeAction;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeActions;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
@AuthorizeActions(actions = {@AuthorizeAction(action = Action.RENDER, roles = {Roles.USER})})
public class LogoutLink extends Link<Void>
{
    public LogoutLink(String id)
    {
        super(id);
        this.setBody(Model.of("Log out"));
    }

    @Override
    public void onClick()
    {
        this.getSession().invalidate();
        this.setResponsePage(WebApplication.get().getHomePage());
    }
}
