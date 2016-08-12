package net.dontdrinkandroot.example.wassh.wicket.component;

import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.AbstractReadOnlyModel;

import net.dontdrinkandroot.example.wassh.wicket.WebSession;


public class UserRolesLabel extends Label
{

	public UserRolesLabel(String id)
	{
		super(id, new AbstractReadOnlyModel<String>() {

			@Override
			public String getObject()
			{
				Roles roles = WebSession.get().getRoles();
				return roles.toString();
			}
		});
	}
}
