package local.wkim.ldap.manager;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import local.wkim.ldap.entity.LdapPolicy;
import local.wkim.ldap.manager.base.LdapManager;

@Scope("prototype")
@Component("policy")
public class LdapPolicyManager extends LdapManager<LdapPolicy> {

}
