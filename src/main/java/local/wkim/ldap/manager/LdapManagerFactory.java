package local.wkim.ldap.manager;

import local.wkim.ldap.manager.base.LdapManager;

public interface LdapManagerFactory {

	public LdapManager<?> createLdapManager(String type);
}
