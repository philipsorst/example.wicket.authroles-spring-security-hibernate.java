package net.dontdrinkandroot.example.wicket.authrolesspringsecurityhibernate;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;


public class WebSession extends AuthenticatedWebSession
{

	public WebSession(Request request)
	{
		super(request);
	}

	@Override
	protected boolean authenticate(String username, String password)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Roles getRoles()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
