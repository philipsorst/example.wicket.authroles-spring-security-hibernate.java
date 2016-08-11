package net.dontdrinkandroot.example.wicket.authrolesspringsecurityhibernate;

import org.apache.wicket.Page;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.authroles.authentication.pages.SignInPage;
import org.apache.wicket.markup.html.WebPage;

import net.dontdrinkandroot.example.wicket.authrolesspringsecurityhibernate.page.HomePage;


public class WebApplication extends AuthenticatedWebApplication
{

	@Override
	protected void init()
	{
		super.init();
	}

	@Override
	protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass()
	{
		return WebSession.class;
	}

	@Override
	protected Class<? extends WebPage> getSignInPageClass()
	{
		return SignInPage.class;
	}

	@Override
	public Class<? extends Page> getHomePage()
	{
		return HomePage.class;
	}

}
