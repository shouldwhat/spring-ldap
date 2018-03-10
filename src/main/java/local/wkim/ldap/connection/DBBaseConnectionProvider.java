package local.wkim.ldap.connection;

import java.util.Map;

import org.springframework.stereotype.Component;

import local.wkim.ldap.connection.base.LdapConnectionProvider;
import local.wkim.ldap.connection.entity.LdapConnectionInfo;

@Component("dbBaseConnectionProvider")
public class DBBaseConnectionProvider extends LdapConnectionProvider {

	@Override
	protected LdapConnectionInfo connectionInfo(Map<String, Object> param) {
		// TODO Auto-generated method stub
		LdapConnectionInfo connectionInfo = new LdapConnectionInfo();
		return connectionInfo;
	}
}
