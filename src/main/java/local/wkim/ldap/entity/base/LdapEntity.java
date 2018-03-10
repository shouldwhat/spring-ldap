package local.wkim.ldap.entity.base;

import javax.naming.Name;

import org.springframework.ldap.odm.annotations.Id;

public abstract class LdapEntity {

	@Id
	protected Name dn;
}
