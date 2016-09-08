package net.dontdrinkandroot.example.wassh.wicket;

import net.dontdrinkandroot.example.wassh.wicket.page.AdminPage;
import net.dontdrinkandroot.example.wassh.wicket.page.HomePage;
import net.dontdrinkandroot.example.wassh.wicket.page.SignInPage;
import net.dontdrinkandroot.example.wassh.wicket.page.UserPage;
import org.apache.wicket.Page;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class WebApplication extends AuthenticatedWebApplication implements ApplicationContextAware
{
    private ApplicationContext applicationContext;

    @Override
    protected void init()
    {
        super.init();
        this.getComponentInstantiationListeners().add(new SpringComponentInjector(this, this.applicationContext, true));
        this.mountPages();
    }

    private void mountPages()
    {
        this.mountPage("login", SignInPage.class);
        this.mountPage("user", UserPage.class);
        this.mountPage("admin", AdminPage.class);
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

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
    {
        this.applicationContext = applicationContext;
    }
}
