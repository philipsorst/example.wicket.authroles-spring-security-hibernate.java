package net.dontdrinkandroot.example.wassh.wicket;

import java.util.Collection;

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
}
