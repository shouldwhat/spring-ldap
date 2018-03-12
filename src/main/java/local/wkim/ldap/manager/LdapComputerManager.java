package local.wkim.ldap.manager;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import local.wkim.ldap.entity.LdapComputer;
import local.wkim.ldap.manager.base.LdapManager;

@Scope("prototype")
@Component("computer")
public class LdapComputerManager extends LdapManager<LdapComputer> {

}
