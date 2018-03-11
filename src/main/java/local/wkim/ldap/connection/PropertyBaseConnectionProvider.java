package local.wkim.ldap.connection;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import local.wkim.ldap.connection.base.LdapConnectionProvider;
import local.wkim.ldap.connection.entity.LdapConnectionInfo;

@Scope("prototype")
@Component("propertyBase")
public class PropertyBaseConnectionProvider  extends LdapConnectionProvider {

	@Autowired
	private Properties connectionProp;

	@Override
	protected LdapConnectionInfo connectionInfo() {

		LdapConnectionInfo connectionInfo = new LdapConnectionInfo();
		
		connectionInfo.setUrl(connectionProp.getProperty("url"));
		connectionInfo.setBase(connectionProp.getProperty("base"));
		connectionInfo.setUserDn(connectionProp.getProperty("userDn"));
		connectionInfo.setPassword(connectionProp.getProperty("password"));
		
		return connectionInfo;
	}
}
