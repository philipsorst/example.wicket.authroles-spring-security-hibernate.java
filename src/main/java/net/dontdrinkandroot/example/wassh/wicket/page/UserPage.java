package net.dontdrinkandroot.example.wassh.wicket.page;

import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
@AuthorizeInstantiation(value = Roles.USER)
public class UserPage extends DecoratorPage<Void>
{
    @Override
    protected IModel<String> getTitleModel()
    {
        return Model.of("UserPage");
    }
}
