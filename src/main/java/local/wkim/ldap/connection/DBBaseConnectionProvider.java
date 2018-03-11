package local.wkim.ldap.connection;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import local.wkim.ldap.connection.base.LdapConnectionProvider;
import local.wkim.ldap.connection.entity.LdapConnectionInfo;

@Scope("prototype")
@Component("dbBase")
public class DBBaseConnectionProvider extends LdapConnectionProvider {

	@Override
	protected LdapConnectionInfo connectionInfo() {
		// TODO Auto-generated method stub
		LdapConnectionInfo connectionInfo = new LdapConnectionInfo();
		return connectionInfo;
	}
}
