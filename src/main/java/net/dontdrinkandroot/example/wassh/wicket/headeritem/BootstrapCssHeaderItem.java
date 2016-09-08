package net.dontdrinkandroot.example.wassh.wicket.headeritem;

import org.apache.wicket.markup.head.CssUrlReferenceHeaderItem;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class BootstrapCssHeaderItem extends CssUrlReferenceHeaderItem
{
    public BootstrapCssHeaderItem()
    {
        super("https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css", null, null);
    }
}
