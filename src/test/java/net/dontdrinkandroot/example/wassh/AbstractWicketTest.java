package net.dontdrinkandroot.example.wassh;

import net.dontdrinkandroot.example.wassh.wicket.WebApplication;
import net.dontdrinkandroot.example.wassh.wicket.WebSession;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/context.xml" })
public abstract class AbstractWicketTest
{

    @Autowired
    protected WebApplication wicketApplication;

    protected WicketTester tester;

    @Before
    public void beforeMethod()
    {
        this.tester = new WicketTester(this.wicketApplication);
    }

    protected WebSession getSession()
    {
        return (WebSession) this.tester.getSession();
    }
}
