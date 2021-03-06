package net.dontdrinkandroot.example.wassh.page;

import net.dontdrinkandroot.example.wassh.AbstractWicketTest;
import net.dontdrinkandroot.example.wassh.wicket.page.HomePage;
import org.apache.wicket.util.tester.TagTester;
import org.junit.Assert;
import org.junit.Test;


public class HomePageTest extends AbstractWicketTest
{

    @Test
    public void testPageAccessibleByDefault()
    {
        this.tester.startPage(HomePage.class);
        this.tester.assertRenderedPage(HomePage.class);

        TagTester logoutLinkTester =
                TagTester.createTagByAttribute(this.tester.getLastResponseAsString(), "wicket:id", "logoutLink");
        Assert.assertNull(logoutLinkTester);
    }

    @Test
    public void testLogoutLink()
    {
        this.getSession().signIn("user", "user");
        Assert.assertTrue(this.getSession().isSignedIn());
        this.tester.startPage(HomePage.class);

        TagTester logoutLinkTester =
                TagTester.createTagByAttribute(this.tester.getLastResponseAsString(), "wicket:id", "logoutLink");
        Assert.assertNotNull(logoutLinkTester);

        this.tester.clickLink("logoutLink");

        Assert.assertFalse(this.getSession().isSignedIn());
    }

    @Test
    public void testInvalidLogin()
    {
        Assert.assertFalse(this.getSession().isSignedIn());
        this.getSession().signIn("wronguser", "wrongpassword");
        Assert.assertFalse(this.getSession().isSignedIn());
    }
}
