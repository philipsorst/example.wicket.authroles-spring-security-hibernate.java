package net.dontdrinkandroot.example.wassh.wicket.page;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class HomePage extends DecoratorPage<Void>
{
    @Override
    protected IModel<String> getTitleModel()
    {
        return Model.of("HomePage");
    }
}
