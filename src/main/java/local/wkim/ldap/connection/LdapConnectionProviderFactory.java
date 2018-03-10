package local.wkim.ldap.connection;

import local.wkim.ldap.connection.base.LdapConnectionProvider;

public interface LdapConnectionProviderFactory {

	public LdapConnectionProvider createConnectionProvider(String type);
}
