package net.dontdrinkandroot.example.wassh.wicket.component;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class SignInPanel extends org.apache.wicket.authroles.authentication.panel.SignInPanel
{
    public SignInPanel(String id)
    {
        super(id);
    }

    public SignInPanel(String id, boolean includeRememberMe)
    {
        super(id, includeRememberMe);
    }
}
