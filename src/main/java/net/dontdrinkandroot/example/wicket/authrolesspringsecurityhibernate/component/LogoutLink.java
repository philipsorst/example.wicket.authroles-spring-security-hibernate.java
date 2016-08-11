package net.dontdrinkandroot.example.wicket.authrolesspringsecurityhibernate.component;

import org.apache.wicket.authorization.Action;
import org.apache.wicket.authroles.authentication.pages.SignOutPage;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeAction;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeActions;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.Model;


@AuthorizeActions(actions = { @AuthorizeAction(action = Action.ENABLE, roles = { Roles.USER }) })
public class LogoutLink extends BookmarkablePageLink<Void>
{

	public LogoutLink(String id)
	{
		super(id, SignOutPage.class);
		this.setBody(Model.of("Log out"));
	}
}
