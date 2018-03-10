package local.wkim.ldap.connection;

import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import local.wkim.ldap.connection.base.LdapConnectionProvider;
import local.wkim.ldap.connection.entity.LdapConnectionInfo;

@Component("propertyBaseConnectionProvider")
public class PropertyBaseConnectionProvider  extends LdapConnectionProvider {

	@Autowired
	private Properties connectionProp;

	@Override
	protected LdapConnectionInfo connectionInfo(Map<String, Object> param) {

		LdapConnectionInfo connectionInfo = new LdapConnectionInfo();
		
		connectionInfo.setUrl(connectionProp.getProperty("url"));
		connectionInfo.setBase(connectionProp.getProperty("base"));
		connectionInfo.setUserDn(connectionProp.getProperty("userDn"));
		connectionInfo.setPassword(connectionProp.getProperty("password"));
		
		return connectionInfo;
	}
	
}
