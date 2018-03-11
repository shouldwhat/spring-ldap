package local.wkim.ldap.manager;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import local.wkim.ldap.entity.LdapUser;
import local.wkim.ldap.manager.base.LdapManager;

@Scope("prototype")
@Component("user")
public class LdapUserManager extends LdapManager<LdapUser> {

}
