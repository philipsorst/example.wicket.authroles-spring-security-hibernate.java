package net.dontdrinkandroot.example.wassh.page;

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
	}
}
