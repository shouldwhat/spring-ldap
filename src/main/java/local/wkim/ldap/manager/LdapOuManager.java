package local.wkim.ldap.manager;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import local.wkim.ldap.entity.LdapOu;
import local.wkim.ldap.manager.base.LdapManager;

@Scope("prototype")
@Component("ou")
public class LdapOuManager extends LdapManager<LdapOu> {

}
