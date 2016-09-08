package net.dontdrinkandroot.example.wassh.wicket.page;

import net.dontdrinkandroot.example.wassh.wicket.component.LogoutLink;
import net.dontdrinkandroot.example.wassh.wicket.component.UserNameLabel;
import net.dontdrinkandroot.example.wassh.wicket.component.UserRolesLabel;
import net.dontdrinkandroot.example.wassh.wicket.headeritem.BootstrapCssHeaderItem;
import net.dontdrinkandroot.example.wassh.wicket.headeritem.BootstrapJsHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.GenericWebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public abstract class DecoratorPage<T> extends GenericWebPage<T>
{
    @Override
    protected void onInitialize()
    {
        super.onInitialize();
        this.add(new Label("title", this.getTitleModel()));
        this.add(new Label("heading", this.getTitleModel()));
        this.add(new BookmarkablePageLink<Void>("homePageLink", HomePage.class).setBody(Model.of("HomePage")));
        this.add(new BookmarkablePageLink<Void>("userPageLink", UserPage.class).setBody(Model.of("UserPage")));
        this.add(new BookmarkablePageLink<Void>("adminPageLink", AdminPage.class).setBody(Model.of("AdminPage")));
        this.add(new LogoutLink("logoutLink"));
        this.add(new UserNameLabel("userName"));
        this.add(new UserRolesLabel("roles"));
    }

    @Override
    public void renderHead(IHeaderResponse response)
    {
        super.renderHead(response);
        response.render(new BootstrapCssHeaderItem());
        response.render(new BootstrapJsHeaderItem());
    }

    protected abstract IModel<String> getTitleModel();
}
