package local.wkim.ldap.connection;

import org.springframework.stereotype.Component;

import local.wkim.ldap.connection.base.LdapConnectionProvider;
import local.wkim.ldap.connection.entity.LdapConnectionInfo;

@Component("dbBaseConnectionProvider")
public class DBBaseConnectionProvider extends LdapConnectionProvider {

	@Override
	protected LdapConnectionInfo connectionInfo() {
		// TODO Auto-generated method stub
		LdapConnectionInfo connectionInfo = new LdapConnectionInfo();
		return connectionInfo;
	}
}
