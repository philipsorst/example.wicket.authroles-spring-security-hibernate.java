package net.dontdrinkandroot.example.wassh.wicket.component;

import net.dontdrinkandroot.example.wassh.wicket.WebSession;
import org.apache.wicket.authorization.Action;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeAction;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeActions;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.AbstractReadOnlyModel;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
@AuthorizeActions(actions = {@AuthorizeAction(action = Action.RENDER, roles = {Roles.USER})})
public class UserNameLabel extends Label
{
    public UserNameLabel(String id)
    {
        super(id, new AbstractReadOnlyModel<String>()
        {
            @Override
            public String getObject()
            {
                return WebSession.get().getUser().getUsername();
            }
        });
    }
}
