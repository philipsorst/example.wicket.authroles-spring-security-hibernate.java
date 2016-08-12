package net.dontdrinkandroot.example.wassh.wicket.component;

import org.apache.wicket.authorization.Action;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeAction;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeActions;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;

import net.dontdrinkandroot.example.wassh.wicket.WebApplication;


@AuthorizeActions(actions = { @AuthorizeAction(action = Action.ENABLE, roles = { Roles.USER }) })
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
