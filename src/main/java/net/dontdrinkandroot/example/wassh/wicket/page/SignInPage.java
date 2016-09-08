package net.dontdrinkandroot.example.wassh.wicket.page;

import net.dontdrinkandroot.example.wassh.wicket.component.SignInPanel;
import net.dontdrinkandroot.example.wassh.wicket.headeritem.BootstrapCssHeaderItem;
import net.dontdrinkandroot.example.wassh.wicket.headeritem.BootstrapJsHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class SignInPage extends WebPage
{
    public SignInPage()
    {
        this(null);
    }

    public SignInPage(final PageParameters parameters)
    {
        add(new SignInPanel("signInPanel"));
    }

    @Override
    public void renderHead(IHeaderResponse response)
    {
        super.renderHead(response);
        response.render(new BootstrapCssHeaderItem());
        response.render(new BootstrapJsHeaderItem());
    }
}
