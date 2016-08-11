package net.dontdrinkandroot.example.wicket.authrolesspringsecurityhibernate;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;


public class WebSession extends AuthenticatedWebSession
{

	private Roles roles;


	public WebSession(Request request)
	{
		super(request);
	}

	@Override
	protected boolean authenticate(String username, String password)
	{
		if ("user".equals(username) && "user".equals(password)) {
			this.roles = new Roles(Roles.USER);
			return true;
		}
		if ("admin".equals(username) && "admin".equals(password)) {
			this.roles = new Roles(new String[] { Roles.USER, Roles.ADMIN });
			return true;
		}

		return false;
	}

	@Override
	public Roles getRoles()
	{
		return this.roles;
	}

	@Override
	public void signOut()
	{
		super.signOut();
		this.roles = null;
	}
}
