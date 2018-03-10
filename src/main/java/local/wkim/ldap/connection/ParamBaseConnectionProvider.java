package local.wkim.ldap.connection;

import java.util.Map;

import org.springframework.stereotype.Component;

import local.wkim.ldap.connection.base.LdapConnectionProvider;
import local.wkim.ldap.connection.entity.LdapConnectionInfo;

@Component("paramBaseConnectionProvider")
public class ParamBaseConnectionProvider  extends LdapConnectionProvider {

	@Override
	protected LdapConnectionInfo connectionInfo(Map<String, Object> param) {

		LdapConnectionInfo connectionInfo = new LdapConnectionInfo();
		
		connectionInfo.setUrl((String) param.get("url"));
		connectionInfo.setBase((String) param.get("base"));
		connectionInfo.setUserDn((String) param.get("userDn"));
		connectionInfo.setPassword((String) param.get("password"));
		
		return connectionInfo;
	}

}
