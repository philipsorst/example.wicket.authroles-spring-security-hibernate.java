package net.dontdrinkandroot.example.wassh.page;

import org.apache.wicket.util.tester.TagTester;
import org.junit.Assert;
import org.junit.Test;

import net.dontdrinkandroot.example.wassh.AbstractWicketTest;
import net.dontdrinkandroot.example.wassh.wicket.page.HomePage;


public class HomePageTest extends AbstractWicketTest
{

	@Test
	public void testPageAccessibleByDefault()
	{
		this.tester.startPage(HomePage.class);
		this.tester.assertRenderedPage(HomePage.class);

		TagTester logoutLinkTester =
				TagTester.createTagByAttribute(this.tester.getLastResponseAsString(), "wicket:id", "logoutLink");
		Assert.assertTrue(logoutLinkTester.getAttributeIs("disabled", "disabled"));
	}

	public void testLogoutLinkEnabledForUser()
	{
		this.getSession().signIn("user", "user");
		this.tester.startPage(HomePage.class);

		TagTester logoutLinkTester =
				TagTester.createTagByAttribute(this.tester.getLastResponseAsString(), "wicket:id", "logoutLink");
		Assert.assertFalse(logoutLinkTester.hasAttribute("disabled"));
	}
}
