package net.dontdrinkandroot.example.wassh.wicket.page;

import org.apache.wicket.markup.html.GenericWebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.Model;

import net.dontdrinkandroot.example.wassh.wicket.component.LogoutLink;
import net.dontdrinkandroot.example.wassh.wicket.component.UserRolesLabel;


public class DecoratorPage<T> extends GenericWebPage<T>
{

	@Override
	protected void onInitialize()
	{
		super.onInitialize();
		this.add(new BookmarkablePageLink<Void>("homePageLink", HomePage.class).setBody(Model.of("HomePage")));
		this.add(new BookmarkablePageLink<Void>("userPageLink", UserPage.class).setBody(Model.of("UserPage")));
		this.add(new BookmarkablePageLink<Void>("adminPageLink", AdminPage.class).setBody(Model.of("AdminPage")));
		this.add(new LogoutLink("logoutLink"));
		this.add(new UserRolesLabel("roles"));
	}

}
