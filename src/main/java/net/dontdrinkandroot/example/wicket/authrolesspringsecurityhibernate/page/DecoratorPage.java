package net.dontdrinkandroot.example.wicket.authrolesspringsecurityhibernate.page;

import org.apache.wicket.markup.html.GenericWebPage;

import net.dontdrinkandroot.example.wicket.authrolesspringsecurityhibernate.component.LogoutLink;
import net.dontdrinkandroot.example.wicket.authrolesspringsecurityhibernate.component.UserRolesLabel;


public class DecoratorPage<T> extends GenericWebPage<T>
{

	@Override
	protected void onInitialize()
	{
		super.onInitialize();
		this.add(new LogoutLink("logoutLink"));
		this.add(new UserRolesLabel("roles"));
	}

}
