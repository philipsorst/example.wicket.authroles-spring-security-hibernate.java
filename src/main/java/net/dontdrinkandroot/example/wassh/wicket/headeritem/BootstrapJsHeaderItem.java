package net.dontdrinkandroot.example.wassh.wicket.headeritem;

import org.apache.wicket.Application;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.JavaScriptUrlReferenceHeaderItem;
import org.apache.wicket.request.resource.ResourceReference;
import org.apache.wicket.resource.JQueryResourceReference;

import java.util.List;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class BootstrapJsHeaderItem extends JavaScriptUrlReferenceHeaderItem
{
    public BootstrapJsHeaderItem()
    {
        super(
                "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js",
                "bootstrap.js",
                true,
                "UTF-8",
                null
        );
    }

    @Override
    public List<HeaderItem> getDependencies()
    {
        final ResourceReference backingLibraryReference;
        if (Application.exists()) {
            backingLibraryReference = Application.get()
                    .getJavaScriptLibrarySettings()
                    .getJQueryReference();
        } else {
            backingLibraryReference = JQueryResourceReference.get();
        }
        List<HeaderItem> dependencies = super.getDependencies();
        dependencies.add(JavaScriptHeaderItem.forReference(backingLibraryReference));

        return dependencies;
    }
}
