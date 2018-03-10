package local.wkim.ldap.entity;

import javax.naming.Name;

import org.springframework.ldap.odm.annotations.Id;

public abstract class LdapEntity {

	@Id
	protected Name dn;
}
