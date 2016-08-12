package net.dontdrinkandroot.example.wassh.page;

import org.apache.wicket.authroles.authentication.pages.SignInPage;
import org.junit.Test;

import net.dontdrinkandroot.example.wassh.AbstractWicketTest;
import net.dontdrinkandroot.example.wassh.wicket.page.UserPage;


public class UserPageTest extends AbstractWicketTest
{

	@Test
	public void testPageInaccessibleByDefault()
	{
		this.tester.startPage(UserPage.class);
		this.tester.assertRenderedPage(SignInPage.class);
	}

	@Test
	public void testPageAccessibleByUser()
	{
		this.getSession().signIn("user", "user");
		this.tester.startPage(UserPage.class);
		this.tester.assertRenderedPage(UserPage.class);
	}

	@Test
	public void testPageAccessibleByAdmin()
	{
		this.getSession().signIn("admin", "admin");
		this.tester.startPage(UserPage.class);
		this.tester.assertRenderedPage(UserPage.class);
	}
}
