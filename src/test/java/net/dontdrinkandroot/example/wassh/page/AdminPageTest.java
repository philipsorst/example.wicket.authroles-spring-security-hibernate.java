package net.dontdrinkandroot.example.wassh.page;

import net.dontdrinkandroot.example.wassh.AbstractWicketTest;
import net.dontdrinkandroot.example.wassh.wicket.page.AdminPage;
import net.dontdrinkandroot.example.wassh.wicket.page.SignInPage;
import org.apache.wicket.authorization.UnauthorizedInstantiationException;
import org.junit.Test;


public class AdminPageTest extends AbstractWicketTest
{

    @Test
    public void testPageInaccessibleByDefault()
    {
        this.tester.startPage(AdminPage.class);
        this.tester.assertRenderedPage(SignInPage.class);
    }

    @Test(expected = UnauthorizedInstantiationException.class)
    public void testPageInaccessibleByUser()
    {
        this.getSession().signIn("user", "user");
        this.tester.startPage(AdminPage.class);
    }

    @Test
    public void testPageAccessibleByAdmin()
    {
        this.getSession().signIn("admin", "admin");
        this.tester.startPage(AdminPage.class);
        this.tester.assertRenderedPage(AdminPage.class);
    }
}
