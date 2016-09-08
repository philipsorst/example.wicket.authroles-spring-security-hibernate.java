package net.dontdrinkandroot.example.wassh.wicket;

import net.dontdrinkandroot.example.wassh.domain.model.User;
import org.apache.wicket.Session;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.request.Request;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class WebSession extends AuthenticatedWebSession
{
    @SpringBean(name = "authenticationManager")
    private AuthenticationManager authenticationManager;

    public WebSession(Request request)
    {
        super(request);
        Injector.get().inject(this);
    }

    @Override
    protected boolean authenticate(String username, String password)
    {
        boolean authenticated = false;
        try {
            Authentication authentication = this.authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            authenticated = authentication.isAuthenticated();
        } catch (AuthenticationException e) {
            authenticated = false;
        }

        return authenticated;
    }

    @Override
    public Roles getRoles()
    {
        Roles roles = new Roles();
        if (this.isSignedIn()) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (null == authentication) {
                this.invalidate();
                return roles;
            }
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority grantedAuthority : authorities) {
                roles.add(grantedAuthority.toString());
            }
        }

        return roles;
    }

    @Override
    public void signOut()
    {
        super.signOut();
        SecurityContextHolder.getContext().setAuthentication(null);
    }

    public User getUser()
    {
        if (this.isSignedIn()) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (null == authentication
                    || null == authentication.getPrincipal()
                    || !(authentication.getPrincipal() instanceof User)) {
                this.invalidate();
                return null;
            }

            return (User) authentication.getPrincipal();
        }

        return null;
    }

    public static WebSession get()
    {
        return (WebSession) Session.get();
    }
}
