package net.dontdrinkandroot.example.wicket.authrolesspringsecurityhibernate.page;

import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.Model;


public class HomePage extends DecoratorPage<Void>
{

	@Override
	protected void onInitialize()
	{
		super.onInitialize();
		this.add(new BookmarkablePageLink<Void>("userPageLink", UserPage.class).setBody(Model.of("UserPage")));
		this.add(new BookmarkablePageLink<Void>("adminPageLink", AdminPage.class).setBody(Model.of("AdminPage")));
	}
}
